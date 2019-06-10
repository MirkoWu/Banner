package com.test.banner.loader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mirkowu.banner.loader.ImageLoader;
import com.test.banner.demo.BannerLocalActivity;
import com.test.banner.ui.RoundImageView;


public class GlideRoundImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //具体方法内容自己去选择，次方法是为了减少banner过多的依赖第三方包，所以将这个权限开放给使用者去选择
        Glide.with(context.getApplicationContext())
                .load(path)
                .into(imageView);
    }

    @Override
    public ImageView createImageView(Context context) {
        //圆角
        RoundImageView imageView = new RoundImageView(context);
        imageView.setRoundRadius(BannerLocalActivity.dip2px(context,10));
        return imageView;
    }
}
