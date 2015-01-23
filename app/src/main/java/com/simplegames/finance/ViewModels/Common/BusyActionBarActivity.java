package com.simplegames.finance.ViewModels.Common;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by andrey.kakin on 23.01.2015.
 */
public class BusyActionBarActivity extends ActionBarActivity {
    protected ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progress = new ProgressDialog(this);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
    }
}
