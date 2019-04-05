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
import com.cet23.inventarioapp20.core.ProductoController;
import com.cet23.inventarioapp20.gui.components.ClienteAdaptar;
import com.cet23.inventarioapp20.gui.components.ProductosAdapter;
import com.cet23.inventarioapp20.gui.components.onItemClickListener;
import com.cet23.inventarioapp20.gui.components.onItemClickListenerC;
import com.cet23.inventarioapp20.model.Cliente;
import com.cet23.inventarioapp20.model.Producto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClientesFragment extends Fragment implements onItemClickListenerC {
    @BindView(R.id.clientesRecycler)
    RecyclerView cliRecyclerView;
    Unbinder unbinder;

    private View view;
    private Context context;
    private MiscController miscController = MiscController.Instance();
    private ClienteController clienteController = ClienteController.instance();

    public ClientesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_clientes, container, false);

        configGlobals();
        configView(inflater, container);
        configRecycler();

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void actualizar() {
        miscController.ShowWait(context, "Consultando Clientes ...");
        clienteController.GetAll();
    }

    public void actualizar(List<Cliente> clientes){
        if (!clientes.isEmpty()){
            cliRecyclerView.setAdapter(new ClienteAdaptar(clientes, this));
            miscController.CloseWait();
        }
    }



    private void configRecycler() {
        cliRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(context,3);
        cliRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void configView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_clientes, container, false);
        ButterKnife.bind(this, view);
        context = container.getContext();

    }

    private void  configGlobals() {
        MainActivity.GLOBALS.put("ClienteFragment", this);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(Cliente cliente) {

    }

    @Override
    public void onLongItemClick(Cliente cliente) {

    }
}
