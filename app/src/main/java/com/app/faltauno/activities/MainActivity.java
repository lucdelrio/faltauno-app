package com.app.faltauno.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.app.faltauno.R;
import com.app.faltauno.request.Communicator;
import com.app.faltauno.response.MatchData;

import java.util.ArrayList;
import java.util.List;

import static android.support.design.R.styleable.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    private Communicator communicator;

    private ArrayList<MatchData> listaDePartidos = new ArrayList<MatchData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display a indeterminate progress bar on title bar
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.layout_main);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.partidos:

                        break;

                    case R.id.search:
                        Intent intent1 = new Intent(MainActivity.this, BuscarPartido.class);
                        startActivity(intent1);
                        break;

                    case R.id.profile:
                        Intent intent2 = new Intent(MainActivity.this, VerPerfilDeUsuario.class);
                        startActivity(intent2);
                        break;
                }


                return false;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.agregar_partido_boton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAddNewMatch = new Intent(MainActivity.this, CrearPartido.class);
                startActivity(intentAddNewMatch);
            }
        });

    }

}
