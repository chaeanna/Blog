package com.blog.service;

import com.blog.domain.BlogDTO;

import java.util.List;

public interface BlogService {
    public boolean registerBlog(BlogDTO params);    //블로그 저장하기
    public BlogDTO getBlogDetail(Long idx); //블로그 하나 조회하기
    public boolean deleteBlog(Long idx);    //블로그 삭제하기
    public List<BlogDTO> getBlogList(BlogDTO params);   //블로그 리스트 조회하기
}
