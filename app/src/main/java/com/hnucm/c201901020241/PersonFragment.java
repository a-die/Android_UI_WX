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


public class PersonFragment extends Fragment {
    List<Person> list=new ArrayList<>();//动态扩容
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    String name[]={"新的朋友","群聊","标签","公众号","a碟","b碟","c碟","d碟","小红","小明","小绿","小蓝"};
    int img[]={R.drawable.c4,R.drawable.c6,R.drawable.c9,R.drawable.c8,R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c5,R.drawable.c7,R.drawable.c10,R.drawable.c11,R.drawable.c12};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView=getActivity().findViewById(R.id.recyclerView2);
        for(int i=0;i<12;i++){
            Person person=new Person();
            person.setName(name[i]);
            person.setImg(img[i]);
            list.add(person);
        }
        myAdapter=new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.person_list, parent, false);
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
            nameTV=itemView.findViewById(R.id.textView8);
            imageView=itemView.findViewById(R.id.imageView6);
        }
    }
}