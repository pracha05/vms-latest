package com.vms.customer.service;

import com.vms.customer.network.ServiceURL;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class VmsApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Timber.d("Base url is" + ServiceURL.getBaseURL());
        retrofit = new Retrofit.Builder()
                .baseUrl("http://vms.prachatech.com/")
                //.addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }


//    class NullOnEmptyConverterFactory implements Converter.Factory {
//        @Override
//        public Converter<ResponseBody, ?> responseBody(Type type, Annotation[] annotations, Retrofit retrofit) {
//            final Converter<ResponseBody, ?> delegate = retrofit.nextResponseBodyConverter(this, type, annotations);
//            return new Converter<>() {
//                @Override
//                public void convert(ResponseBody body) {
//                    if (body.contentLength() == 0) return null;
//                    return delegate.convert(body);
//                }
//            };
//        }
//    }
}