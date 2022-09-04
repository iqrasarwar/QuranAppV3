package com.example.quranappv3.ui.surahurdu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.quranappv3.Ayat;
import com.example.quranappv3.DataBaseHelper;
import com.example.quranappv3.R;
import com.example.quranappv3.Surah;
import com.example.quranappv3.SurahContext;
import com.example.quranappv3.SurahCustomListConfig;
import com.example.quranappv3.databinding.FragmentHomeBinding;
import com.example.quranappv3.databinding.FragmentSlideshowBinding;
import com.example.quranappv3.databinding.FragmentSurahUrduBinding;
import com.example.quranappv3.recyclerAdapter;
import com.example.quranappv3.ui.slideshow.SlideshowViewModel;

import java.util.ArrayList;
import java.util.List;

public class surahUrduFragment extends Fragment {
    private FragmentSurahUrduBinding binding;
    ListView l;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSurahUrduBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        DataBaseHelper db;
        db = new DataBaseHelper(getContext());
        List<Surah> surahs = db.getSurahs();
        l = binding.listview;
        SurahCustomListConfig list = new SurahCustomListConfig(getContext(),0,surahs);
        l.setAdapter(list);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), SurahContext.class);
                intent.putExtra("index", l + "");
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