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
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.cet23.inventarioapp20.R;
import com.cet23.inventarioapp20.core.MiscController;
import com.cet23.inventarioapp20.core.ProductoController;
import com.cet23.inventarioapp20.gui.components.ProductosAdapter;
import com.cet23.inventarioapp20.gui.components.onItemClickListener;
import com.cet23.inventarioapp20.model.Producto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductosFragment extends Fragment implements onItemClickListener {
    @BindView(R.id.ProductoRecycler)
    RecyclerView productosRecycler;
    Unbinder unbinder;

    private View view;
    private Context context;
    private MiscController miscController = MiscController.Instance();
    private ProductoController productoController = ProductoController.instance();

    public ProductosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        configGlobals();
        configView(inflater, container);
        configRecycler();

       // actualizar();

        unbinder = ButterKnife.bind(this, view);
        return view;


    }
    private void actualizar() {
        miscController.ShowWait(context, "Consultando Productos ...");
        productoController.GetAll();
    }

    public void actualizar(List<Producto> productos){
        if (!productos.isEmpty()){
            productosRecycler.setAdapter(new ProductosAdapter(productos, this));
            miscController.CloseWait();
        }
    }



    private void configRecycler() {
        productosRecycler.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(context,3);
        productosRecycler.setLayoutManager(linearLayoutManager);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_productos, container, false);
        ButterKnife.bind(this, view);
        context = container.getContext();

    }

    private void  configGlobals() {
        MainActivity.GLOBALS.put("productoFragment", this);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(Producto producto) {

    }

    @Override
    public void onLongItemClick(Producto producto) {

    }
}
