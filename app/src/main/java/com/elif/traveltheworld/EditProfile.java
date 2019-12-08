package com.elif.traveltheworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
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
            Intent intent= new Intent(EditProfile.this, MainActivity.class);
            startActivity(intent);
        }
        if(id==R.id.item2){
            Intent intent= new Intent(EditProfile.this, Total.class);
            startActivity(intent);
        }
        if(id==R.id.item3){
            Intent intent= new Intent(EditProfile.this, Where2Go.class);
            startActivity(intent);
        }
        if(id==R.id.item4){
            Intent intent= new Intent(EditProfile.this, Profile.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
