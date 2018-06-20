package android.rishirajpurohit.in.databasedemoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        setTitle("All Tasks");

        ListView lv = findViewById(R.id.listView);

        DatabaseManager databaseManager = new DatabaseManager(TaskListActivity.this);
        final ArrayList<Task> taskArrayList = databaseManager.getTasksFromDB();

//        ArrayAdapter<Task> adapter = new ArrayAdapter<Task>(TaskListActivity.this,android.R.layout.simple_list_item_1,taskArrayList);

        TaskAdapter taskAdapter = new TaskAdapter(TaskListActivity.this,taskArrayList);

        lv.setAdapter(taskAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Task t = taskArrayList.get(i);
                Toast.makeText(TaskListActivity.this, "You clicked : " + t.getTitle(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(TaskListActivity.this,TaskDetailActivity.class);

                intent.putExtra("task",t);

                startActivity(intent);
                finish();
            }
        });

    }
}
