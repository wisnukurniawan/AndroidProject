package com.wisnu_krn.instagramlogin.network;

import com.wisnu_krn.instagramlogin.models.ResponseToken;
import com.wisnu_krn.instagramlogin.models.UserMediaResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by private on 07/12/2016.
 */

public interface InstagramApi {

    @FormUrlEncoded
    @POST("/oauth/access_token")
    Observable<ResponseToken> getToken(
            @Field("client_id") String clientID, @Field("client_secret") String clientSecret,
            @Field("grant_type") String grantType, @Field("redirect_uri") String redirectUri,
            @Field("code") String code);

    @GET("/v1/users/{id}/media/recent") Observable<UserMediaResponse> getUserMediaRecent(
            @Path("id") String userId, @Query("access_token") String accessToken);
}
