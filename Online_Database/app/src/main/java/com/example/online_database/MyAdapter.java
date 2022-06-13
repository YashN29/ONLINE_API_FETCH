package com.example.online_database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyClass>
{
    List<Model> modelList;
    Context context;

    public MyAdapter(List<Model> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new MyClass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyClass holder, int position) {
        holder.tvtitle.setText(modelList.get(position).getName());
        holder.tvemail.setText(modelList.get(position).getEmail());
        holder.tvbody.setText(modelList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class MyClass extends RecyclerView.ViewHolder
    {
        TextView tvtitle,tvbody,tvemail,tvid;
        public MyClass(@NonNull View itemView)
        {
            super(itemView);

            tvtitle = itemView.findViewById(R.id.tvtitle);
            tvbody = itemView.findViewById(R.id.tvbody);
            tvemail = itemView.findViewById(R.id.tvemail);
            tvid = itemView.findViewById(R.id.tvid);
        }
    }

}
