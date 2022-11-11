package com.blog.mapper;

import com.blog.domain.BlogDTO;
import com.blog.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    public int insertBlog(BlogDTO params);
    public BlogDTO selectBlogDetail(Long idx);
    public int updateBlog(BlogDTO params);
    public int deleteBlog(Long idx);
    public List<BlogDTO> selectBlogList(BlogDTO params);
    public int selectBlogTotalCount(BlogDTO params);
    public int updateBlogCnt(Long idx);

}
