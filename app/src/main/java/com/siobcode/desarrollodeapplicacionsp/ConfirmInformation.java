package com.siobcode.desarrollodeapplicacionsp;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmInformation extends AppCompatActivity {

    TextView tv;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    Button btnEditarr;
    String stnombre;
    String stemail;
    String stfecha;
    String stdescripcion;
    String stettelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_information);
        tv = (TextView) findViewById(R.id.teCDatos);
        tv2 = (TextView) findViewById(R.id.teCDatos2);
        tv3 = (TextView) findViewById(R.id.teCDatos3);
        tv4 = (TextView) findViewById(R.id.teCDatos4);
        tv5 = (TextView) findViewById(R.id.teCDatos5);

        stnombre = getIntent().getExtras().getString("ConfirmInformation");
        stemail = getIntent().getExtras().getString("ConfirmInformation2");
        stfecha = getIntent().getExtras().getString("ConfirmInformation3");
        stdescripcion = getIntent().getExtras().getString("ConfirmInformation4");
        stettelefono = getIntent().getExtras().getString("ConfirmInformation5");
        tv.setText(stnombre);
        tv2.setText(stemail);
        tv3.setText(stfecha);
        tv4.setText(stdescripcion);
        tv5.setText(stettelefono);

        Bundle parametros = getIntent().getExtras();
            if (parametros != null){
                stnombre = parametros.getString(getResources().getString(R.string.feedbackname));
                stemail = parametros.getString(getResources().getString(R.string.Email));
                stfecha= parametros.getString(getResources().getString(R.string.Fecha));
                stdescripcion = parametros.getString(getResources().getString(R.string.Descripcion));
                stettelefono = parametros.getString(getResources().getString(R.string.Telefono));

            tv.setText(stnombre);
            tv2.setText(stemail);
            tv3.setText(stfecha);
            tv4.setText(stdescripcion);
            tv5.setText(stettelefono);
        }

        btnEditarr = (Button) findViewById(R.id.btnEditarr);
        btnEditarr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConfirmInformation.this, MainActivity.class);

                i.putExtra(getResources().getString(R.string.feedbackname), stnombre);
                i.putExtra(getResources().getString(R.string.Email), stemail);
                i.putExtra(getResources().getString(R.string.Fecha),stfecha);
                i.putExtra(getResources().getString(R.string.Descripcion),stdescripcion);
                i.putExtra(getResources().getString(R.string.Telefono), stettelefono);

                startActivity(i);
                finish();

            }
        });
    }

            }

