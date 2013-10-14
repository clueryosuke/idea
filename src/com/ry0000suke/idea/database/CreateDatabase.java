package com.ry0000suke.idea.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateDatabase {
	public static final String TAG = "DBAdapter";
	private SQLiteDatabase sqliteDb;
	private SQLiteOpenHelper dbHelper;
	private static final String DATABASE_NAME = "Idea";
	private static final int DATABASE_VERSTION = 1;

	public CreateDatabase(Context context) {
		this.dbHelper = new DBAdapterHelper(context);
	}

	public static CreateDatabase create(Context context) {
		return new CreateDatabase(context);
	}

	public SQLiteDatabase open() {
		if (sqliteDb == null || !sqliteDb.isOpen()) {
			try {
				sqliteDb = dbHelper.getWritableDatabase();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqliteDb;
	}

	public void close() {
		if (sqliteDb != null && sqliteDb.isOpen()) {
			sqliteDb.close();
		}
	}

	public static class DBAdapterHelper extends SQLiteOpenHelper {
		public DBAdapterHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSTION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			ParentMapScheme.onCreate(db);
			ChildMapScheme.onCreate(db);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		}
	}
}
