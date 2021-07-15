package com.example.eng;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ColorTheoryAdapter extends RecyclerView.Adapter<ColorTheoryAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<TheoryColor> theoryColors;

    public ColorTheoryAdapter(Context context, List<TheoryColor> theoryColors) {
        this.inflater = LayoutInflater.from(context);
        this.theoryColors = theoryColors;
    }

    @NonNull
    @Override
    public ColorTheoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorTheoryAdapter.ViewHolder holder, int position) {
        TheoryColor theoryColor = theoryColors.get(position);
        holder.colorText.setText(theoryColor.getColorText());
        holder.colorDesc.setText(theoryColor.getColorDesc());
        holder.colorText.setTextColor(theoryColor.getColorInt());
    }


    @Override
    public int getItemCount() {
        return theoryColors.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView colorText, colorDesc;
        ViewHolder(View view) {
            super(view);
            colorText = view.findViewById(R.id.colorText);
            colorDesc = view.findViewById(R.id.colorDesc);
        }
    }
}
