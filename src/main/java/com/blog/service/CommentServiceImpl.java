package com.blog.service;

import com.blog.domain.BlogDTO;
import com.blog.domain.CommentDTO;
import com.blog.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public boolean registerComment(CommentDTO params) {
        // TODO Auto-generated method stub
        int queryResult = 0;
        if( params.getIdx() == null ) {
            queryResult = commentMapper.insertComment(params);
        } else {
            queryResult = commentMapper.updateComment(params);
        }
        return (queryResult == 1) ? true : false;
    }

    @Override
    public boolean deleteComment(long idx) {
        // TODO Auto-generated method stub
        int queryResult = 0;

        CommentDTO comment = commentMapper.selectCommentDetail(idx);

        if( comment != null && "Y".equals(comment.getStatus())) {
            queryResult = commentMapper.deleteComment(idx);
        }
        return (queryResult == 1) ? true : false;
    }

    @Override
    public List<CommentDTO> getCommentList() {
        // TODO Auto-generated method stub
        List<CommentDTO> commentList = Collections.emptyList();

        int commentTotalCount = commentMapper.selectCommentTotalCount();
        if( commentTotalCount > 0 ) {
            commentList = commentMapper.selectCommentList();
        }
        return commentList;
    }
}
