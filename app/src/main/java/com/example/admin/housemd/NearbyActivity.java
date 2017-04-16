package com.example.admin.housemd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NearbyActivity extends AppCompatActivity {

    ImageView i,j,k;
    TextView r,s,t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);

        i = (ImageView) findViewById(R.id.nb_image1);
        j = (ImageView) findViewById(R.id.nb_image2);
        k = (ImageView) findViewById(R.id.nb_image3);
        r = (TextView) findViewById(R.id.nb_name1);
        s = (TextView) findViewById(R.id.nb_name2);
        t = (TextView) findViewById(R.id.nb_name3);

        Picasso.with(this).load(R.drawable.swineflu).into(i);
        Picasso.with(this).load(R.drawable.malaria).into(j);
        Picasso.with(this).load(R.drawable.dengue).into(k);

        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nd1 = new Intent(getApplicationContext(), NearbyDisease.class);
                startActivity(nd1);
            }
        });

        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nd2 = new Intent(getApplicationContext(), NearbyDisease.class);
                startActivity(nd2);
            }
        });

        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nd3 = new Intent(getApplicationContext(), NearbyDisease.class);
                startActivity(nd3);
            }
        });
    }
}
