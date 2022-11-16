package com.blog.mapper;

import com.blog.domain.AboutDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AboutMapper {

    public AboutDTO selectAboutDetail(Long idx);
    public List<AboutDTO> selectAboutList();
    public int selectAboutTotalCount();
}
