package com.app.faltauno.activities;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.app.faltauno.R;
import com.app.faltauno.request.BusProvider;
import com.app.faltauno.request.Communicator;
import com.app.faltauno.request.ErrorEvent;
import com.app.faltauno.request.MatchEvent;
import com.app.faltauno.response.MatchData;
import com.app.faltauno.response.MatchDataResponse;
import com.app.faltauno.response.MatchResults;
import com.app.faltauno.services.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.design.R.styleable.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    private Communicator communicator;

    private TextView txtPartidos;


    private List<MatchDataResponse> listaDePartidos;

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

        getMatches();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.agregar_partido_boton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAddNewMatch = new Intent(MainActivity.this, CrearPartido.class);
                startActivity(intentAddNewMatch);
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.mostrar_partido_boton);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMostrarPartido = new Intent(MainActivity.this, MostrarPartido.class);
                startActivity(intentMostrarPartido);
            }
        });

    }

    private void getMatches(){
        ApiService service = Communicator.getClient().create(ApiService.class);

        Call<List<MatchDataResponse>> call = service.getListMatches();

        call.enqueue(new Callback<List<MatchDataResponse>>() {
            @Override
            public void onFailure(Call<List<MatchDataResponse>> call, Throwable t) {
                Log.d("APIPlug", "Error Occured: " + t.getMessage());

            }

            @Override
            public void onResponse(Call<List<MatchDataResponse>> call, Response<List<MatchDataResponse>> response) {
                Log.d("APIPlug", "Successfully response fetched" );

                listaDePartidos = response.body();

                if(listaDePartidos.size()>0) {
                    showList();
                }else{
                    Log.d("APIPlug", "No item found");
                }
            }
        });
    }

    //Our method to show list
    private void showList() {
        Log.d("APIPlug", "Show List");

        txtPartidos = (TextView) findViewById(R.id.matchesList);

        txtPartidos.setText(listaDePartidos.get(1).getOwnerName().toString());
        txtPartidos.setText(listaDePartidos.get(1).getTime().toString());
        //txtPartidos.setText(listaDePartidos.toString());

    }
}
