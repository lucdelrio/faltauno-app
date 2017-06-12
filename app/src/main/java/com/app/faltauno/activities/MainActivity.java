package com.app.faltauno.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.app.faltauno.R;
import com.app.faltauno.request.Communicator;
import com.app.faltauno.response.MatchDataAdapter;
import com.app.faltauno.services.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

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

        myOnClickListener = new MyOnClickListener(this);
        setContentView(R.layout.activity_main);

        getMatchDataAdapter = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

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

        Call<List<MatchDataAdapter>> call = service.getListMatches();

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
            showMatchDetail(v);
        }

        private void showMatchDetail(View v) {
            int selectedItemPosition = recyclerView.getChildPosition(v);

            RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForPosition(selectedItemPosition);
            System.out.println(viewHolder.getAdapterPosition());
            TextView textViewName = (TextView) viewHolder.itemView.findViewById(R.id.textView4);
            String selectedName = (String) textViewName.getText();

            int selectedItemId = 0;
            for (int i = 0; i < getMatchDataAdapter.size(); i++) {
                if (selectedName.equals(getMatchDataAdapter.get(i).getOwnerName())) {
                    selectedItemId = i;
                }
            }

            Intent intentSeeMatchDetail = new Intent(MainActivity.this, MostrarPartido.class);
            intentSeeMatchDetail.putExtra("index", selectedItemId);
            startActivity(intentSeeMatchDetail);

        }
    }

}
