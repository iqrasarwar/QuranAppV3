package com.example.quranappv3.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.quranappv3.DataBaseHelper;
import com.example.quranappv3.R;
import com.example.quranappv3.Surah;
import com.example.quranappv3.SurahContext;
import com.example.quranappv3.SurahCustomListConfig;
import com.example.quranappv3.databinding.FragmentSettingsBinding;

import java.util.List;

public class settingsFragment extends Fragment {

    RadioGroup urdu,english;
    Button update;
    private FragmentSettingsBinding binding;
    String uTranslator, eTranslator;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
            binding = FragmentSettingsBinding.inflate(inflater, container, false);
            View root = binding.getRoot();
            urdu = binding.radioGroup;
            english = binding.radioGroup2;
            update = binding.button8;
            urdu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButton1:
                            uTranslator = "fateh";
                            break;
                        case R.id.radioButton2:
                            uTranslator = "mehmood";
                            break;
                    }
                }
            });
            english.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch(checkedId) {
                        case R.id.radioButton3:
                            eTranslator = "mohsin";
                            break;
                        case R.id.radioButton4:
                            eTranslator = "taqi";
                            break;
                    }
                }
            });

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

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