package com.example.inmobiliaria.request;

import android.media.session.MediaSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class ApiClient {
    private static final String PATH="https://192.168.43.50:45456/api/";
    private static MyApiInterface myApiInterface;

    public static MyApiInterface getMyApiInterface(){
        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient client = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PATH)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        //Log.d("mensaje",retrofit.baseUrl().toString());
        myApiInterface= retrofit.create(MyApiInterface.class);
        return myApiInterface;
    }

    public interface MyApiInterface{
        //String prov = "74";
        //@GET("municipios?provincia="+prov)
        @POST("propietario/login")
        Call<String> login(@Query("Usuario") String correo, @Query("Clave") String clave);

    }
}
