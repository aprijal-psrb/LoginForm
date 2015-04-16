package com.asa.loginform;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MasukActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.masuk_layout);
        TextView daftar = (TextView)findViewById(R.id.daftar);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftarActivity = new Intent(getApplicationContext(),DaftarActivity.class);
                startActivity(daftarActivity);
            }
        });
        final EditText etNamaPenggunaMasuk = (EditText)findViewById(R.id.etNamaPenggunaMasuk);
        final EditText etSandiMasuk = (EditText)findViewById(R.id.etSandiMasuk);
        Button btnMasuk = (Button)findViewById(R.id.btnMasuk);
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences user = getApplicationContext().getSharedPreferences("user", MODE_PRIVATE);
                boolean isPenggunaTersedia = user.getBoolean(etNamaPenggunaMasuk.getText().toString() + "Sandi" + etSandiMasuk.getText().toString(), false);
                if (isPenggunaTersedia) {
                    Intent todoActivity = new Intent(getApplicationContext(), TodoActivity.class);
                    todoActivity.putExtra("Nama", user.getString(etNamaPenggunaMasuk.getText().toString(), ""));
                    startActivity(todoActivity);
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.error_pengguna), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
