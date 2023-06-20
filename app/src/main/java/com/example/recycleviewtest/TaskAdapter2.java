package com.example.recycleviewtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter2 extends RecyclerView.Adapter<TaskAdapter2.TaskViewHolder> {

    private List<Task> taskList;
    private RecyclerView recyclerView;
    private OnTaskSwipeListener onTaskSwipeListener;

    public TaskAdapter2(List<Task> taskList, RecyclerView recyclerView) {
        this.taskList = taskList;
        this.recyclerView = recyclerView;
    }

    public interface OnTaskSwipeListener {
        void onTaskSwiped(Task task);
    }

    public void setOnTaskSwipeListener(OnTaskSwipeListener listener) {
        this.onTaskSwipeListener = listener;
    }


    @NonNull
    @Override
    public TaskAdapter2.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View intemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskAdapter2.TaskViewHolder(intemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter2.TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.textTitle.setText(task.getTitle());
        holder.textDescription.setText(task.getDescription());

        ItemTouchHelper.SimpleCallback swipeCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedPosition = viewHolder.getAdapterPosition();
                if (onTaskSwipeListener != null) {
                    onTaskSwipeListener.onTaskSwiped(taskList.get(swipedPosition));
                }
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
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
