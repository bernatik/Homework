package com.alexbernat.classwork22;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.alexbernat.homework.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ToggleButton toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        toggle = (ToggleButton)findViewById(R.id.toggle);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                else
                    mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng minsk = new LatLng(53.902230, 27.561957);
        LatLng brest = new LatLng(52.093495, 23.731818);
        LatLng gomel = new LatLng(52.431122, 30.984319);
        LatLng vitebsk = new LatLng(55.191293, 30.193647);
        LatLng mogilev = new LatLng(53.905594, 30.332693);
        LatLng grodno = new LatLng(53.675925, 23.834065);

        PolylineOptions line1 = new PolylineOptions()
                .add(brest)
                .add(minsk);
        PolylineOptions line2 = new PolylineOptions()
                .add(gomel)
                .add(minsk);
        PolylineOptions line3 = new PolylineOptions()
                .add(vitebsk)
                .add(minsk);
        PolylineOptions line4 = new PolylineOptions()
                .add(mogilev)
                .add(minsk);
        PolylineOptions line5 = new PolylineOptions()
                .add(grodno)
                .add(minsk);

        mMap.addPolyline(line1);
//        line.setColor(R.color.color_red);
        mMap.addPolyline(line2);
        mMap.addPolyline(line3);
        mMap.addPolyline(line4);
        mMap.addPolyline(line5);

        mMap.addMarker(new MarkerOptions().position(minsk).title("Minsk"));
        mMap.addMarker(new MarkerOptions().position(brest).title("Brest"));
        mMap.addMarker(new MarkerOptions().position(gomel).title("Gomel"));
        mMap.addMarker(new MarkerOptions().position(vitebsk).title("Vitebsk"));
        mMap.addMarker(new MarkerOptions().position(mogilev).title("Mogilev"));
        mMap.addMarker(new MarkerOptions().position(grodno).title("Grodno"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(minsk));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(5.0f));
    }
}
