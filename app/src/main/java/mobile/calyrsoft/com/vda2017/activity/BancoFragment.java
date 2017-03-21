package mobile.calyrsoft.com.vda2017.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;

import mobile.calyrsoft.com.vda2017.MainActivity;
import mobile.calyrsoft.com.vda2017.R;
import mobile.calyrsoft.com.vda2017.model.Cajero;

/**
 * <p> The BancoFragment class </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class BancoFragment extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<Cajero> lista;
    private String DATA_BANCO = "Data_Cajeros";
    private static final String MENU_PRINCIPAL = "menuprincipal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.banco_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapBanco);

        Toolbar mToolbar;
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int clave = extras.getInt(DATA_BANCO);
            if (clave == 31 ){
                this.lista =  new ArrayList<>();
                lista.add(new Cajero(-17.403252,-66.040369,"Agencia Sacaba","Plaza Principal, acera oeste."));
                lista.add(new Cajero(-17.404153,-66.040750,"Tigo Sacaba","Instalaciones de Telecel S.A., Calle La Tapia esquina Comercio N° 112" ));
                lista.add(new Cajero(-17.399825, -66.042501,"Sacaba","Instalaciones Terminal de Buses Interprovincial, Avenida Barrientos s/n Km.11.5 carretera CBB-SCZ"));
            }

            if (clave == 32 ){
                this.lista =  new ArrayList<>();
                lista.add(new Cajero(-17.402380, -66.038542,"AGENCIA SACABA","Calle Colombia s/n entre Calles Monseñor Alcocer y Bolívar(SACABA)"));
            }

            if (clave == 33 ){
                this.lista =  new ArrayList<>();
                lista.add(new Cajero(-17.405437, -66.038005,"Agencia Sacaba","Calle Sucre E-200 esquina Independencia diagonal mercado central de Sacaba / Centro / "));
            }

            if (clave == 34 ){
                this.lista =  new ArrayList<>();
                lista.add(new Cajero(-17.4043889,-66.0406917,"Agencia Sacaba","Calle Tapia # 427, a media cuadra Plaza Principal."));
                    }

        }
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


        mMap.getUiSettings().setCompassEnabled(true); //Compass
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true); //Indoor
        mMap.getUiSettings().setMapToolbarEnabled(true); //Map toolsbar
        mMap.getUiSettings().setZoomControlsEnabled(true);

        for (int i= 0; i < this.lista.size(); i++) {
            if ( i == 0) {
                LatLng micentro = new LatLng(lista.get(i).getLatitud(), lista.get(i).getLongitud());
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(micentro).zoom(16).build();
                mMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
            MarkerOptions markerend = new MarkerOptions().position(
                    new LatLng(lista.get(i).getLatitud(), lista.get(i).getLongitud())).title(lista.get(i).getTitle()).snippet(lista.get(i).getDescription());
            markerend.icon(BitmapDescriptorFactory
                    .defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
            // adding marker
            mMap.addMarker(markerend);
        }



    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent intent  = new Intent(this, MainActivity.class);
            intent.putExtra(MENU_PRINCIPAL,3);
            startActivity(intent);
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
