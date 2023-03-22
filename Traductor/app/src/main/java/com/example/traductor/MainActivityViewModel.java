package com.example.traductor;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;

    private MutableLiveData<String> resultado=null;
    public Map<String,String> palabras= new HashMap<String,String>(){{
        put("hola","hello");
        put("casa","house");
        put("perro","dog");
        put("gato","cat");
        put("rojo","red");
        put("ventana","windows");
        put("pajaro","bird");
        put("abeja","bee");
        put("araña","spider");
        put("black","negro");
    }};

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }

    public LiveData<String> getTraduccion(){
        if (resultado==null){
            this.resultado=new MutableLiveData<>();
        }
        return resultado;
    }
    public void traducir(String palab){
        try {
            palab = palab.toLowerCase();
            resultado.setValue(palabras.get(palab));
            if(resultado.getValue()==null){
                resultado.setValue("No encontrada");
            }
        }catch (Exception exception){
            Toast.makeText(context,"ERROR, Paso algo inesperado",Toast.LENGTH_LONG).show();
        }
    }
}
