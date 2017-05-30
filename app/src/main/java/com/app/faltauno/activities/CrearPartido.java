package com.app.faltauno.activities;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.ParseException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

//Para campo Fecha
import android.app.DatePickerDialog;
import android.widget.TimePicker;
import android.widget.Toast;

//Para campo Hora


import com.app.faltauno.R;
import com.app.faltauno.request.Communicator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CrearPartido extends AppCompatActivity{

    private Communicator communicator;

    EditText organizador;
    EditText direccion;
    EditText ciudad;
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

        communicator = new Communicator();

        organizador = (EditText) findViewById(R.id.input_organizador);
        hora = (EditText) findViewById(R.id.input_hora);
        direccion = (EditText) findViewById(R.id.input_direccion);
        ciudad = (EditText) findViewById(R.id.input_ciudad);
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
            public void onClick(View view) {
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

    }

    public void onMatchCreationButtonClick(View view) {

        String ownerName = organizador.getText().toString();
        String countOfPlayers = cant_jugadores.getSelectedItem().toString();
        String time = hora.getText().toString();
        String date = fecha.getText().toString();
        String gender = genero.getSelectedItem().toString();
        String address = direccion.getText().toString();
        String city = ciudad.getText().toString();

        Intent intent = new Intent(CrearPartido.this, MainActivity.class);

        if(!TextUtils.isEmpty(ownerName) && !TextUtils.isEmpty(countOfPlayers) &&
                !TextUtils.isEmpty(time) && !TextUtils.isEmpty(date) &&
                !TextUtils.isEmpty(gender) && !TextUtils.isEmpty(address) &&
                !TextUtils.isEmpty(city)) {

            String timeString = time;
            //SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
            //Date convertedTime = new Date();

            String dateString = date;
            //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");
            //Date convertedDate = new Date();
            /*try {
                try {
                    convertedTime = timeFormat.parse(timeString);
                    convertedDate = dateFormat.parse(dateString);
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }*/
            crearPartido(ownerName, Integer.parseInt(countOfPlayers), time, date, gender, address, city);
            showMatchCreatedToast(view);
            startActivity(intent);
        }
        else {
            showFormErrorToast(view);
        }
    }

    private void crearPartido(String ownerName, Integer countOfPlayers, String time, String date, String gender, String address, String city){
        communicator.matchPost(ownerName, countOfPlayers, time, date, gender, address, city);
    }

    public void onBackButtonClick(View view) {
        Intent intent = new Intent(CrearPartido.this, MainActivity.class);
        startActivity(intent);

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