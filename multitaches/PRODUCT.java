package com.example.multitaches;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class PRODUCT extends AppCompatActivity {
    Switch swtch;
    Button btndec, btnrechrch;
    ListView listview;
    BluetoothAdapter bluetoothadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        testing();
        swtch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true){
                  OnBT();
                  swtch.setText("ON");
                }else{
                    offBT();
                    swtch.setText("OFF");
                }
            }

        });
        if (!bluetoothadapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivityForResult(enableBtIntent, 1);
        }
    }



    @SuppressLint("MissingPermission")
    public void testing(){
        bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothadapter == null) {
         Toast.makeText(getApplicationContext(),"Device doesn't support PRODUCT",Toast.LENGTH_LONG).show();
        }
        else { Toast.makeText(getApplicationContext(),"Device supports PRODUCT",Toast.LENGTH_LONG).show();

        } }
        @SuppressLint("MissingPermission")
        public void OnBT(){
            if (!bluetoothadapter.isEnabled() ) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
            } }
            @SuppressLint("MissingPermission")
            public void offBT(){
                bluetoothadapter.disable();
            }
        }





