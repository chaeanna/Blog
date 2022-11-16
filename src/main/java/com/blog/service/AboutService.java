package com.blog.service;

import com.blog.domain.AboutDTO;

import java.util.List;

public interface AboutService {

    public AboutDTO getAboutDetail(Long idx);
    public List<AboutDTO> getAboutList();

}
