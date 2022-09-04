package com.example.quranappv3.ui.mainMenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quranappv3.Ayat;
import com.example.quranappv3.DataBaseHelper;
import com.example.quranappv3.databinding.FragmentMainMenuBinding;

import java.util.ArrayList;

public class mainMenuFragment extends Fragment {

private FragmentMainMenuBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMainMenuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}