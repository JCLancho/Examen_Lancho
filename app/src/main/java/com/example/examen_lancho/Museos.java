package com.example.examen_lancho;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Museos extends AppCompatActivity {

    private ListView listView;
    private Museo[] arrayMuseo = {
            new Museo("Museo Guggenheim de Bilbao", "Bilbo (Bizkaia)", "https://www.guggenheim-bilbao.eus/", R.drawable.guggenheim),
            new Museo("Museo de Bellas Artes de Bilbao", "Bilbo (Bizkaia)", "http://www.museobilbao.com/", R.drawable.bellas_artes_bilbao_1),
            new Museo("Museo San Telmo", "Donostia (Gipuzkoa)", "https://www.santelmomuseoa.eus", R.drawable.san_telmo_donostia_1)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museos);

        listView = findViewById(R.id.listView);


        AdaptadorMuseo adaptadorMuseo = new AdaptadorMuseo(this, arrayMuseo);

        listView.setAdapter(adaptadorMuseo);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Museo webSeleccionada = (Museo)parent.getItemAtPosition(position);

                Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(webSeleccionada.getUrl()));
                startActivity(intent);
            }
        });


    }


    class AdaptadorMuseo extends ArrayAdapter<Museo> {

        public AdaptadorMuseo(@NonNull Context context, Museo[] resource) {
            super(context, R.layout.activity_museos, arrayMuseo);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_museo, null);

            TextView museo = (TextView)item.findViewById(R.id.museo);
            museo.setText(arrayMuseo[position].getMuseo());
            TextView localidad = (TextView)item.findViewById(R.id.localidad);
            localidad.setText(arrayMuseo[position].getLocalidad());
            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);


            Context ctx = getApplicationContext();

           // imagen.setImageResource(arrayMuseo[position].getImagen());
//            imagen.setImageResource(R.drawable.guggenheim);
            return item;
        }
    }
}
