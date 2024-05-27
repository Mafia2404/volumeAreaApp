package com.example.volumeareaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class myCustomAdapter extends ArrayAdapter<ModalClassShape>{

   private ArrayList<ModalClassShape> shapeArrayList;
    Context context;

    public myCustomAdapter(ArrayList<ModalClassShape> shapeArrayList, Context context) {
        super(context, R.layout.grid_view_layout,shapeArrayList);
        this.shapeArrayList = shapeArrayList;
        this.context = context;
    }
    //viewHolder class :used to cache references to the views within an item layout
    private static class ViewHolder{
        ImageView shapeImg;
        TextView shapeName;
    }
    //getView();used to create and return a view for a specific item in a grid

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //1.get the shape object from the current position
        ModalClassShape modalClassShape=getItem(position);

        //2.Inflating Layout
        ViewHolder myViewHolder;

        if(convertView==null){
            // No view went off the screen -->create new view
            myViewHolder=new ViewHolder();
            LayoutInflater layoutInflater=LayoutInflater.from(getContext());
            convertView= layoutInflater.inflate(R.layout.grid_view_layout,parent,false);
            myViewHolder.shapeImg=(ImageView) convertView.findViewById(R.id.imageView);
            myViewHolder.shapeName=(TextView)convertView.findViewById(R.id.textView);
            convertView.setTag(myViewHolder);
        }
        else{
            //a view went off the screen -->reuse it
            myViewHolder=(ViewHolder) convertView.getTag();
        }
        //getting the data from the modal class -->ModalClassShape
       myViewHolder.shapeName.setText(modalClassShape.getImgName());
        myViewHolder.shapeImg.setImageResource(modalClassShape.getShapeImg());
        return convertView;
    }
}
