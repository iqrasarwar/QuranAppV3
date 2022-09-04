package com.example.quranappv3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
//import android.support.v4.View.Menu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SurahContext extends AppCompatActivity {
    Store store;
    DataBaseHelper db;
    ArrayList<Ayat> thisSurahAyat;
    AyatCustomListConfig list;
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_context);
        store = new Store();
        l = findViewById(R.id.listview);
        db = new DataBaseHelper(SurahContext.this);
        ArrayList<Ayat> ayat = db.getAyat();
        thisSurahAyat = new ArrayList<>();
        Intent i = getIntent();
        if(i.getExtras() != null) {
            int index = Integer.parseInt(i.getStringExtra("index"));
            index++;
            if(index > 1)
                thisSurahAyat.add(ayat.get(0));
            for (int ind = 0; ind < ayat.size(); ind++) {
                String id = ayat.get(ind).getSuratId();
                int idi = Integer.parseInt(id);
                if (idi == index) {
                    thisSurahAyat.add(ayat.get(ind));
                }
            }
        }
       list = new AyatCustomListConfig(this, 0, thisSurahAyat);
        l.setAdapter(list);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menusearch,menu);
        MenuItem menuitem = menu.findItem(R.id.search);
        SearchView  sv = (SearchView) menuitem.getActionView();
        sv.setQueryHint("Type here to search");
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                list.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}