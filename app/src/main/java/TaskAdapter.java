package com.example.todolistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private Context context;
    private List<Task> taskList;
    private OnTaskListener onTaskListener;

    public TaskAdapter(Context context, List<Task> taskList, OnTaskListener onTaskListener) {
        this.context = context;
        this.taskList = taskList;
        this.onTaskListener = onTaskListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view, onTaskListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.textViewTask.setText(task.getTitle());
        holder.checkBoxTask.setChecked(task.isCompleted());
        holder.checkBoxTask.setOnCheckedChangeListener((buttonView, isChecked) -> task.setCompleted(isChecked));
        holder.buttonDeleteTask.setOnClickListener(v -> onTaskListener.onDeleteTask(task));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTask;
        CheckBox checkBoxTask;
        ImageButton buttonDeleteTask;

        public TaskViewHolder(@NonNull View itemView, OnTaskListener onTaskListener) {
            super(itemView);
            textViewTask = itemView.findViewById(R.id.text_view_task);
            checkBoxTask = itemView.findViewById(R.id.checkbox_task);
            buttonDeleteTask = itemView.findViewById(R.id.button_delete_task);
        }
    }

    public interface OnTaskListener {
        void onDeleteTask(Task task);
    }
}
