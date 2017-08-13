package com.example.sigkill.eventmap;

/**
 * Created by sigkill on 8/12/17.
 */

import android.app.Fragment;
import android.content.Intent;
import android.location.Location;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

//import com.google.android.gms.location.places;
public class Map extends android.support.v4.app.Fragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
//    private LocationClient mLocationClient;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_maps, container, false);

        SupportMapFragment mapFragment =  (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        return rootView;
    }

    public java.util.Map<Marker, String> dict;

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        LatLng moscow = new LatLng(55.751244, 37.618423);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(moscow));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(mMap.getCameraPosition().zoom + 10.0f));
        mMap.setOnMapClickListener(this);

    }

    Integer hashcode = 0;
    @Override
    public void onMapClick(final LatLng latlng) {

        Marker marker = mMap.addMarker(new MarkerOptions()
                .position(latlng)
                .title("default")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));



        if (dict == null) {
            dict = new HashMap<Marker, String>();
        }

        String id = hashcode.toString();
        hashcode += 1;

        dict.put(marker, id);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String id = dict.get(marker);
                Intent intent = new Intent(getActivity(), CreateEventActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);

                return true;
            }
        });

        Intent intent = new Intent(getActivity(), CreateEventActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("latlng", latlng);
        startActivity(intent);


    }

}
