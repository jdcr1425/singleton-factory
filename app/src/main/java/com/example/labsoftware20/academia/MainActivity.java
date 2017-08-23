package com.example.labsoftware20.academia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.lang.System.in;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    Spinner opciones;
    Persona p;
    List<Persona> agregados = new ArrayList<Persona>();
    List<Persona> per = new ArrayList<Persona>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        opciones=(Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones , android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);

        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        EditText nombre=(EditText) findViewById(R.id.editText);
        EditText identificacion=(EditText) findViewById(R.id.editText2);
        EditText direccion=(EditText) findViewById(R.id.editText3);

        String Nombre=nombre.getText().toString();
        String ID=identificacion.getText().toString();
        String Direccion=direccion.getText().toString();

        TextView Mostrar =(TextView) findViewById(R.id.mostrar);

        if(Nombre.equals("")|| ID.equals("")|| Direccion.equals("")){
            Mostrar.setText("Rellene Todos los campos");
        }else{
            Spinner mySpinner=(Spinner) findViewById(R.id.spinner);
            String rol = mySpinner.getSelectedItem().toString();
            p=FactoryAcademia.getPersona(rol);
            p.setNombre(Nombre);
            p.setID(ID);
            p.setDireccion(Direccion);

            if(agregados.size() > 0){
                Log.d("Aqui estoy", "prueba");
                per = (List<Persona>)Academiasingleton.getInstance().memory.get("personas");
                per.add(p);
                Academiasingleton.getInstance().memory.put("personas",per);
            }else{
                agregados.add(p);
                Academiasingleton.getInstance().memory.put("personas",agregados);
            }




            //Academiasingleton academia= Academiasingleton.getInstance();

           //academia.contar(agregados);
           // academia.setAsistencia(agregados.size());

            Mostrar.setText("Usted ha ingresado un "+rol+"\n\n"+
                    "Datos :\n\n"+ "Nombre : "+p.getNombre() + "\n" + "Identificacion : "+ p.getID() + "\n" + "Direccion : "+ p.getDireccion()

                   // +"\n\n\n\n"+ "Asistencia : " + agregados.size() + "     "+academia.getAsistencia()
            );





            nombre.setText("");
            identificacion.setText("");
            direccion.setText("");

        }




    }

    public void ListarPersonas(View view){
        Intent ListarPersona = new Intent(this, MostrarActivity.class);
        startActivity(ListarPersona);
    }
}
