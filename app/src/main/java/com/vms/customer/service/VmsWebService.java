package com.vms.customer.service;

import com.vms.customer.model.forgotpassword.ForgotPasswordRequestModel;
import com.vms.customer.model.forgotpassword.ForgotPasswordResponseModel;
import com.vms.customer.model.registration.RegistrationRequestModel;
import com.vms.customer.model.registration.RegistrationResponseModel;
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
    @Headers({"Content-type: application/json",
            "Accept: */*"})
    @POST("api/login.php")
    Call<SignInResponseModel> getUser(@Body SignInRequestModel user);

    @Headers({"Content-type: application/json",
            "Accept: */*"})
    @POST("api/register.php")
    Call<RegistrationResponseModel> createUser(@Body RegistrationRequestModel user);

    @Headers({"Content-type: application/json",
            "Accept: */*"})
    @POST("api/forgot_password.php")
    Call<ForgotPasswordResponseModel> resetPassword(@Body ForgotPasswordRequestModel user);
}
