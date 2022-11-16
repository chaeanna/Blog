package com.blog.mapper;

import com.blog.domain.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    public int insertComment(CommentDTO params); //댓글 등록
    public CommentDTO selectCommentDetail(Long idx); //댓글 하나
    public int updateComment(CommentDTO params); //댓글 수정
    public int deleteComment(Long idx); //댓글 삭제
    public List<CommentDTO> selectCommentList(); //댓글 리스트 조회
    public int selectCommentTotalCount(); //댓글 총 개수
}
