package com.example.quranappv3.ui.search;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranappv3.Ayat;
import com.example.quranappv3.DataBaseHelper;
import com.example.quranappv3.GlobalSettings;
import com.example.quranappv3.ParaContext;
import com.example.quranappv3.R;
import com.example.quranappv3.Store;
import com.example.quranappv3.databinding.FragmentSearchBinding;
import com.example.quranappv3.recyclerAdapter;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SearchFragment extends Fragment{

    private FragmentSearchBinding binding;
    ArrayList<Ayat> allAyats;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView rv;
    MenuProvider p;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        rv = binding.recylerViewStudent;
        DataBaseHelper db = new DataBaseHelper(getContext());
        allAyats = db.getAyat();
        adapter = new recyclerAdapter(allAyats,"both") ;
        rv.setAdapter(adapter);
        p = new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
                inflater.inflate(R.menu.menusearch, menu);
                MenuItem item = menu.findItem(R.id.search);
                item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String s) {
                        return true;
                    }
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public boolean onQueryTextChange(String s) {
                        GlobalSettings settings = GlobalSettings.getInstance();
                        String urdu =settings.getUrduTranslator();
                        String eng = settings.getEnglishTraslator();
                        ArrayList<Ayat> toDisplay = new ArrayList<>();
                        for (int i = 0; i < 500; i++) {
                            Log.i("ayat",allAyats.get(i).getAyatId());
                            if(eng.equals("mohsin") && allAyats.get(i).getEnglishMohsin().contains(s))
                                toDisplay.add(allAyats.get(i));
                            else if(allAyats.get(i).getTaqiUsmani().contains(s))
                                toDisplay.add(allAyats.get(i));
                            if(urdu.equals("fateh") && allAyats.get(i).getUrduFateh().contains(s))
                                toDisplay.add(allAyats.get(i));
                            else if(allAyats.get(i).getUrduMehmood().contains(s))
                                toDisplay.add(allAyats.get(i));
                        }
//                        for (Ayat ayat : allAyats) {
//                            Log.i("ayat",ayat.getAyatId());
//                            if(eng.equals("mohsin") && ayat.getEnglishMohsin().contains(s))
//                                toDisplay.add(ayat);
//                            else if(ayat.getTaqiUsmani().contains(s))
//                                toDisplay.add(ayat);
//                            if(urdu.equals("fateh") && ayat.getUrduFateh().contains(s))
//                                toDisplay.add(ayat);
//                            else if(ayat.getUrduMehmood().contains(s))
//                                toDisplay.add(ayat);
//                        }
                        adapter = new recyclerAdapter(toDisplay,"both") ;
                        rv.setAdapter(adapter);
                        return true;
                    }
                });
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        };
        requireActivity().addMenuProvider(p);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
        return root;
    }

    @Override
    public void onDestroyView() {
        requireActivity().removeMenuProvider(p);
        super.onDestroyView();
        binding = null;
    }
}