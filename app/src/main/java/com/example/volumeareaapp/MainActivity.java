package com.example.volumeareaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<ModalClassShape> shapeArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //write here
        //1.adapter view Grid view
        gridView=findViewById(R.id.grid_view);
        //2.Data source ArrayList<ModalClassShape>
        shapeArrayList=new ArrayList<>();
        //3.adapter -->myCustomAdapter
        myCustomAdapter adapter;


        ModalClassShape s1=new ModalClassShape(R.drawable.sphere,"Sphere");
        ModalClassShape s2=new ModalClassShape(R.drawable.cylinder,"Cylinder");
        ModalClassShape s3=new ModalClassShape(R.drawable.cube,"Cube");
        ModalClassShape s4=new ModalClassShape(R.drawable.prism,"Prism");

        shapeArrayList.add(s1);
        shapeArrayList.add(s2);
        shapeArrayList.add(s3);
        shapeArrayList.add(s4);

        adapter= new myCustomAdapter(shapeArrayList,getApplicationContext());
        gridView.setAdapter(adapter);
        //no. of column in grid
        gridView.setNumColumns(2);//android::numColumns="2"

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getApplicationContext(),Sphere.class);
                startActivity(i);
            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}