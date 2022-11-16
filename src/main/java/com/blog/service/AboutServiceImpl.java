package com.blog.service;

import com.blog.domain.AboutDTO;
import com.blog.mapper.AboutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AboutServiceImpl implements AboutService{
    @Autowired
    private AboutMapper aboutMapper;

    @Override
    public AboutDTO getAboutDetail(Long idx) {
        //공지사항 글 가져오기
        return aboutMapper.selectAboutDetail(idx);
    }

    @Override
    public List<AboutDTO> getAboutList(){
        List<AboutDTO> aboutList =  Collections.emptyList();
        //공지사항 개수 가져오기
        int AboutTotalCount = aboutMapper.selectAboutTotalCount();

        //공지사항 글이 존재하면 리스트로 가져오기
        if(AboutTotalCount > 0) {
            aboutList = aboutMapper.selectAboutList();
        }

        return aboutList;
    }
}
