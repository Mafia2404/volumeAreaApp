package com.example.volumeareaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Sphere extends AppCompatActivity {

    EditText radius;
    Button btn;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);

        radius=findViewById(R.id.editText);
        btn=findViewById(R.id.button);
        result=findViewById(R.id.textView4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=radius.getText().toString();
                int r=Integer.parseInt(s);
                double vol=(4/3)*3.1415*r*r*r;
                result.setText("Result: "+vol+"m^3");
            }
        });


    }
}