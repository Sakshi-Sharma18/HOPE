package com.sakshi.hope;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.sakshi.hope.databinding.ActivityMapBinding;

public class mapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        LatLng userLocation = new LatLng(12.9710, 79.1613);
        mMap.addMarker(new MarkerOptions().position(userLocation).title("You are Here"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));

        LatLng D1 = new LatLng(12.9334, 79.1252);
        mMap.addMarker(new MarkerOptions().position(D1).title("Donor 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(D1));

        LatLng D2 = new LatLng(12.8524, 79.0321);
        mMap.addMarker(new MarkerOptions().position(D2).title("Donor 2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(D2));

        LatLng D3 = new LatLng(12.8390, 79.1808);
        mMap.addMarker(new MarkerOptions().position(D3).title("Donor 3").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(D3));


        LatLng R1 = new LatLng(12.9271, 79.0955);
        mMap.addMarker(new MarkerOptions().position(R1).title("Receiver 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(R1));

        LatLng R2 = new LatLng(12.9039, 79.1474);
        mMap.addMarker(new MarkerOptions().position(R2).title("Receiver 3").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(R2));

        LatLng R3 = new LatLng(12.9582, 79.1159);
        mMap.addMarker(new MarkerOptions().position(R3).title("Receiver 3").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(R3));

        LatLng V1 = new LatLng(12.9135, 79.1077);
        mMap.addMarker(new MarkerOptions().position(V1).title("Volunteer 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(V1));

        LatLng V2 = new LatLng(12.9530, 79.1083);
        mMap.addMarker(new MarkerOptions().position(V2).title("Volunteer 2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(V2));

        LatLng V3 = new LatLng(12.9639, 79.1256);
        mMap.addMarker(new MarkerOptions().position(V3).title("Volunteer 3").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(V3));

    }

//-------------------------------------------------------------------------------------------------------------------------------------------


}