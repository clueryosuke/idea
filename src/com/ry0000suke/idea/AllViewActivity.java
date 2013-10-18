package com.ry0000suke.idea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ry0000suke.idea.database.CreateDatabase;
import com.ry0000suke.idea.database.ParentMapDAO;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AllViewActivity extends BaseActivity implements OnClickListener {

	private int count1, count2;
	private int count = 0;

	private int[] sns_store_id;
	private int firstCate_id; // category_id of first category when enter
								// BookMarkActivity
	private int idCateCurrent = -1; // Save id of category current for initial
									// BookMarkActivity after recycled

	private Bitmap[] bitmapCate;
	private Drawable[] dCate;

	private Bitmap[] bitmapIcon_LCO;
	private Drawable[] dIcon_LCO;

	private Bitmap[] bitmapIcon_SNS;
	private Drawable[] dIcon_SNS;

	private ProgressDialog prog;
	public Context context;
	private final static int REQUEST_CODE_BOOKMARK_ACTIVITY = 1;

	private int delete_flg = 0;
	private TextView featureTitleHeader;
	private ImageView featureTitleImage;
	private TextView featureTitleDescription;
	private LinearLayout pastList;
	private LinearLayout listNormalStore;


	private Button deleteEditBtn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.all_view);
		super.loadController();

		super.changeImageMenu(R.drawable.tabbar_home_1_1,
				R.drawable.tabbar_defaultmap_1_2, R.drawable.tabbar_bookmark_2_3, 3);
		context = this;

		TextView title = (TextView) findViewById(R.id.all_view_text);
		deleteEditBtn = (Button) findViewById(R.id.all_view_delete_edit);

		pastList = (LinearLayout) this.findViewById(R.id.all_view_list);

		title.setText(getText(R.string.all_view_title));
		deleteEditBtn.setText(getText(R.string.all_view_delete_edit));
		deleteEditBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (delete_flg == 0) {
					showDeleteList();
					deleteEditBtn.setText(getText(R.string.all_view_delete_done));
					delete_flg = 1;
				}
				else {
					showList();
					deleteEditBtn.setText(getText(R.string.all_view_delete_edit));
					delete_flg = 0;
				}
			
			}
		});

		//
		showList();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);

		//switch (v.getId()) {
		//case R.id.all_view_delete_edit:
		//	break;
		//default:
		//	break;
		//}

	//	idCateCurrent = v.getId();

	//	listLCO_store.removeAllViews();
	//	listSNS_store.removeAllViews();
	//	CreateDatabase db = new CreateDatabase(this);
	//	DataBaseCommon dbCommon = new DataBaseCommon(db.open());
	//	int lco_store = showList1();
	//	db.close();

	}

	public void showList() {
		pastList.removeAllViews();

		// Open database
		CreateDatabase db = new CreateDatabase(this);
		ParentMapDAO parentMapDAO = new ParentMapDAO(db.open());
		Cursor cursor = parentMapDAO.getAllList();

		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			int i = 0;
			do {
				final int parent_id = cursor.getInt(0);
				String theme = cursor.getString(5);

				Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.map5);

				//View view = getLayoutInflater().inflate(R.layout.all_view_list, null);
				final View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.all_view_list, null);

				ImageView avatar = (ImageView) view.findViewById(R.id.all_view_list_image);
				TextView titleText = (TextView) view.findViewById(R.id.all_view_list_title);
				ImageView arrow = (ImageView) view.findViewById(R.id.all_view_list_arrow);

				avatar.setImageBitmap(icon);

				titleText.setText(theme);
				arrow.setBackgroundResource(R.drawable.rightarrow);

				view.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent = new Intent();
						intent.setClass(getApplicationContext(), IdeaMain.class);
						intent.putExtra("parent_id", parent_id);
						startActivity(intent);
					}
				});

				pastList.addView(view);
				i++;

			} while (cursor.moveToNext());

		}
		cursor.close();
		db.close();
	}

	public void showDeleteList() {
		pastList.removeAllViews();

		// Open database
		CreateDatabase db = new CreateDatabase(this);
		ParentMapDAO parentMapDAO = new ParentMapDAO(db.open());
		Cursor cursor = parentMapDAO.getAllList();

		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			int i = 0;
			do {
				final int parent_id = cursor.getInt(0);
				String theme = cursor.getString(5);

				Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.map5);

				//View view = getLayoutInflater().inflate(R.layout.all_view_list, null);
				final View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.all_view_list, null);

				ImageView avatar = (ImageView) view.findViewById(R.id.all_view_list_image);
				TextView titleText = (TextView) view.findViewById(R.id.all_view_list_title);
				ImageView arrow = (ImageView) view.findViewById(R.id.all_view_list_arrow);

				avatar.setImageBitmap(icon);

				titleText.setText(theme);
				arrow.setBackgroundResource(R.drawable.remove);
				arrow.setId(parent_id);

				arrow.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(final View v) {
						AlertDialog.Builder dialog = new AlertDialog.Builder(context);
						dialog.setMessage(getText(R.string.all_view_delete_message))
							.setPositiveButton(getText(R.string.all_view_delete_yes),
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int id) {
				System.out.println("hogeeeeeeeeeeeeeeeeeeeeee gegege   parent_id " + v.getId());
										DeleteCountryDBAsyncTask deleteCountryDBAsyncTask = new DeleteCountryDBAsyncTask(v.getId());
										deleteCountryDBAsyncTask.execute("");
									}
								})
								.setNegativeButton(getText(R.string.all_view_delete_no),
									new DialogInterface.OnClickListener() {
										public void onClick(DialogInterface dialog, int id) {
											dialog.cancel();
										}
									});
							dialog.show();
						}
					});
				//});

				pastList.addView(view);
				i++;

			} while (cursor.moveToNext());

		}
		cursor.close();
		db.close();
	}

	private class DeleteCountryDBAsyncTask extends AsyncTask<String, Void, String> {
		int id;

		public DeleteCountryDBAsyncTask(int id) {
			this.id = id;
		}

		@Override
		protected void onPreExecute() {
			prog = new ProgressDialog(context);
			prog.setMessage(getText(R.string.all_view_delete_time));
			prog.show();

		}

		@Override
		protected String doInBackground(String... params) {
			CreateDatabase db = new CreateDatabase(context);
			System.out.println("hogeeeeee  id " + id);

			ParentMapDAO parentMapDAO = new ParentMapDAO(db.open());
			parentMapDAO.deleteByParentId(id);

			db.close();

			return null;
		}

		@Override
		protected void onPostExecute(String page) {
			showDeleteList();
			prog.dismiss();

		}
	}


	//public void recycleBitmap() {

	//	if (listLCO_store.getChildCount() > 0) {

	//		int temp = listLCO_store.getChildCount();

	//		for (int i = 0; i < temp; i++) {
	//			try {
	//				bitmapIcon_LCO[i].recycle();
	//				System.out.println("---Recycle---BookMarkActivity--LCO---");
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	}

	//	System.out.println("list_SNS_store.getChildCount() = "
	//			+ listSNS_store.getChildCount());

	//	if (listSNS_store.getChildCount() > 0) {

	//		int temp = listSNS_store.getChildCount();

	//		for (int i = 0; i < temp; i++) {
	//			try {

	//				bitmapIcon_SNS[i].recycle();
	//				System.out.println("---Recycle---BookMarkActivity--SNS---");

	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	}

	//}

	//protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	//	super.onActivityResult(requestCode, resultCode, data);
	//	switch (requestCode) {
	//	case REQUEST_CODE_BOOKMARK_ACTIVITY:
	//		if (resultCode == RESULT_OK) {
	//			System.out.println("-----bookmark---first-----");
	//			CreateDatabase db = new CreateDatabase(this);

	//			showCategory(db);

	//			DataBaseCommon dbCommon = new DataBaseCommon(db.open());
	//			View v = new View(this);
	//			if (idCateCurrent != -1) {
	//				v.setId(idCateCurrent);
	//			} else {
	//				v.setId(firstCate_id);
	//			}
	//			System.out.println("v.getID() = " + v.getId());
	//			showList1();

	//			db.close();
	//			System.out.println("-----bookmark---end-----");
	//		}

	//		break;

	//	default:
	//		break;
	//	}
	//}

	//@Override
	//public void onBackPressed() {
	//	recycleBitmap();
	//	all_view_ml.setVisibility(View.GONE);
	//	Intent intent = new Intent();
	//	intent.setClass(getApplicationContext(), TopActivity.class);
	//	startActivity(intent);
	//	finish();
	//	super.onBackPressed();
	//}

	//// -----------BroadcastReceiver-----------------------------------

	//IntentFilter filterDragDrop = new IntentFilter("BookMarkActivity");

	//BroadcastReceiver receiverPathUndo = new BroadcastReceiver() {

	//	@Override
	//	public void onReceive(Context context, Intent intent) {

	//		if (intent.getAction().equals("BookMarkActivity")) {
	//			System.out.println("--------------cuongpm----------------");
	//			recycleBitmap();
	//			listLCO_store.removeAllViewsInLayout();
	//			listSNS_store.removeAllViewsInLayout();
	//			count = 0;
	//			count1 = 0;
	//			count2 = 0;
	//		}

	//	}
	//};

	protected void onDestroy() {
		super.onDestroy();
		//unregisterReceiver(receiverPathUndo);
	};
}
