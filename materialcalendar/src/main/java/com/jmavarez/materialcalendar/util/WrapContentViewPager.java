package com.jmavarez.materialcalendar.util;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.components.PageSlider;
import ohos.app.Context;

/**
 * { @summary WrapContentViewPager extension of pageSlider
 * }
 */
public class WrapContentViewPager extends PageSlider implements Component.EstimateSizeListener {

    public WrapContentViewPager(Context context) {
        super(context);
        setEstimateSizeListener(this);
    }

    public WrapContentViewPager(Context context, AttrSet attrs) {
        super(context, attrs);
        setEstimateSizeListener(this);
    }

    public WrapContentViewPager(Context context, AttrSet attrSet, String styleName) {
        super(context, attrSet, styleName);
        setEstimateSizeListener(this);
    }

    @Override
    public boolean onEstimateSize(int widthEstimatedSize, int heightEstimatedSize) {
        int count = getChildCount();
        int height = 0;

        for (int i = 0; i < count; i++) {
            Component child = getComponentAt(i);
            child.estimateSize(widthEstimatedSize, EstimateSpec.getSizeWithMode(0, EstimateSpec.UNCONSTRAINT));
            int h = child.getEstimatedHeight();
            if (h > height) {
                height = h;
            }
        }
        setEstimatedSize(widthEstimatedSize, EstimateSpec.getSizeWithMode(height, EstimateSpec.PRECISE));
        return true;
    }
}

