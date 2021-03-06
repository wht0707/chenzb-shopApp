package com.example.administrator.myapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapp.R;
import com.example.administrator.myapp.adapter.CategoryRecyclerViewAdapter;
import com.example.administrator.myapp.base.BaseFragment;

/**
 * Created by Administrator on 2017/2/15.
 */

public class CategoryTablayoutFragment extends BaseFragment {

    private static final String PAGE_TAG ="page_tag";
    public static CategoryTablayoutFragment mCategoryTablayoutFragment=null;

    private View view=null;
    private int page;
    private RecyclerView mRecyclerView;

    //初始化
    public static CategoryTablayoutFragment getInstance(int page){

            Bundle bundle=new Bundle();
            bundle.putInt(PAGE_TAG,page);
            mCategoryTablayoutFragment=new CategoryTablayoutFragment();
            mCategoryTablayoutFragment.setArguments(bundle);
            return mCategoryTablayoutFragment;

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
            page = getArguments().getInt(PAGE_TAG);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.category_tablayout_fragment_view,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,4, LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(new CategoryRecyclerViewAdapter(context));
    }
}
