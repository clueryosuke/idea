package com.ry0000suke.idea;

import com.ry0000suke.idea.database.CreateDatabase;
import com.ry0000suke.idea.database.ParentMapDAO;
import com.ry0000suke.idea.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

public class IdeaMain extends BaseActivity implements OnClickListener {
	private Context context;
	private TextView title;
	private ImageView back;
	private Button deleteEditBtn;
	private Button saveBtn;
	private Button allViewBtn;
	private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9;
	private String text1, text2, text3, text4, text5, text6, text7, text8, text9;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.idea_main);
		super.loadController();

		super.changeImageMenu(R.drawable.tabbar_home_1_1,
				R.drawable.tabbar_defaultmap_1_2, R.drawable.tabbar_bookmark_1_3,
				R.drawable.tabbar_mrt_1_4, R.drawable.tabbar_search_2_5, 5);

		context = this;

		title = (TextView) findViewById(R.id.idea_main_text);

		back = (ImageView) findViewById(R.id.idea_main_back);
		deleteEditBtn = (Button) findViewById(R.id.idea_main_delete_edit); 
		saveBtn = (Button) findViewById(R.id.save_btn); 
		allViewBtn = (Button) findViewById(R.id.all_view_btn); 

		back.setOnClickListener(this);

		title.setText(getText(R.string.idea_main_title));
		deleteEditBtn.setText(getText(R.string.idea_main_delete_edit));
		saveBtn.setText(getText(R.string.idea_main_save));

		editText1 = (EditText) findViewById(R.id.edittext1);
		editText2 = (EditText) findViewById(R.id.edittext2);
		editText3 = (EditText) findViewById(R.id.edittext3);
		editText4 = (EditText) findViewById(R.id.edittext4);
		editText5 = (EditText) findViewById(R.id.edittext5);
		editText6 = (EditText) findViewById(R.id.edittext6);
		editText7 = (EditText) findViewById(R.id.edittext7);
		editText8 = (EditText) findViewById(R.id.edittext8);
		editText9 = (EditText) findViewById(R.id.edittext9);
		//editText.setText(getText(R.string.idea_main_theme));
		//editText.selectAll();
		text1 = editText1.getText().toString();
		text2 = editText2.getText().toString();
		text3 = editText3.getText().toString();
		text4 = editText4.getText().toString();
		text5 = editText5.getText().toString();
		text6 = editText6.getText().toString();
		text7 = editText7.getText().toString();
		text8 = editText8.getText().toString();
		text9 = editText9.getText().toString();
		//Toast.makeText(this, text, Toast.LENGTH_LONG);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {	
			case R.id.idea_main_back:
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), TopActivity.class);
				startActivity(intent);
				break;
			case R.id.idea_main_delete_edit:
				break;
			case R.id.save_btn:
				CreateDatabase db = new CreateDatabase(context);
				ParentMapDAO parentMapDAO = new ParentMapDAO(db.open());
				// check transaction
				parentMapDAO.insertParentMap(text1, text2, text3, text4, text5, text6, text7, text8, text9);
				db.close();
				break;
			case R.id.all_view_btn:
				break;
		}
	}
}
