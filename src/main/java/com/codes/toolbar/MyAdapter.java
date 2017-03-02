package com.codes.toolbar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codes.R;

import java.util.ArrayList;

/**
 * Created by Posti on 29/07/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<RecyclerViewData> datos;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle;
        public TextView textViewSubtitle;

        public ViewHolder(View v) {
            super(v);
            textViewTitle = (TextView) v.findViewById(R.id.textViewTitleRecycler);
            textViewSubtitle = (TextView) v.findViewById(R.id.textViewSubtitleRecycler);
        }

        public void bindData(RecyclerViewData data){
            textViewTitle.setText(data.getTitle());
            textViewSubtitle.setText(data.getSubtitle());
        }
    }

    public MyAdapter(ArrayList<RecyclerViewData> datos) {
        this.datos = datos;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_adapter, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}
