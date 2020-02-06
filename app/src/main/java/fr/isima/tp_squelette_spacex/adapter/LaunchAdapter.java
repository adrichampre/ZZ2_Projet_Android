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
import fr.isima.tp_squelette_spacex.activity.LaunchesActivity;
import fr.isima.tp_squelette_spacex.ws.WsManager;

public class LaunchAdapter extends ArrayAdapter<Launch> {

    int ID;
    LayoutInflater layoutInflater;

    LaunchAdapter(Activity activity, int layoutResourceId, List<Launch> objects) {
        super(activity, layoutResourceId, objects);
        ID = layoutResourceId;
        layoutInflater = activity.getLayoutInflater();

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = layoutInflater.inflate(ID, parent, false);
        TextView nomFusee = convertView.findViewById(R.id.nomFusee);
        nomFusee.setText(getItem(position).info_rocket.rocket_name);
        TextView nomMission = convertView.findViewById(R.id.nomFusee);
        nomMission.setText(getItem(position).mission_name);
        TextView dateMission = convertView.findViewById(R.id.nomFusee);
        dateMission.setText(getItem(position).launch_date_unix.toString());

        return convertView;
    }
}
