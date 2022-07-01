package com.example.cardiacrecorder;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class showList extends RecyclerView.Adapter<showList.ViewHolder> {
    private ArrayList<Measurement> MeasurementList=new ArrayList<>();
    private Context context;

    public showList(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.showlist,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date.setText(MeasurementList.get(position).getDate());
        holder.time.setText(MeasurementList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return MeasurementList.size();
    }

    public void setMeasurementList(ArrayList<Measurement> measurementList) {
        MeasurementList = measurementList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private EditText date;
        private EditText time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.date);
            time=itemView.findViewById(R.id.time);
        }
    }
}
