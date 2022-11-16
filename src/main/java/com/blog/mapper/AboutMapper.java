package com.blog.mapper;

import com.blog.domain.AboutDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AboutMapper {

    public AboutDTO selectAboutDetail(Long idx); //공지사항 글 조회
    public List<AboutDTO> selectAboutList(); //공지사항 리스트 조회
    public int selectAboutTotalCount(); //공지사항 총 개수
}
