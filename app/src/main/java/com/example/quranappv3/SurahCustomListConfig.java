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

public class SurahCustomListConfig extends ArrayAdapter<Surah> {
    public SurahCustomListConfig(@NonNull Context context, int resource,
                                 @NonNull List<Surah> objects) {
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Surah s =  getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.surah_item,parent,
                false);
        TextView id = convertView.findViewById(R.id.textView);
        TextView english = convertView.findViewById(R.id.english);
        TextView place = convertView.findViewById(R.id.place);
        TextView urdu = convertView.findViewById(R.id.urdu);
        id.setText(s.getId());
        english.setText(s.getNameE());
        urdu.setText(s.getNameU());
        place.setText(s.getNazool());
        Typeface urduface = Typeface.createFromAsset(
                getContext().getAssets(),
                "Jameel Noori Nastaleeq.ttf");
        urdu.setTypeface(urduface);
        return convertView;
    }
}
