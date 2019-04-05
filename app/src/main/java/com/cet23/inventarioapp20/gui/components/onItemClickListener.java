package com.cet23.inventarioapp20.gui.components;

import com.cet23.inventarioapp20.model.Producto;

public interface onItemClickListener {

    void onItemClick(Producto producto);
    void onLongItemClick(Producto producto);
}
