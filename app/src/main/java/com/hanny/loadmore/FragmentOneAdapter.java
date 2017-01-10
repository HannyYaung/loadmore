package com.hanny.loadmore;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * zhangyao
 * 16/9/25
 * zhangyao@jiandanxinli.com
 */

public class FragmentOneAdapter extends BaseRecyclerAdapter<String> {

    public FragmentOneAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mLayoutInflater.inflate(R.layout.item_fragment_one, parent, false);
        return new TitleHolder(mContext, view, this);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TitleHolder) holder).bindViewData((String) mDataList.get(position), position);
    }


    class TitleHolder extends RecyclerView.ViewHolder {

        TextView textView;

        FragmentOneAdapter mAdapter;
        private Context mContext;

        public TitleHolder(Context context, View view, FragmentOneAdapter adapter) {
            super(view);
            mAdapter = adapter;
            this.mContext = context;
            textView = (TextView) view.findViewById(R.id.textview);
        }

        public void bindViewData(String bean, int position) {
            textView.setText(bean);
        }
    }
}
