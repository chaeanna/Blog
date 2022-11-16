package com.blog.service;

import com.blog.domain.AboutDTO;

import java.util.List;

public interface AboutService {

    public AboutDTO getAboutDetail(Long idx); //공지사항 글 가져오기
    public List<AboutDTO> getAboutList(); //공지사항 리스트 가져오기

}
