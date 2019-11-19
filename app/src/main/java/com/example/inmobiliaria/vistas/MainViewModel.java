package com.example.inmobiliaria.vistas;

import android.media.session.MediaSession;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.model.Propietario;
import com.example.inmobiliaria.request.ApiClient;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> propietarioMutableLiveData ;

    public LiveData<String> getPropietarioMutableLiveData(){
        if(propietarioMutableLiveData==null){
            propietarioMutableLiveData = new MutableLiveData<>();
        }
        return propietarioMutableLiveData;
    }

    public void loginVM(final String Usuario, final String Clave){
        Call<String> datos = ApiClient.getMyApiInterface().login(Usuario, Clave);
        datos.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){

                    String resultado = response.body();
                    propietarioMutableLiveData.postValue(resultado);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                propietarioMutableLiveData.postValue(t.getMessage());
            }
        });

    }
}
