package com.example.christopher.proyecto;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    public void showDetails(String name) {
        TextView TextView = (TextView) getView().findViewById(R.id.TextView);
        TextView.setText(name.substring(0, name.length()-6));
        ImageView ImageView1 = (ImageView) getView().findViewById(R.id.ImageView);
        ImageView1.setScaleType(ImageView.ScaleType.FIT_XY); // stretch image
        if (name.equals("TOYOTA $1000")) {
            ImageView1.setImageResource(R.drawable.toyota);
        } else if (name.equals("HONDA $2000")) {
            ImageView1.setImageResource(R.drawable.honda);
        } else if (name.equals("HYUNDAI $3000")) {
            ImageView1.setImageResource(R.drawable.hyundai);
        } else if (name.equals("BMW $5000")) {
            ImageView1.setImageResource(R.drawable.bmw);
        }
    }
}

