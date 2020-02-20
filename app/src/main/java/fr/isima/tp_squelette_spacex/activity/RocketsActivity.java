package fr.isima.tp_squelette_spacex.activity;


import fr.isima.tp_squelette_spacex.R;
import fr.isima.tp_squelette_spacex.adapter.Rocket;
import fr.isima.tp_squelette_spacex.adapter.RocketAdapter;
import fr.isima.tp_squelette_spacex.ws.WsManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

public class RocketsActivity extends Activity implements AdapterView.OnItemClickListener, Callback<List<Rocket>>{

    private ProgressBar p;
    private ListView l;
    private RocketAdapter rocketadapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rockets);
        p = findViewById(R.id.progressbarRocket);
        l = findViewById(R.id.listRocket);
        l.setOnItemClickListener(this);
        loadRockets();
    }

    public void loadRockets(){
        p.setVisibility(View.VISIBLE);
        WsManager.getSpaceXService().listRockets().enqueue(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        Rocket r = (Rocket) parent.getItemAtPosition(position);
        intent = new Intent(this, RocketActivity.class).putExtra("Rocket", r);
        startActivity(intent);
    }

    @Override
    public void onResponse(Call<List<Rocket>> call, Response<List<Rocket>> response) {
        p.setVisibility(View.INVISIBLE);
        rocketadapt = new RocketAdapter(this, android.R.layout.simple_list_item_1, response.body());
        l.setAdapter(rocketadapt);
    }

    @Override
    public void onFailure(Call<List<Rocket>> call, Throwable t) {
        p.setVisibility(View.INVISIBLE);
        Toast.makeText(this, "Erreur aucune réponse !", Toast.LENGTH_SHORT).show();
    }
}
