package com.hanny.loadmore;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, LoadMoreListener {

    private RecyclerViewUpRefresh recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private FragmentOneAdapter fragmentOneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerViewUpRefresh) findViewById(R.id.recyclerview);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiprefreshlayout);
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fragmentOneAdapter = new FragmentOneAdapter(this);
        recyclerView.setAdapter(fragmentOneAdapter);
        fragmentOneAdapter.addItems(initData());
        recyclerView.setCanloadMore(true);
        recyclerView.setLoadMoreListener(this);
    }

    @Override
    public void onRefresh() {

    }
    private List initData(){
        List<String> mList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            mList.add(i + "");
        }
        return mList;
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(swipeRefreshLayout.isRefreshing()){
                    swipeRefreshLayout.setRefreshing(false);
                }
                fragmentOneAdapter.addItems(initData());
                SystemClock.sleep(3);
                recyclerView.loadMoreComplete();
            }
        }, 2000);
    }
}
