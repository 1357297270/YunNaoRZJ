package com.dayu.welcome.viewpager;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dayu.MainActivity;
import com.dayu.R;
import com.dayu.app.MyApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2018/9/21.
 */

public class MoguViewPager extends RelativeLayout {
    private MyApp app;
    private MoguViewPagerAdapter mAdapter;
    private ViewPager mViewPager;
    private TransforView mTransforView;
    private List<View> mViewList = new ArrayList<>();
    private int[] mLayouts = new int[]{R.layout.guide_view_one, R.layout.guide_view_two, R.layout.guide_view_three,
            R.layout.guide_view_four};
    private Button button;

    public MoguViewPager(Context context) {
        super(context);
        init();
    }

    public MoguViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.layout_mogu_viewpager, this);

        mViewPager = (ViewPager) this.findViewById(R.id.viewpager);
        mTransforView = (TransforView) this.findViewById(R.id.transfor_view);

        {
            /** 初始化4个页面 */
            for (int i = 0; i < mLayouts.length; i++) {
                View view = View.inflate(getContext(), mLayouts[i], null);
                button = view.findViewById(R.id.btn_start);
                mViewList.add(view);
            }
        }

        mAdapter = new MoguViewPagerAdapter(mViewList, getContext());
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mTransforView.transfor(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(final int position) {
                button.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), position + "ss", Toast.LENGTH_SHORT).show();
                    }
                });
                if (position == 3) {

                    button.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // onClickbtn.onClicBtn();
                            //Toast.makeText(getContext(), "v", Toast.LENGTH_SHORT).show();
                            //安卓巴士

                            app.btn = true;
                           // Log.d("TAG", "tiao");
                                if (MyApp.btn == true) {

                                Intent intent = new Intent(getContext(), MainActivity.class);
                                getContext().startActivity(intent);
                               // Log.d("TAG", "tiao");

                            }


                        }
                    });
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
