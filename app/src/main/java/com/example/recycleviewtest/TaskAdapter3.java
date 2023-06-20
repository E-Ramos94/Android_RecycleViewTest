package com.example.recycleviewtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter3 extends RecyclerView.Adapter<TaskAdapter3.TaskViewHolder> {

    private List<Task> taskList;

    public TaskAdapter3(List<Task> taskList) {
        this.taskList = taskList;
    }


    @NonNull
    @Override
    public TaskAdapter3.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View intemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskAdapter3.TaskViewHolder(intemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter3.TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.textTitle.setText(task.getTitle());
        holder.textDescription.setText(task.getDescription());
    }

    @Override
    public  int getItemCount() {
        return  taskList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder{
        public TextView textTitle;
        public TextView textDescription;

        public TaskViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
        }
    }
}
