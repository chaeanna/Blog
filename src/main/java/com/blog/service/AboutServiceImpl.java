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

        return aboutMapper.selectAboutDetail(idx);
    }

    @Override
    public List<AboutDTO> getAboutList(){
        List<AboutDTO> aboutList =  Collections.emptyList();

        int AboutTotalCount = aboutMapper.selectAboutTotalCount();


        if(AboutTotalCount > 0) {
            aboutList = aboutMapper.selectAboutList();
        }

        return aboutList;
    }
}
