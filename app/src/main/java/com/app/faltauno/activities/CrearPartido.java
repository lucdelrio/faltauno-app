package com.app.faltauno.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

//Para campo Fecha
import android.app.DatePickerDialog;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.TimePickerDialog;

//Para dar mensaje que se creo partido
import android.widget.Toast;

import com.app.faltauno.R;
import com.app.faltauno.request.Communicator;
import com.app.faltauno.response.Partido;
import java.util.Calendar;

public class CrearPartido extends AppCompatActivity{

    private Communicator communicator;

    EditText organizador;
    EditText direccion;
    EditText ciudad;
    TextView fecha;
    TextView hora;
    EditText cupo;
    EditText email;

    Spinner tamanio_de_cancha;
    ArrayAdapter<CharSequence> tamanio_de_cancha_adapter;
    Spinner genero;
    ArrayAdapter<CharSequence> genero_adapter;
    Spinner nivel;
    ArrayAdapter<CharSequence> nivel_adapter;
    Spinner categoria;
    ArrayAdapter<CharSequence> categoria_adapter;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_crear_partido);

        communicator = new Communicator();

        organizador = (EditText) findViewById(R.id.input_organizador);
        email = (EditText) findViewById(R.id.input_email);
        hora = (TextView) findViewById(R.id.input_hora);
        direccion = (EditText) findViewById(R.id.input_direccion);
        ciudad = (EditText) findViewById(R.id.input_ciudad);
        fecha = (TextView) findViewById(R.id.input_fecha);
        cupo = (EditText) findViewById(R.id.input_cupo);

        //Crear selector de cantidad de jugadores
        tamanio_de_cancha = (Spinner)findViewById(R.id.selector_tamanio_de_cancha);
        tamanio_de_cancha_adapter = ArrayAdapter.createFromResource(this,R.array.opciones_tamanio_de_cancha, android.R.layout.simple_spinner_item);
        tamanio_de_cancha_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tamanio_de_cancha.setAdapter(tamanio_de_cancha_adapter);

        //Crear selector de genero
        genero = (Spinner)findViewById(R.id.selector_genero);
        genero_adapter = ArrayAdapter.createFromResource(this,R.array.opciones_genero, android.R.layout.simple_spinner_item);
        genero_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genero.setAdapter(genero_adapter);

        //Crear selector de nivel
        nivel = (Spinner)findViewById(R.id.selector_nivel);
        nivel_adapter = ArrayAdapter.createFromResource(this,R.array.opciones_nivel, android.R.layout.simple_spinner_item);
        nivel_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nivel.setAdapter(nivel_adapter);

        //Crear selector de categoria
        categoria = (Spinner)findViewById(R.id.selector_categoria);
        categoria_adapter = ArrayAdapter.createFromResource(this,R.array.opciones_categoria, android.R.layout.simple_spinner_item);
        categoria_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoria.setAdapter(categoria_adapter);

        //Despliegue de Calendario en Fecha
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se instancia clase Calendario con fecha actual
                final Calendar c = Calendar.getInstance();
                int mAnio = c.get(Calendar.YEAR); // anio actual
                int mMes = c.get(Calendar.MONTH); // mes actual
                int mDia = c.get(Calendar.DAY_OF_MONTH); // dia actual
                //datePickerDialog.getDatePicker().setMinDate(milisegundos);
                // fecha picker dialog
                datePickerDialog = new DatePickerDialog(CrearPartido.this,
                        new DatePickerDialog.OnDateSetListener(){
                            @Override
                            public void onDateSet(DatePicker view, int anio, int meseDelAnio, int dayOfMonth) {

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

                                hora.setText(horaDelDia + " : " + (minuto >= 10 ? String.valueOf(minuto) : "0"+minuto));
                            }
                        }, mHora, mMinutos, DateFormat.is24HourFormat(CrearPartido.this));
                timePickerDialog.show();
            }
        });

        System.out.println(hora);

    }

    public void onMatchCreationButtonClick(View view) {

        String nombreOrganizador = organizador.getText().toString();
        String email = this.email.getText().toString();

        String editTamanioDeCancha = this.tamanio_de_cancha.getSelectedItem().toString();
        Integer tamanioDeCancha = Integer.parseInt(editTamanioDeCancha);

        System.out.println(hora);

        String hora = this.hora.getText().toString();
        String fecha = this.fecha.getText().toString();
        String genero = this.genero.getSelectedItem().toString();
        String direccion = this.direccion.getText().toString();
        String ciudad = this.ciudad.getText().toString();
        String nivel = this.nivel.getSelectedItem().toString();
        String categoria = this.categoria.getSelectedItem().toString();

        String editCupo = this.cupo.getText().toString();

        if(TextUtils.isEmpty(nombreOrganizador) || TextUtils.isEmpty(email) ||
                TextUtils.isEmpty(editTamanioDeCancha) ||
                TextUtils.isEmpty(hora) || TextUtils.isEmpty(fecha) ||
                TextUtils.isEmpty(genero) || TextUtils.isEmpty(direccion) ||
                TextUtils.isEmpty(ciudad) || TextUtils.isEmpty(nivel) ||
                TextUtils.isEmpty(categoria) || TextUtils.isEmpty(editCupo)) {

            toastErrorEnFormulario(view);

        } else if (Integer.parseInt(editCupo) < 1 || Integer.parseInt(editCupo) > Integer.parseInt(editTamanioDeCancha) * 2) {
            toastCupoInvalido(view);

        } else {
            Integer cupo = Integer.parseInt(editCupo);

            Partido datosDePartido = new Partido(nombreOrganizador, email, tamanioDeCancha,
                    hora, fecha, genero, direccion, ciudad,
                    nivel, categoria, cupo);

            crearPartido(datosDePartido);
        }
    }

    public void notificarListaDePartidos(){

        Intent intentMainActivity = new Intent(CrearPartido.this, MainActivity.class);
        startActivity(intentMainActivity);

    }
    private void crearPartido(Partido datosDePartido){
        
	    communicator.postPartido(datosDePartido, this);
    }

    public void toastErrorEnFormulario(View view){
        Toast formErrorToast = Toast.makeText(getApplicationContext(), "Hay campos vacíos", Toast.LENGTH_SHORT);
        formErrorToast.show();
    }

    public void toastCupoInvalido(View view){
        Toast cupoInvalidoToast = Toast.makeText(getApplicationContext(), "Cupo inválido", Toast.LENGTH_SHORT);
        cupoInvalidoToast.show();
    }

}