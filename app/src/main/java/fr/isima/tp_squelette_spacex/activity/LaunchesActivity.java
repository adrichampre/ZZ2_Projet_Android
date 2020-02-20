package fr.isima.tp_squelette_spacex.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.Nullable;
import fr.isima.tp_squelette_spacex.adapter.LaunchAdapter;
import fr.isima.tp_squelette_spacex.ws.WsManager;
import fr.isima.tp_squelette_spacex.model.Launch;


import fr.isima.tp_squelette_spacex.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Intent.ACTION_VIEW;

public class LaunchesActivity extends Activity implements AdapterView.OnItemClickListener, Callback<List<Launch>> {


    private ProgressBar progressBar;
    private ListView listView;
    private LaunchAdapter launchadapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launches);
        progressBar = findViewById(R.id.progressbar);
        listView = findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        loadLaunches();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        Launch listView = (Launch) parent.getItemAtPosition(position);
        if(listView.links.article_link == null){
            Toast.makeText(this, "Pas d'article_link !", Toast.LENGTH_SHORT).show();
        }
        else{
            if(listView.links.article_link.contains("https://")) {
                intent = new Intent(this, LaunchActivity.class).putExtra("Launch", listView);
            }
            else{
                intent = new Intent(ACTION_VIEW,Uri.parse(listView.links.article_link));
            }
            startActivity(intent);
        }
    }

    public void loadLaunches(){
        progressBar.setVisibility(View.VISIBLE);
        WsManager.getSpaceXService().listLaunches().enqueue(this);
    }

    @Override
    public void onResponse(@Nullable Call<List<Launch>> call, Response<List<Launch>> response) {
        progressBar.setVisibility(View.INVISIBLE);
        launchadapt = new LaunchAdapter(this, R.layout.layout, response.body());
        listView.setAdapter(launchadapt);
    }

    @Override
    public void onFailure(@Nullable Call<List<Launch>> call, @Nullable Throwable t) {
        progressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(this, "Erreur aucune réponse !", Toast.LENGTH_SHORT).show();
    }
}
