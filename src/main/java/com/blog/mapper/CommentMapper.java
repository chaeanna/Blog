package com.blog.mapper;

import com.blog.domain.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    public int insertComment(CommentDTO params);
    public CommentDTO selectCommentDetail(Long idx);
    public int updateComment(CommentDTO params);
    public int deleteComment(Long idx);
    public List<CommentDTO> selectCommentList();
    public int selectCommentTotalCount();
}
