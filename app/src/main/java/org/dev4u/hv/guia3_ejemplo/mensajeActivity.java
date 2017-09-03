package org.dev4u.hv.guia3_ejemplo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class mensajeActivity extends AppCompatActivity {

    public static int GUARDADO=47;

    private AdaptadorMensaje adaptadorMensaje;
    private ArrayList<Mensaje> mensajeArrayList;
    private Button btnEnviar;
    private EditText txtEntrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);
        setTitle("Mensaje...");
        btnEnviar  = (Button) findViewById(R.id.btnEnviar);
        txtEntrada = (EditText) findViewById(R.id.txtEntrada);

        mensajeArrayList = new ArrayList<>();
        //Inicializando el adaptador
       adaptadorMensaje = new AdaptadorMensaje(this, mensajeArrayList);
        //Inicializando el listView
        ListView listView = (ListView) findViewById(R.id.lstMensaje);
        //seteando el adaptador al listview
        listView.setAdapter(adaptadorMensaje);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //si alguno de los dos campos estan vacios
                if(txtEntrada.getText().toString().isEmpty()){
                    Toast.makeText(mensajeActivity.this,"Insertar Mensaje",Toast.LENGTH_SHORT).show();
                }else{//de lo contrario los campos estan llenos
                    //envio los datos al MainActivity

                    Calendar c = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    String fecha = sdf.format(c.getTime());

                   Mensaje m = new Mensaje(txtEntrada.getText().toString(), fecha);
                    mensajeArrayList.add(m);
                    adaptadorMensaje.notifyDataSetChanged();
                    Toast.makeText(mensajeActivity.this,"Enviado con Exito..!",Toast.LENGTH_SHORT).show();
                }
                txtEntrada.setText("");
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(txtEntrada.getWindowToken(), 0);

            }
        });
    }
}
