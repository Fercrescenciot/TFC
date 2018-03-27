package com.tcc.fernanda.tcc.VisualizarPrimeiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.tcc.fernanda.tcc.Banco.Eventos;
import com.tcc.fernanda.tcc.ConfiguracaoFireBase;
import com.tcc.fernanda.tcc.MainActivity;
import com.tcc.fernanda.tcc.R;

import java.util.ArrayList;

public class VisualizarEventos extends AppCompatActivity {

    private ListView listViewEventos;
    private Button btnVoltar;
    private Button btnCadastrarEventos;
    private ArrayAdapter adapter;
    private DatabaseReference firebase;
    private ArrayList<String> eventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_eventos);

        listViewEventos =   findViewById(R.id.lv_eventos);
        btnCadastrarEventos = findViewById(R.id.btnCadEventos);
        btnVoltar = findViewById(R.id.btnVoltarVE);
        eventos =  new ArrayList<>();
       // eventos.add("Fernanda");
       // eventos.add("Teste");
        firebase = ConfiguracaoFireBase.getFirebase().child("eventos");

        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                eventos.clear();

                for(DataSnapshot dados: dataSnapshot.getChildren()){
                    Eventos evento= dados.getValue(Eventos.class);
                    eventos.add(evento.getNomeEvento());

                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, eventos);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        listViewEventos.setAdapter(adapter);


        listViewEventos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),"Deu certo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(VisualizarEventos.this, MainActivity.class);
                intent.putExtra("nomeid", i);
                startActivity(intent);
                return false;
            }
        });

       /*btnCadastrarEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VisualizarEventos.this, MainActivity.class));
            }
        });*/

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VisualizarEventos.this, MainActivity.class));
            }
        });

    }


}
