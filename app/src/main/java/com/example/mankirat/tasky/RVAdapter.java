package com.example.mankirat.tasky;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Mankirat on 17-02-2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.Tasks>  {

    List<Whattodo> task;
    static Activity context;


    public RVAdapter(List<Whattodo> task,Activity context){
        this.task=task;
        this.context=context;
    }


    public static class Tasks extends RecyclerView.ViewHolder {
        CardView cv;
        TextView time;
        TextView date;
        TextView location;
        TextView title;
        TextView category;

        Tasks(final View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            time = (TextView) itemView.findViewById(R.id.time);
            date = (TextView) itemView.findViewById(R.id.date);
            location = (TextView) itemView.findViewById(R.id.location);
            title = (TextView) itemView.findViewById(R.id.title);
            category = (TextView) itemView.findViewById(R.id.Category);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int postion=getAdapterPosition();
                    task_activity task_activity = (com.example.mankirat.tasky.task_activity) context;
                    task_activity.openBottomSheet(postion);
                    return true;
                }
            });



        }



    }

    @Override
    public Tasks onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        Tasks task = new Tasks(v);
        return task;
    }

    @Override
    public void onBindViewHolder(Tasks holder, int position) {
        holder.title.setText(task.get(position).getTitle());
        holder.time.setText(task.get(position).getTime());
        holder.date.setText(task.get(position).getDate());
        holder.location.setText(task.get(position).getLocation());
        holder.category.setText(task.get(position).getCategory());

    }

    @Override
    public int getItemCount() {
        return task.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }





}
