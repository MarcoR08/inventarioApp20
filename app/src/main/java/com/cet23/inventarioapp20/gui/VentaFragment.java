package com.cet23.inventarioapp20.gui;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cet23.inventarioapp20.R;
import com.cet23.inventarioapp20.core.ClienteController;
import com.cet23.inventarioapp20.core.MiscController;
import com.cet23.inventarioapp20.core.VentaController;
import com.cet23.inventarioapp20.gui.components.ClienteAdaptar;
import com.cet23.inventarioapp20.gui.components.VentaAdapter;
import com.cet23.inventarioapp20.gui.components.onItemClickListenerC;
import com.cet23.inventarioapp20.gui.components.onItemClickListenerV;
import com.cet23.inventarioapp20.model.Cliente;
import com.cet23.inventarioapp20.model.Venta;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class VentaFragment extends Fragment implements onItemClickListenerV {

    @BindView(R.id.ventaRecycler)
    RecyclerView ventaRecycler;
    Unbinder unbinder;

    private View view;
    private Context context;
    private MiscController miscController = MiscController.Instance();
    private VentaController ventaController = VentaController.instance();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        configGlobals();
        configView(inflater, container);
        configRecycler();

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void actualizar() {
        miscController.ShowWait(context, "Consultando ventas ...");
        ventaController.GetAll();
    }

    public void actualizar(List<Venta> ventas){
        if (!ventas.isEmpty()){
            ventaRecycler.setAdapter(new VentaAdapter(ventas, this));
            miscController.CloseWait();
        }
    }



    private void configRecycler() {
        ventaRecycler.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(context,3);
        ventaRecycler.setLayoutManager(linearLayoutManager);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_venta, container, false);
        ButterKnife.bind(this, view);
        context = container.getContext();

    }

    private void configGlobals() {
        MainActivity.GLOBALS.put("VentaFragment", this);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(Venta venta) {

    }

    @Override
    public void onLongItemClick(Venta venta) {

    }
}
