package com.elif.traveltheworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Map extends AppCompatActivity implements OnMapReadyCallback {


    static public GoogleMap mMap;
    private Button wentbutton;
    private Button wantbutton;
    final static HashMap<String, GeoJsonLayer> countries_and_names = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        wentbutton = findViewById(R.id.wentbutton);
        wantbutton = findViewById(R.id.wantbutton);



        new MyThread().execute();

    }

    public class MyThread extends AsyncTask<Void, String, HashMap<String, GeoJsonLayer>>
    {

        @Override
        protected HashMap<String, GeoJsonLayer> doInBackground(Void... voids) {


            String[] country_names;
            country_names = new String[]{
                    "Afghanistan", "Angola", "Albania", "United Arab Emirates", "Argentina",
                    "Armenia", "Antarctica", "French Southern and Antarctic Lands", "Australia",
                    "Austria", "Azerbaijan", "Burundi", "Belgium", "Benin", "Burkina Faso",
                    "Bangladesh", "Bulgaria", "The Bahamas", "Bosnia and Herzegovina", "Belarus",
                    "Belize", "Bermuda", "Bolivia,", "Brazil", "Brunei", "Bhutan", "Botswana",
                    "Central African Republic","Canada", "Switzerland", "Chile", "China",
                    "Ivory Coast","Cameroon", "Democratic Republic of the Congo",
                    "Republic of the Congo", "Colombia", "Costa Rica", "Cuba",
                    "Cyprus", "Czech Republic", "Germany", "Djibouti", "Denmark",
                    "Dominican Republic", "Algeria", "Ecuador", "Egypt", "Eritrea",
                    "Western Sahara", "Spain", "Estonia", "Ethiopia", "Finland",
                    "Fiji", "Falkland Islands", "France", "Gabon", "United Kingdom",
                    "Georgia", "Ghana", "Guinea", "Gambia", "Guinea Bissau",
                    "Equatorial Guinea", "Greece", "Greenland", "Guatemala",
                    "French Guiana", "Guyana","Honduras","Croatia", "Haiti",
                    "Hungary","Indonesia", "India", "Ireland", "Iran", "Iraq",
                    "Iceland", "Israel", "Italy", "Jamaica", "Jordan",
                    "Japan", "Kazakhstan", "Kenya", "Kyrgyzstan", "Cambodia",
                    "South Korea", "Kuwait", "Laos", "Lebanon", "Liberia",
                    "Libya", "Sri Lanka", "Lesotho", "Lithuania", "Luxembourg", "Latvia",
                    "Morocco", "Moldova", "Madagascar", "Mexico", "Macedonia", "Mali",
                    "Malta", "Myanmar","Montenegro", "Mongolia", "Mozambique", "Mauritania",
                    "Malawi","Malaysia","Namibia", "New Caledonia", "Niger","Nigeria",
                    "Nicaragua", "Netherlands","Norway","Nepal","New Zealand", "Oman",
                    "Pakistan","Panama", "Peru", "Philippines", "Papua New Guinea","Poland",
                    "Puerto Rico", "North Korea", "Portugal", "Paraguay", "West Bank","Qatar",
                    "Romania", "Russia", "Rwanda", "Saudi Arabia", "Sudan", "Senegal", "Solomon Islands",
                    "Sierra Leone", "El Salvador","Somalia", "Republic of Serbia","South Sudan",
                    "Suriname","Slovakia","Slovenia", "Sweden", "Swaziland", "Syria", "Chad", "Togo",
                    "Thailand", "Tajikistan","Turkmenistan","East Timor","Trinidad and Tobago","Tunisia",
                    "Turkey", "Taiwan", "United Republic of Tanzania","Uganda","Ukraine",
                    "Uruguay","United States of America", "Uzbekistan","Venezuela", "Vietnam","Vanuatu",
                    "Yemen", "South Africa", "Zambia","Zimbabwe"};
            Integer[] country_layers;
            country_layers = new Integer[]{
                    R.raw.afggeo, R.raw.agogeo, R.raw.albgeo, R.raw.aregeo, R.raw.arggeo, R.raw.armgeo, R.raw.atageo,
                    R.raw.atfgeo, R.raw.ausgeo, R.raw.autgeo, R.raw.azegeo, R.raw.bdigeo, R.raw.belgeo, R.raw.bengeo,
                    R.raw.bfageo, R.raw.bgdgeo, R.raw.bgrgeo, R.raw.bhsgeo, R.raw.bihgeo, R.raw.blrgeo, R.raw.blzgeo,
                    R.raw.bmugeo, R.raw.bolgeo, R.raw.brageo, R.raw.brngeo, R.raw.btngeo, R.raw.bwageo, R.raw.cafgeo,
                    R.raw.cangeo, R.raw.chegeo, R.raw.chlgeo, R.raw.chngeo, R.raw.civgeo, R.raw.cmrgeo, R.raw.codgeo,
                    R.raw.coggeo, R.raw.colgeo, R.raw.crigeo, R.raw.cubgeo, R.raw.cypgeo, R.raw.czegeo, R.raw.deugeo,
                    R.raw.djigeo, R.raw.dnkgeo, R.raw.domgeo, R.raw.dzageo, R.raw.ecugeo, R.raw.egygeo, R.raw.erigeo,
                    R.raw.eshgeo, R.raw.espgeo, R.raw.estgeo, R.raw.ethgeo,  R.raw.fingeo, R.raw.fjigeo,
                    R.raw.flkgeo, R.raw.frageo, R.raw.gabgeo, R.raw.gbrgeo, R.raw.geogeo, R.raw.ghageo, R.raw.gingeo,
                    R.raw.gmbgeo, R.raw.gnbgeo, R.raw.gnqgeo, R.raw.grcgeo, R.raw.grlgeo, R.raw.gtmgeo, R.raw.gufgeo,
                    R.raw.guygeo, R.raw.hndgeo, R.raw.hrvgeo, R.raw.htigeo, R.raw.hungeo, R.raw.idngeo, R.raw.indgeo,
                    R.raw.irlgeo, R.raw.irngeo, R.raw.irqgeo, R.raw.islgeo, R.raw.isrgeo, R.raw.itageo, R.raw.jamgeo,
                    R.raw.jorgeo, R.raw.jpngeo, R.raw.kazgeo, R.raw.kengeo, R.raw.kgzgeo, R.raw.khmgeo, R.raw.korgeo,
                    R.raw.kwtgeo, R.raw.laogeo, R.raw.lbngeo, R.raw.lbrgeo, R.raw.lbygeo, R.raw.lkageo, R.raw.lsogeo,
                    R.raw.ltugeo, R.raw.luxgeo, R.raw.lvageo, R.raw.margeo, R.raw.mdageo, R.raw.mdggeo, R.raw.mexgeo,
                    R.raw.mkdgeo, R.raw.mligeo, R.raw.mltgeo, R.raw.mmrgeo, R.raw.mnegeo, R.raw.mnggeo, R.raw.mozgeo,
                    R.raw.mrtgeo, R.raw.mwigeo, R.raw.mysgeo, R.raw.namgeo, R.raw.nclgeo, R.raw.nergeo, R.raw.ngageo,
                    R.raw.nicgeo, R.raw.nldgeo, R.raw.norgeo, R.raw.nplgeo, R.raw.nzlgeo,  R.raw.omngeo, R.raw.pakgeo,
                    R.raw.pangeo, R.raw.pergeo, R.raw.phlgeo, R.raw.pnggeo, R.raw.polgeo, R.raw.prigeo, R.raw.prkgeo,
                    R.raw.prtgeo, R.raw.prygeo, R.raw.psegeo, R.raw.qatgeo, R.raw.rougeo, R.raw.rusgeo, R.raw.rwageo,
                    R.raw.saugeo, R.raw.sdngeo, R.raw.sengeo, R.raw.slbgeo, R.raw.slegeo, R.raw.slvgeo, R.raw.somgeo,
                    R.raw.srbgeo, R.raw.ssdgeo, R.raw.surgeo, R.raw.svkgeo, R.raw.svngeo, R.raw.swegeo,  R.raw.swzgeo,
                    R.raw.syrgeo, R.raw.tcdgeo, R.raw.tgogeo, R.raw.thageo, R.raw.tjkgeo, R.raw.tkmgeo, R.raw.tlsgeo,
                    R.raw.ttogeo, R.raw.tungeo, R.raw.turgeo, R.raw.twngeo, R.raw.tzageo, R.raw.ugageo, R.raw.ukrgeo,
                    R.raw.urygeo, R.raw.usageo, R.raw.uzbgeo, R.raw.vengeo, R.raw.vnmgeo, R.raw.vutgeo, R.raw.yemgeo,
                    R.raw.zafgeo, R.raw.zmbgeo, R.raw.zwegeo};



            try {

                for (int item = 0; item < country_names.length; item++) {
                    countries_and_names.put(country_names[item], new GeoJsonLayer(mMap, country_layers[item], getApplicationContext()));
                }
            }
            catch (Exception e) {
                e.getStackTrace();
            }

            return  countries_and_names;
        }

        @Override
        protected void onPostExecute(final HashMap<String, GeoJsonLayer> r) {

            try {

                final Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

                mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {
                        try {


                            final List<Address> addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);

                            Toast.makeText(getApplicationContext(), "Do you want to go  " + addresses.get(0).getCountryName()
                                    + "?", Toast.LENGTH_LONG).show();

                            wentbutton.setOnClickListener(new View.OnClickListener() {
                                @Override

                                public void onClick(View v) {
                                    if (r.keySet().contains(addresses.get(0).getCountryName())) {


                                        GeoJsonLayer layer = r.get(addresses.get(0).getCountryName());
                                        GeoJsonPolygonStyle polygonStyle = layer.getDefaultPolygonStyle();
                                        polygonStyle.setPolygonFillColor(getRandomColor());
                                        polygonStyle.setStrokeWidth(0);
                                        layer.addLayerToMap();

                                    }

                                }
                            });



                        } catch (Exception e) {
                            //
                        }
                    }



                });

            }

            catch (Exception ex) {
                //
            }



        }


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
            Intent intent= new Intent(Map.this, MainActivity.class);
            startActivity(intent);
        }
        if(id==R.id.item2){
            Intent intent= new Intent(Map.this, Total.class);
            startActivity(intent);
        }
        if(id==R.id.item3){
            Intent intent= new Intent(Map.this, Where2Go.class);
            startActivity(intent);
        }
        if(id==R.id.item4){
            Intent intent= new Intent(Map.this, Profile.class);
            startActivity(intent);
        }
        if(id==R.id.item5){
            Intent intent= new Intent(Map.this, Profile.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }





    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


    }



    public ArrayList<String> visitedCountries(String countryName) {


        ArrayList<String > visited_countries = new ArrayList<> ();

        visited_countries.add(countryName);

        return  visited_countries;


    }


    static public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}



