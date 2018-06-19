package android.rishirajpurohit.in.databasedemoandroid;

/**
 * Created by rishi on 19-06-2018.
 */

public class Task {

    public static final String TABLE_NAME = "tasks";
    public static final String _ID = "id";
    public static final String COLUMN_NAME_TITLE = "title" ;
    public static final String COLUMN_NAME_SUBTITLE = "subtitle" ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    private String title;
    private String subtitle;
    private String _id;
}
