package com.cet23.inventarioapp20.api.apiservices;

import com.cet23.inventarioapp20.model.Cliente;
import com.cet23.inventarioapp20.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ClienteService {



    @GET("cliente/getall")
    Call<List<Cliente>> getAll();

    @GET("cliente/getbyid/{idCliente}")
    Call<Cliente> getById(@Path("idCliente") int idCliente);
}
