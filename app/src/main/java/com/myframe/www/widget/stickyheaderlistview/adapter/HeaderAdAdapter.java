package com.myframe.www.widget.stickyheaderlistview.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.myframe.www.ShowEdittextActivity;

import java.util.List;

import www.wuhai.common.utils.ToastUtils;

/**
 * Created by sunfusheng on 16/4/20.
 */
public class HeaderAdAdapter extends PagerAdapter {

    private Context mContext;
    private List<ImageView> ivList; // ImageView的集合
    private int count = 1; // 广告的数量

    public HeaderAdAdapter(Context context, List<ImageView> ivList) {
        super();
        this.mContext = context;
        this.ivList = ivList;
        if(ivList != null && ivList.size() > 0){
            count = ivList.size();
        }
    }

    @Override
    public int getCount() {
        if (count == 1) {
            return 1;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final int newPosition = position % count;
        // 先移除在添加，更新图片在container中的位置（把iv放至container末尾）
        ImageView iv = ivList.get(newPosition);
        container.removeView(iv);
        container.addView(iv);

        /**
         * 点击图片操作
         */
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(mContext, "点击了" + newPosition);
                ShowEdittextActivity.startActivity(mContext);
            }
        });

        return iv;
    }
}
