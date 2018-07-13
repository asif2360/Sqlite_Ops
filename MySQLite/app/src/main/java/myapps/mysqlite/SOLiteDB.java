package myapps.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Acer on 24-02-2017.
 */

public class SOLiteDB extends SQLiteOpenHelper {
    private static final String DB_NAME="myfirst.db";
    private  static final int DB_VER=1;
    private  static final String TABLE_NAME="LoginTable";
    private Context context;
    private  static final String col1="name";
    private  static final String col2="pass";
    String Name;
    public SOLiteDB(Context context) {
        super(context, DB_NAME, null, DB_VER);
        this.context=context;
        Toast.makeText(context, "Constructor was called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TABLE_NAME+"(_id INTEGER PRIMARY KEY AUTOINCREMENT,"+col1+" VARCHAR(90),"+col2+" VARCHAR(30));";
        try {
            db.execSQL(query);
            Toast.makeText(context, "Oncreate was called ", Toast.LENGTH_LONG).show();

        }
        catch (Exception e){

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void show(String naam, String password) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalue=new ContentValues();
        contentvalue.put(col1,naam);
        contentvalue.put(col2,password);
        long res= db.insert(TABLE_NAME,null,contentvalue);
        if(res==-1){
            Toast.makeText(context, "UNSUCCESSFUL", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Successful inserted", Toast.LENGTH_SHORT).show();
        }

    }
    public Cursor getalldata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM "+TABLE_NAME+"",null);
        return res;
    }
    public Integer del(String name) {

        SQLiteDatabase db = this.getWritableDatabase();

        int ret = db.delete(TABLE_NAME, "Name=?", new String[]{"" + name + ""});
        return ret;

    }
    public int Update(String newname,String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(SOLiteDB.col1,newname);
        int ret=db.update(SOLiteDB.TABLE_NAME,cv,SOLiteDB.col1+"=?",new  String[]{name});
        return ret;
    }

}