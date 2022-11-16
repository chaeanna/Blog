package com.blog;


import com.blog.domain.CommentDTO;
import com.blog.mapper.CommentMapper;
import com.blog.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CommentTests {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void registerComments() {
        int number = 5;
        for (int i = 1; i <= number; i++) {
            CommentDTO params = new CommentDTO();
            params.setContent(i + "번 댓글을 추가합니다!");
            commentService.registerComment(params);
        }
        System.out.println("댓글 " + number + "개가 동륵되었습니다.");
    }

    @Test
    public void deleteComment() {
        commentMapper.deleteComment((long) 1);
        getCommentList();
    }

    @Test
    public void getCommentList() {
        List<CommentDTO> commentList = commentMapper.selectCommentList();


        for( CommentDTO comment : commentList ) {
            System.out.println("==================");
            System.out.println(comment.getIdx());
            System.out.println(comment.getContent());
            System.out.println("==================");
        }
    }
}