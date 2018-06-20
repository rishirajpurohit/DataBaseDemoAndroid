package android.rishirajpurohit.in.databasedemoandroid;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rishi on 19-06-2018.
 */

public class Task implements Parcelable{


    public Task(String title, String subtitle, String string){
        this.setTitle(title);
        this.setSubtitle(subtitle);
        this.set_id(string);
    }

    Task(){

    }

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

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }

    Task(Parcel parcel){
        String[] data = new String[3];
        parcel.readStringArray(data);
        this.set_id(data[0]);
        this.setTitle(data[1]);
        this.setSubtitle(data[2]);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[]{this.get_id(),this.getTitle(),this.getSubtitle()});
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}
