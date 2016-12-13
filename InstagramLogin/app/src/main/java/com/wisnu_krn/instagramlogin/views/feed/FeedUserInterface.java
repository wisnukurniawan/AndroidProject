package com.wisnu_krn.instagramlogin.views.feed;

import com.wisnu_krn.instagramlogin.models.Post;

import java.util.List;

/**
 * Created by private on 07/12/2016.
 */

public interface FeedUserInterface {
    void showData(List<Post> posts);

    void showLoading();

    void hideLoading();
}
