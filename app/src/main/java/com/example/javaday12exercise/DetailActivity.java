package com.example.javaday12exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {
    EditText etAgentId, etFName, etInitial, etLName, etEmail, etPhone, etPosition, etAgencyId;
    Button btnSave;
    DataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        etAgentId = findViewById(R.id.etAgetnId);
        etFName = findViewById(R.id.etFName);
        etLName = findViewById(R.id.etLName);
        etInitial = findViewById(R.id.etInitial);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etPosition = findViewById(R.id.etPosition);
        etAgencyId = findViewById(R.id.etAgencyId);
        btnSave = findViewById(R.id.btnSave);

        dataSource = new DataSource(this);

        Intent intent = getIntent();
        Agent agent = (Agent) intent.getSerializableExtra("agent");
        String mode = intent.getStringExtra("mode");

        if (mode.equals("edit"))
        {
            etAgentId.setText(agent.getAgentId() + "");
            etFName.setText(agent.getAgtFirstName());
            etInitial.setText(agent.getAgtMiddleInitial());
            etLName.setText(agent.getAgtLastName());
            etPhone.setText(agent.getAgtBusPhone());
            etEmail.setText(agent.getAgtEmail());
            etPosition.setText(agent.getAgtPosition());
            etAgencyId.setText(String.valueOf(agent.getAgencyId()));
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mode.equals("edit"))
                {
                    dataSource.updateAgent(new Agent(Integer.parseInt(etAgentId.getText().toString()), etFName.getText().toString(), etInitial.getText().toString(), etLName.getText().toString(), etPhone.getText().toString(), etEmail.getText().toString(), etPosition.getText().toString(), Integer.parseInt(etAgencyId.getText().toString())));
                }
                else
                {
                    dataSource.insertAgent(new Agent(0, etFName.getText().toString(), etInitial.getText().toString(), etLName.getText().toString(), etPhone.getText().toString(), etEmail.getText().toString(), etPosition.getText().toString(), Integer.parseInt(etAgencyId.getText().toString())));
                }
                DetailActivity.this.finish();
            }
        });

    }
}