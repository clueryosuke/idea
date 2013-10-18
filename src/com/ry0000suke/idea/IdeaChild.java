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

public class IdeaChild extends BaseActivity implements OnClickListener, OnItemSelectedListener {
	private Context context;
	private int parentId;
	private int positionId;
	private String word;
	private TextView title;
	private ImageView back;
	private ImageView popover;
	private Button saveBtn;
	private Button allViewBtn;
	private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9;
	private String text1, text2, text3, text4, text5, text6, text7, text8, text9;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.idea_child);
		super.loadController();
		super.changeImageMenu(R.drawable.tabbar_home_1_1,
				R.drawable.tabbar_defaultmap_2_2, R.drawable.tabbar_bookmark_1_3, 2);
		context = this;

		Bundle bundle = getIntent().getExtras();
		parentId = bundle.getInt("parent_id");
		positionId = bundle.getInt("position");
		word = bundle.getString("word");
		System.out.println("hogeeeeeeeeeeeeeeee parentId " + parentId);
		System.out.println("hogeeeeeeeeeeeeeeee positionId " + positionId);
		System.out.println("hogeeeeeeeeeeeeeeee word " + word);

		title = (TextView) findViewById(R.id.idea_child_text);

		back = (ImageView) findViewById(R.id.idea_child_back);
		popover = (ImageView) findViewById(R.id.popup_menu);
		saveBtn = (Button) findViewById(R.id.save_btn); 
		allViewBtn = (Button) findViewById(R.id.all_view_btn); 

		back.setOnClickListener(this);
		popover.setOnClickListener(this);
		setOnClick();

		title.setText(positionId + ": " + word);
		saveBtn.setText(getText(R.string.idea_child_save));
		allViewBtn.setText(getText(R.string.idea_child_all_view));

		editText1 = (EditText) findViewById(R.id.edittext1);
		editText2 = (EditText) findViewById(R.id.edittext2);
		editText3 = (EditText) findViewById(R.id.edittext3);
		editText4 = (EditText) findViewById(R.id.edittext4);
		editText5 = (EditText) findViewById(R.id.edittext5);
		editText6 = (EditText) findViewById(R.id.edittext6);
		editText7 = (EditText) findViewById(R.id.edittext7);
		editText8 = (EditText) findViewById(R.id.edittext8);
		editText9 = (EditText) findViewById(R.id.edittext9);
		int drawableId = getResources().getIdentifier("map" + positionId, "drawable", this.getPackageName());
		Bitmap bitmapPopover = BitmapFactory.decodeResource(getResources(), drawableId);
		popover.setImageBitmap(bitmapPopover);

		setEditText();
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
			}
		});
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {	
			case R.id.idea_child_back:
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), TopActivity.class);
				startActivity(intent);
				break;
			case R.id.popup_menu:
				PopupMenu menu = new PopupMenu(this);
				menu.setOnItemSelectedListener(this);
				CreateDatabase db = new CreateDatabase(this);
				ParentMapDAO parentMapDAO = new ParentMapDAO(db.open());
				Cursor cursor = parentMapDAO.getByParentId(parentId);
				cursor.moveToFirst();
				for (int i = 0; i < 9; i++) {
					int num = i + 1;
					int resStringId = getResources().getIdentifier("map" + num, "string", this.getPackageName());
					int resDrowableId = getResources().getIdentifier("map" + num, "drawable", this.getPackageName());
					menu.add(i, getString(resStringId) + " : " + cursor.getString(num)).setIcon(getResources().getDrawable(resDrowableId));
				}
					
				db.close();
				menu.show(v);
				break;
		}
	}

	public void setEditText() {
		CreateDatabase db = new CreateDatabase(this);
		ChildMapDAO childMapDAO = new ChildMapDAO(db.open());
		Cursor cursor = childMapDAO.getByParentIdandPositionId(parentId, positionId);
		editText5.setText(word);
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			editText1.setText(cursor.getString(3));
			editText2.setText(cursor.getString(4));
			editText3.setText(cursor.getString(5));
			editText4.setText(cursor.getString(6));
			editText6.setText(cursor.getString(8));
			editText7.setText(cursor.getString(9));
			editText8.setText(cursor.getString(10));
			editText9.setText(cursor.getString(11));
		}
	}

	public void saveRecode() {
		text1 = editText1.getText().toString();
		text2 = editText2.getText().toString();
		text3 = editText3.getText().toString();
		text4 = editText4.getText().toString();
		text5 = editText5.getText().toString();
		text6 = editText6.getText().toString();
		text7 = editText7.getText().toString();
		text8 = editText8.getText().toString();
		text9 = editText9.getText().toString();
		CreateDatabase db = new CreateDatabase(context);
		ChildMapDAO childMapDAO = new ChildMapDAO(db.open());
		// check transaction
		childMapDAO.insertChildMap(parentId, positionId, text1, text2, text3, text4, text5, text6, text7, text8, text9);
		db.close();
	}

	public void onItemSelected(MenuItem item) {
		saveRecode();
		int position = item.getItemId() + 1;
		Intent intent = new Intent();
		if (position == 5) {
			intent.setClass(getApplicationContext(), IdeaMain.class);
			intent.putExtra("parent_id", parentId);
			startActivity(intent);
		}
		else if (position != positionId){
			intent.setClass(getApplicationContext(), IdeaChild.class);
			intent.putExtra("position", position);	
			//int id = getParentIdByNewRecord();
			intent.putExtra("parent_id", parentId);
			String word = getParentEditTextByNum(position);
			intent.putExtra("word", word);
			startActivity(intent);
		}
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
