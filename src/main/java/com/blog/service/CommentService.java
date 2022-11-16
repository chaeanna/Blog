package com.blog.service;

import com.blog.domain.BlogDTO;
import com.blog.domain.CommentDTO;

import java.util.List;

public interface CommentService {

    public boolean registerComment(CommentDTO params);  //댓글 저장하기
    public boolean deleteComment(long idx); //댓글 삭제하기
    public List<CommentDTO> getCommentList();   //댓글 리스트 가져오기

}
