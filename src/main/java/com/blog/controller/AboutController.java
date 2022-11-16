package com.blog.controller;

import com.blog.domain.AboutDTO;
import com.blog.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AboutController {

    @Autowired
    AboutService aboutService;

    //공지사항 페이지 리스트 조회
    @GetMapping(value = "/blog/aboutlist.do")
    public String openAboutList(Model model) {
        List<AboutDTO> aboutList = aboutService.getAboutList();
        model.addAttribute("aboutList", aboutList);

        return "blog/aboutlist";
    }

    //공지사항 글 조회
    @GetMapping(value = "/blog/about.do")
    public String openAboutDetail(@RequestParam(value = "idx", required = false) Long idx, Model model){
        if (idx == null) {
            return "redirect:/blog/list.do";
        }

        AboutDTO about = aboutService.getAboutDetail(idx);

        //조회할 글이 없거나 삭제된 상태면 메인으로 리다이렉트
        if (about == null || "N".equals(about.getStatus())) {
            return "redirect:/blog/list.do";
        }
        model.addAttribute("about", about);

        return "blog/about";
    }

    //message메뉴로 가도록 함
    @GetMapping(value = "/blog/message.do")
    public String openMessage(Model model) {
        model.addAttribute("message", "Hello!!!");
        return "blog/message";
    }
    

}


