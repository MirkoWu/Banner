package com.mirkowu.banner;

import android.support.v4.view.ViewPager.PageTransformer;

import com.mirkowu.banner.transformer.AccordionTransformer;
import com.mirkowu.banner.transformer.BackgroundToForegroundTransformer;
import com.mirkowu.banner.transformer.CubeInTransformer;
import com.mirkowu.banner.transformer.CubeOutTransformer;
import com.mirkowu.banner.transformer.DefaultTransformer;
import com.mirkowu.banner.transformer.DepthPageTransformer;
import com.mirkowu.banner.transformer.FlipHorizontalTransformer;
import com.mirkowu.banner.transformer.FlipVerticalTransformer;
import com.mirkowu.banner.transformer.ForegroundToBackgroundTransformer;
import com.mirkowu.banner.transformer.RotateDownTransformer;
import com.mirkowu.banner.transformer.RotateUpTransformer;
import com.mirkowu.banner.transformer.ScaleInOutTransformer;
import com.mirkowu.banner.transformer.ScaleTransformer;
import com.mirkowu.banner.transformer.StackTransformer;
import com.mirkowu.banner.transformer.TabletTransformer;
import com.mirkowu.banner.transformer.ZoomInTransformer;
import com.mirkowu.banner.transformer.ZoomOutSlideTransformer;
import com.mirkowu.banner.transformer.ZoomOutTranformer;

public class Transformer {
    public static Class<? extends PageTransformer> Default = DefaultTransformer.class;
    public static Class<? extends PageTransformer> Accordion = AccordionTransformer.class;
    public static Class<? extends PageTransformer> BackgroundToForeground = BackgroundToForegroundTransformer.class;
    public static Class<? extends PageTransformer> ForegroundToBackground = ForegroundToBackgroundTransformer.class;
    public static Class<? extends PageTransformer> CubeIn = CubeInTransformer.class;
    public static Class<? extends PageTransformer> CubeOut = CubeOutTransformer.class;
    public static Class<? extends PageTransformer> DepthPage = DepthPageTransformer.class;
    public static Class<? extends PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
    public static Class<? extends PageTransformer> FlipVertical = FlipVerticalTransformer.class;
    public static Class<? extends PageTransformer> RotateDown = RotateDownTransformer.class;
    public static Class<? extends PageTransformer> RotateUp = RotateUpTransformer.class;
    public static Class<? extends PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
    public static Class<? extends PageTransformer> Stack = StackTransformer.class;
    public static Class<? extends PageTransformer> Tablet = TabletTransformer.class;
    public static Class<? extends PageTransformer> ZoomIn = ZoomInTransformer.class;
    public static Class<? extends PageTransformer> ZoomOut = ZoomOutTranformer.class;
    public static Class<? extends PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;
    public static Class<? extends PageTransformer> Scale = ScaleTransformer.class;
}
