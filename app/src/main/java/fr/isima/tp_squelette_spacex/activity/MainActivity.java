package fr.isima.tp_squelette_spacex.activity;

import androidx.annotation.NonNull;
import fr.isima.tp_squelette_spacex.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mission)
        {
            startActivity(new Intent(this, LaunchesActivity.class));
        }
        if(item.getItemId() == R.id.rockets)
        {

        }
        return super.onOptionsItemSelected(item);
    }
}
