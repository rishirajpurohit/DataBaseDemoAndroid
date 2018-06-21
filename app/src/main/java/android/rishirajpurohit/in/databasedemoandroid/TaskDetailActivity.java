package android.rishirajpurohit.in.databasedemoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TaskDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

//        Bundle data = getIntent().getExtras();
        final Task task = (Task) getIntent().getParcelableExtra("task");
//        Task task = (Task) data.getParcelable("task");

//        Toast.makeText(this, "Title : "+task.getTitle(), Toast.LENGTH_SHORT).show();

        TextView tv_title = findViewById(R.id.tv_title_detail);
        TextView tv_subtitle = findViewById(R.id.tv_subtitle_detail);

        tv_title.setText(task.getTitle());
        tv_subtitle.setText(task.getSubtitle());

        Button btnGoToUpdate = findViewById(R.id.btn_goToUpdate);
        btnGoToUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TaskDetailActivity.this,MainActivity.class);
                i.putExtra("task",task);
                i.putExtra("edit_action",true);
                startActivity(i);
                finish();
            }
        });

    }



}
