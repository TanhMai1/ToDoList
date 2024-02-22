package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements DatePickerDialog.SaveDateListener {

    private Task CurrentTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            initTask(extras.getInt("taskID"));
        }
        else{
            currentTask = new Task();
        }

        initTextChangedEvents();
        initSaveButton();
        initChangeDateButton();
        initListButton();
    }

    @Override
    public void didFinishDatePickerDialog(Calender selectedTime){
        TextView dataLabel = findViewById(R.id.dateLabel);
        dateLabel.setText(DateFormat.format("MM/dd/yyyy", selectedTime));
        currentTask.setDueDate(selectedTime);
    }

    private void initChangeDateButton(){
        Button changeDate = findViewById(R.id.changeDateButton);
        changeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}