package com.cet23.inventarioapp20.gui.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cet23.inventarioapp20.R;
import com.cet23.inventarioapp20.model.Cliente;
import com.cet23.inventarioapp20.model.Venta;

import java.util.List;

public class VentaAdapter extends RecyclerView.Adapter<VentaAdapter.ViewHolder> {
    private List<Venta> ventas;
    private onItemClickListenerV listener;
    private Context context;

    public VentaAdapter(List<Venta> ventas, onItemClickListenerV listener) {
        this.ventas = ventas;
        this.listener = listener;
    }



    @NonNull
    @Override
    public VentaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_venta,viewGroup,false);
        context = viewGroup.getContext();
        return  new VentaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VentaAdapter.ViewHolder viewHolder, int i) {
        Venta venta = ventas.get(i);
        viewHolder.setOnClickListener(venta, listener);
        viewHolder.txtDatos.setText(context.getString(R.string.item_ventas_data, venta.getCliente(),
                ""+ venta.getCantidad(), "" + venta.getFecha()));
    }

    @Override
    public int getItemCount() {
        return ventas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  View view;
        protected AppCompatTextView txtDatos;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            txtDatos = itemView.findViewById(R.id.txtDatos);
            this.view = itemView;
        }
        public void setOnClickListener(final Venta venta, final onItemClickListenerV listener) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(venta);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onLongItemClick(venta);
                    return true;
                }
            });
        }
    }
}
