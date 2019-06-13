package cn.edu.swufe.appframe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class XueyManager {
    private DBhelper dbHelper;
    private String TBNAME;

    public XueyManager(Context context){
        dbHelper = new DBhelper(context);
        TBNAME = DBhelper.TB_NAME;
    }
    public void add(XueyItemDB item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("curname",item.getCurName());
        values.put("curxuey",item.getCurHttp());
        db.insert(TBNAME,null,values);
        db.close();
    }

    public void delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME,"ID=?",new String[]{String.valueOf(id)});
        db.close();
    }

    public void update(XueyItemDB item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("curname",item.getCurName());
        values.put("curxuey",item.getCurHttp());
        db.update(TBNAME,values,"ID=?",new String[]{String.valueOf(item.getId()),null});
        db.close();
    }
    public XueyItemDB findById(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(TBNAME,null,"ID=?",new String[]{String.valueOf(id)},null,
                null,null,null);
        XueyItemDB rateItem = null;
        if (cursor!=null && cursor.moveToFirst()){
            rateItem = new XueyItemDB();
            rateItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            rateItem.setCurName(cursor.getString(cursor.getColumnIndex("CURNAME")));
            rateItem.setCurHttp(cursor.getString(cursor.getColumnIndex("CURHTTP")));
        }
        db.close();
        return rateItem;
    }
    public void deletAll(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME,null,null);
        db.close();
    }

    public void addAll(List<XueyItemDB> list){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        for (XueyItemDB item : list){
            ContentValues values = new ContentValues();
            values.put("curname",item.getCurName());
            values.put("curxuey",item.getCurHttp());
            db.insert(TBNAME,null,values);
        }
        db.close();
    }

    public List<XueyItemDB> listAll(){
        List<XueyItemDB> ratelist = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME,null,null,null,null,null,null);
        if (cursor!=null){
            ratelist = new ArrayList<XueyItemDB>();
            while(cursor.moveToNext()){
                XueyItemDB item = new XueyItemDB();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                item.setCurName(cursor.getString(cursor.getColumnIndex("CURNAME")));
                item.setCurHttp(cursor.getString(cursor.getColumnIndex("CURHTTP")));
                ratelist.add(item);
            }
            cursor.close();
        }
        db.close();
        return  ratelist;
    }

}
