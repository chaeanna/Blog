package com.blog.service;

import com.blog.domain.BlogDTO;
import com.blog.domain.CommentDTO;

import java.util.List;

public interface CommentService {

    public boolean registerComment(CommentDTO params);
    public boolean deleteComment(long idx);
    public List<CommentDTO> getCommentList();

}
