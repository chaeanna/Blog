package com.blog.domain;

import com.blog.paging.Criteria;
import com.blog.paging.PaginationInfo;

import java.time.LocalDateTime;

public class CommonDTO extends Criteria {
    private PaginationInfo paginationInfo;
    private String status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public PaginationInfo getPaginationInfo() {
        return paginationInfo;
    }

    public void setPaginationInfo(PaginationInfo paginationInfo) {
        this.paginationInfo = paginationInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
