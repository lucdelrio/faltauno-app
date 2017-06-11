package com.app.faltauno.activities;

import android.content.Context;
import android.content.Intent;
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
import com.app.faltauno.response.MatchDataAdapter;
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
    static View.OnClickListener myOnClickListener;

    List<MatchDataAdapter> getMatchDataAdapter;

    private List<MatchDataAdapter> listaDePartidos;

    RecyclerView recyclerView;

    RecyclerView.LayoutManager recyclerViewlayoutManager;

    RecyclerView.Adapter recyclerViewadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display a indeterminate progress bar on title bar
        //requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);

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

    }

    private void getMatches(){
        ApiService service = Communicator.getClient().create(ApiService.class);

        Call<List<MatchDataAdapter>> call = service.getMatches();

        call.enqueue(new Callback<List<MatchDataAdapter>>() {
            @Override
            public void onFailure(Call<List<MatchDataAdapter>> call, Throwable t) {
                Log.d("APIPlug", "Error Occured: " + t.getMessage());

            }

            @Override
            public void onResponse(Call<List<MatchDataAdapter>> call, Response<List<MatchDataAdapter>> response) {
                Log.d("APIPlug", "Successfully response fetched" );

                listaDePartidos = response.body();

                if(listaDePartidos.size()>0) {
                    showList(listaDePartidos);
                }else{
                    Log.d("APIPlug", "No item found");
                }
            }
        });
    }

    private void showList(List<MatchDataAdapter> array){

        for(int i = 0; i<array.size(); i++) {

            MatchDataAdapter matchDataAdapter = new MatchDataAdapter();

            matchDataAdapter.setOwnerName(array.get(i).getOwnerName());
            matchDataAdapter.setGender(array.get(i).getGender());
            matchDataAdapter.setCity(array.get(i).getCity());

            getMatchDataAdapter.add(matchDataAdapter);
        }

        recyclerViewadapter = new RecyclerViewAdapter(getMatchDataAdapter, this);

        recyclerView.setAdapter(recyclerViewadapter);
    }

    private class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            Intent intentAddNewMatch = new Intent(MainActivity.this, CrearPartido.class);
            startActivity(intentAddNewMatch);
            //removeItem(v);
        }
    }

}
