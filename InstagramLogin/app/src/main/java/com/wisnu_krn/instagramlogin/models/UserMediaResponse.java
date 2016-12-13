package com.wisnu_krn.instagramlogin.models;

import java.util.List;

/**
 * Created by private on 07/12/2016.
 */

public class UserMediaResponse {
    private Pagination pagination;
    private List<Post> data;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Post> getData() {
        return data;
    }

    public void setData(List<Post> data) {
        this.data = data;
    }
}
