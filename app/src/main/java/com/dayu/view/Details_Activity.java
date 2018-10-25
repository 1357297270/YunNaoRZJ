package com.dayu.view;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.dayu.R;
import com.dayu.bean.Details_Bean;
import com.dayu.bean.SetBean;
import com.dayu.bean.SuduBean;
import com.dayu.utils.OkhttpUtils;
import com.dayu.utils.Timeutils;
import com.google.gson.Gson;

import java.util.List;

public class Details_Activity extends AppCompatActivity implements View.OnClickListener {

    public String path;
    public String sudupath = "http://192.168.1.106/yunnao/home/api/getClassReadSpeed";
    public String setpath = "http://192.168.1.106/yunnao/home/api/getClassSetting";
    /**
     * 题目：大家好 字数 0 速度：200字/分钟
     */

    private TextView mBiaoti;
    private TextView mTitle;
    /**
     * 开始阅读
     */
    private Button mStartRead;
    /**
     * 00:00:00
     */
    private Button mTimes;
    /**
     * 阅读速度
     */
    private Button mReadSudu;
    /**
     * 其他设置
     */
    private Button mSetBut;
    /**
     * 返回目录
     */
    private Button mCatalog;
    private Details_Bean details_bean;
    private String content;
    private Timeutils timeutils;
    private boolean followMovie = false;
    //暂停
    private String STOP;
    //开始
    private String START;
    //继续
    private String PUSE;
    private List<SuduBean.ContentBean> content_sudu;
    private List<SetBean.ContentBean> content_set;
    boolean show = true;
    private ScrollView ll_view;
    private String cid;

    public Details_Activity() {

        path = "http://192.168.1.106/yunnao/home/api/getBooksContent?id=11";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);

        Intent intent = getIntent();
        cid = intent.getStringExtra("id");
        Toast.makeText(this, cid+"", Toast.LENGTH_SHORT).show();
        initView();
        timeutils = new Timeutils(mTimes);
        initDatasudu();
        initDataset();
    }

    private void initData() {
        OkhttpUtils getshu = OkhttpUtils.getshu();
        getshu.say(path, new OkhttpUtils.fun1() {

            @Override
            public void onres(String string) {
                Gson gson = new Gson();
                details_bean = gson.fromJson(string, Details_Bean.class);
                content = details_bean.getContent().getContent();

                initDetails();
            }
        });
    }

    private void initDataset() {
        final OkhttpUtils getshu = OkhttpUtils.getshu();
        getshu.say(setpath, new OkhttpUtils.fun1() {


            @Override
            public void onres(String string) {
                Gson gson = new Gson();
                SetBean setBean = gson.fromJson(string, SetBean.class);
                content_set = setBean.getContent();
            }
        });
    }

    private void initDatasudu() {
        OkhttpUtils getshu = OkhttpUtils.getshu();
        getshu.say(sudupath, new OkhttpUtils.fun1() {


            @Override
            public void onres(String string) {
                Gson gson = new Gson();
                SuduBean suduBean = gson.fromJson(string, SuduBean.class);
                content_sudu = suduBean.getContent();

            }
        });
    }

    private void initDetails() {
        final OkhttpUtils getshu = OkhttpUtils.getshu();
        getshu.say(content, new OkhttpUtils.fun1() {
            @Override
            public void onres(String string) {

                mTitle.setText(string);


            }
        });
    }


    private AlertDialog alertDialog2;

    private AlertDialog alertDialog3;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //开始阅读
            case R.id.start_read:

                initData();

               performAnim2();
                //开始计时
                if ("0".equals(START)) {
                    timeutils.startTimer();
                    mStartRead.setBackgroundResource(R.drawable.stop_20181016140909);

                } else if ("1".equals(STOP)) {
                    //暂停计时
                    timeutils.stopTimer();
                } else if ("2".equals(PUSE)) {
                    //继续计时
                    timeutils.puseTimer();
                }


                break;
            //时间
            case R.id.times:
                Toast.makeText(this, "时间", Toast.LENGTH_SHORT).show();

                break;
            //速度
            case R.id.read_sudu:

               /* AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle("\t\t" + "设定你要挑战的阅读速度！");
                builder1.setMessage(content_sudu.get(0).getName());
                builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                builder1.show();
*/
                // 单选提示框
                final String[] items = {"200字/分","400字/分","800字/分","1000字/分","1200字/分"};
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
                alertBuilder.setTitle("设定你要挑战的阅读速度！");
                alertBuilder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int index) {
                        Toast.makeText(Details_Activity.this, items[index], Toast.LENGTH_SHORT).show();
                    }
                });
                alertBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        //TODO 业务逻辑代码

                        // 关闭提示框
                        alertDialog2.dismiss();
                    }
                });
                alertBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO 业务逻辑代码

                        // 关闭提示框
                        alertDialog2.dismiss();
                    }
                });
                alertDialog2 = alertBuilder.create();
                alertDialog2.show();
                /*new AlertDialog.Builder(this).
                        setTitle("\t\t" + "设定你要挑战的阅读速度！").
                        setMessage("\t\t\t" + "200字/分" + "\n\n\t\t\t" + "400字/分" + "\n\n\t\t\t" + "600字/分" + "\n\n\t\t\t" + "800字/分" + "\n\n\t\t\t" + "1000字/分").
                        setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).

                        create().

                        show();*/
                break;
            //设置
            case R.id.set_but:
               /* new AlertDialog.Builder(this).
                        setTitle("\t\t" + "设置背景、字体和文字颜色！").
                        setMessage("\t\t\t" + "文字绿色" + "\t\t\t\t\t" + "Arial(默认)" + "\n\n\n\t\t\t" + "文字红色" + "\t\t\t\t\t" + "行楷字体" + "\n\n\n\t\t\t" + "文字蓝色" + "\t\t\t\t\t" + "切边字体" + "\n\n\n\t\t\t" + "文字黑色" + "\t\t\t\t\t" + "漫画字体").
                        setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).

                        create().

                        show();*/
             /*   AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("\t\t" + "设置背景、字体和文字颜色！");
                builder.setMessage(content_set.get(1).getName());
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                builder.show();*/
                // 多选提示框
                final String[] items1 = {"文字绿色","Arial(默认)","文字红色","行楷字体","文字蓝色","切边字体","文字黑色","漫画字体"};
                AlertDialog.Builder alertBuilder1 = new AlertDialog.Builder(this);
                alertBuilder1.setTitle("设置背景、字体和文字颜色！");
                alertBuilder1.setSingleChoiceItems(items1, 0, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int index) {
                        Toast.makeText(Details_Activity.this, items1[index], Toast.LENGTH_SHORT).show();
                    }
                });
                alertBuilder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        //TODO 业务逻辑代码

                        // 关闭提示框
                        alertDialog2.dismiss();
                    }
                });
                alertBuilder1.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO 业务逻辑代码

                        // 关闭提示框
                        alertDialog2.dismiss();
                    }
                });
                alertDialog3 = alertBuilder1.create();
                alertDialog3.show();
                break;
            //返回
            case R.id.catalog:
                Intent intent = new Intent(Details_Activity.this, ClassRoomActivity.class);
                startActivity(intent);
                finish();

                break;
        }
    }

    private void initView() {
        mBiaoti = (TextView) findViewById(R.id.biaoti);
        mTitle = (TextView) findViewById(R.id.title);
        mStartRead = (Button) findViewById(R.id.start_read);
        mStartRead.setOnClickListener(this);
        mTimes = (Button) findViewById(R.id.times);
        mTimes.setOnClickListener(this);
        mReadSudu = (Button) findViewById(R.id.read_sudu);
        mReadSudu.setOnClickListener(this);
        mSetBut = (Button) findViewById(R.id.set_but);
        mSetBut.setOnClickListener(this);
        mCatalog = (Button) findViewById(R.id.catalog);
        mCatalog.setOnClickListener(this);
        ll_view = findViewById(R.id.ll_view);
    }


    private void performAnim2() {
        //View是否显示的标志

        //属性动画对象
        ValueAnimator va;
        if (show) {
            //显示view，高度从0变到height值
            va = ValueAnimator.ofInt(0, 1200);
        } else {
            //隐藏view，高度从height变为0
            va = ValueAnimator.ofInt(1200, 0);
        }
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //获取当前的height值
                int h = (Integer) valueAnimator.getAnimatedValue();
                //动态更新view的高度
                ll_view.getLayoutParams().height = h;
                ll_view.requestLayout();
            }
        });
        va.setDuration(10000);
        //开始动画
        va.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timeutils = null;
    }
}
