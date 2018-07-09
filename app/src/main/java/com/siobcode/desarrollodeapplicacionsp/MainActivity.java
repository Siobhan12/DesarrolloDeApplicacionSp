package com.siobcode.desarrollodeapplicacionsp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText Nombre;
    EditText Email;
    EditText etFecha;
    EditText Descripcion;
    EditText ettelefono;
    Button btn;
    String stnombre;
    String stemail;
    String stfecha;
    String stdescripcion;
    String stettelefono;

    Calendar mycalendar =  Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            mycalendar.set(Calendar.YEAR, year);
            mycalendar.set(Calendar.MONTH, monthOfYear);
            mycalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabels ();
        }
    };
    public void updateLabels() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat,Locale.ENGLISH);
        etFecha.setText(sdf.format(mycalendar.getTime()));
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = (EditText) findViewById(R.id.etNombre);
        Email = (EditText) findViewById(R.id.etEmail);
        etFecha = (EditText) findViewById(R.id.etFecha);
        Descripcion = (EditText) findViewById(R.id.etDescripcion);
        ettelefono = (EditText) findViewById(R.id.ettelefono);
        btn = (Button) findViewById(R.id.btnSubmit);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null){
           stnombre = parametros.getString(getResources().getString(R.string.feedbackname));
           stemail = parametros.getString(getResources().getString(R.string.Email));
           stfecha= parametros.getString(getResources().getString(R.string.Fecha));
           stdescripcion = parametros.getString(getResources().getString(R.string.Descripcion));
           stettelefono = parametros.getString(getResources().getString(R.string.Telefono));

            Nombre.setText(stnombre);
            Email.setText(stemail);
            etFecha.setText(stfecha);
            Descripcion.setText(stdescripcion);
            ettelefono.setText(stettelefono);
        }


        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this, date, mycalendar
                .get(Calendar.YEAR), mycalendar.get(Calendar.MONTH),
                        mycalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ConfirmInformation.class);
                i.putExtra(getResources().getString(R.string.feedbackname), Nombre.getText().toString());
                i.putExtra(getResources().getString(R.string.Email), Email.getText().toString());
                i.putExtra(getResources().getString(R.string.Fecha), etFecha.getText().toString());
                i.putExtra(getResources().getString(R.string.Descripcion), Descripcion.getText().toString());
                i.putExtra(getResources().getString(R.string.Telefono), ettelefono.getText().toString());

                startActivity(i);
                finish();

            }
        });
    }
}
