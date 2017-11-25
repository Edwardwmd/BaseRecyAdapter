package com.wmd.adapter.baserecyadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.wmd.adapter.baserecyadapter.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private RecyclerView recy;
    private List<ContBean> contBeans = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recy = findViewById(R.id.recy);
        adapter = new MyAdapter(this);
        recy.setLayoutManager(new LinearLayoutManager(this));
        recy.setAdapter(adapter);
        addData();

    }

    private void addData() {
        contBeans.add(new ContBean(R.drawable.asparagus, "PA"));
        contBeans.add(new ContBean(R.drawable.asparagus_lettuce, "PB"));
        contBeans.add(new ContBean(R.drawable.beetroot, "PC"));
        contBeans.add(new ContBean(R.drawable.bell_pepper, "PD"));
        contBeans.add(new ContBean(R.drawable.bitter_gourd, "PE"));
        contBeans.add(new ContBean(R.drawable.broccoli, "PF"));
        contBeans.add(new ContBean(R.drawable.cabbage, "PG"));
        contBeans.add(new ContBean(R.drawable.carrot, "PF"));
        adapter.setData(contBeans);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void setOnItemClickListener(int position) {
        Toast.makeText(MainActivity.this, contBeans.get(position).getTextName(), Toast.LENGTH_SHORT).
        show();
    }
}
