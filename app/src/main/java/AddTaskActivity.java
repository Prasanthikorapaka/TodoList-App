package com.example.todolistapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    private EditText editTextTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editTextTask = findViewById(R.id.edit_text_task);
        findViewById(R.id.button_save_task).setOnClickListener(v -> saveTask());
    }

    private void saveTask() {
        String taskTitle = editTextTask.getText().toString().trim();
        if (!taskTitle.isEmpty()) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("task_title", taskTitle);
            setResult(RESULT_OK, resultIntent);
            finish();
        }
    }
}
