package com.test.banner.demo;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;

import com.mirkowu.banner.Banner;
import com.mirkowu.banner.Transformer;
import com.mirkowu.banner.listener.OnBannerListener;
import com.test.banner.R;
import com.test.banner.loader.GlideRoundImageLoader;

import java.util.ArrayList;
import java.util.List;

public class BannerLocalActivity extends AppCompatActivity {

    Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_local);
        initView();
    }

    private void initView() {
        banner = (Banner) findViewById(R.id.banner);
        //本地图片数据（资源文件）
        final List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.b1);
        list.add(R.mipmap.b2);
        list.add(R.mipmap.b3);
        list.add(R.mipmap.b3);

        final List<Integer> list2 = new ArrayList<>();
        list2.add(R.mipmap.b1);
        list2.add(R.mipmap.b3);


        banner.setImages(list)
                .setPageClipToPadding(false)
                .setPageHorPadding(dip2px(this, 30))
                .setPageMargin(dip2px(this, 6))
                .setImageLoader(new GlideRoundImageLoader())
                .setBannerAnimation(Transformer.Scale)
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void onBannerClick(View view, int position) {
                        if (position%2==0) {
                            banner.update(list2);
                        }else {
                            banner.update(list);
                        }
                    }
                })
                .start();
    }

    public static int dip2px(Context context, float dp) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics()) + 0.5);
    }

    @Override
    protected void onResume() {
        super.onResume();
        banner.startAutoPlay();
    }

    @Override
    protected void onPause() {
        super.onPause();
        banner.stopAutoPlay();
    }
}
