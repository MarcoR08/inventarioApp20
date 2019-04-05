package com.cet23.inventarioapp20.api.apiservices;

import com.cet23.inventarioapp20.model.Producto;
import com.cet23.inventarioapp20.model.Venta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface VentaService {


    @GET("venta/getall")
    Call<List<Venta>> getAll();

    @GET("venta/getbyid/{idVenta}")
    Call<Venta> getById(@Path("idVenta") int idVenta);
}
