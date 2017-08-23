package com.example.labsoftware20.academia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MostrarActivity extends AppCompatActivity {
    List<Persona> per = new ArrayList<Persona>();
    TextView datos;
    String data = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        datos = (TextView)findViewById(R.id.DataList);

        //ListView dataList =(ListView)findViewById(R.id.ListPersonas);
        per = (List<Persona>)Academiasingleton.getInstance().memory.get("personas");
        if(per.size() != 0){
            for(int i=0; i< per.size(); i++){
                data+= "Nombre: "+ per.get(i).getNombre() + "\n" +
                        "Idenficacion: " + per.get(i).getID() + "\n" +
                        "Direccion: " + per.get(i).getDireccion() + "\n" +
                        "______________________\n";
            }

            datos.setText(data);
        }else{
            datos.setText("Nombre : Jair Diaz");
        }
    }

    public void changeToMain(View view){
        Intent CrearPersona = new Intent(this, MainActivity.class);
        startActivity(CrearPersona);
    }



}
