package com.yoyo.yoappmanage.module.recommend.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoyo.yoappmanage.R;
import com.yoyo.yoappmanage.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * 项目名称：YoAppManage
 * 类描述：推荐
 * 创建人：yoyo
 * 创建时间：2016/6/20 15:42
 * 修改人：yoyo
 * 修改时间：2016/6/20 15:42
 * 修改备注：
 */
public class RecommendFragment  extends BaseFragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public RecommendFragment() {
    }
    public static RecommendFragment newInstance(int sectionNumber) {
        RecommendFragment fragment = new RecommendFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, rootView);
        init();
        return rootView;
    }

    @Override
    protected void init() {

    }
}