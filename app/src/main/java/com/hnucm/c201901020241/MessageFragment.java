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


public class MessageFragment extends Fragment {

    List<Chat> list=new ArrayList<>();//动态扩容
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    String name[]={"计科二班","湖南名媛2群","EDEN会员群","有戏推理社","家庭","c碟","计科","微信运动","订阅号消息","a碟"};
    String content[]={"在干嘛","去哪吃","好好学习天天向上","今天打本吗","明天比赛了","天气怎么样","你还在吗","学如逆水行舟","不进则退","找到老人了吗"};
    String time[]={"9:45","8:30","7:40","7:35","昨天11:45","昨天11:25","昨天10:05","昨天8:25","周四17:25","周四11:25"};
    int img[]={R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,R.drawable.b6,R.drawable.b7,R.drawable.b8,R.drawable.b9,R.drawable.b10};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView=getActivity().findViewById(R.id.recyclerView);
        for(int i=0;i<10;i++){
            Chat chat=new Chat();
            chat.setName(name[i]);
            chat.setContent(content[i]);
            chat.setTime(time[i]);
            chat.setImg(img[i]);
            list.add(chat);
        }
        myAdapter=new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_list, parent, false);
            MyViewHolder myViewHolder=new MyViewHolder(view);
            return myViewHolder;
        }
        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.nameTV.setText(list.get(position).getName());
            holder.contentV.setText(list.get(position).getContent());
            holder.timeTV.setText(list.get(position).getTime());
            holder.imageView.setBackground(getResources().getDrawable(list.get(position).getImg()));
        }
        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameTV;
        TextView contentV;
        TextView timeTV;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV=itemView.findViewById(R.id.textView5);
            contentV=itemView.findViewById(R.id.textView6);
            timeTV=itemView.findViewById(R.id.textView7);
            imageView=itemView.findViewById(R.id.imageView5);
        }
    }
}