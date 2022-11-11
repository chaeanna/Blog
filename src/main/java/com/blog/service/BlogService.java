package com.blog.service;

import com.blog.domain.BlogDTO;
import com.blog.paging.Criteria;

import java.util.List;

public interface BlogService {
    public boolean registerBlog(BlogDTO params);
    public BlogDTO getBlogDetail(Long idx);
    public boolean deleteBlog(Long idx);
    public List<BlogDTO> getBlogList(BlogDTO params);
}
