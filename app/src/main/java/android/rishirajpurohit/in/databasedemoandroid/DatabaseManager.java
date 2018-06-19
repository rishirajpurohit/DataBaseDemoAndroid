package android.rishirajpurohit.in.databasedemoandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rishi on 19-06-2018.
 */

public class DatabaseManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TasksDB";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Task.TABLE_NAME + " (" +
                    Task._ID + " INTEGER PRIMARY KEY," +
                    Task.COLUMN_NAME_TITLE + " TEXT," +
                    Task.COLUMN_NAME_SUBTITLE + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Task.TABLE_NAME;

    DatabaseManager(Context ctx){
        super(ctx,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    public void addTaskToDB(Task task){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(Task.COLUMN_NAME_TITLE,task.getTitle());
        cv.put(Task.COLUMN_NAME_SUBTITLE,task.getSubtitle());

        database.insert(Task.TABLE_NAME,null,cv);
    }
}














