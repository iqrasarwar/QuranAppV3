package com.example.quranappv3.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranappv3.Ayat;
import com.example.quranappv3.DataBaseHelper;
import com.example.quranappv3.databinding.FragmentHomeBinding;
import com.example.quranappv3.recyclerAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

private FragmentHomeBinding binding;
    ArrayList<Ayat> ayats = new ArrayList<>();
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        DataBaseHelper db = new DataBaseHelper(getContext());
        ayats = db.getAyat();
        final RecyclerView rv = binding.recylerViewStudent;
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
        adapter = new recyclerAdapter(ayats) ;
        rv.setAdapter(adapter);
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}