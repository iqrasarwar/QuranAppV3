package com.example.quranappv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ParaContext extends AppCompatActivity {
    Store store;
    DataBaseHelper db;
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_context);
        store = new Store();
        l = findViewById(R.id.listview);
        db = new DataBaseHelper(ParaContext.this);
        ArrayList<Ayat> ayat = db.getAyat();
        ArrayList<Ayat> thisParaAyat = new ArrayList<>();
        Intent i = getIntent();
        if(i.getExtras() != null) {
            int index = Integer.parseInt(i.getStringExtra("index"));
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
        AyatCustomListConfig list = new AyatCustomListConfig(this, 0, thisParaAyat);
        l.setAdapter(list);
    }
}