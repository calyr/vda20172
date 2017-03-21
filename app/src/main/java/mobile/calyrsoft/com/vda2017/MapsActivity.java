package mobile.calyrsoft.com.vda2017;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String MENU_PRINCIPAL = "menuprincipal";
    private GoogleMap mMap;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

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


        //mMap.setMyLocationEnabled(true); //Location
        mMap.getUiSettings().setCompassEnabled(true); //Compass
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true); //Indoor
        mMap.getUiSettings().setMapToolbarEnabled(true); //Map toolsbar
        mMap.getUiSettings().setZoomControlsEnabled(true);
        // latitude and longitude
        double latitude = -17.408677;
        double longitude = -66.040862;
        // create marker
        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(latitude, longitude)).title(getString(R.string.partida)).snippet(getString(R.string.title));

        // Changing marker icon
        marker.icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

        // adding marker
        mMap.addMarker(marker);
        LatLng inicio = new LatLng(latitude, longitude);

        LatLng micentro = new LatLng(-17.404359, -66.040772);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(micentro).zoom(16).build();
        mMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));

        mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(latitude, longitude))  // Sydney
                .add(new LatLng(-17.403416, -66.038394))  // Fiji
                .add(new LatLng(-17.400509, -66.045882))  // Hawaii
                .add(new LatLng(-17.401676, -66.046183))
                .add(new LatLng(-17.404076, -66.040604))
                .add(new LatLng(-17.403495, -66.040314))
                .add(new LatLng(-17.403736, -66.039778))
                .add(new LatLng(-17.405067, -66.040405))// Mountain View
        );
        MarkerOptions markerend = new MarkerOptions().position(
                new LatLng(-17.405067, -66.040405)).title(getString(R.string.llegada)).snippet(getString(R.string.title));

        // Changing marker icon
        markerend.icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_CYAN));

        // adding marker
        mMap.addMarker(markerend);



    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent intent  = new Intent(this, MainActivity.class);
            startActivity(intent);
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
