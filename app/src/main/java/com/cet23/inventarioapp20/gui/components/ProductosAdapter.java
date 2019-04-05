package com.cet23.inventarioapp20.gui.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.cet23.inventarioapp20.R;
import com.cet23.inventarioapp20.model.Producto;

import java.util.List;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ViewHolder> {
    private List<Producto> productos;
    private onItemClickListener listener;
    private Context context;

    public ProductosAdapter(List<Producto> productos, onItemClickListener listener) {
        this.productos = productos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_producto,viewGroup,false);
        context = viewGroup.getContext();
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Producto producto = productos.get(i);
        viewHolder.setOnClickListener(producto, listener);
        viewHolder.txtDatos.setText(context.getString(R.string.item_product_data, producto.getNombre(),
                ""+ producto.getCatidad()));
        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop();
        Glide.with(context).load(producto.getFotoURL()).apply(options).into(viewHolder.imgFoto);
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  View view;
        protected AppCompatImageView imgFoto;
        protected AppCompatTextView txtDatos;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            txtDatos = itemView.findViewById(R.id.txtDatos);
            this.view = itemView;
        }

        public void setOnClickListener(final Producto producto, final onItemClickListener listener) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(producto);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onLongItemClick(producto);
                    return true;
                }
            });
        }
    }
}
