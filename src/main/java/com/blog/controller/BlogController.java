package com.blog.controller;

import com.blog.constant.Method;
import com.blog.domain.BlogDTO;
import com.blog.service.BlogService;
import com.blog.util.UiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController extends UiUtils {

    @Autowired
    private BlogService blogService;

    //블로그 작성화면으로 이동
    @GetMapping(value="/blog/write.do")
    public String openBlogWrite(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        if(idx == null) {
            model.addAttribute("blog", new BlogDTO());
        } else {
            BlogDTO blog = blogService.getBlogDetail(idx);
            if(blog == null) {
                return "redirect:/blog/list.do";
            }
            model.addAttribute("blog", blog);
        }

        return "blog/write";
    }

    //블로그 작성하기
    @PostMapping(value = "/blog/register.do")
    public String registerBlog(@ModelAttribute("params") final BlogDTO params, Model model) {
        try {
            boolean isRegistered = blogService.registerBlog(params);
            if (isRegistered == false) {
                // TODO => 게시글 등록에 실패하였다는 메시지를 전달
                return showMessageWithRedirect("게시글 등록에 실패하였습니다.", "/blog/list.do", Method.GET, null, model);
            }
        } catch (DataAccessException e) {
            // TODO => 데이터베이스 처리 과정에 문제가 생겼다는 메시지를 전달
            return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.", "/blog/list.do", Method.GET, null, model);
        } catch (Exception e) {
            // TODO => 시스템에 문제가 발생하였다는 메시지를 전달
            return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/blog/list.do", Method.GET, null, model);
        }

        return showMessageWithRedirect("게시글 등록이 완료되었습니다.", "/blog/list.do", Method.GET, null, model);

    }

    //블로그 리스트 조회
    @GetMapping(value = "/blog/list.do")
    public String openBlogList(@ModelAttribute("params") BlogDTO params, Model model) {
        List<BlogDTO> blogList = blogService.getBlogList(params);
        model.addAttribute("blogList", blogList);

        return "blog/list";
    }

    //블로그 포스트 조회
    @GetMapping(value = "/blog/view.do")
    public String openBlogDetail(@RequestParam(value = "idx", required = false) Long idx, Model model){
        if (idx == null) {
            return "redirect:/blog/list.do";
        }

        BlogDTO blog = blogService.getBlogDetail(idx);

        if (blog == null || "N".equals(blog.getStatus())) {
            return "redirect:/blog/list.do";
        }
        model.addAttribute("blog", blog);

        return "blog/view";
    }

    //블로그 삭제하기
    @PostMapping(value = "/blog/delete.do")
    public String deleteBoard(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        if (idx == null) {
            return showMessageWithRedirect("올바르지 않은 접근입니다.", "/blog/list.do", Method.GET, null, model);
        }

        try {
            boolean isDeleted = blogService.deleteBlog(idx);
            if (isDeleted == false) {
                // TODO => 게시글 삭제에 실패하였다는 메시지를 전달
                return showMessageWithRedirect("게시글 삭제에 실패하였습니다.", "/blog/list.do", Method.GET, null, model);

            }
        } catch (DataAccessException e) {
            // TODO => handle exception
            return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.", "/blog/list.do", Method.GET, null, model);
        } catch (Exception e) {
            // TODO => handle exception (시스템에 문제가 발생하였다는 메시지를 전달)
            return showMessageWithRedirect("시스템에 문제가 발생하였습니다..", "/blog/list.do", Method.GET, null, model);
        }

        return showMessageWithRedirect("게시글 삭제가 완료되었습니다.", "/blog/list.do", Method.GET, null, model);

    }



}
