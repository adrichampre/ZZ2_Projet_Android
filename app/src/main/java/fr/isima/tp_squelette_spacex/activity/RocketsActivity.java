package fr.isima.tp_squelette_spacex.activity;


import androidx.annotation.Nullable;
import fr.isima.tp_squelette_spacex.R;
import fr.isima.tp_squelette_spacex.model.Rocket;
import fr.isima.tp_squelette_spacex.adapter.RocketAdapter;
import fr.isima.tp_squelette_spacex.ws.WsManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

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

    private ProgressBar progressBar;
    private ListView listView;
    private RocketAdapter rocketadapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rockets);
        progressBar = findViewById(R.id.progressbarRocket);
        listView = findViewById(R.id.listRocket);
        listView.setOnItemClickListener(this);
        loadRockets();
    }

    public void loadRockets(){
        progressBar.setVisibility(View.VISIBLE);
        WsManager.getSpaceXService().listRockets().enqueue(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Rocket r = (Rocket) parent.getItemAtPosition(position);
        Intent intent = new Intent(this, RocketActivity.class).putExtra("Rocket", r);
        startActivity(intent);
    }

    @Override
    public void onResponse(@Nullable Call<List<Rocket>> call, Response<List<Rocket>> response) {
        progressBar.setVisibility(View.INVISIBLE);
        rocketadapt = new RocketAdapter(this, android.R.layout.simple_list_item_1, response.body());
        listView.setAdapter(rocketadapt);
    }

    @Override
    public void onFailure(@Nullable Call<List<Rocket>> call, @Nullable Throwable t) {
        progressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(this, "Erreur aucune réponse !", Toast.LENGTH_SHORT).show();
    }
}
