package com.wb.baseadapter.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * @author wubo
 * @date 2016/11/23 0023.
 */

public class DividerDecoration extends RecyclerView.ItemDecoration {

    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    int dividerHeight;
    int dividerColor;
    int mOrientation;

    public DividerDecoration(Context context, int orientation, int dividerHeight, @ColorRes int resId) {
        this.dividerHeight = dividerHeight;
        this.dividerColor = context.getResources().getColor(resId);
        mOrientation = orientation;
    }

    public DividerDecoration(Context context, int orientation, @DrawableRes int resId) {
        this(orientation, context.getResources().getDrawable(resId));
    }

    public DividerDecoration(int orientation, Drawable drawable) {
        if (orientation == HORIZONTAL_LIST) {
            dividerHeight = drawable.getIntrinsicWidth();
        } else {
            dividerHeight = drawable.getIntrinsicHeight();
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        int childCount = parent.getAdapter().getItemCount();
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, dividerHeight);
        } else {
            outRect.set(0, 0, dividerHeight, 0);
        }
        if (itemPosition == childCount - 1)
            outRect.set(0, 0, 0, 0);
    }
}
