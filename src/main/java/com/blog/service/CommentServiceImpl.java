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
        //해당하는 인덱스가 없으면 댓글 등록
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
        //해당하는 댓글 가져오기
        CommentDTO comment = commentMapper.selectCommentDetail(idx);

        //댓글이 존재하고 삭제되지 않은 상태면 삭제하기
        if( comment != null && "Y".equals(comment.getStatus())) {
            queryResult = commentMapper.deleteComment(idx);
        }
        return (queryResult == 1) ? true : false;
    }

    @Override
    public List<CommentDTO> getCommentList() {
        // TODO Auto-generated method stub
        //댓글 리스트
        List<CommentDTO> commentList = Collections.emptyList();

        //댓글 총 개숙 가져와서 하나라도 있으면 리스트로 가져오기
        int commentTotalCount = commentMapper.selectCommentTotalCount();
        if( commentTotalCount > 0 ) {
            commentList = commentMapper.selectCommentList();
        }
        return commentList;
    }
}
