package whu.iss.sric.utils;

import android.content.Context;

import whu.iss.sric.base.CCApplication;

public class DensityUtil {
    private static float scale;

    public static float dip2pxAsFloat(float dpValue) {
        if (scale == 0) {
            scale = CCApplication.getInstance().getResources().getDisplayMetrics().density;
        }
        return (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        return (int) dip2pxAsFloat(dpValue);
    }

    public static float px2dipAsFloat(float pxValue) {
        if (scale == 0) {
            scale = CCApplication.getInstance().getResources().getDisplayMetrics().density;
        }
        return (pxValue / scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
        return (int) px2dipAsFloat(pxValue);
    }

    /**
     * 获得状态栏的高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {

        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusHeight;
    }

    public static float getTreeStoryWidth() {
        return (float) ((WindowUtil.getScreenWidth() - DensityUtil.dip2px(9) * 1.0) / 4.5);
    }

    public static float getTreeStoryHeight() {
        return getTreeStoryWidth() * 16 / 9;
    }

    public static int[] getTreeStorySize() {
        int[] ret = new int[2];
        ret[0] = (int) getTreeStoryWidth();
        ret[1] = (ret[0] * 16 / 9);
        return ret;
    }

}
