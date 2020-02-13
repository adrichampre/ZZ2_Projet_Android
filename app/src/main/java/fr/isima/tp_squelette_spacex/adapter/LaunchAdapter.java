package fr.isima.tp_squelette_spacex.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import fr.isima.tp_squelette_spacex.R;

public class LaunchAdapter extends ArrayAdapter<Launch> {

    int ID;
    LayoutInflater layoutInflater;

    public LaunchAdapter(Activity activity, int layoutResourceId, List<Launch> objects) {
        super(activity, layoutResourceId, objects);
        ID = layoutResourceId;
        layoutInflater = activity.getLayoutInflater();

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(ID, parent, false);
        }
        TextView nomFusee = convertView.findViewById(R.id.nomFusee);
        nomFusee.setText(getItem(position).rocket.rocket_name);
        TextView nomMission = convertView.findViewById(R.id.nomMission);
        nomMission.setText(getItem(position).mission_name);
        TextView dateMission = convertView.findViewById(R.id.dateMission);
        Date date = new Date(getItem(position).launch_date_unix);
        SimpleDateFormat formater = new SimpleDateFormat("dd MMMM yyyy hh:mm");
        dateMission.setText(formater.format(date));

        return convertView;
    }
}
