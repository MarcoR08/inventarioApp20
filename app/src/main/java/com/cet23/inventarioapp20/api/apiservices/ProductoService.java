package com.cet23.inventarioapp20.api.apiservices;

import com.cet23.inventarioapp20.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductoService {


    @GET("producto/getall")
    Call<List<Producto>> getAll();

    @GET("producto/getbyid/{idProducto}")
    Call<Producto> getById(@Path("idProducto") int idProducto);
}

