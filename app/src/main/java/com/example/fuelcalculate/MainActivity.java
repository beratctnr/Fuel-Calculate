package com.example.fuelcalculate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtyakit, edtkm;
    Button btnhesap;
    TextView txtsonuc;
    Spinner spinnerYakıtTürü;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtyakit = findViewById(R.id.edtyakit);
        edtkm = findViewById(R.id.edtkm);
        btnhesap = findViewById(R.id.btnhesap);
        txtsonuc = findViewById(R.id.txtsonuc);
        spinnerYakıtTürü = findViewById(R.id.spinnerYakıtTürü);

        btnhesap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double yakit, km, sonuc;
                yakit = Double.parseDouble(edtyakit.getText().toString());
                km = Double.parseDouble(edtkm.getText().toString());


                String yakitTuru = spinnerYakıtTürü.getSelectedItem().toString();
                double litreBasiMaliyet = 0;

                switch (yakitTuru) {
                    case "Gasoline":
                        litreBasiMaliyet = 1.72;
                        break;
                    case "LPG":
                        litreBasiMaliyet = 1.03;
                        break;
                    case "Diesel Oil":
                        litreBasiMaliyet = 1.60;
                        break;
                }

                sonuc = (yakit * litreBasiMaliyet) / km;

                txtsonuc.setText("Your vehicle consumes  " + String.format("%.2f", sonuc) + " £ per km. ");
            }
        });
    }
}
