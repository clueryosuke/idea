package com.ry0000suke.idea.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;

public class ChildMapDAO {
	private final SQLiteDatabase db;
	
	public ChildMapDAO(SQLiteDatabase db) {
		this.db = db;
	}

	public long insertChildMap(int parend_id, int position_id, String text1, String text2, String text3, String text4, 
			String text5, String text6, String text7, String text8, String text9) {
		ContentValues inititalValue = new ContentValues();
		inititalValue.put(ChildMapScheme.PARENT_ID, parend_id);
		inititalValue.put(ChildMapScheme.POSITION_NUMBER, position_id);
		inititalValue.put(ChildMapScheme.TEXT1, text1);
		inititalValue.put(ChildMapScheme.TEXT2, text2);
		inititalValue.put(ChildMapScheme.TEXT3, text3);
		inititalValue.put(ChildMapScheme.TEXT4, text4);
		inititalValue.put(ChildMapScheme.TEXT5, text5);
		inititalValue.put(ChildMapScheme.TEXT6, text6);
		inititalValue.put(ChildMapScheme.TEXT7, text7);
		inititalValue.put(ChildMapScheme.TEXT8, text8);
		inititalValue.put(ChildMapScheme.TEXT9, text9);

		return db.insert(ChildMapScheme.TABLE_NAME, null, inititalValue);
	}

	public long updateChildMap(int parend_id, int position_id, String text1, String text2, String text3, String text4, 
			String text5, String text6, String text7, String text8, String text9) {
		ContentValues inititalValue = new ContentValues();
		inititalValue.put(ChildMapScheme.PARENT_ID, parend_id);
		inititalValue.put(ChildMapScheme.POSITION_NUMBER, position_id);
		inititalValue.put(ChildMapScheme.TEXT1, text1);
		inititalValue.put(ChildMapScheme.TEXT2, text2);
		inititalValue.put(ChildMapScheme.TEXT3, text3);
		inititalValue.put(ChildMapScheme.TEXT4, text4);
		inititalValue.put(ChildMapScheme.TEXT5, text5);
		inititalValue.put(ChildMapScheme.TEXT6, text6);
		inititalValue.put(ChildMapScheme.TEXT7, text7);
		inititalValue.put(ChildMapScheme.TEXT8, text8);
		inititalValue.put(ChildMapScheme.TEXT9, text9);

		return db.update(ChildMapScheme.TABLE_NAME, inititalValue, ChildMapScheme.PARENT_ID + " = " + parend_id 
				+ " and " + ChildMapScheme.POSITION_NUMBER + " = " + position_id, null);
	}

	public long insertOrReplaceChildMap(int parend_id, int position_id, String text1, String text2, String text3, String text4, 
			String text5, String text6, String text7, String text8, String text9) {
		ContentValues inititalValue = new ContentValues();
		inititalValue.put(ChildMapScheme.PARENT_ID, parend_id);
		inititalValue.put(ChildMapScheme.POSITION_NUMBER, position_id);
		inititalValue.put(ChildMapScheme.TEXT1, text1);
		inititalValue.put(ChildMapScheme.TEXT2, text2);
		inititalValue.put(ChildMapScheme.TEXT3, text3);
		inititalValue.put(ChildMapScheme.TEXT4, text4);
		inititalValue.put(ChildMapScheme.TEXT5, text5);
		inititalValue.put(ChildMapScheme.TEXT6, text6);
		inititalValue.put(ChildMapScheme.TEXT7, text7);
		inititalValue.put(ChildMapScheme.TEXT8, text8);
		inititalValue.put(ChildMapScheme.TEXT9, text9);

		return db.replace(ChildMapScheme.TABLE_NAME, null, inititalValue);
	}

	public Cursor getAllList() {
		String sql = "SELECT * FROM child_map";
		Cursor mcursor = db.rawQuery(sql, null);
		return mcursor;
	}

	public Cursor getByParentId(int parent_id) {
		String sql = "SELECT * FROM child_map WHERE parent_id =" + parent_id;
		Cursor mcursor = db.rawQuery(sql, null);
		return mcursor;
	}

	public Cursor getByParentIdandPositionId(int parent_id, int position_number) {
		String sql = "SELECT * FROM child_map WHERE parent_id =" + parent_id + " and position_number = " + position_number;
		Cursor mcursor = db.rawQuery(sql, null);
		return mcursor;
	}
}
