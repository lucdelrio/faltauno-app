package com.app.faltauno.activities;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

//Para campo Fecha
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import java.util.Calendar;
import java.util.Date;

//Para campo Hora


import com.app.faltauno.R;
import com.app.faltauno.data.MatchData;
import com.app.faltauno.services.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class CrearPartido extends AppCompatActivity{

    private ApiService apiService;
    private TextView mResponseTv;

    EditText organizador;
    EditText direccion;
    EditText cuidad;
    EditText fecha;
    EditText hora;
    Spinner cant_jugadores;
    ArrayAdapter<CharSequence> cant_jugadores_adapter;
    Spinner genero;
    ArrayAdapter<CharSequence> genero_adapter;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_crear_partido);

        organizador = (EditText) findViewById(R.id.input_organizador);
        hora = (EditText) findViewById(R.id.input_hora);
        direccion = (EditText) findViewById(R.id.input_direccion);
        cuidad = (EditText) findViewById(R.id.input_cuidad);
        fecha = (EditText) findViewById(R.id.input_fecha);

        //Crear selector de cantidad de jugadores
        cant_jugadores = (Spinner)findViewById(R.id.selector_cant_jugadores);
        cant_jugadores_adapter = ArrayAdapter.createFromResource(this,R.array.opciones_cant_jugadores, android.R.layout.simple_spinner_item);
        cant_jugadores_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cant_jugadores.setAdapter(cant_jugadores_adapter);

        //Crear selector de genero
        genero = (Spinner)findViewById(R.id.selector_genero);
        genero_adapter = ArrayAdapter.createFromResource(this,R.array.opciones_genero, android.R.layout.simple_spinner_item);
        genero_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genero.setAdapter(genero_adapter);

        //Despliegue de Calendario en Fecha
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se instancia clase Calendario con fecha actual
                final Calendar c = Calendar.getInstance();
                int mAnio = c.get(Calendar.YEAR); // anio actual
                int mMes = c.get(Calendar.MONTH); // mes actual
                int mDia = c.get(Calendar.DAY_OF_MONTH); // dia actual
                int milisegundos = c.get(Calendar.MILLISECOND);
                //datePickerDialog.getDatePicker().setMinDate(milisegundos);
                // fecha picker dialog
                datePickerDialog = new DatePickerDialog(CrearPartido.this,
                        new DatePickerDialog.OnDateSetListener(){
                            @Override
                            public void onDateSet(DatePicker view, int anio, int meseDelAnio, int dayOfMonth) {
                                //Set dia, mes y año en el EditText
                                //view.setMinDate(System.currentTimeMillis());
                                fecha.setText(dayOfMonth + "/" + (meseDelAnio + 1) + "/" + anio);
                            }
                        }, mAnio, mMes, mDia);
                datePickerDialog.show();
            }
        });

        hora.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mHora = c.get(Calendar.HOUR);
                int mMinutos = c.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(CrearPartido.this,
                        new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker view, int horaDelDia, int minuto) {
                        //String AM_PM;
                        //int am_pm;

                        hora.setText(horaDelDia + " : " + minuto + "  ");
                    }
                }, mHora, mMinutos, false);
                timePickerDialog.show();
            }
        });


        //mirar esto
        /*
        public static void showTime(final Context context, final TextView textView) {

            final Calendar myCalendar = Calendar.getInstance();
            TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    String am_pm = "";
                    myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    myCalendar.set(Calendar.MINUTE, minute);
                    if (myCalendar.get(Calendar.AM_PM) == Calendar.AM)
                        am_pm = "AM";
                    else if (myCalendar.get(Calendar.AM_PM) == Calendar.PM)
                        am_pm = "PM";
                    String strHrsToShow = (myCalendar.get(Calendar.HOUR) == 0) ? "12" : myCalendar.get(Calendar.HOUR) + "";
                    //UIHelper.showLongToastInCenter(context, strHrsToShow + ":" + myCalendar.get(Calendar.MINUTE) + " " + am_pm);
                    textView.setText(strHrsToShow + ":" + myCalendar.get(Calendar.MINUTE) + " " + am_pm);
                }
            };
            new TimePickerDialog(context, mTimeSetListener, myCalendar.get(Calendar.HOUR), myCalendar.get(Calendar.MINUTE), false).show();
        }
        */
    }

    /*public void onMatchCreationButtonClick(View view) {

        EditText editOwnerName = (EditText) findViewById(R.id.owner_name);
        EditText editCountOfPlayers = (EditText) findViewById(R.id.count_of_players);
        EditText editTime = (EditText) findViewById(R.id.hora);
        EditText editDate = (EditText) findViewById(R.id.fecha);
        EditText editGender = (EditText) findViewById(R.id.genero);
        EditText editAddress = (EditText) findViewById(R.id.direccion);
        EditText editCity = (EditText) findViewById(R.id.cuidad);

        String organizador = editOwnerName.getText().toString();
        String cant_jugadores = editCountOfPlayers.getText().toString();
        String hora = editTime.getText().toString();
        String fecha = editDate.getText().toString();
        String genero = editGender.getText().toString();
        String direccion = editAddress.getText().toString();
        String cuidad = editCity.getText().toString();

        Intent intent = new Intent(CrearPartido.this, MainActivity.class);

        if(!TextUtils.isEmpty(organizador) && !TextUtils.isEmpty(cant_jugadores) &&
            !TextUtils.isEmpty(hora) && !TextUtils.isEmpty(fecha) &&
            !TextUtils.isEmpty(genero) && !TextUtils.isEmpty(direccion) &&
            !TextUtils.isEmpty(cuidad)) {

            String timeString = hora;
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
            Date convertedTime = new Date();

            String dateString = fecha;
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
            createMatch(organizador, Integer.parseInt(cant_jugadores), convertedTime, convertedDate, genero, direccion, cuidad);
            showMatchCreatedToast(view);
            startActivity(intent);
        }
        else {
            showFormErrorToast(view);
        }
    }*/

    /*public void onBackButtonClick(View view) {
        Intent intent = new Intent(CrearPartido.this, MainActivity.class);
        startActivity(intent);

    }*/

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
