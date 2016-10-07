package com.wisnu_krn.retrofitexample.RestApi;

import com.wisnu_krn.retrofitexample.Models.Models;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by private on 07/10/2016.
 */

public interface RestApi{
    //modelnya get
    @GET ("contohjson")
    Call<Models>getDataAdmin();

}
