package com.example.quranappv3.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.quranappv3.AllSurahs;
import com.example.quranappv3.DataBaseHelper;
import com.example.quranappv3.R;
import com.example.quranappv3.Surah;
import com.example.quranappv3.SurahContext;
import com.example.quranappv3.SurahCustomListConfig;
import com.example.quranappv3.databinding.FragmentSlideshowBinding;

import java.util.List;

public class SlideshowFragment extends Fragment {

private FragmentSlideshowBinding binding;
    DataBaseHelper myDBHlpr;
    ListView l;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
            binding = FragmentSlideshowBinding.inflate(inflater, container, false);
            View root = binding.getRoot();
            myDBHlpr = new DataBaseHelper(getContext());
            List<Surah> surahs = myDBHlpr.getSurahs();
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