package fr.isima.tp_squelette_spacex.activity;

import androidx.viewpager.widget.ViewPager;
import fr.isima.tp_squelette_spacex.R;
import fr.isima.tp_squelette_spacex.adapter.PicturesPager;
import fr.isima.tp_squelette_spacex.adapter.Rocket;

import android.app.Activity;
import android.os.Bundle;

public class RocketActivity extends Activity {

    private ViewPager viewpager;
    private Rocket r;

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
            r = (Rocket) getIntent().getSerializableExtra("Rocket");
            viewpager.setAdapter(new PicturesPager(this, r.flickr_images));
        }
    }
}
