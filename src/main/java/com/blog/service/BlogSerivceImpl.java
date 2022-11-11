package com.blog.service;

import com.blog.domain.BlogDTO;
import com.blog.mapper.BlogMapper;
import com.blog.paging.Criteria;
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

        if(params.getIdx() == null) {
            queryResult = blogMapper.insertBlog(params);
        } else {
            queryResult = blogMapper.updateBlog(params);
        }

        return (queryResult == 1) ? true : false;
    }


    @Override
    public BlogDTO getBlogDetail(Long idx) {
        int result = updateBlogCnt(idx);

        return blogMapper.selectBlogDetail(idx);
    }


    public int updateBlogCnt(Long idx) {
        int result = blogMapper.updateBlogCnt(idx);

        return result;

    }

    @Override
    public boolean deleteBlog(Long idx) {
        int queryResult = 0;

        BlogDTO blog = blogMapper.selectBlogDetail(idx);

        if(blog != null && "Y".equals(blog.getStatus())) {
            queryResult = blogMapper.deleteBlog(idx);
        }

        return (queryResult == 1) ? true : false;
    }

    @Override
    public List<BlogDTO> getBlogList(BlogDTO params){
        List<BlogDTO> blogList =  Collections.emptyList();

        int blogTotalCount = blogMapper.selectBlogTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(blogTotalCount);

        params.setPaginationInfo(paginationInfo);

        if(blogTotalCount > 0) {
            blogList = blogMapper.selectBlogList(params);
        }

        return blogList;
    }
}
