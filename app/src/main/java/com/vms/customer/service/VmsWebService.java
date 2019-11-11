package com.vms.customer.service;

import com.vms.customer.model.ResendOtp;
import com.vms.customer.model.allotbooking.AllotBookingStatusRequest;
import com.vms.customer.model.allotbooking.AllotBookingStatusResponse;
import com.vms.customer.model.bookload.BookLoadRequestModel;
import com.vms.customer.model.bookload.BookLoadResponseModel;
import com.vms.customer.model.forgotpassword.ForgotPasswordRequestModel;
import com.vms.customer.model.forgotpassword.ForgotPasswordResponseModel;
import com.vms.customer.model.forgotpassword.RecreatePasswordRequestModel;
import com.vms.customer.model.forgotpassword.RecreatePasswordResponseModel;
import com.vms.customer.model.registration.RegistrationRequestModel;
import com.vms.customer.model.registration.RegistrationResponseModel;
import com.vms.customer.model.searchvehicle.SearchVehicleRequestModel;
import com.vms.customer.model.searchvehicle.SearchVehicleResponseModel;
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

    /**
     * create user
     * @param user
     * @return
     */
    @Headers({"Content-type: application/json",
            "Accept: */*"})
    @POST("api/register.php")
    Call<RegistrationResponseModel> createUser(@Body RegistrationRequestModel user);

    /**
     * forgot password
     * @param user
     * @return
     */
    @Headers({"Content-type: application/json",
            "Accept: */*"})
    @POST("api/forgot_password.php")
    Call<ForgotPasswordResponseModel> resetPassword(@Body ForgotPasswordRequestModel user);

    /**
     * re-create password
     * @param user
     * @return
     */
    @Headers({"Content-type: application/json",
            "Accept: */*"})
    @POST("api/forgot_password.php")
    Call<RecreatePasswordResponseModel> recreatePassword(@Body RecreatePasswordRequestModel user);

    /**
     * re-send otp
     * @param user
     * @return
     */
    @Headers({"Content-type: application/json",
            "Accept: */*"})
    @POST("api/resend_otp.php")
    Call<ForgotPasswordResponseModel> resendOTP(@Body ResendOtp user);

    /**
     * search vehicles
     * @param searchDataModel
     * @return
     */

    @Headers({"Content-type: application/json",
            "Accept: */*"})
    @POST("api/search_vehicles.php")
    Call<SearchVehicleResponseModel> searchVehicles(@Body SearchVehicleRequestModel searchDataModel);

    /**
     * book load
     * @param loadDataModel
     * @return
     */

    @Headers({"Content-type: application/json",
            "Accept: */*"})
    @POST("api/book_load.php")
    Call<BookLoadResponseModel> bookVehicles(@Body BookLoadRequestModel loadDataModel);

    /**
     * allot booking
     * @param allotDataModel
     * @return
     */

    @Headers({"Content-type: application/json",
            "Accept: */*"})
    @POST("api/allot_booking.php")
    Call<AllotBookingStatusResponse> allotVehicles(@Body AllotBookingStatusRequest allotDataModel);
}
