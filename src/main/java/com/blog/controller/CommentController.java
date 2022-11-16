package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.domain.CommentDTO;
import com.blog.service.CommentService;
import com.google.gson.JsonObject;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    //댓글 등록
    @RequestMapping(value = { "/comments"}, method = { RequestMethod.POST, RequestMethod.PATCH })
    public JsonObject registerComment(@RequestBody final CommentDTO params) {
        JsonObject jsonObj = new JsonObject();

        try {
            boolean isRegistered = commentService.registerComment(params);
            jsonObj.addProperty("result", isRegistered);

        } catch (DataAccessException e) {
            jsonObj.addProperty("message", "데이터베이스 처리 과정에 문제가 발생하였습니다.");

        } catch (Exception e) {
            jsonObj.addProperty("message", "시스템에 문제가 발생하였습니다.");
        }

        return jsonObj;
    }

    //댓글 리스트 조회
    @GetMapping(value = "/comments/list")
    public List<CommentDTO> getCommentList() {
        List<CommentDTO> commentList = commentService.getCommentList();
        return commentList;
    }

}