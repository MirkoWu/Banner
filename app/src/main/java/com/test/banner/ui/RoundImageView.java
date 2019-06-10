package com.test.banner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;

public class RoundImageView extends android.support.v7.widget.AppCompatImageView {

    private float mRadius = 20;
    private Bitmap bitmapFrame;

    /*圆角的半径，依次为左上角xy半径，右上角，右下角，左下角*/
    private float[] rids = new float[]{mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius};
    private Paint bitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public RoundImageView(Context context) {
        super(context);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setRoundRadius(float radius) {
        this.mRadius = radius;
        this.rids = new float[]{mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius};
    }

    private Bitmap makeRoundRectFrame(int w, int h) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Path path = new Path();
        path.addRoundRect(new RectF(0, 0, w, h), rids, Path.Direction.CW);
        Paint bitmapPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bitmapPaint.setColor(Color.GREEN); // 颜色随意，不要有透明度。
        c.drawPath(path, bitmapPaint);
        return bm;
    }

    protected void onDraw(Canvas canvas) {
        final int w = getWidth();
        final int h = getHeight();
        Bitmap bitmapOriginal = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bitmapOriginal);
        super.onDraw(c);

        if (bitmapFrame == null) {
            bitmapFrame = makeRoundRectFrame(w, h);
        }

        int sc = canvas.saveLayer(0, 0, w, h, null, Canvas.ALL_SAVE_FLAG);

        canvas.drawBitmap(bitmapFrame, 0, 0, bitmapPaint);
        // 利用Xfermode取交集（利用bitmapFrame作为画框来裁剪bitmapOriginal）
        bitmapPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmapOriginal, 0, 0, bitmapPaint);

        bitmapPaint.setXfermode(null);
        canvas.restoreToCount(sc);
    }
}
