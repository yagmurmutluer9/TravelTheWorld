package com.elif.traveltheworld;

import android.view.View;
import android.widget.Button;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    public void testEditPage() {

        final Profile profile = null;


        Button edit =  profile.findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile.openEditProfile();
            }
        });




    }



}