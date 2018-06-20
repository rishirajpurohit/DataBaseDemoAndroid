package android.rishirajpurohit.in.databasedemoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class TaskDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

//        Bundle data = getIntent().getExtras();
        Task task = (Task) getIntent().getParcelableExtra("task");
//        Task task = (Task) data.getParcelable("task");

        Toast.makeText(this, "Title : "+task.getTitle(), Toast.LENGTH_SHORT).show();

    }
}
