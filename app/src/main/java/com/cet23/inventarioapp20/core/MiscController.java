package com.cet23.inventarioapp20.core;

import android.content.Context;
import android.app.AlertDialog;

import com.cet23.inventarioapp20.R;

import java.security.PrivateKey;

import dmax.dialog.SpotsDialog;

public class MiscController {




    private static MiscController instance=null;
    private AlertDialog alertDialog;



    private MiscController(){}
    public static MiscController Instance()
    {
        if (instance == null)
            instance = new MiscController();
        return instance;
    }
    public void ShowWait(Context context,String message)
    {
        alertDialog = new SpotsDialog(context,message, R.style.CustomProgressBar);
        alertDialog.show();
    }

    public void CloseWait(){
        if (alertDialog !=null && alertDialog.isShowing())
            alertDialog.dismiss();
    }
}
