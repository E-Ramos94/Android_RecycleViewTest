package com.example.recycleviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        taskList = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            taskList.add(new Task("Tarea " + String.valueOf(i), "Descripcion de la tarea " + String.valueOf(i) ));
        }

//        taskList.add(new Task("Tarea 1", "Descripcion de la tarea 1"));
//        taskList.add(new Task("Tarea 2", "Descripcion de la tarea 2"));
//        taskList.add(new Task("Tarea 3", "Descripcion de la tarea 3"));

        taskAdapter = new TaskAdapter(taskList);
        recyclerView.setAdapter(taskAdapter);

        taskAdapter.setOnTaskClickListener(new TaskAdapter.OnTaskClickListener() {
            @Override
            public void onTaskClick(Task task) {
                taskAdapter.setOnTaskClickListener(new TaskAdapter.OnTaskClickListener() {
                    @Override
                    public void onTaskClick(Task task) {
                        // Manejar el evento de clic aquí
                        Toast.makeText(MainActivity.this, "Clic en la tarea: " + task.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}