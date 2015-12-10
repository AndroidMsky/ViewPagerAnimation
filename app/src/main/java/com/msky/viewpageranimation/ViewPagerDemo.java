package com.msky.viewpageranimation;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.msky.viewpageranimation.animationlibrary.AccordionTransformer;
import com.msky.viewpageranimation.animationlibrary.BackgroundToForegroundTransformer;
import com.msky.viewpageranimation.animationlibrary.CubeInTransformer;
import com.msky.viewpageranimation.animationlibrary.CubeOutTransformer;
import com.msky.viewpageranimation.animationlibrary.FlipHorizontalTransformer;
import com.msky.viewpageranimation.animationlibrary.FlipVerticalTransformer;
import com.msky.viewpageranimation.animationlibrary.ForegroundToBackgroundTransformer;
import com.msky.viewpageranimation.animationlibrary.RotateDownTransformer;
import com.msky.viewpageranimation.animationlibrary.ScaleInOutTransformer;
import com.msky.viewpageranimation.animationlibrary.StackTransformer;
import com.msky.viewpageranimation.animationlibrary.TabletTransformer;
import com.msky.viewpageranimation.animationlibrary.ZoomInTransformer;
import com.msky.viewpageranimation.animationlibrary.ZoomOutSlideTransformer;
import com.msky.viewpageranimation.animationlibrary.ZoomOutTranformer;


public class ViewPagerDemo extends Activity {

	private View view1, view2, view3;
	private ViewPager viewPager;

	private PagerTabStrip pagerTabStrip;
	private List<View> viewList;
	private List<String> titleList;
	private Button changeButton;

	int a = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_view_pager_demo);
		initView();
	}

	private void initView() {
		viewPager = (ViewPager) findViewById(R.id.viewpager);

		pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagertab);
		pagerTabStrip.setDrawFullUnderline(false);

		pagerTabStrip.setTextSpacing(50);

		view1 = findViewById(R.layout.layout1);
		view2 = findViewById(R.layout.layout2);
		view3 = findViewById(R.layout.layout3);

		LayoutInflater lf = getLayoutInflater().from(this);
		view1 = lf.inflate(R.layout.layout1, null);
		view2 = lf.inflate(R.layout.layout2, null);
		view3 = lf.inflate(R.layout.layout3, null);

		viewList = new ArrayList<View>();
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);

		titleList = new ArrayList<String>();
		titleList.add("1");
		titleList.add("2");
		titleList.add("3");

		PagerAdapter pagerAdapter = new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {

				return arg0 == arg1;
			}

			@Override
			public int getCount() {

				return viewList.size();
			}

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				container.removeView(viewList.get(position));

			}

			@Override
			public int getItemPosition(Object object) {

				return super.getItemPosition(object);
			}

			@Override
			public CharSequence getPageTitle(int position) {

				return titleList.get(position);
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				container.addView(viewList.get(position));
				changeButton = (Button) findViewById(R.id.button1);
				changeButton.setOnClickListener(new OnClickListener() {

					public void onClick(View v) {

						changeButton.setText("当前效果："+a+"  共16种效果");

						a++;
						if (a==17) {
							a=1;
						}

						switch (a) {
						case 1:
							viewPager.setPageTransformer(true,
									new AccordionTransformer());
							break;
						case 2:
							viewPager.setPageTransformer(true,
									new BackgroundToForegroundTransformer());

							break;
						case 3:
							viewPager.setPageTransformer(true,
									new CubeInTransformer());
							break;
						case 4:
							viewPager.setPageTransformer(true,
									new CubeOutTransformer());
							break;
						case 5:
							viewPager.setPageTransformer(true,
									new DepthPageTransformer());
							break;
						case 6:
							viewPager.setPageTransformer(true,
									new FlipHorizontalTransformer());
							break;
						case 7:
							viewPager.setPageTransformer(true,
									new FlipVerticalTransformer());
							break;
						case 8:
							viewPager.setPageTransformer(true,
									new ForegroundToBackgroundTransformer());
							break;
						case 9:
							viewPager.setPageTransformer(true,
									new RotateDownTransformer());
							break;
						case 11:
							viewPager.setPageTransformer(true,
									new ScaleInOutTransformer());
							break;
						case 12:
							viewPager.setPageTransformer(true,
									new StackTransformer());
							break;
						case 13:
							viewPager.setPageTransformer(true,
									new TabletTransformer());
							break;
						case 14:
							viewPager.setPageTransformer(true,
									new ZoomInTransformer());
							break;
						case 15:
							viewPager.setPageTransformer(true,
									new ZoomOutSlideTransformer());
							break;
						case 16:
							viewPager.setPageTransformer(true,
									new ZoomOutTranformer());
							break;

						default:
							break;
						}

					}
				});
				return viewList.get(position);
			}

		};


		viewPager.setPageTransformer(true, new ScaleInOutTransformer());
		viewPager.setAdapter(pagerAdapter);
	}

}
