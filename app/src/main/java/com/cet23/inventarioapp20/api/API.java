package com.cet23.inventarioapp20.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    public static final String BASE_URL="https://kjmbnavc50.execute-api.us-east-1.amazonaws.com/dev/dam/";
    private static Retrofit retrofit=null;
    private String XD;



    public static Retrofit getApi(){
        if(retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
