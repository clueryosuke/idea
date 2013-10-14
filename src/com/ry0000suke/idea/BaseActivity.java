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
	private ImageView menu_bottom4;
	private ImageView menu_bottom5;
	private RelativeLayout rl1;
	private RelativeLayout rl2;
	private RelativeLayout rl3;
	private RelativeLayout rl4;
	private RelativeLayout rl5;
	private TextView textMenu1;
	private TextView textMenu2;
	private TextView textMenu3;
	private TextView textMenu4;
	private TextView textMenu5;

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
		textMenu4 = (TextView) findViewById(R.id.menu_text_4);
		textMenu5 = (TextView) findViewById(R.id.menu_text_5);

		rl1 = (RelativeLayout) findViewById(R.id.menu_layout_1);
		rl2 = (RelativeLayout) findViewById(R.id.menu_layout_2);
		rl3 = (RelativeLayout) findViewById(R.id.menu_layout_3);
		rl4 = (RelativeLayout) findViewById(R.id.menu_layout_4);
		rl5 = (RelativeLayout) findViewById(R.id.menu_layout_5);

		rl1.setOnClickListener(this);
		rl2.setOnClickListener(this);
		rl3.setOnClickListener(this);
		rl4.setOnClickListener(this);
		rl5.setOnClickListener(this);

		menu_bottom1 = (ImageView) findViewById(R.id.menu_bottom_1);
		menu_bottom2 = (ImageView) findViewById(R.id.menu_bottom_2);
		menu_bottom3 = (ImageView) findViewById(R.id.menu_bottom_3);
		menu_bottom4 = (ImageView) findViewById(R.id.menu_bottom_4);
		menu_bottom5 = (ImageView) findViewById(R.id.menu_bottom_5);

		menu_bottom1.setOnClickListener(this);
		menu_bottom2.setOnClickListener(this);
		menu_bottom3.setOnClickListener(this);
		menu_bottom4.setOnClickListener(this);
		menu_bottom5.setOnClickListener(this);

		// Check language use flagLan
		//if (dataApplication.getFlagLan("lan").equals("001")) {
			// Japanese
			textMenu1.setText(getText(R.string.menu_home_jp));
			textMenu2.setText(getText(R.string.menu_map_jp));
			textMenu3.setText(getText(R.string.menu_bookmark_jp));
			textMenu4.setText(getText(R.string.menu_mrt_jp));
			textMenu5.setText(getText(R.string.menu_search_jp));
		//}
		//else {
		//	// English
		//	textMenu1.setText(getText(R.string.menu_home_en));
		//	textMenu1.setTypeface(Typeface.createFromAsset(getAssets(), "HNU_font.ttf"));
		//	textMenu2.setText(getText(R.string.menu_map_en));
		//	textMenu2.setTypeface(Typeface.createFromAsset(getAssets(), "HNU_font.ttf"));
		//	textMenu3.setText(getText(R.string.menu_bookmark_en));
		//	textMenu3.setTypeface(Typeface.createFromAsset(getAssets(), "HNU_font.ttf"));
		//	textMenu4.setText(getText(R.string.menu_mrt_en));
		//	textMenu4.setTypeface(Typeface.createFromAsset(getAssets(), "HNU_font.ttf"));
		//	textMenu5.setText(getText(R.string.menu_search_en));
		//	textMenu5.setTypeface(Typeface.createFromAsset(getAssets(), "HNU_font.ttf"));
		//}

	}

	public void changeImageMenu(int resId1, int resId2, int resId3, int resId4,
			int resId5, int index) {
		System.out.println("hogeeeeeeeeeeeee resId1 " + resId1);
		System.out.println("hogeeeeeeeeeeeee menu_bottom1 " + menu_bottom1);
		System.out.println("hogeeeeeeeeeeeee rl2 " + rl2);


		menu_bottom1.setBackgroundResource(resId1);
		menu_bottom2.setBackgroundResource(resId2);
		menu_bottom3.setBackgroundResource(resId3);
		menu_bottom4.setBackgroundResource(resId4);
		menu_bottom5.setBackgroundResource(resId5);
		//menu_bottom5.setImageResource(R.drawable.tab_search);

		if (index == 1) {
			rl1.setBackgroundResource(R.drawable.tabselect);
			rl2.setBackgroundResource(R.drawable.tabbar2);
			rl3.setBackgroundResource(R.drawable.tabbar3);
			rl4.setBackgroundResource(R.drawable.tabbar4);
			rl5.setBackgroundResource(R.drawable.tabbar5);

			textMenu1.setTextColor(getResources().getColor(R.color.white));
			textMenu2.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu3.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu4.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu5.setTextColor(getResources().getColor(
					R.color.menu_text_color));

		}
		if (index == 2) {
			rl1.setBackgroundResource(R.drawable.tabbar1);
			rl2.setBackgroundResource(R.drawable.tabselect);
			rl3.setBackgroundResource(R.drawable.tabbar3);
			rl4.setBackgroundResource(R.drawable.tabbar4);
			rl5.setBackgroundResource(R.drawable.tabbar5);

			textMenu1.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu2.setTextColor(getResources().getColor(R.color.white));
			textMenu3.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu4.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu5.setTextColor(getResources().getColor(
					R.color.menu_text_color));
		}
		if (index == 3) {
			rl1.setBackgroundResource(R.drawable.tabbar1);
			rl2.setBackgroundResource(R.drawable.tabbar2);
			rl3.setBackgroundResource(R.drawable.tabselect);
			rl4.setBackgroundResource(R.drawable.tabbar4);
			rl5.setBackgroundResource(R.drawable.tabbar5);

			textMenu1.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu2.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu3.setTextColor(getResources().getColor(R.color.white));
			textMenu4.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu5.setTextColor(getResources().getColor(
					R.color.menu_text_color));
		}
		if (index == 4) {
			rl1.setBackgroundResource(R.drawable.tabbar1);
			rl2.setBackgroundResource(R.drawable.tabbar2);
			rl3.setBackgroundResource(R.drawable.tabbar3);
			rl4.setBackgroundResource(R.drawable.tabselect);
			rl5.setBackgroundResource(R.drawable.tabbar5);

			textMenu1.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu2.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu3.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu4.setTextColor(getResources().getColor(R.color.white));
			textMenu5.setTextColor(getResources().getColor(
					R.color.menu_text_color));
		}
		if (index == 5) {
			rl1.setBackgroundResource(R.drawable.tabbar1);
			rl2.setBackgroundResource(R.drawable.tabbar2);
			rl3.setBackgroundResource(R.drawable.tabbar3);
			rl4.setBackgroundResource(R.drawable.tabbar4);
			rl5.setBackgroundResource(R.drawable.tabselect);
			textMenu1.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu2.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu3.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu4.setTextColor(getResources().getColor(
					R.color.menu_text_color));
			textMenu5.setTextColor(getResources().getColor(R.color.white));
		}
	}

	public void setMenuLayout1() {
		//startActivity(new Intent(BaseActivity.this, TopActivity.class));
	}

	public void setMenuLayout2() {
		//startActivity(new Intent(BaseActivity.this, DefaultMapActivity.class));
	}

	public void setMenuLayout3() {
		//startActivity(new Intent(BaseActivity.this, BookMarkActivity.class));

	}

	public void setMenuLayout4() {
		//startActivity(new Intent(BaseActivity.this, GuideMapActivity.class));
	}

	public void setMenuLayout5() {
		//startActivity(new Intent(BaseActivity.this, SearchActivity.class));
	}

	/* @Override */
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
		case R.id.menu_layout_4:
			setMenuLayout4();
			break;
		case R.id.menu_layout_5:
			setMenuLayout5();
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
		case R.id.menu_bottom_4:
			setMenuLayout4();
			break;
		case R.id.menu_bottom_5:
			setMenuLayout5();
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
