package com.blog.service;

import com.blog.domain.BlogDTO;
import com.blog.mapper.BlogMapper;
import com.blog.paging.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BlogSerivceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public boolean registerBlog(BlogDTO params) {
        int queryResult = 0;
        //인덱스가 없으면 새로 등록
        if(params.getIdx() == null) {
            queryResult = blogMapper.insertBlog(params);
        } else {
            //인덱스 존재시 글 수정하기
            queryResult = blogMapper.updateBlog(params);
        }

        return (queryResult == 1) ? true : false;
    }


    @Override
    public BlogDTO getBlogDetail(Long idx) {
        //조회수 업데이트
        int result = updateBlogCnt(idx);
        //글 하나 조회
        return blogMapper.selectBlogDetail(idx);
    }


    public int updateBlogCnt(Long idx) {
        //관련된 글 조회수 올리기
        int result = blogMapper.updateBlogCnt(idx);

        return result;

    }

    @Override
    public boolean deleteBlog(Long idx) {
        int queryResult = 0;
        //해당 인덱스의 블로그 글 가져오기
        BlogDTO blog = blogMapper.selectBlogDetail(idx);

        //블로그 글이 존재하고 삭제되지 않은 상태면 삭제하기
        if(blog != null && "Y".equals(blog.getStatus())) {
            queryResult = blogMapper.deleteBlog(idx);
        }

        return (queryResult == 1) ? true : false;
    }

    @Override
    public List<BlogDTO> getBlogList(BlogDTO params){
        //블로그 리스트 저장
        List<BlogDTO> blogList =  Collections.emptyList();
        //블로그 총 개수 가져오기
        int blogTotalCount = blogMapper.selectBlogTotalCount(params);

        //페이징 처리
        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(blogTotalCount);

        params.setPaginationInfo(paginationInfo);

        //블로그가 하나라도 존재할 경우 리스트로 가져오기
        if(blogTotalCount > 0) {
            blogList = blogMapper.selectBlogList(params);
        }

        return blogList;
    }
}
