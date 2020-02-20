package fr.isima.tp_squelette_spacex.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import fr.isima.tp_squelette_spacex.model.Rocket;


public class RocketAdapter extends ArrayAdapter<Rocket> {
    private int layoutResourceId;
    private LayoutInflater inflater;

    public RocketAdapter(Activity activity, int layoutResourceId, List<Rocket> data)
    {
        super(activity, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        inflater = activity.getLayoutInflater();
    }

    @Override @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(layoutResourceId, parent, false);
        }
        ViewHolder holder = (ViewHolder)view.getTag();
        if (holder == null)
        {
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        Rocket rocket = getItem(position);
        if(rocket != null)
            holder.rocketName.setText(rocket.rocket_name);

        return view;
    }


    private class ViewHolder
    {
        private TextView rocketName;

        private ViewHolder(View row)
        {
            rocketName = row.findViewById(android.R.id.text1);
        }
    }
}
