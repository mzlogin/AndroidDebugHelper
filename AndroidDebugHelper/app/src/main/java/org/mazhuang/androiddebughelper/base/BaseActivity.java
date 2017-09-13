package org.mazhuang.androiddebughelper.base;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.mazhuang.androiddebughelper.R;

/**
 * Created by Lenovo on 2017/8/1.
 */

public class BaseActivity extends AppCompatActivity {
    protected void alert(String msg) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.tips)
                .setMessage(msg)
                .setPositiveButton(R.string.ok_i_know, null)
                .show();
    }

    protected void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
