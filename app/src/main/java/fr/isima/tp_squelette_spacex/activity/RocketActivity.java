package fr.isima.tp_squelette_spacex.activity;

import androidx.viewpager.widget.ViewPager;
import fr.isima.tp_squelette_spacex.R;
import fr.isima.tp_squelette_spacex.adapter.PicturesPager;
import fr.isima.tp_squelette_spacex.model.Rocket;

import android.app.Activity;
import android.os.Bundle;

public class RocketActivity extends Activity {

    private ViewPager viewpager;
    private Rocket rocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rocket);
        viewpager = findViewById(R.id.viewpager);
        if (viewpager == null)
        {
            finish();
        }
        else{
            rocket = (Rocket) getIntent().getSerializableExtra("Rocket");
            if(rocket != null)
                viewpager.setAdapter(new PicturesPager(this, rocket.flickr_images));
        }
    }
}
