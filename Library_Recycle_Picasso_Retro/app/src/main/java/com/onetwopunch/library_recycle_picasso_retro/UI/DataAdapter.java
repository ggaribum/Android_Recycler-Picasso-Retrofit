package com.onetwopunch.library_recycle_picasso_retro.UI;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.onetwopunch.library_recycle_picasso_retro.R;
import com.onetwopunch.library_recycle_picasso_retro.VO.DataVO;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-07-21.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    ArrayList<DataVO> dataList = new ArrayList<DataVO>();
    Context adapContext;

    public DataAdapter(Context context, ArrayList<DataVO> dataList) {
        this.adapContext =context;
        this.dataList = dataList;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.v("where am i","어뎁터 온크리에이트");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_cardview,parent,false);

        DataViewHolder holder = new DataViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        Log.v("where am i","어뎁터 온바인더");
        holder.tv_cardView1.setText(dataList.get(position).getRank());
        holder.tv_cardView2.setText(dataList.get(position).getName());
        Picasso.with(adapContext).load(dataList.get(position).getUrl()).into(holder.iv_cardView);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    ///////////////////////////////////////////////

    public class DataViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_cardView;
        public TextView tv_cardView1;
        public TextView tv_cardView2;

        public DataViewHolder(View itemView) {
            super(itemView);
            tv_cardView1 =(TextView)itemView.findViewById(R.id.tv_CardView1);
            tv_cardView2 =(TextView)itemView.findViewById(R.id.tv_CardView2);
            iv_cardView =(ImageView) itemView.findViewById(R.id.iv_CardView);

        }
    }
}

