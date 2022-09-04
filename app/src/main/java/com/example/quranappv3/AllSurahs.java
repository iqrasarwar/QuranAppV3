package com.example.quranappv3;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class AllSurahs extends AppCompatActivity {
    DataBaseHelper myDBHlpr;
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_surahs);
        myDBHlpr = new DataBaseHelper(this);
        List<Surah> surahs = myDBHlpr.getSurahs();
        l = findViewById(R.id.listview);
        SurahCustomListConfig list = new SurahCustomListConfig(this,0,surahs);
        l.setAdapter(list);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AllSurahs.this, SurahContext.class);
                intent.putExtra("index", l + "");
                startActivity(intent);
            }
        });
    }
}