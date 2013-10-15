package com.ry0000suke.idea;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

//@SuppressLint("ParserError")
public class BaseActivity extends Activity implements OnClickListener {

	private ImageView menu_bottom1;
	private ImageView menu_bottom2;
	private ImageView menu_bottom3;
	private RelativeLayout rl1;
	private RelativeLayout rl2;
	private RelativeLayout rl3;
	private TextView textMenu1;
	private TextView textMenu2;
	private TextView textMenu3;

	private String ua_id;
	private long value = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		Log.e("Google", "go traker");
	}

	public void loadController() {

		textMenu1 = (TextView) findViewById(R.id.menu_text_1);
		textMenu2 = (TextView) findViewById(R.id.menu_text_2);
		textMenu3 = (TextView) findViewById(R.id.menu_text_3);

		rl1 = (RelativeLayout) findViewById(R.id.menu_layout_1);
		rl2 = (RelativeLayout) findViewById(R.id.menu_layout_2);
		rl3 = (RelativeLayout) findViewById(R.id.menu_layout_3);

		rl1.setOnClickListener(this);
		rl2.setOnClickListener(this);
		rl3.setOnClickListener(this);

		menu_bottom1 = (ImageView) findViewById(R.id.menu_bottom_1);
		menu_bottom2 = (ImageView) findViewById(R.id.menu_bottom_2);
		menu_bottom3 = (ImageView) findViewById(R.id.menu_bottom_3);

		menu_bottom1.setOnClickListener(this);
		menu_bottom2.setOnClickListener(this);
		menu_bottom3.setOnClickListener(this);

		// Check language use flagLan
		//if (dataApplication.getFlagLan("lan").equals("001")) {
			// Japanese
		textMenu1.setText(getText(R.string.menu_top));
		textMenu2.setText(getText(R.string.menu_create));
		textMenu3.setText(getText(R.string.menu_all_view));
		//}
		//else {
		//	// English
		//	textMenu1.setText(getText(R.string.menu_home_en));
		//	textMenu1.setTypeface(Typeface.createFromAsset(getAssets(), "HNU_font.ttf"));
		//	textMenu2.setText(getText(R.string.menu_map_en));
		//	textMenu2.setTypeface(Typeface.createFromAsset(getAssets(), "HNU_font.ttf"));
		//	textMenu3.setText(getText(R.string.menu_bookmark_en));
		//	textMenu3.setTypeface(Typeface.createFromAsset(getAssets(), "HNU_font.ttf"));
		//}

	}

	public void changeImageMenu(int resId1, int resId2, int resId3, int index) {
		menu_bottom1.setBackgroundResource(resId1);
		menu_bottom2.setBackgroundResource(resId2);
		menu_bottom3.setBackgroundResource(resId3);

		if (index == 1) {
			rl1.setBackgroundResource(R.drawable.tabselect);
			rl2.setBackgroundResource(R.drawable.tabbar2);
			rl3.setBackgroundResource(R.drawable.tabbar3);

			textMenu1.setTextColor(getResources().getColor(R.color.white));
			textMenu2.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu3.setTextColor(getResources().getColor(
					R.color.menu_text_color));

		}
		if (index == 2) {
			rl1.setBackgroundResource(R.drawable.tabbar1);
			rl2.setBackgroundResource(R.drawable.tabselect);
			rl3.setBackgroundResource(R.drawable.tabbar3);

			textMenu1.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu2.setTextColor(getResources().getColor(R.color.white));
			textMenu3.setTextColor(getResources().getColor(
					R.color.menu_text_color));
		}
		if (index == 3) {
			rl1.setBackgroundResource(R.drawable.tabbar1);
			rl2.setBackgroundResource(R.drawable.tabbar2);
			rl3.setBackgroundResource(R.drawable.tabselect);

			textMenu1.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu2.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu3.setTextColor(getResources().getColor(R.color.white));
		}
	}

	public void setMenuLayout1() {
		startActivity(new Intent(BaseActivity.this, TopActivity.class));
	}

	public void setMenuLayout2() {
		startActivity(new Intent(BaseActivity.this, IdeaMain.class));
	}

	public void setMenuLayout3() {
		startActivity(new Intent(BaseActivity.this, AllViewActivity.class));

	}

	/* @Override */
	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.menu_layout_1:
			setMenuLayout1();
			break;
		case R.id.menu_layout_2:
			setMenuLayout2();
			break;
		case R.id.menu_layout_3:
			setMenuLayout3();
			break;
		case R.id.menu_bottom_1:
			setMenuLayout1();
			break;
		case R.id.menu_bottom_2:
			setMenuLayout2();
			break;
		case R.id.menu_bottom_3:
			setMenuLayout3();
			break;
		default:

			break;
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
