package com.wisnu_krn.retrofit2.network;

import com.wisnu_krn.retrofit2.model.request.LoginRequestModel;
import com.wisnu_krn.retrofit2.model.response.LoginResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by private on 25/11/2016.
 */

public interface ApiInterface {

    @POST("/api/login")
    Call<LoginResponseModel> login(@Body LoginRequestModel requestModel);


}
