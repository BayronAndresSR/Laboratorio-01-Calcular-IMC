package com.example.calcularimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String NAME_IMC = "NAME_IMC";
    public static final String WEIGHT_IMC = "WEIGHT_IMC";
    public static final String HEIGHT_IMC = "HEIGHT_IMC";

    EditText input_name, input_weight, input_height;
    Button button_calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_name = findViewById(R.id.input_name);
        input_weight = findViewById(R.id.input_weight);
        input_height = findViewById(R.id.input_height);
        button_calculate = findViewById(R.id.button_calculate);

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = input_name.getText().toString();
                float weight = Float.parseFloat(input_weight.getText().toString());
                float height = Float.parseFloat(input_height.getText().toString());
                if(name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Ingrese nombre", Toast.LENGTH_SHORT).show();
                }else{
                    SendDataForActivity(name, weight, height);
                }
            }
        });

    }

    private void SendDataForActivity(String name, float weight, float height){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(NAME_IMC, name);
        intent.putExtra(WEIGHT_IMC, weight);
        intent.putExtra(HEIGHT_IMC, height);
        startActivity(intent);
    }
}