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
    EditText etTitle,etSubTitle;
    String task_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final boolean isEditAction = getIntent().getBooleanExtra("edit_action",false);

        etTitle = findViewById(R.id.et_title);
        etSubTitle = findViewById(R.id.et_subtitle);


        btnAddTask = findViewById(R.id.btn_addTask);
        manager = new DatabaseManager(MainActivity.this);
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = etTitle.getText().toString();
                String subtitle = etSubTitle.getText().toString();

                Task task = new Task();
                task.setTitle(title);
                task.setSubtitle(subtitle);

                if(isEditAction){
                    task.set_id(task_id);
                    manager.editTaskInDB(task);
                }else{
                    manager.addTaskToDB(task);
                }

            }
        });

        if(isEditAction){
            Task task = (Task) getIntent().getParcelableExtra("task");
            task_id = task.get_id();
            etTitle.setText(task.getTitle());
            etSubTitle.setText(task.getSubtitle());
            btnAddTask.setText("Update");
        }

        (findViewById(R.id.btn_viewall)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TaskListActivity.class));
            }
        });

    }
}
