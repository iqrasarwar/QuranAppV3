package com.example.quranappv3;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.myViewHolder> {
    ArrayList<Ayat> ayatList;
    String Type;
    GlobalSettings s;
    public recyclerAdapter(ArrayList<Ayat> friendsList,String type) {
        Type=type;
        this.ayatList = friendsList;
        s = GlobalSettings.getInstance();
    }

    @NonNull
    @Override
    public recyclerAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.translated_ayat, parent, false);
        return new myViewHolder(itemView,parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.myViewHolder holder, int position) {
        holder.data=ayatList.get(position);
        holder.arabicAyat.setText(holder.data.getArabicText());
        if(s.getEnglishTraslator().equals("mohsin"))
            holder.englishTrans.setText(String.valueOf(holder.data.getEnglishMohsin()));
        if(s.getEnglishTraslator().equals("taqi"))
            holder.englishTrans.setText(String.valueOf(holder.data.getTaqiUsmani()));
        if(s.getUrduTranslator().equals("fateh"))
            holder.urduTrans.setText(String.valueOf(holder.data.getUrduFateh()));
        if(s.getUrduTranslator().equals("mehmood"))
            holder.urduTrans.setText(String.valueOf(holder.data.getUrduMehmood()));
        if(Type.equals("urdu"))
        {
            holder.englishTrans.setText("");
        }
        if(Type.equals("english"))
        {
            holder.urduTrans.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return ayatList.size();
    }


    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView arabicAyat;
        TextView englishTrans;
        TextView urduTrans;
        Ayat data;
        public myViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            arabicAyat = itemView.findViewById(R.id.textView4);
            urduTrans = itemView.findViewById(R.id.textView5);
            englishTrans = itemView.findViewById(R.id.textView6);
            Typeface typeface = Typeface.createFromAsset(
                    context.getAssets(),
                    "noorehuda.ttf");
            Typeface urduface = Typeface.createFromAsset(
                    context.getAssets(),
                    "Jameel Noori Nastaleeq.ttfq");
            arabicAyat.setTypeface(typeface);
            urduTrans.setTypeface(urduface);
            englishTrans.setTypeface(urduface);
        }
    }
}
