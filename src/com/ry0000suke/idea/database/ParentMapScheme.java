package com.ry0000suke.idea.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ParentMapScheme {
	public static final String TABLE_NAME = "parent_map";
	public static final String PARENT_ID  = "parent_id";
	public static final String TEXT1      = "text1";
	public static final String TEXT2      = "text2";
	public static final String TEXT3      = "text3";
	public static final String TEXT4      = "text4";
	public static final String TEXT5      = "text5";
	public static final String TEXT6      = "text6";
	public static final String TEXT7      = "text7";
	public static final String TEXT8      = "text8";
	public static final String TEXT9      = "text9";

	private static final String DATABASE_CREATE_TABLE = "create table "
		+ TABLE_NAME + "("
		+ PARENT_ID + " integer primary key autoincrement, "
		+ TEXT1 + " text, "
		+ TEXT2 + " text, "
		+ TEXT3 + " text, "
		+ TEXT4 + " text, "
		+ TEXT5 + " text, "
		+ TEXT6 + " text, "
		+ TEXT7 + " text, "
		+ TEXT8 + " text, "
		+ TEXT9 + " text "
		//+ "primary key (" + PARENT_ID + ")"
		+ ");";

	public static void onCreate(SQLiteDatabase db) {
		Log.i("onCreate", "onCreate parent_map table");
		db.execSQL(DATABASE_CREATE_TABLE);
	}
}
