package android.rishirajpurohit.in.databasedemoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button btnAddTask;
    DatabaseManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddTask = findViewById(R.id.btn_addTask);
        manager = new DatabaseManager(MainActivity.this);
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etTitle = findViewById(R.id.et_title);
                EditText etSubTitle = findViewById(R.id.et_subtitle);

                String title = etTitle.getText().toString();
                String subtitle = etSubTitle.getText().toString();

                Task task = new Task();
                task.setTitle(title);
                task.setSubtitle(subtitle);


                manager.addTaskToDB(task);
            }
        });

        (findViewById(R.id.btn_viewall)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TaskListActivity.class));
            }
        });

    }
}
