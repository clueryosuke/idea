package com.ry0000suke.idea;

import com.ry0000suke.idea.database.ChildMapDAO;
import com.ry0000suke.idea.database.CreateDatabase;
import com.ry0000suke.idea.database.ParentMapDAO;
import com.ry0000suke.idea.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ry0000suke.idea.util.MenuItem;
import com.ry0000suke.idea.util.PopupMenu;
import com.ry0000suke.idea.util.PopupMenu.OnItemSelectedListener;

public class IdeaAll extends BaseActivity implements OnClickListener {
	private Context context;
	private int parentId;
	private int positionId;
	private String childTitleWord;
	private String word;
	private TextView title;
	private ImageView back;
	private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9;
	private TextView text1_1, text1_2, text1_3, text1_4, text1_5, text1_6, text1_7, text1_8, text1_9,
					 text2_1, text2_2, text2_3, text2_4, text2_5, text2_6, text2_7, text2_8, text2_9,
					 text3_1, text3_2, text3_3, text3_4, text3_5, text3_6, text3_7, text3_8, text3_9,
					 text4_1, text4_2, text4_3, text4_4, text4_5, text4_6, text4_7, text4_8, text4_9,
					 text5_1, text5_2, text5_3, text5_4, text5_5, text5_6, text5_7, text5_8, text5_9,
					 text6_1, text6_2, text6_3, text6_4, text6_5, text6_6, text6_7, text6_8, text6_9,
					 text7_1, text7_2, text7_3, text7_4, text7_5, text7_6, text7_7, text7_8, text7_9,
					 text8_1, text8_2, text8_3, text8_4, text8_5, text8_6, text8_7, text8_8, text8_9,
					 text9_1, text9_2, text9_3, text9_4, text9_5, text9_6, text9_7, text9_8, text9_9;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.idea_all);
		super.loadController();
		super.changeImageMenu(R.drawable.tabbar_home_1_1,
				R.drawable.tabbar_defaultmap_2_2, R.drawable.tabbar_bookmark_1_3, 2);
		context = this;

		Bundle bundle = getIntent().getExtras();
		parentId = bundle.getInt("parent_id");
		positionId = bundle.getInt("position_id");
		childTitleWord = bundle.getString("word");

		setInit();
		setText();

	}


	public void setInit() {
		title = (TextView) findViewById(R.id.idea_all_text);
		back = (ImageView) findViewById(R.id.idea_all_back);
		text1_1 = (TextView) findViewById(R.id.text1_1);
		text1_2 = (TextView) findViewById(R.id.text1_2);
		text1_3 = (TextView) findViewById(R.id.text1_3);
		text1_4 = (TextView) findViewById(R.id.text1_4);
		text1_5 = (TextView) findViewById(R.id.text1_5);
		text1_6 = (TextView) findViewById(R.id.text1_6);
		text1_7 = (TextView) findViewById(R.id.text1_7);
		text1_8 = (TextView) findViewById(R.id.text1_8);
		text1_9 = (TextView) findViewById(R.id.text1_9);
		text2_1 = (TextView) findViewById(R.id.text2_1);
		text2_2 = (TextView) findViewById(R.id.text2_2);
		text2_3 = (TextView) findViewById(R.id.text2_3);
		text2_4 = (TextView) findViewById(R.id.text2_4);
		text2_5 = (TextView) findViewById(R.id.text2_5);
		text2_6 = (TextView) findViewById(R.id.text2_6);
		text2_7 = (TextView) findViewById(R.id.text2_7);
		text2_8 = (TextView) findViewById(R.id.text2_8);
		text2_9 = (TextView) findViewById(R.id.text2_9);
		text3_1 = (TextView) findViewById(R.id.text3_1);
		text3_2 = (TextView) findViewById(R.id.text3_2);
		text3_3 = (TextView) findViewById(R.id.text3_3);
		text3_4 = (TextView) findViewById(R.id.text3_4);
		text3_5 = (TextView) findViewById(R.id.text3_5);
		text3_6 = (TextView) findViewById(R.id.text3_6);
		text3_7 = (TextView) findViewById(R.id.text3_7);
		text3_8 = (TextView) findViewById(R.id.text3_8);
		text3_9 = (TextView) findViewById(R.id.text3_9);
		text4_1 = (TextView) findViewById(R.id.text4_1);
		text4_2 = (TextView) findViewById(R.id.text4_2);
		text4_3 = (TextView) findViewById(R.id.text4_3);
		text4_4 = (TextView) findViewById(R.id.text4_4);
		text4_5 = (TextView) findViewById(R.id.text4_5);
		text4_6 = (TextView) findViewById(R.id.text4_6);
		text4_7 = (TextView) findViewById(R.id.text4_7);
		text4_8 = (TextView) findViewById(R.id.text4_8);
		text4_9 = (TextView) findViewById(R.id.text4_9);
		text5_1 = (TextView) findViewById(R.id.text5_1);
		text5_2 = (TextView) findViewById(R.id.text5_2);
		text5_3 = (TextView) findViewById(R.id.text5_3);
		text5_4 = (TextView) findViewById(R.id.text5_4);
		text5_5 = (TextView) findViewById(R.id.text5_5);
		text5_6 = (TextView) findViewById(R.id.text5_6);
		text5_7 = (TextView) findViewById(R.id.text5_7);
		text5_8 = (TextView) findViewById(R.id.text5_8);
		text5_9 = (TextView) findViewById(R.id.text5_9);
		text6_1 = (TextView) findViewById(R.id.text6_1);
		text6_2 = (TextView) findViewById(R.id.text6_2);
		text6_3 = (TextView) findViewById(R.id.text6_3);
		text6_4 = (TextView) findViewById(R.id.text6_4);
		text6_5 = (TextView) findViewById(R.id.text6_5);
		text6_6 = (TextView) findViewById(R.id.text6_6);
		text6_7 = (TextView) findViewById(R.id.text6_7);
		text6_8 = (TextView) findViewById(R.id.text6_8);
		text6_9 = (TextView) findViewById(R.id.text6_9);
		text7_1 = (TextView) findViewById(R.id.text7_1);
		text7_2 = (TextView) findViewById(R.id.text7_2);
		text7_3 = (TextView) findViewById(R.id.text7_3);
		text7_4 = (TextView) findViewById(R.id.text7_4);
		text7_5 = (TextView) findViewById(R.id.text7_5);
		text7_6 = (TextView) findViewById(R.id.text7_6);
		text7_7 = (TextView) findViewById(R.id.text7_7);
		text7_8 = (TextView) findViewById(R.id.text7_8);
		text7_9 = (TextView) findViewById(R.id.text7_9);
		text8_1 = (TextView) findViewById(R.id.text8_1);
		text8_2 = (TextView) findViewById(R.id.text8_2);
		text8_3 = (TextView) findViewById(R.id.text8_3);
		text8_4 = (TextView) findViewById(R.id.text8_4);
		text8_5 = (TextView) findViewById(R.id.text8_5);
		text8_6 = (TextView) findViewById(R.id.text8_6);
		text8_7 = (TextView) findViewById(R.id.text8_7);
		text8_8 = (TextView) findViewById(R.id.text8_8);
		text8_9 = (TextView) findViewById(R.id.text8_9);
		text9_1 = (TextView) findViewById(R.id.text9_1);
		text9_2 = (TextView) findViewById(R.id.text9_2);
		text9_3 = (TextView) findViewById(R.id.text9_3);
		text9_4 = (TextView) findViewById(R.id.text9_4);
		text9_5 = (TextView) findViewById(R.id.text9_5);
		text9_6 = (TextView) findViewById(R.id.text9_6);
		text9_7 = (TextView) findViewById(R.id.text9_7);
		text9_8 = (TextView) findViewById(R.id.text9_8);
		text9_9 = (TextView) findViewById(R.id.text9_9);

		boolean isTabletDevice = getResources().getBoolean(R.bool.isTablet);
		if (isTabletDevice == true) {
			text1_1.setTextSize(13);
			text1_2.setTextSize(13);
			text1_3.setTextSize(13);
			text1_4.setTextSize(13);
			text1_5.setTextSize(13);
			text1_6.setTextSize(13);
			text1_7.setTextSize(13);
			text1_8.setTextSize(13);
			text1_9.setTextSize(13);
			text2_1.setTextSize(13);
			text2_2.setTextSize(13);
			text2_3.setTextSize(13);
			text2_4.setTextSize(13);
			text2_5.setTextSize(13);
			text2_6.setTextSize(13);
			text2_7.setTextSize(13);
			text2_8.setTextSize(13);
			text2_9.setTextSize(13);
			text3_1.setTextSize(13);
			text3_2.setTextSize(13);
			text3_3.setTextSize(13);
			text3_4.setTextSize(13);
			text3_5.setTextSize(13);
			text3_6.setTextSize(13);
			text3_7.setTextSize(13);
			text3_8.setTextSize(13);
			text3_9.setTextSize(13);
			text4_1.setTextSize(13);
			text4_2.setTextSize(13);
			text4_3.setTextSize(13);
			text4_4.setTextSize(13);
			text4_5.setTextSize(13);
			text4_6.setTextSize(13);
			text4_7.setTextSize(13);
			text4_8.setTextSize(13);
			text4_9.setTextSize(13);
			text5_1.setTextSize(13);
			text5_2.setTextSize(13);
			text5_3.setTextSize(13);
			text5_4.setTextSize(13);
			text5_5.setTextSize(13);
			text5_6.setTextSize(13);
			text5_7.setTextSize(13);
			text5_8.setTextSize(13);
			text5_9.setTextSize(13);
			text6_1.setTextSize(13);
			text6_2.setTextSize(13);
			text6_3.setTextSize(13);
			text6_4.setTextSize(13);
			text6_5.setTextSize(13);
			text6_6.setTextSize(13);
			text6_7.setTextSize(13);
			text6_8.setTextSize(13);
			text6_9.setTextSize(13);
			text7_1.setTextSize(13);
			text7_2.setTextSize(13);
			text7_3.setTextSize(13);
			text7_4.setTextSize(13);
			text7_5.setTextSize(13);
			text7_6.setTextSize(13);
			text7_7.setTextSize(13);
			text7_8.setTextSize(13);
			text7_9.setTextSize(13);
			text8_1.setTextSize(13);
			text8_2.setTextSize(13);
			text8_3.setTextSize(13);
			text8_4.setTextSize(13);
			text8_5.setTextSize(13);
			text8_6.setTextSize(13);
			text8_7.setTextSize(13);
			text8_8.setTextSize(13);
			text8_9.setTextSize(13);
			text9_1.setTextSize(13);
			text9_2.setTextSize(13);
			text9_3.setTextSize(13);
			text9_4.setTextSize(13);
			text9_5.setTextSize(13);
			text9_6.setTextSize(13);
			text9_7.setTextSize(13);
			text9_8.setTextSize(13);
			text9_9.setTextSize(13);
		}
		else {
			text1_1.setTextSize(8);
			text1_2.setTextSize(8);
			text1_3.setTextSize(8);
			text1_4.setTextSize(8);
			text1_5.setTextSize(8);
			text1_6.setTextSize(8);
			text1_7.setTextSize(8);
			text1_8.setTextSize(8);
			text1_9.setTextSize(8);
			text2_1.setTextSize(8);
			text2_2.setTextSize(8);
			text2_3.setTextSize(8);
			text2_4.setTextSize(8);
			text2_5.setTextSize(8);
			text2_6.setTextSize(8);
			text2_7.setTextSize(8);
			text2_8.setTextSize(8);
			text2_9.setTextSize(8);
			text3_1.setTextSize(8);
			text3_2.setTextSize(8);
			text3_3.setTextSize(8);
			text3_4.setTextSize(8);
			text3_5.setTextSize(8);
			text3_6.setTextSize(8);
			text3_7.setTextSize(8);
			text3_8.setTextSize(8);
			text3_9.setTextSize(8);
			text4_1.setTextSize(8);
			text4_2.setTextSize(8);
			text4_3.setTextSize(8);
			text4_4.setTextSize(8);
			text4_5.setTextSize(8);
			text4_6.setTextSize(8);
			text4_7.setTextSize(8);
			text4_8.setTextSize(8);
			text4_9.setTextSize(8);
			text5_1.setTextSize(8);
			text5_2.setTextSize(8);
			text5_3.setTextSize(8);
			text5_4.setTextSize(8);
			text5_5.setTextSize(8);
			text5_6.setTextSize(8);
			text5_7.setTextSize(8);
			text5_8.setTextSize(8);
			text5_9.setTextSize(8);
			text6_1.setTextSize(8);
			text6_2.setTextSize(8);
			text6_3.setTextSize(8);
			text6_4.setTextSize(8);
			text6_5.setTextSize(8);
			text6_6.setTextSize(8);
			text6_7.setTextSize(8);
			text6_8.setTextSize(8);
			text6_9.setTextSize(8);
			text7_1.setTextSize(8);
			text7_2.setTextSize(8);
			text7_3.setTextSize(8);
			text7_4.setTextSize(8);
			text7_5.setTextSize(8);
			text7_6.setTextSize(8);
			text7_7.setTextSize(8);
			text7_8.setTextSize(8);
			text7_9.setTextSize(8);
			text8_1.setTextSize(8);
			text8_2.setTextSize(8);
			text8_3.setTextSize(8);
			text8_4.setTextSize(8);
			text8_5.setTextSize(8);
			text8_6.setTextSize(8);
			text8_7.setTextSize(8);
			text8_8.setTextSize(8);
			text8_9.setTextSize(8);
			text9_1.setTextSize(8);
			text9_2.setTextSize(8);
			text9_3.setTextSize(8);
			text9_4.setTextSize(8);
			text9_5.setTextSize(8);
			text9_6.setTextSize(8);
			text9_7.setTextSize(8);
			text9_8.setTextSize(8);
			text9_9.setTextSize(8);
		}

		title.setText(getText(R.string.idea_all_title));

		back.setOnClickListener(this);

	}
	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {	
			case R.id.idea_all_back:
				Intent intent = new Intent();

				if (positionId > 0) {
					intent.setClass(getApplicationContext(), IdeaChild.class);
					intent.putExtra("parent_id", parentId);
					intent.putExtra("position", positionId);
					intent.putExtra("word", word);
				}
				else {
					intent.setClass(getApplicationContext(), IdeaMain.class);
					intent.putExtra("parent_id", parentId);
				}
				startActivity(intent);
				break;
		}
	}

	public void setText() {
		CreateDatabase db = new CreateDatabase(this);

		// Parent Map
		ParentMapDAO parentMapDAO = new ParentMapDAO(db.open());
		Cursor cursor1 = parentMapDAO.getByParentId(parentId);
		int total1 = cursor1.getCount();
		cursor1.moveToFirst();
		if (total1 > 0) {
			text5_1.setText(cursor1.getString(1));
			text5_2.setText(cursor1.getString(2));
			text5_3.setText(cursor1.getString(3));
			text5_4.setText(cursor1.getString(4));
			text5_5.setText(cursor1.getString(5));
			text5_6.setText(cursor1.getString(6));
			text5_7.setText(cursor1.getString(7));
			text5_8.setText(cursor1.getString(8));
			text5_9.setText(cursor1.getString(9));
		}


		// Child Map
		ChildMapDAO childMapDAO = new ChildMapDAO(db.open());
		Cursor cursor2 = childMapDAO.getByParentId(parentId);
		int total2 = cursor2.getCount();
			System.out.println("hogeeeeeeeeeeeeeeeeeeeee parentId " + parentId);
			System.out.println("hogeeeeeeeeeeeeeeeeeeeee total2 " + total2);
		cursor2.moveToFirst();
		if (total2 > 0) {
			for (int i = 0; i < total2; i++) {
				int position_num = cursor2.getInt(2);
				String text1 = cursor2.getString(3);
				String text2 = cursor2.getString(4);
				String text3 = cursor2.getString(5);
				String text4 = cursor2.getString(6);
				String text5 = cursor2.getString(7);
				String text6 = cursor2.getString(8);
				String text7 = cursor2.getString(9);
				String text8 = cursor2.getString(10);
				String text9 = cursor2.getString(11);
				if (position_num == 1) {
					text1_1.setText(text1);
					text1_2.setText(text2);
					text1_3.setText(text3);
					text1_4.setText(text4);
					text1_5.setText(text5);
					text1_6.setText(text6);
					text1_7.setText(text7);
					text1_8.setText(text8);
					text1_9.setText(text9);
				}
				if (position_num == 2) {
					text2_1.setText(text1);
					text2_2.setText(text2);
					text2_3.setText(text3);
					text2_4.setText(text4);
					text2_5.setText(text5);
					text2_6.setText(text6);
					text2_7.setText(text7);
					text2_8.setText(text8);
					text2_9.setText(text9);
				}
				if (position_num == 3) {
					text3_1.setText(text1);
					text3_2.setText(text2);
					text3_3.setText(text3);
					text3_4.setText(text4);
					text3_5.setText(text5);
					text3_6.setText(text6);
					text3_7.setText(text7);
					text3_8.setText(text8);
					text3_9.setText(text9);
				}
				if (position_num == 4) {
					text4_1.setText(text1);
					text4_2.setText(text2);
					text4_3.setText(text3);
					text4_4.setText(text4);
					text4_5.setText(text5);
					text4_6.setText(text6);
					text4_7.setText(text7);
					text4_8.setText(text8);
					text4_9.setText(text9);
				}
				if (position_num == 6) {
					text6_1.setText(text1);
					text6_2.setText(text2);
					text6_3.setText(text3);
					text6_4.setText(text4);
					text6_5.setText(text5);
					text6_6.setText(text6);
					text6_7.setText(text7);
					text6_8.setText(text8);
					text6_9.setText(text9);
				}
				if (position_num == 7) {
					text7_1.setText(text1);
					text7_2.setText(text2);
					text7_3.setText(text3);
					text7_4.setText(text4);
					text7_5.setText(text5);
					text7_6.setText(text6);
					text7_7.setText(text7);
					text7_8.setText(text8);
					text7_9.setText(text9);
				}
				if (position_num == 8) {
					text8_1.setText(text1);
					text8_2.setText(text2);
					text8_3.setText(text3);
					text8_4.setText(text4);
					text8_5.setText(text5);
					text8_6.setText(text6);
					text8_7.setText(text7);
					text8_8.setText(text8);
					text8_9.setText(text9);
				}
				if (position_num == 9) {
					text9_1.setText(text1);
					text9_2.setText(text2);
					text9_3.setText(text3);
					text9_4.setText(text4);
					text9_5.setText(text5);
					text9_6.setText(text6);
					text9_7.setText(text7);
					text9_8.setText(text8);
					text9_9.setText(text9);
				}
				cursor2.moveToNext();
			}
		}
		db.close();
	}



	public int getParentIdByNewRecord() {
		CreateDatabase db = new CreateDatabase(this);
		ParentMapDAO parentMapDAO = new ParentMapDAO(db.open());
		Cursor cursor = parentMapDAO.getNewRecord();
		cursor.moveToFirst();
		int parentId = cursor.getInt(0);
		db.close();
		return parentId;
	}

	public String getParentEditTextByNum(int position) {
		CreateDatabase db = new CreateDatabase(this);
		ParentMapDAO parentMapDAO = new ParentMapDAO(db.open());
		Cursor cursor = parentMapDAO.getByParentId(parentId);
		cursor.moveToFirst();
		String word = cursor.getString(position);
		db.close();
		return word;
	}
}
