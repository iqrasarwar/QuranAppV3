package com.example.quranappv3.ui.parahEnglish;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.quranappv3.DataBaseHelper;
import com.example.quranappv3.ParaContext;
import com.example.quranappv3.Parah;
import com.example.quranappv3.ParahCustomListConfig;
import com.example.quranappv3.R;
import com.example.quranappv3.Store;
import com.example.quranappv3.databinding.FragmentParahEnglishBinding;
import com.example.quranappv3.databinding.FragmentParahUrduBinding;

import java.util.ArrayList;

public class parahEnglishFragment extends Fragment {
    private FragmentParahEnglishBinding binding;
    Store store;
    ListView l;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentParahEnglishBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        DataBaseHelper db;
        db = new DataBaseHelper(getContext());
        l = binding.listview;
        store = new Store();
        ArrayList<Parah> arraylist = store.getAllPararh();
        ParahCustomListConfig list = new ParahCustomListConfig(getContext(), 0, arraylist);
        l.setAdapter(list);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), ParaContext.class);
                intent.putExtra("index", l + "");
                intent.putExtra("type","english");
                startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}