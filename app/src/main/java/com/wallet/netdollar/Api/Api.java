package com.wallet.netdollar.Api;


import com.wallet.netdollar.models.BaseModel;
import com.wallet.netdollar.models.RegisterUser;
import com.wallet.netdollar.models.LoginResponse;
import com.wallet.netdollar.models.TransactionsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {
//    @POST("")
//    Call<ResponseBody>adduser(
//      //@Field("") String phone
//    );

    @FormUrlEncoded
    @POST("getparams")
    Call<LoginResponse>logger(
            @Field("username") String phone,
            @Field("walletid") String walletid
    );


    @Headers("Content-Type: application/json")
    @POST("create")
    Call<BaseModel> register(@Body RegisterUser registerUser);


    @FormUrlEncoded
    @GET("transactions")
    Call<TransactionsResponse>getTransations();
}
