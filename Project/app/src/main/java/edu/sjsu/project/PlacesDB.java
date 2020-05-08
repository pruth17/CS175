package edu.sjsu.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PlacesDB extends SQLiteOpenHelper {

    private static String DBNAME = "place.db";
    private static int VERSION = 1;
    public static final String FIELD_ROW_ID = "_id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_RATINGS = "rating";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String DATABASE_TABLE = "place_table";
    public static final String FIELD_LAT = "latitude";
    public static final String FIELD_LONG = "longitude";
    private SQLiteDatabase mDB;

    public PlacesDB(Context context){
        super(context, DBNAME, null, VERSION);
        this.mDB = getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = 	"create table " + DATABASE_TABLE + " ( " +
                FIELD_ROW_ID + " integer primary key autoincrement , " +
                FIELD_NAME + " text , " +
                FIELD_RATINGS + " text , " +
                FIELD_DESCRIPTION + " text, " +
                FIELD_LAT + " double, " +
                FIELD_LONG + " double " +
                " ) ";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }

    public boolean insert(String name, String ratings, String description, String latitude, String longitude) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIELD_NAME, name);
        contentValues.put(FIELD_RATINGS, ratings);
        contentValues.put(FIELD_DESCRIPTION, description);
        contentValues.put(FIELD_LAT, latitude);
        contentValues.put(FIELD_LONG, longitude);
        long result = mDB.insert(DATABASE_TABLE,null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getPlace(String request) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DATABASE_TABLE, new String[] {FIELD_ROW_ID, FIELD_NAME,
                        FIELD_RATINGS, FIELD_DESCRIPTION, FIELD_LAT, FIELD_LONG },
                FIELD_NAME + "=?", new String[] {request},
                null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }

    public void delete(){

        mDB.delete(DATABASE_TABLE, null,null);
    }
}