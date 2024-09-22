package com.example.recyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private List<Item> itemList;
    private EditText editTextName;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        editTextName = findViewById(R.id.editTextName);
        buttonSave = findViewById(R.id.buttonSave);

        itemList = new ArrayList<>();
        itemAdapter = new ItemAdapter(itemList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                if (!name.isEmpty()) {
                    int id = itemList.size() + 1;
                    itemList.add(new Item(id, name));
                    itemAdapter.notifyItemInserted(itemList.size() - 1);
                    editTextName.setText("");
                }
            }
        });

        // Menambahkan data statis awal
        initData();
    }

    private void initData() {
        itemList.add(new Item(1, "Android"));
        itemList.add(new Item(2, "iPhone"));
        itemList.add(new Item(3, "Mac OS X"));
        itemList.add(new Item(4, "Windows"));
        itemList.add(new Item(5, "Linux"));
        itemAdapter.notifyDataSetChanged();
    }
}