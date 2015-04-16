package com.asa.loginform;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by APRIJAL_PASARIBU on 16/04/2015.
 */
public class DaftarActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.daftar_layout);
        final EditText etNamaDaftar = (EditText)findViewById(R.id.etNamaDaftar);
        final EditText etNamaPenggunaDaftar = (EditText)findViewById(R.id.etNamaPenggunaDaftar);
        final EditText etSandiDaftar = (EditText)findViewById(R.id.etSandiDaftar);
        final EditText etSandiUlangDaftar = (EditText)findViewById(R.id.etSandiUlangDaftar);
        Button btnDaftar = (Button)findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etSandiUlangDaftar.getText().toString().equals(etSandiDaftar.getText().toString()) && etNamaDaftar.getText() != null && etNamaPenggunaDaftar.getText() != null) {
                    SharedPreferences user = getApplicationContext().getSharedPreferences("user", MODE_PRIVATE);
                    SharedPreferences.Editor editor = user.edit();
                    editor.putString(etNamaPenggunaDaftar.getText().toString(), etNamaDaftar.getText().toString());
                    editor.putBoolean(etNamaPenggunaDaftar.getText().toString() + etSandiDaftar.getText().toString(), true);
                    editor.apply();
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
