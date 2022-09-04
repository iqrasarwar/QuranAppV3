package com.example.quranappv3;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AyatCustomListConfig extends ArrayAdapter<Ayat> {
    public AyatCustomListConfig(@NonNull Context context, int resource,
                                 @NonNull List<Ayat> objects) {
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Ayat s =  getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.translated_ayat,parent,
                false);
        TextView arabic = convertView.findViewById(R.id.textView4);
        TextView translation = convertView.findViewById(R.id.textView5);
        TextView english = convertView.findViewById(R.id.textView6);
        arabic.setText(s.getArabicText());
        translation.setText(s.getUrduFateh());
        english.setText(s.getEnglishMohsin());
        Typeface typeface = Typeface.createFromAsset(
                getContext().getAssets(),
                "noorehuda.ttf");
        Typeface urduface = Typeface.createFromAsset(
                getContext().getAssets(),
                "Jameel Noori Nastaleeq.ttf");
        arabic.setTypeface(typeface);
        translation.setTypeface(urduface);
        return convertView;
    }
}
