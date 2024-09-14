package com.example.recyclerview;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StudentAdapter.OnItemClickListener{
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<studentData> studentDataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        studentAdapter = new StudentAdapter(studentDataList, this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(studentAdapter);
        StudentDataPrepare();
    }

        private void StudentDataPrepare () {
            studentData data = new studentData("Radhika", 22);
            studentDataList.add(data);
            data = new studentData("Sophia", 21);
            studentDataList.add(data);
            data = new studentData("Ranju", 22);
            studentDataList.add(data);
            data = new studentData("Amisha", 21);
            studentDataList.add(data);
            data = new studentData("Sapana", 22);
            studentDataList.add(data);
            data = new studentData("Kajal", 22);
            studentDataList.add(data);
            data = new studentData("Anu", 22);
            studentDataList.add(data);
            data = new studentData("Neha", 25);
            studentDataList.add(data);
            data = new studentData("Astha", 20);
            studentDataList.add(data);
            data = new studentData("Gita", 19);
            studentDataList.add(data);

            // Notify the adapter that data has changed
            //studentAdapter.notifyDataSetChanged();
        }
    @Override
    public void onItemClick(int position) {
        studentData clickedStudent = studentDataList.get(position);
        Toast.makeText(this, "Clicked: " + clickedStudent.getName(), Toast.LENGTH_SHORT).show();
    }

    }
