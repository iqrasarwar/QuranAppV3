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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.quranappv3.DataBaseHelper;
import com.example.quranappv3.GlobalSettings;
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
    GlobalSettings s;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
            binding = FragmentSettingsBinding.inflate(inflater, container, false);
        final View rootView =
                inflater.inflate(R.layout.fragment_settings, container, false);
            View root = binding.getRoot();
            urdu = binding.urduRb;
            english = binding.englishRb;
            update = binding.button8;
            s = GlobalSettings.getInstance();
            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int urduSlecetd = urdu.getCheckedRadioButtonId();
                    int englishSelected = english.getCheckedRadioButtonId();
                    RadioButton urduBtn = rootView.findViewById(urduSlecetd);
                    RadioButton engBtn = rootView.findViewById(englishSelected);
                    if(engBtn.getText().equals("Dr. Mohisn khan"))
                        s.setEnglishTraslator("mohsin");
                    else
                        s.setEnglishTraslator("taqi");
                    if(urduBtn.getText().equals("Fateh Muhammad Jalehndri"))
                        s.setUrduTranslator("fateh");
                    else
                        s.setUrduTranslator("mehmood");
                    Toast msg = Toast.makeText(getContext(),"Settings Updated!",Toast.LENGTH_SHORT);
                    msg.show();
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