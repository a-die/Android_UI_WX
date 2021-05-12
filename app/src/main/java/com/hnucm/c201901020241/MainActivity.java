package com.hnucm.c201901020241;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    FindFragment findFragment=new FindFragment();
    MessageFragment messageFragment=new MessageFragment();
    MyFragment myFragment=new MyFragment();
    PersonFragment personFragment=new PersonFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout op1=findViewById(R.id.constraintLayout5);
        ConstraintLayout op2=findViewById(R.id.constraintLayout4);
        ConstraintLayout op3=findViewById(R.id.constraintLayout6);
        ConstraintLayout op4=findViewById(R.id.constraintLayout7);
        getSupportFragmentManager().beginTransaction().replace(R.id.optionFragment,messageFragment).commit();//默认在消息界面
        op1.setSelected(true);
        op2.setSelected(false);
        op3.setSelected(false);
        op4.setSelected(false);
        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.optionFragment,messageFragment).commit();
                op1.setSelected(true);
                op2.setSelected(false);
                op3.setSelected(false);
                op4.setSelected(false);
            }
        });

        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.optionFragment,personFragment).commit();
                op1.setSelected(false);
                op2.setSelected(true);
                op3.setSelected(false);
                op4.setSelected(false);
            }
        });

        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.optionFragment,findFragment).commit();
                op1.setSelected(false);
                op2.setSelected(false);
                op3.setSelected(true);
                op4.setSelected(false);
            }
        });
        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.optionFragment,myFragment).commit();
                op1.setSelected(false);
                op2.setSelected(false);
                op3.setSelected(false);
                op4.setSelected(true);
            }
        });
    }


}