package com.example.quranappv3;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AllParahs extends AppCompatActivity {
    Store store;
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_parahs);
        l = findViewById(R.id.listview);
        store = new Store();
        ArrayList<Parah> arraylist = store.getAllPararh();
        ParahCustomListConfig list = new ParahCustomListConfig(this, 0, arraylist);
        l.setAdapter(list);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AllParahs.this, ParaContext.class);
                intent.putExtra("index", l + "");
                startActivity(intent);
            }
        });
    }
}