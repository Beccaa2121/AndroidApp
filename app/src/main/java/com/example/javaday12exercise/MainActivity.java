package com.example.javaday12exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    DataSource dataSource;
    ListView lvAgents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSource = new DataSource(this);
        lvAgents = findViewById(R.id.lvAgents);

        loadData();

        lvAgents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("agent", (Agent)lvAgents.getAdapter().getItem(i));
                intent.putExtra("mode", "edit");
                startActivity(intent);
            }
        });

        loadData();

    }

    private void loadData() {
        ArrayAdapter<Agent> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                        dataSource.getAgents());
        lvAgents.setAdapter(adapter);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }
}