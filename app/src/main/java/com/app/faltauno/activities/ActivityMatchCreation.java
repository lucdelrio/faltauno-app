package com.app.faltauno.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.ParseException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.faltauno.R;
import com.app.faltauno.data.MatchData;
import com.app.faltauno.services.ApiService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.format;
import static android.content.ContentValues.TAG;

public class ActivityMatchCreation extends Activity{

    private ApiService apiService;
    private TextView mResponseTv;

    EditText ownerName, countOfPlayers, time, date, gender, address, city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_creation);

        ownerName = (EditText) findViewById(R.id.owner_name);
        countOfPlayers = (EditText) findViewById(R.id.count_of_players);
        time = (EditText) findViewById(R.id.time);
        date = (EditText) findViewById(R.id.date);
        gender = (EditText) findViewById(R.id.gender);
        address = (EditText) findViewById(R.id.address);
        city = (EditText) findViewById(R.id.city);

    }

    public void onMatchCreationButtonClick(View view) {

        EditText editOwnerName = (EditText) findViewById(R.id.owner_name);
        EditText editCountOfPlayers = (EditText) findViewById(R.id.count_of_players);
        EditText editTime = (EditText) findViewById(R.id.time);
        EditText editDate = (EditText) findViewById(R.id.date);
        EditText editGender = (EditText) findViewById(R.id.gender);
        EditText editAddress = (EditText) findViewById(R.id.address);
        EditText editCity = (EditText) findViewById(R.id.city);

        String ownerName = editOwnerName.getText().toString();
        String countOfPlayers = editCountOfPlayers.getText().toString();
        String time = editTime.getText().toString();
        String date = editDate.getText().toString();
        String gender = editGender.getText().toString();
        String address = editAddress.getText().toString();
        String city = editCity.getText().toString();

        Intent intent = new Intent(ActivityMatchCreation.this, MainActivity.class);

        if(!TextUtils.isEmpty(ownerName) && !TextUtils.isEmpty(countOfPlayers) &&
            !TextUtils.isEmpty(time) && !TextUtils.isEmpty(date) &&
            !TextUtils.isEmpty(gender) && !TextUtils.isEmpty(address) &&
            !TextUtils.isEmpty(city)) {

            String timeString = time;
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
            Date convertedTime = new Date();

            String dateString = date;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");
            Date convertedDate = new Date();
            try {
                try {
                    convertedTime = timeFormat.parse(timeString);
                    convertedDate = dateFormat.parse(dateString);
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            createMatch(ownerName, Integer.parseInt(countOfPlayers), convertedTime, convertedDate, gender, address, city);
            showMatchCreatedToast(view);
            startActivity(intent);
        }
        else {
            showFormErrorToast(view);
        }
    }

    public void onBackButtonClick(View view) {
        Intent intent = new Intent(ActivityMatchCreation.this, MainActivity.class);
        startActivity(intent);

    }

    public void createMatch(String ownerName, Integer countOfPlayers, Date time, Date date, String gender, String address, String city) {
        apiService.postMatch(ownerName, countOfPlayers, time, date, gender, address, city).enqueue(new Callback<MatchData>() {
            @Override
            public void onResponse(Call<MatchData> call, Response<MatchData> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<MatchData> call, Throwable t) {
                Log.e(TAG, "Unable to submit post to API.");
            }
        });
    }

    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }

    public void showFormErrorToast(View view){
        Toast formErrorToast = Toast.makeText(getApplicationContext(), "Hay campos vacíos", Toast.LENGTH_LONG);
        formErrorToast.show();
    }

    public void showMatchCreatedToast(View view){
        Toast matchCreatedToast = Toast.makeText(getApplicationContext(), "Partido creado exitosamente", Toast.LENGTH_LONG);
        matchCreatedToast.show();
    }
}
