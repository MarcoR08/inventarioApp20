package com.cet23.inventarioapp20.core;

import android.util.Log;

import com.cet23.inventarioapp20.api.API;
import com.cet23.inventarioapp20.api.apiservices.ProductoService;
import com.cet23.inventarioapp20.gui.MainActivity;
import com.cet23.inventarioapp20.gui.ProductosFragment;
import com.cet23.inventarioapp20.model.Producto;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductoController {
    private static ProductoController instance = null;

    public ProductoController() {
    }

    public  static ProductoController instance() {
        if (instance == null)
            instance = new ProductoController();
        return instance;
    }

    public void GetAll(){
        API.getApi().create(ProductoService.class).getAll().enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                Log.i("getall",response.body().toString());
                ((ProductosFragment) Objects.requireNonNull(MainActivity.GLOBALS.get("productoFragment"))).actualizar(response.body());
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Log.i("getall",t.getMessage());
            }
        });
    }

    public void GetById(int idProducto){
        API.getApi().create(ProductoService.class).getById(idProducto).enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                Log.i("getbyid", response.body().toString());
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                Log.i("getbyid",t.getMessage());
            }
        });
    }

}
