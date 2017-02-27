package com.codes.cardview;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.codes.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements PopupMenu.OnMenuItemClickListener {
    private ArrayList<RecyclerViewData> datos;
    private Context context;
    private int itemPosition;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewTitle;
        public TextView textViewSubtitle;
        public ImageView imageViewOverflow;

        public ViewHolder(View v) {
            super(v);
            textViewTitle = (TextView) v.findViewById(R.id.textViewTitleCardView);
            textViewSubtitle = (TextView) v.findViewById(R.id.textViewSubtitleCardView);
            imageViewOverflow = (ImageView) v.findViewById(R.id.imageViewOverflowCardView);
        }

        public void bindData(RecyclerViewData data){
            textViewTitle.setText(data.getTitle());
            textViewSubtitle.setText(data.getSubtitle());
        }
    }

    public MyAdapter(Context context, ArrayList<RecyclerViewData> datos) {
        this.datos = datos;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_adapter_cardview, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.bindData(datos.get(position));
        holder.imageViewOverflow.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                itemPosition = position;
                showPopupMenu(view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void showPopupMenu(View v){
        PopupMenu popupMenu = new PopupMenu(context, v);
        popupMenu.setOnMenuItemClickListener(this);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.cardview, popupMenu.getMenu());
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorite:
                Toast.makeText(context, "Añadido a favoritos", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                Toast.makeText(context, "Borrado", Toast.LENGTH_SHORT).show();
                datos.remove(itemPosition);
                notifyDataSetChanged();
                return true;
            default:
                return false;
        }
    }
}
