package com.blog.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AboutDTO extends CommonDTO{
    private Long idx; //공지사항 인덱스
    private String title; //공지사항 제목
    private String content; //공지사항 내용

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
