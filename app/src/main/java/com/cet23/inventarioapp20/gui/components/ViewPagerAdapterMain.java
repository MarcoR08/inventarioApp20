package com.cet23.inventarioapp20.gui.components;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cet23.inventarioapp20.gui.ClientesFragment;
import com.cet23.inventarioapp20.gui.ProductosFragment;
import com.cet23.inventarioapp20.gui.VentaFragment;

public class ViewPagerAdapterMain extends FragmentPagerAdapter {




    private FragmentManager fragmentManager;
    private ProductosFragment productosFragment;
    private ClientesFragment clientesFragment;
    private VentaFragment ventaFragment;

    public ViewPagerAdapterMain(FragmentManager fm) {
        super(fm);
        this.fragmentManager = fm;
        inicializar();
    }

    private void inicializar() {

        productosFragment = new ProductosFragment();
        clientesFragment= new ClientesFragment();
        ventaFragment = new VentaFragment();

    }

    public ProductosFragment getProductosFragment() {


        return productosFragment;
    }

    public ClientesFragment getClientesFragment() {


        return clientesFragment;
    }

    public VentaFragment getVentasFragment() {


      return ventaFragment;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return productosFragment;


            case 1:
                return clientesFragment;

            case 2:
                return ventaFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {


        return 3;
    }
}
