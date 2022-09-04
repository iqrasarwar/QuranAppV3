package com.example.quranappv3;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.myViewHolder> {
    ArrayList<Ayat> ayatList;
    public recyclerAdapter(ArrayList<Ayat> friendsList) {
        this.ayatList = friendsList;
    }

    @NonNull
    @Override
    public recyclerAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.translated_ayat, parent, false);
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.myViewHolder holder, int position) {
        holder.data=ayatList.get(position);
        holder.arabicAyat.setText(holder.data.getArabicText());
        holder.englishTrans.setText(String.valueOf(holder.data.getEnglishMohsin()));
        holder.urduTrans.setText(holder.data.getUrduFateh());
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
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            arabicAyat = itemView.findViewById(R.id.textView4);
            englishTrans = itemView.findViewById(R.id.textView5);
            urduTrans = itemView.findViewById(R.id.textView6);
        }
    }
}
