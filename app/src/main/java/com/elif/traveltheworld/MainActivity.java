package com.elif.traveltheworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button where;
    private Button total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        where = (Button) findViewById(R.id.where);
        where.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWhere2Go();
            }
        });
        total = (Button) findViewById(R.id.total);
        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                openProfile();
            }
        });

    }
    public void openWhere2Go(){
        Intent intent = new Intent(this, Where2Go.class);
        startActivity(intent);

    }
    public void openProfile(){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.item1){
            Intent intent= new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }
        if(id==R.id.item2){
            Intent intent= new Intent(MainActivity.this, Profile.class);
            startActivity(intent);
        }
        if(id==R.id.item3){
            Intent intent= new Intent(MainActivity.this, Where2Go.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
