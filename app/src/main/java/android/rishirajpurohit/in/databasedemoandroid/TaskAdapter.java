package android.rishirajpurohit.in.databasedemoandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rishi on 20-06-2018.
 */

public class TaskAdapter extends ArrayAdapter {

    LayoutInflater inflater;
    List<Task> taskArrayList;

    public TaskAdapter(@NonNull Context context, @NonNull List objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
//        super()
        taskArrayList = objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View vi = inflater.inflate(R.layout.single_task_row,null);

        TextView tv_title = vi.findViewById(R.id.tv_title);
        TextView tv_subtitle = vi.findViewById(R.id.tv_subtitle);
        TextView tv_id = vi.findViewById(R.id.tv_id);

        Task task = taskArrayList.get(position);
        tv_title.setText(task.getTitle());
        tv_subtitle.setText(task.getSubtitle());
        tv_id.setText(task.get_id() + " : ");

        return vi;
    }
}
