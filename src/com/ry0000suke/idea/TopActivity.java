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

public class TopActivity extends BaseActivity implements OnClickListener {
	private Context context;
	private int parentId = 0;
	private TextView app_name;
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
		setContentView(R.layout.top);
		context = this;

		app_name = (TextView) findViewById(R.id.top_app_name);

		newMapBtn = (Button) findViewById(R.id.top_btn); 
		newMapBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), IdeaMain.class);
				startActivity(intent);
			}
		});

		app_name.setText(getText(R.string.top_app_name));
		newMapBtn.setText(getText(R.string.top_start));
	}

}
