//package cn.jzvd.demo.lj;
//
//import android.content.pm.ActivityInfo;
//import android.graphics.Paint;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.View;
//import android.widget.TextView;
//
//import com.bumptech.glide.Glide;
//import com.qdgdcm.basemodule.util.ToastUtils;
//import com.qdgdcm.basemodule.util.Util;
//import com.qdgdcm.fsfedu.R;
//import com.qdgdcm.fsfedu.fsdi.component.PMainComponent;
//import com.qdgdcm.fsfedu.fsedu.base.ParentBaseActivity;
//import com.qdgdcm.fsfedu.fsedu.util.IntentUtils;
//import com.qdgdcm.fsfedu.fsedu.view.parent.adapter.PCourseRecommendAdapter;
//import com.qdgdcm.fsfedu.fsedu.view.support.FansiJzvd;
//import com.zhy.autolayout.AutoLinearLayout;
//
//import javax.inject.Inject;
//
//import butterknife.BindView;
//import butterknife.OnClick;
//import cn.jzvd.Jzvd;
//import cn.jzvd.JzvdStd;
//
///**
// * 线上微课详情界面
// * class_name: PMicroClassDetailActivity
// * package_name: com.qdgdcm.fsfedu.FSEDU.view.parent.activity
// * acthor: lucheng
// * time: 2018/8/1 14:25
// */
//public class PMicroClassDetailActivity extends ParentBaseActivity implements FansiJzvd.JZVDCallBack {
//    @BindView(R.id.all_p_class_view)
//    AutoLinearLayout allPClassView;
//    @BindView(R.id.tv_p_login)
//    TextView tvPLogin;
//    @BindView(R.id.rv_p_class)
//    RecyclerView rvPClass;
//    @Inject
//    ToastUtils toastUtils;
//    @Inject
//    PMainComponent pMainComponent;
//    private FansiJzvd fansiJzvd;
//    private PCourseRecommendAdapter mCourseRecommendAdapter;
//    private boolean isVideo = false;
//
//    @Override
//    protected int getContentView() {
//        return R.layout.activity_pmicroclass_detail;
//    }
//
//    @Override
//    protected void initComponent() {
//        pMainComponent = getFsActivityComponent().mainComponent();
//        pMainComponent.inject(this);
//    }
//
//    @Override
//    protected void initView() {
//        Util.setStatusBarTextStyle(this, Util.LIGHT_TEXTCOLOR);
//        fansiJzvd = findViewById(R.id.jzvd_p_fz);
//        mCourseRecommendAdapter = new PCourseRecommendAdapter(this);
//        rvPClass.setAdapter(mCourseRecommendAdapter);
//        rvPClass.setLayoutManager(new LinearLayoutManager(this));
//        rvPClass.setNestedScrollingEnabled(false);
//        rvPClass.setFocusableInTouchMode(false);
//        tvPLogin.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
//        String videoUrl = "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-17_17-33-30.mp4";
//        String mp3 = "http://www.ytmp3.cn/down/53528.mp3";
//        fansiJzvd.setJzvdCallBack(this);
//        //全屏自动横屏
//        Jzvd.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
//        Jzvd.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
//        fansiJzvd.setUp(videoUrl
//                , "", JzvdStd.SCREEN_WINDOW_NORMAL);
//        Glide.with(this).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").into(fansiJzvd.thumbImageView);
//
////        fansiJzvd.setVideo(false);
//    }
//
//    @Override
//    protected void initData() {
//
//    }
//
//    @Override
//    public View getRootView() {
//        return null;
//    }
//
//    @OnClick({R.id.tv_p_hui, R.id.btn_p_buy, R.id.tv_p_review, R.id.tv_p_buy_now})
//    public void onClick(View view) {
//        if (antiShake.check(view.getId())) {
//            return;
//        }
//        switch (view.getId()) {
//            case R.id.iv_p_top_back:
//                finish();
//                break;
//            case R.id.iv_p_share:
//                //TODO 分享
//                break;
//            case R.id.tv_p_hui:
//                // 套餐优惠
//                IntentUtils.toPTaoCanYouHuiActivity(this);
//                break;
//            case R.id.btn_p_buy:
//                // 订单详情
//                IntentUtils.toPOrderDetailActivity(this);
//                break;
//            case R.id.tv_p_review:
//                Log.d("====", "重新试看");
//                allPClassView.setVisibility(View.GONE);
//                fansiJzvd.startVideo();
//                break;
//            case R.id.tv_p_buy_now:
//                Log.d("====", "立即购买");
//                allPClassView.setVisibility(View.GONE);
//                IntentUtils.toPOrderDetailActivity(this);
//                break;
//        }
//    }
//
//
//    @Override
//    public void onBackPressed() {
//        if (Jzvd.backPress()) {
//            return;
//        } else {
//            finish();
//        }
//        super.onBackPressed();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Jzvd.releaseAllVideos();
//
//        //Change these two variables back
//        Jzvd.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_SENSOR;
//        Jzvd.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
//    }
//
//    @Override
//    public void changeUiToComplete() {
//        allPClassView.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    public void changeUiToError() {
//
//    }
//
//    //播放音频则重写jzvd
////    @Override
////    public void changeUiToPlayingShow() {
////        super.changeUiToPlayingShow();
////        thumbImageView.setVisibility(View.VISIBLE);
////
////    }
//}
