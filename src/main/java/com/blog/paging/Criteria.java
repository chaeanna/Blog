package com.blog.paging;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class Criteria {
    private int currentPageNo;

    private int recordsPerPage;

    private int pageSize;


    public Criteria() {
        this.currentPageNo = 1;
        this.recordsPerPage = 5;
        this.pageSize = 10;

    }

    public int getStartPage() {
        return (currentPageNo - 1) * recordsPerPage;

    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getRecordsPerPage() {
        return recordsPerPage;
    }

    public void setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Criteria(int currentPageNo, int recordsPerPage, int pageSize) {
        this.currentPageNo = currentPageNo;
        this.recordsPerPage = recordsPerPage;
        this.pageSize = pageSize;
    }

    public String makeQueryString(int pageNo) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("currentPageNo", pageNo)
                .queryParam("recordsPerPage", recordsPerPage)
                .queryParam("pageSize", pageSize)
                .build()
                .encode();
        return uriComponents.toUriString();

    }
}
