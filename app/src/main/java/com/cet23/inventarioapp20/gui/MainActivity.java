package com.cet23.inventarioapp20.gui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.cet23.inventarioapp20.R;
import com.cet23.inventarioapp20.core.ClienteController;
import com.cet23.inventarioapp20.core.MiscController;
import com.cet23.inventarioapp20.core.ProductoController;
import com.cet23.inventarioapp20.core.VentaController;
import com.cet23.inventarioapp20.gui.components.ViewPagerAdapterMain;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
public static HashMap<String,Object> GLOBALS= new HashMap<>();
    @BindView(R.id.tlbPrincipal)
    Toolbar tlbPrincipal;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.id_appbar)
    AppBarLayout idAppbar;
    @BindView(R.id.viewPagerMain)
    ViewPager viewPagerMain;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;
    private ViewPagerAdapterMain viewPagerAdapterMain;
    private ProductoController productoController = ProductoController.instance();
    private ClienteController clienteController = ClienteController.instance();
    private VentaController ventaController = VentaController.instance();
    private MiscController miscController = MiscController.Instance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        inicializar();
    }
    private void inicializar() {
        GLOBALS.put("app", this);
        viewPagerAdapterMain = new ViewPagerAdapterMain(getSupportFragmentManager());
        viewPagerMain.setAdapter(viewPagerAdapterMain);
        setSupportActionBar(tlbPrincipal);
        tabLayout.setupWithViewPager(viewPagerMain);
        tabLayout.getTabAt(0).setText("Productos");
        tabLayout.getTabAt(1).setText("Clientes");
        tabLayout.getTabAt(2).setText("Ventas");
        miscController.ShowWait(MainActivity.this,"Consultando Productos...");
        productoController.GetAll();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        try {
                            miscController.ShowWait(MainActivity.this,"Consultando Productos...");
                            productoController.GetAll();
                        } catch(Exception ex){

                        }
                        break;
                    case 1:
                        try {
                            miscController.ShowWait(MainActivity.this,"Consultando Clientes...");
                            clienteController.GetAll();
                        } catch(Exception ex){

                        }
                        break;
                    case 2:
                        try {
                            miscController.ShowWait(MainActivity.this,"Consultando Ventas...");
                            ventaController.GetAll();
                        } catch(Exception ex){

                        }
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
