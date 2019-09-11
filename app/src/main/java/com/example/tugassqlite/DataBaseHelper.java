package com.example.tugassqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static android.icu.text.Normalizer.NO;

public class DataBaseHelper  extends SQLiteOpenHelper {

    private static final int DB_VERSION=1;
    private static final String DB_NAME="UserInfo";
    private static final String TABLE_NAME="tbl_user";
    private static final String KEY_NO="NO";
    private static final String KEY_NAME="name";
    private static final String KEY_TL="TL";
    private static final String KEY_JK="JK";
    private static final String KEY_ALAMAT="ALAMAT";


    public DataBaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable="Create Table "
                +TABLE_NAME+"("+KEY_NO+" TEXT PRIMARY KEY,"+KEY_NAME+" TEXT, "+ KEY_TL +" TEXT,"+KEY_JK+" Text,"+KEY_ALAMAT+")";
                db.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql=("drop table if exists " +TABLE_NAME);
        db.execSQL(sql);
        onCreate(db);
    }
    public void insert(PersonBean personBean){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NO,personBean.getNO());
        values.put(KEY_NAME,personBean.getNAME());
        values.put(KEY_TL,personBean.getTL());
        values.put(KEY_JK,personBean.getJK());
        values.put(KEY_ALAMAT,personBean.getALAMAT());

        db.insert(TABLE_NAME,null,values);
    }
    public List<PersonBean> selectUserData(){
        ArrayList<PersonBean> userList=new ArrayList<PersonBean>();
        SQLiteDatabase db= getReadableDatabase();
        String[] columns={KEY_NO,KEY_NAME,KEY_TL,KEY_JK,KEY_ALAMAT};
        Cursor c =db.query(TABLE_NAME,columns,null,null,null,null,null);
        while (c.moveToNext()){
            String NO=c.getString(0);
            String name=c.getString(0);
            String TL=c.getString(0);
            String JK=c.getString(0);
            String ALAMAT=c.getString(0);
            PersonBean personBean=new PersonBean();
            personBean.setNO(NO);
            personBean.setNAME(name);
            personBean.setTL(TL);
            personBean.setJK(JK);
            personBean.setALAMAT(ALAMAT);
            userList.add(personBean);
        }
        return userList;
    }
    public void delete(String no){
        SQLiteDatabase db =getWritableDatabase();
        String whereClause=KEY_NO+"='"+no+"'";
        db.delete(TABLE_NAME,whereClause,null);
    }
    public void update(PersonBean personBean){
        SQLiteDatabase db=getReadableDatabase();
        ContentValues v=new ContentValues();
        String whereClause=KEY_NO+"='"+personBean.getNO()+"'";
        v.put(KEY_NAME,personBean.getNAME());
        v.put(KEY_TL,personBean.getTL());
        v.put(KEY_JK,personBean.getJK());
        v.put(KEY_ALAMAT,personBean.getALAMAT());
        db.update(TABLE_NAME,v,whereClause ,null );
    }
}
