package com.vms.customer.service;

import com.vms.customer.model.signin.SignInRequestModel;
import com.vms.customer.model.signin.SignInResponseModel;
import com.vms.customer.network.NetworkConstant;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface VmsWebService {

    /**
     * login with email
     * @param user
     * @return
     */
//    @Headers({"Content-type: application/json",
//            "Accept: */*"})
    @POST("/api/login.php")//NetworkConstant.USER_LOGIN_END_POINTS)
    Call<SignInResponseModel> getUser(@Body SignInRequestModel user);

}
