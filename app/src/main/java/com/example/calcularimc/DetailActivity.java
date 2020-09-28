package com.example.calcularimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calcularimc.Models.IMC;

public class DetailActivity extends AppCompatActivity {

    TextView detail_name, detail_recommendation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detail_name = findViewById(R.id.detail_name);
        detail_recommendation = findViewById(R.id.detail_recommendation);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.NAME_IMC);
        float weight = intent.getFloatExtra(MainActivity.WEIGHT_IMC, 0);
        float height = intent.getFloatExtra(MainActivity.HEIGHT_IMC, 0);
        IMC imc = new IMC();
        imc.setName(name);
        imc.setWeight(weight);
        imc.setHeight(height);
        CalculateIMC(imc);
    }

    private void CalculateIMC(IMC obj){
        String recommendation = getRecommendation(obj.getImc());
        String hello_name = "Hola " + obj.getName();
        detail_name.setText(hello_name);
        detail_recommendation.setText(recommendation);
    }

    public String getRecommendation(float imc){
        String recommendation="";
        if(imc<16.00){
            recommendation= getString(R.string.imc_0);
        }else if(imc<=16.00 || imc<=16.99){
            recommendation=getString(R.string.imc_1);
        }else if(imc<=17.00 || imc<=18.49){
            recommendation=getString(R.string.imc_2);
        }else if(imc<=18.50 || imc<=24.99){
            recommendation=getString(R.string.imc_3);
        }else if(imc<=25.00 || imc<=29.99){
            recommendation=getString(R.string.imc_4);
        }else if(imc<=30.00 || imc<=34.99){
            recommendation=getString(R.string.imc_5);
        }else if(imc<=35.00 || imc==40.00){
            recommendation=getString(R.string.imc_6);
        }else{
            recommendation=getString(R.string.imc_7);
        }
        return recommendation;
    }
}