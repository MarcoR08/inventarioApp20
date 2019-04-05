package com.cet23.inventarioapp20.gui.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.cet23.inventarioapp20.R;
import com.cet23.inventarioapp20.model.Cliente;
import com.cet23.inventarioapp20.model.Producto;

import java.util.List;

public class ClienteAdaptar extends RecyclerView.Adapter<ClienteAdaptar.ViewHolder> {

    private List<Cliente> clientes;
    private onItemClickListenerC listener;
    private Context context;

    public ClienteAdaptar(List<Cliente> clientes, onItemClickListenerC listener) {
        this.clientes = clientes;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ClienteAdaptar.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_cliente,viewGroup,false);
        context = viewGroup.getContext();
        return  new ClienteAdaptar.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClienteAdaptar.ViewHolder viewHolder, int i) {
        Cliente cliente = clientes.get(i);
        viewHolder.setOnClickListener(cliente, listener);
        viewHolder.txtDatos.setText( cliente.getNombre() +
                ""+ cliente.getApellidoP()+""+ cliente.getApellidoM());

    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  View view;
        protected AppCompatTextView txtDatos;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDatos = itemView.findViewById(R.id.txtDatos);
            this.view = itemView;
        }
        public void setOnClickListener(final Cliente cliente, final onItemClickListenerC listener) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(cliente);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onLongItemClick(cliente);
                    return true;
                }
            });
        }
    }
}
