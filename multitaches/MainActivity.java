package com.example.multitaches;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  public CardView bluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetooth = (CardView) findViewById(R.id.bluetooth);
        bluetooth.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch  (view.getId()){
            case R.id.bluetooth:
                i= new Intent(this, PRODUCT.class);
                startActivity(i);
                break;



        }


    }
}