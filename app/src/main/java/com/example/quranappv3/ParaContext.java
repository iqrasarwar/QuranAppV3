package com.example.quranappv3;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class ParaContext extends AppCompatActivity {
    Store store;
    DataBaseHelper db;
    RecyclerView.Adapter adapter;
    String translationType;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Ayat> toDisplay;
//    MenuProvider p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_context);
        store = new Store();
        toDisplay = new ArrayList<>();
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

//        p = new MenuProvider() {
//            @Override
//            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//                inflater.inflate(R.menu.menusearch, menu);
//                MenuItem item = menu.findItem(R.id.search);
//                item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
//                SearchView searchView = (SearchView) item.getActionView();
//                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//                    @Override
//                    public boolean onQueryTextSubmit(String s) {
//                        return true;
//                    }
//                    @RequiresApi(api = Build.VERSION_CODES.N)
//                    @Override
//                    public boolean onQueryTextChange(String s) {
//                        GlobalSettings settings = GlobalSettings.getInstance();
//                        String urdu =settings.getUrduTranslator();
//                        String eng = settings.getEnglishTraslator();
//                        for (Ayat ayat : thisParaAyat) {
//                            Log.i("ayat",ayat.getAyatId());
//                            if(translationType.equals("urdu")) {
//                                if(urdu.equals("fateh") && ayat.getUrduFateh().contains(s))
//                                    continue;
//                                else if(ayat.getUrduMehmood().contains(s))
//                                    continue;
//                                else
//                                    thisParaAyat.remove(ayat);
//                            }
//                            else
//                            {
//                                if(eng.equals("mohsin") && ayat.getEnglishMohsin().contains(s))
//                                    continue;
//                                else if(ayat.getTaqiUsmani().contains(s))
//                                    continue;
//                                else
//                                    thisParaAyat.remove(ayat);
//                            }
//                        }
//                        adapter.notifyDataSetChanged();
//                        return true;
//                    }
//                });
//            }
//
//            @Override
//            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
//                return false;
//            }
//        };
//        this.addMenuProvider(p);
        final RecyclerView rv = findViewById(R.id.recylerViewStudent);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(ParaContext.this,
                LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
        adapter = new recyclerAdapter(thisParaAyat,translationType) ;
        rv.setAdapter(adapter);
    }
//    @Override
//    public  void onDestroy()
//    {
//        super.onDestroy();
//        this.removeMenuProvider(p);
//    }
}