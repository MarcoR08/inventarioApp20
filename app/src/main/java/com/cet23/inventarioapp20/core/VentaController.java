package com.cet23.inventarioapp20.core;

import android.util.Log;

import com.cet23.inventarioapp20.api.API;
import com.cet23.inventarioapp20.api.apiservices.VentaService;
import com.cet23.inventarioapp20.gui.MainActivity;
import com.cet23.inventarioapp20.gui.VentaFragment;
import com.cet23.inventarioapp20.model.Venta;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VentaController {

    private static VentaController instance = null;

    public VentaController() {
    }

    public  static VentaController instance() {
        if (instance == null)
            instance = new VentaController();
        return instance;
    }

    public void GetAll(){
        API.getApi().create(VentaService.class).getAll().enqueue(new Callback<List<Venta>>() {
            @Override
            public void onResponse(Call<List<Venta>> call, Response<List<Venta>> response) {
                Log.i("getall",response.body().toString());
                ((VentaFragment) Objects.requireNonNull(MainActivity.GLOBALS.get("VentaFragment"))).actualizar(response.body());
            }

            @Override
            public void onFailure(Call<List<Venta>> call, Throwable t) {
                Log.i("getall",t.getMessage());
            }
        });
    }

    public void GetById(int idVenta){
        API.getApi().create(VentaService.class).getById(idVenta).enqueue(new Callback<Venta>() {
            @Override
            public void onResponse(Call<Venta> call, Response<Venta> response) {
                Log.i("getbyid", response.body().toString());
            }

            @Override
            public void onFailure(Call<Venta> call, Throwable t) {
                Log.i("getbyid",t.getMessage());
            }
        });
    }

}
