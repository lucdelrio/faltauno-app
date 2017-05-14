package com.app.faltauno.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.faltauno.R;
import com.app.faltauno.model.Match;

public class ActivityMatchCreation extends AppCompatActivity {

    private Match match;

    EditText ownerName, countOfPlayers, time, date, gender, address, city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_creation);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        ownerName = (EditText) findViewById(R.id.owner_name);
        countOfPlayers = (EditText) findViewById(R.id.count_of_players);
        time = (EditText) findViewById(R.id.time);
        date = (EditText) findViewById(R.id.date);
        gender = (EditText) findViewById(R.id.gender);
        address = (EditText) findViewById(R.id.address);
        city = (EditText) findViewById(R.id.city);

    }

    public void onButtonClick(View view) {

        //faltauno app = Faltauno.getInstance();


        if(view.getId() == R.id.back){
            Intent intent = new Intent(ActivityMatchCreation.this, MainActivity.class);
            startActivity(intent);
        }else if(view.getId() == R.id.createMatch){
        /**
            String ownerNameSt = ownerName.getText().toString();
            String countOfPlayersSt = countOfPlayers.getText().toString();
            String scheduleSt = schedule.getText().toString();
            String dateSt = date.getText().toString();
            String genderSt = gender.getText().toString();
            String citySt = city.getText().toString();

            if(ownerNameSt.isEmpty()){
                ownerNameSt.setError("Campo Vacio");
                ownerNameSt.requestFocus();
            }
            else if(countOfPlayersSt.isEmpty()){

                countOfPlayersSt.setError("Campo Vacio");
                countOfPlayersSt.requestFocus();
            }
            else if(scheduleSt.isEmpty()){

                scheduleSt.setError("Campo Vacio");
                scheduleSt.requestFocus();

            }else if(dateSt.isEmpty()){
                dateSt.setError("Campo Vacio");
                dateSt.requestFocus();
            }
            else if(genderSt.isEmpty()) {
                genderSt.setError("Campo Vacio");
                genderSt.requestFocus();
            }
            else if(citySt.isEmpty()) {
                citySt.setError("Campo Vacio");
                citySt.requestFocus();
            }
            else{

                Intent intent = new Intent(ActivityMatchCreation.this, MainActivity.class);
                startActivity(intent);
            }*/
        }
    }

    public void showMatchCreatedToast(View view){
        Toast matchCreatedToast = Toast.makeText(getApplicationContext(), "Partido creado exitosamente", Toast.LENGTH_LONG);
        matchCreatedToast.show();
    }
}
