package fr.isima.tp_squelette_spacex.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import fr.isima.tp_squelette_spacex.ws.WsManager;
import fr.isima.tp_squelette_spacex.Launch;


import fr.isima.tp_squelette_spacex.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaunchesActivity extends Activity implements AdapterView.OnItemClickListener, Callback<List<Launch>> {


    private ProgressBar p;
    private ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launches);
        p = findViewById(R.id.progressbar);
        l = findViewById(R.id.list);
        l.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Launch l = (Launch) parent.getItemAtPosition(position);
        if(l.article_link == null){
            Toast.makeText(this, "Pas d'article_link !", Toast.LENGTH_SHORT);
        }
        else{
            /*if(l.article_link.article_link.contains("https://"))
                Intent intent = */
        }

    }

    public void loadLauchnes(){
        p.setVisibility(View.VISIBLE);
        WsManager.getSpaceXService().listLaunches().enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
        p.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onFailure(Call<List<Launch>> call, Throwable t) {
        p.setVisibility(View.INVISIBLE);
        Toast.makeText(this, "Erreur !", Toast.LENGTH_SHORT).show();
    }
}
