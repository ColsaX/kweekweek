package com.imp.emag.kweekweek.uiElements;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.imp.emag.kweekweek.R;
import com.imp.emag.kweekweek.model.OneEvent;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by tzury on 18/05/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private ArrayList<OneEvent> events=new ArrayList<>();

    public RecyclerAdapter(ArrayList<OneEvent> events){
        events=events;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView title;
        public TextView price;
        public TextView date;
        public TextView place;
        public TextView reason;


        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.eventImg);
            title=(TextView) itemView.findViewById(R.id.title);
            price=(TextView) itemView.findViewById(R.id.price);
            date=(TextView) itemView.findViewById(R.id.date);
            place=(TextView) itemView.findViewById(R.id.location);
            reason=(TextView) itemView.findViewById(R.id.reason);
        }
    }

    public void add(int position, OneEvent item) {
        events.add(position, item);
        notifyItemInserted(position);
    }
    public void remove(OneEvent item) {
        int position = events.indexOf(item);
        events.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_event_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bitmap bitmap= null;
        try {
            InputStream in = new java.net.URL(events.get(position).getImg()).openStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        holder.img.setImageBitmap(bitmap);
        holder.title.setText(events.get(position).getTitle());
        holder.price.setText(events.get(position).getPrice());
        holder.date.setText(events.get(position).getDate());
        holder.place.setText(events.get(position).getPlace());
        holder.reason.setText(events.get(position).getReason());

    }

    @Override
    public int getItemCount() {
        return events.size();
    }


}
