package com.example.hw9;
import android.support.v7.widget.*;
import android.view.*;
import java.util.*;
import android.widget.*;
import com.bumptech.glide.*;
//继承自 RecyclerView.Adapter

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder> {

    private List<Map<String,Object>> mData;
    private MyAdapter1.OnItemClickListener onItemClickListener;

    public MyAdapter1(List<Map<String,Object>> data) {
        this.mData = data;
    }

    public void updateData(List<Map<String,Object>> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    /**
     * 添加新的Item
     */
   /* public void addNewItem() {
        if (mData == null) {
            mData = new ArrayList<>();
        }
        mData.add(0, "new Item");
        notifyItemInserted(0);
    }
    *//**
     * 删除Item
     *//*
    public void deleteItem() {
        if (mData == null || mData.isEmpty()) {
            return;
        }
        mData.remove(0);
        notifyItemRemoved(0);
    }*/

    /**
     * 设置回调监听
     *
     * @param
     */
    public void setOnItemClickListener(MyAdapter1.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.similat_item, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // 绑定数据
        Glide.with(holder.productImage.getContext()).load(mData.get(position).get("photo").toString()).into(holder.productImage);
        holder.title.setText(mData.get(position).get("title").toString());
      //  holder.zip.setText(mData.get(position).get("zip").toString());
        holder.ship.setText(mData.get(position).get("ship").toString());
      //  holder.condi.setText(mData.get(position).get("condition").toString());
        holder.price.setText(mData.get(position).get("price").toString());
        holder.dayleft.setText(mData.get(position).get("dayleft").toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (onItemClickListener != null) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView, pos);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemClickListener != null) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(holder.itemView, pos);
                }
                //表示此事件已经消费，不会触发单击事件
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView dayleft;
        ImageView productImage;
        TextView ship;
       // TextView condi;
      //  TextView zip;
        TextView price;
        TextView title;
      //  ImageView wishbtn;

        public ViewHolder(View itemView) {
            super(itemView);
            dayleft = (TextView) itemView.findViewById(R.id.dayleft);
            productImage = (ImageView) itemView.findViewById(R.id.similarphoto);
            ship = (TextView) itemView.findViewById(R.id.similarship);
            title = (TextView) itemView.findViewById(R.id.similart);
          //  zip = (TextView) itemView.findViewById(R.id.zip);
            price = (TextView) itemView.findViewById(R.id.similarcost);
          //  wishbtn = (ImageView) itemView.findViewById(R.id.wishbtn);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }
}
