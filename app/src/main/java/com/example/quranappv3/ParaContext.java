package com.example.quranappv3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ParaContext extends AppCompatActivity {
    Store store;
    DataBaseHelper db;
    RecyclerView.Adapter adapter;
    String translationType;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_context);
        store = new Store();
        db = new DataBaseHelper(ParaContext.this);
        ArrayList<Ayat> ayat = db.getAyat();
        ArrayList<Ayat> thisParaAyat = new ArrayList<>();

        Intent i = getIntent();
        if(i.getExtras() != null) {
            int index = Integer.parseInt(i.getStringExtra("index"));
            translationType = i.getStringExtra("type");
            index++;
            if(index > 0)
                thisParaAyat.add(ayat.get(0));
            for (int ind = 0; ind < ayat.size(); ind++) {
                String id = ayat.get(ind).getParahId();
                int idi = Integer.parseInt(id);
                if (idi == index) {
                    thisParaAyat.add(ayat.get(ind));
                }
            }
        }
        final RecyclerView rv = findViewById(R.id.recylerViewStudent);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(ParaContext.this,
                LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
        adapter = new recyclerAdapter(thisParaAyat,translationType) ;
        rv.setAdapter(adapter);
    }
}