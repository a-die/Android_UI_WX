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


public class MyFragment extends Fragment {
    List<Find> list=new ArrayList<>();//动态扩容
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    String name[]={"支付","收藏","朋友圈","卡包","表情","设置"};
    int img[]={R.drawable.e2,R.drawable.e3,R.drawable.e4,R.drawable.e5,R.drawable.e6,R.drawable.e7};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView=getActivity().findViewById(R.id.recyclerView4);
        for(int i=0;i<6;i++){
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