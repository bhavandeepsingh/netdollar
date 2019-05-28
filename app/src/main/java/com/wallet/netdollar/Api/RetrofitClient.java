package com.wallet.netdollar.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

  private static final  String BASE_URL="http://192.168.1.11:8180/wallets/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private  RetrofitClient(){
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder()
              .addInterceptor(interceptor).build();

      retrofit =new Retrofit.Builder()
              .baseUrl(BASE_URL)
              .client(client)
              .addConverterFactory(GsonConverterFactory.create())
              .build();
    }

    public static synchronized RetrofitClient getInstance(){
      if(mInstance==null){
        mInstance=new RetrofitClient();
      }return mInstance;
    }

    public Api getApi(){
      return  retrofit.create(Api.class);
    }
}
