package com.cet23.inventarioapp20.core;

import android.util.Log;

import com.cet23.inventarioapp20.api.API;
import com.cet23.inventarioapp20.api.apiservices.ClienteService;
import com.cet23.inventarioapp20.api.apiservices.ProductoService;
import com.cet23.inventarioapp20.gui.ClientesFragment;
import com.cet23.inventarioapp20.gui.MainActivity;
import com.cet23.inventarioapp20.gui.ProductosFragment;
import com.cet23.inventarioapp20.model.Cliente;
import com.cet23.inventarioapp20.model.Producto;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClienteController {


    private static ClienteController instance = null;

    public ClienteController() {
    }

    public  static ClienteController instance() {
        if (instance == null)
            instance = new ClienteController();
        return instance;
    }

    public void GetAll(){
        API.getApi().create(ClienteService.class).getAll().enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                Log.i("getall",response.body().toString());
                ((ClientesFragment) Objects.requireNonNull(MainActivity.GLOBALS.get("ClienteFragment"))).actualizar(response.body());
            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {
                Log.i("getall",t.getMessage());
            }
        });
    }

    public void GetById(int idCliente){
        API.getApi().create(ClienteService.class).getById(idCliente).enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                Log.i("getbyid", response.body().toString());
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Log.i("getbyid",t.getMessage());
            }
        });
    }
}
