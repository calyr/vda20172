package mobile.calyrsoft.com.vda2017;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import mobile.calyrsoft.com.vda2017.activity.BancoFragment;
import mobile.calyrsoft.com.vda2017.activity.FragmentDrawer;
import mobile.calyrsoft.com.vda2017.activity.FraternidadesfolkloricasFragment;
import mobile.calyrsoft.com.vda2017.activity.GastronomiaFragment;
import mobile.calyrsoft.com.vda2017.activity.MenubancosFragment;
import mobile.calyrsoft.com.vda2017.activity.MenuprincipalFragment;
import mobile.calyrsoft.com.vda2017.activity.PortadaFragment;
import mobile.calyrsoft.com.vda2017.activity.ProgramafestivoFragment;
import mobile.calyrsoft.com.vda2017.activity.RecorridosinFragment;
import mobile.calyrsoft.com.vda2017.activity.TurismoFragment;
import mobile.calyrsoft.com.vda2017.model.Cajero;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {


    private static final String MENU_PRINCIPAL = "menuprincipal";
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private static final String TAG = "MainActivity";
    private String DATA_BANCO = "Data_Cajeros";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int menu = extras.getInt(MENU_PRINCIPAL);
            displayView(menu);
        } else {
            displayView(20);
        }
    }




    @Override
    protected void onPause() {
        super.onPause();

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            Log.d("Mostrando la infor","Toda la info del boton setting");
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    public void displayView(int position) {
        Fragment fragment = null;
        Bundle args = new Bundle();
        String title = getString(R.string.app_name);
        Intent intent = new Intent(this, BancoFragment.class);

        switch (position) {
            case 0:
                fragment = new ProgramafestivoFragment();
                title = getString(R.string.title_programafestivo);
                break;
            case 1:

                if (!verificaConexion(this)) {

                    fragment = new RecorridosinFragment();
                    title = getString(R.string.title_recorrido);
                    break;
                }else{
                    Intent i = new Intent(this, MapsActivity.class);
                    startActivity(i);
                }

                title = getString(R.string.title_recorrido);
                break;
            case 2:
                fragment = new FraternidadesfolkloricasFragment();
                title = getString(R.string.title_fraternidadesfolkloricas);
               break;
            case 3:
                fragment = new MenubancosFragment();
                title = getString(R.string.title_cajerosautomaticos);
                break;

            case 4:
                fragment = new GastronomiaFragment();
                title  = getString(R.string.title_gastronomia);
                break;
            case 5:
                fragment = new TurismoFragment();
                title  = getString(R.string.title_turismo);
                break;
            case 6:

            case 11:
                fragment = new PortadaFragment();
                title = getString(R.string.title_portada);
               break;
            case 20:
                fragment = new MenuprincipalFragment();
                break;

            case 31:
                intent.putExtra(DATA_BANCO,position);
                startActivity(intent);


            case 32:
                intent.putExtra(DATA_BANCO,position);
                startActivity(intent);
            case 33:
                intent.putExtra(DATA_BANCO,position);
                startActivity(intent);

            case 34:
                intent.putExtra(DATA_BANCO,position);
                startActivity(intent);

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }




    public void mostrarMenu(View view) {
        displayView(20);
    }




    public static boolean verificaConexion(Context ctx) {
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // No sólo wifi, también GPRS
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        // este bucle debería no ser tan ñapa
        for (int i = 0; i < 2; i++) {
            // ¿Tenemos conexión? ponemos a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
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
