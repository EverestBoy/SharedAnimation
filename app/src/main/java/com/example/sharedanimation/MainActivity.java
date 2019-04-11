package com.example.sharedanimation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private CardView cardView;
    private ImageView imageView;
    private TextView title;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cardView = findViewById(R.id.card);
        imageView = findViewById(R.id.image);
        title = findViewById(R.id.name);
        desc = findViewById(R.id.desc);

        cardView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(MainActivity.this, SharedActivity.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(imageView,"imageTransition");
                pairs[1] = new Pair<View, String>(title,"titleTransition");
                pairs[2] = new Pair<View, String>(desc,"descTransition");

                ActivityOptions activityOptions = (ActivityOptions) ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs );

                startActivity(i, activityOptions.toBundle());
//                startActivity(i);
            }
        });

    }
}
