package com.blog.mapper;

import com.blog.domain.BlogDTO;
import com.blog.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    public int insertBlog(BlogDTO params); //블로그 등록
    public BlogDTO selectBlogDetail(Long idx); //블로그 글 조회
    public int updateBlog(BlogDTO params); //블로그 수정하기
    public int deleteBlog(Long idx); //블로그 삭제
    public List<BlogDTO> selectBlogList(BlogDTO params); //블로그 리스트 조회
    public int selectBlogTotalCount(BlogDTO params); //블로그 조회수
    public int updateBlogCnt(Long idx); //블로그 조회수 업데이트

}
