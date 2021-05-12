package com.hnucm.c201901020241;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FindFragment extends Fragment {
    List<Find> list=new ArrayList<>();//动态扩容
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    String name[]={"朋友圈","视频号","扫一扫","摇一摇","看一看","搜一搜","直播和附近","购物","游戏","小程序"};
    int img[]={R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,R.drawable.d11};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView=getActivity().findViewById(R.id.recyclerView3);
        for(int i=0;i<10;i++){
            Find find=new Find();
            find.setName(name[i]);
            find.setImg(img[i]);
            list.add(find);
        }
        myAdapter=new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.find_list, parent, false);
            MyViewHolder myViewHolder=new MyViewHolder(view);
            return myViewHolder;
        }
        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.nameTV.setText(list.get(position).getName());
            holder.imageView.setBackground(getResources().getDrawable(list.get(position).getImg()));
        }
        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameTV;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV=itemView.findViewById(R.id.textView9);
            imageView=itemView.findViewById(R.id.imageView7);
        }
    }
}