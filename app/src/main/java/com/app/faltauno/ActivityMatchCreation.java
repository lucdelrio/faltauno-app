package com.app.faltauno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityMatchCreation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_creation);
    }

    public void onButtonClick(View view) {
        if(view.getId() == R.id.back){
            Intent intent = new Intent(ActivityMatchCreation.this, MainActivity.class);
            startActivity(intent);
        }
    }

}
