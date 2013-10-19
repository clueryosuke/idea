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

public class IdeaMain extends BaseActivity implements OnClickListener, OnItemSelectedListener {
	private Context context;
	private int parentId = 0;
	private TextView title;
	private ImageView back;
	private ImageView popover;
	private Button saveBtn;
	private Button allViewBtn;
	private Button newMapBtn;
	private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9;
	private String text1, text2, text3, text4, text5, text6, text7, text8, text9;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.idea_main);
		super.loadController();
		super.changeImageMenu(R.drawable.tabbar_home_1_1,
				R.drawable.tabbar_defaultmap_2_2, R.drawable.tabbar_bookmark_1_3, 2);
		context = this;
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			parentId = bundle.getInt("parent_id");
		}

		title = (TextView) findViewById(R.id.idea_main_text);

		back = (ImageView) findViewById(R.id.idea_main_back);
		popover = (ImageView) findViewById(R.id.popup_menu);
		saveBtn = (Button) findViewById(R.id.save_btn); 
		allViewBtn = (Button) findViewById(R.id.all_view_btn); 
		newMapBtn = (Button) findViewById(R.id.idea_main_new_map); 
		newMapBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), IdeaMain.class);
				startActivity(intent);
			}
		});

		back.setOnClickListener(this);
		popover.setOnClickListener(this);
		setOnClick();

		title.setText(getText(R.string.idea_main_title));
		saveBtn.setText(getText(R.string.idea_main_save));
		allViewBtn.setText(getText(R.string.idea_main_all_view));
		newMapBtn.setText(getText(R.string.idea_main_new_map));

		editText1 = (EditText) findViewById(R.id.edittext1);
		editText2 = (EditText) findViewById(R.id.edittext2);
		editText3 = (EditText) findViewById(R.id.edittext3);
		editText4 = (EditText) findViewById(R.id.edittext4);
		editText5 = (EditText) findViewById(R.id.edittext5);
		editText6 = (EditText) findViewById(R.id.edittext6);
		editText7 = (EditText) findViewById(R.id.edittext7);
		editText8 = (EditText) findViewById(R.id.edittext8);
		editText9 = (EditText) findViewById(R.id.edittext9);

		if (parentId != 0) {
			setEditText();
		}
	}

	public void setOnClick() {
		saveBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				saveRecode();
			}
		});
		allViewBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				saveRecode();
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), IdeaAll.class);
				intent.putExtra("parent_id", parentId);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {	
			case R.id.idea_main_back:
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), TopActivity.class);
				startActivity(intent);
				break;
			case R.id.popup_menu:
				PopupMenu menu = new PopupMenu(this);
				menu.setOnItemSelectedListener(this);
				setEachEditText();
				for (int i = 0; i < 9; i++) {
					int num = i + 1;
					int resStringId = getResources().getIdentifier("map" + num, "string", this.getPackageName());
					int resDrowableId = getResources().getIdentifier("map" + num, "drawable", this.getPackageName());
					String word = getEditTextByNum(num);
					menu.add(i, getString(resStringId) + " : " + word).setIcon(getResources().getDrawable(resDrowableId));
				}
				menu.show(v);
				break;
		}
	}

	public void setEditText() {
		CreateDatabase db = new CreateDatabase(this);
		ParentMapDAO parentMapDAO = new ParentMapDAO(db.open());
		Cursor cursor = parentMapDAO.getByParentId(parentId);
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			editText1.setText(cursor.getString(1));
			editText2.setText(cursor.getString(2));
			editText3.setText(cursor.getString(3));
			editText4.setText(cursor.getString(4));
			editText5.setText(cursor.getString(5));
			editText6.setText(cursor.getString(6));
			editText7.setText(cursor.getString(7));
			editText8.setText(cursor.getString(8));
			editText9.setText(cursor.getString(9));
		}
	}

	public void saveRecode() {
		setEachEditText();
		CreateDatabase db = new CreateDatabase(context);
		ParentMapDAO parentMapDAO = new ParentMapDAO(db.open());
		// Insert
		if (parentId == 0) {
			parentMapDAO.insertParentMap(text1, text2, text3, text4, text5, text6, text7, text8, text9);
			parentId = getParentIdByNewRecord();
		}
		// Update
		else {
			parentMapDAO.updateParentMap(parentId, text1, text2, text3, text4, text5, text6, text7, text8, text9);
		}

		ChildMapDAO childMapDAO = new ChildMapDAO(db.open());
		Cursor cursor = childMapDAO.getByParentId(parentId);
			System.out.println("hogeeeeeeee total  " + cursor.getCount());
		int total = cursor.getCount();
		int j = 1;
		cursor.moveToFirst();
		for (int i = 0; i < 9; i++) {
			int position_num = 0;

			if (j <= total) {
				position_num = cursor.getInt(2);
				j = j +1;
			}


			int count = i + 1;
			// record exist
			System.out.println("hogeeeeeeee position_num " + position_num);
			System.out.println("hogeeeeeeee count " + count);
			System.out.println("hogeeeeeeee parentId " + parentId);
			if (count == position_num) {
				cursor.moveToNext();
			}
			// record not exist
			else {
				if (count == 1 && text1.length() > 0) {
			System.out.println("hogeeeeeeee parentId hogeeeeeeeeeeeeeeeeeeee 1 " );
			System.out.println("hogeeeeeeee parentId hogeeeeeeeeeeeeeeeeeeee text1 " + text1);
					childMapDAO.insertChildMap(parentId, count, " ", " ", " ", " ", text1, " ", " ", " ", " ");
				}
				if (count == 2 && text2.length() > 0) {
					childMapDAO.insertChildMap(parentId, count, "", "", "", "", text2, "", "", "", "");
				}
				if (count == 3 && text3.length() > 0) {
					childMapDAO.insertChildMap(parentId, count, "", "", "", "", text3, "", "", "", "");
				}
				if (count == 4 && text4.length() > 0) {
					childMapDAO.insertChildMap(parentId, count, "", "", "", "", text4, "", "", "", "");
				}
				if (count == 5 && text5.length() > 0) {
					childMapDAO.insertChildMap(parentId, count, "", "", "", "", text5, "", "", "", "");
				}
				if (count == 6 && text6.length() > 0) {
					childMapDAO.insertChildMap(parentId, count, "", "", "", "", text6, "", "", "", "");
				}
				if (count == 7 && text7.length() > 0) {
					childMapDAO.insertChildMap(parentId, count, "", "", "", "", text7, "", "", "", "");
				}
				if (count == 8 && text8.length() > 0) {
					childMapDAO.insertChildMap(parentId, count, "", "", "", "", text8, "", "", "", "");
				}
				if (count == 9 && text9.length() > 0) {
					childMapDAO.insertChildMap(parentId, count, "", "", "", "", text9, "", "", "", "");
				}
			}
		}

		db.close();
	}

	public void setEachEditText() {
		text1 = editText1.getText().toString();
		text2 = editText2.getText().toString();
		text3 = editText3.getText().toString();
		text4 = editText4.getText().toString();
		text5 = editText5.getText().toString();
		text6 = editText6.getText().toString();
		text7 = editText7.getText().toString();
		text8 = editText8.getText().toString();
		text9 = editText9.getText().toString();
	}

	public void onItemSelected(MenuItem item) {
		saveRecode();
		int position = item.getItemId() + 1;
		String word = getEditTextByNum(position);
		if (position != 5 && word.length() > 0) {
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), IdeaChild.class);
			intent.putExtra("position", position);	
			//int id = getParentIdByNewRecord();
			intent.putExtra("parent_id", parentId);
			intent.putExtra("word", word);	
			startActivity(intent);
		}
	}

	public int getParentIdByNewRecord() {
		CreateDatabase db = new CreateDatabase(this);
		ParentMapDAO parentMapDAO = new ParentMapDAO(db.open());
		Cursor cursor = parentMapDAO.getNewRecord();
		cursor.moveToFirst();
		int id = cursor.getInt(0);
		db.close();
		return id;
	}

	public String getEditTextByNum(int num) {
		String word = null;
		if (num == 1) {
			word = text1;
		}
		else if (num == 2) {
			word = text2;
		}
		else if (num == 3) {
			word = text3;
		}
		else if (num == 4) {
			word = text4;
		}
		else if (num == 5) {
			word = text5;
		}
		else if (num == 6) {
			word = text6;
		}
		else if (num == 7) {
			word = text7;
		}
		else if (num == 8) {
			word = text8;
		}
		else if (num == 9) {
			word = text9;
		}
		return word;
	}
}
