package com.example.efm_regio_app_bmi_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText Weight,Height;
    Button ok;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Weight = findViewById(R.id.weight);
        Height = findViewById(R.id.height);
        ok = findViewById(R.id.btnOk);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this , "BMI = "+ calculerBMI() +" , Etat = " + etat(),Toast.LENGTH_LONG).show();
            }
        });

    }

    public double calculerBMI(){
        double w= Double.parseDouble(Weight.getText().toString());
        double h = Double.parseDouble(Height.getText().toString());

        return (w/(703*h*h));
    }

    public String etat(){
        String et = "";
        if(calculerBMI()<18.5){et = "Underweight";}
        else if(calculerBMI()>=18.5 && calculerBMI()<25){et = "Normal";}
        else if(calculerBMI()<40 && calculerBMI()>=25){et = "Overweight";}
        else if(calculerBMI()>=40 ){et = "Obese";}

        return et;
    }
}