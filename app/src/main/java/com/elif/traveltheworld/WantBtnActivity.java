package com.elif.traveltheworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WantBtnActivity extends AppCompatActivity  implements View.OnClickListener{

    Button mapbtn;
    Button wikibtn;
    String value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_btn);

        mapbtn = findViewById(R.id.gmapbtn);
        mapbtn.setOnClickListener(this);
        wikibtn = findViewById(R.id.wikibtn);
        wikibtn.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
             value = extras.getString("Key");
        }



    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.gmapbtn:

                String geoUri = "https://www.google.com/maps/place/" + value;

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                this.startActivity(intent);
                break;
            case R.id.wikibtn:

                String wikiUri = "https://en.wikipedia.org/wiki/" + value;

                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(wikiUri));
                this.startActivity(intent2);

                break;



        }

    }
}
