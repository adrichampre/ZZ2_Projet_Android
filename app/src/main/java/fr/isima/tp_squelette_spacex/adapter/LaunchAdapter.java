package fr.isima.tp_squelette_spacex.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.isima.tp_squelette_spacex.Launch;
import fr.isima.tp_squelette_spacex.R;

public class LaunchAdapter extends ArrayAdapter<Launch> {

    int ID;
    LayoutInflater layoutInflater;

    LaunchAdapter(Activity activity, int layoutResourceId, List<Launch> objects){
        super(activity, layoutResourceId, objects);
        ID = layoutResourceId;
        layoutInflater = activity.getLayoutInflater();

    }

    /*public View getView(int postion, View convertView, ViewGroup parent){
        if(convertView == NULL)
            view = layoutInflater.inflate(ID, parent, false);
            TextView name = findViewById(R.id.list)
    }*/
}
