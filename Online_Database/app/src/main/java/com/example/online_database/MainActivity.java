package com.example.online_database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Model> modelList;
    ApiInterface apiInterface;

    RecyclerView rev;

    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rev=findViewById(R.id.rev_data);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
        rev.setLayoutManager(layoutManager);



        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        apiInterface.getComment().enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response)
            {
                modelList = response.body();
                myAdapter =new MyAdapter(modelList,MainActivity.this);
                rev.setAdapter(myAdapter);
                Log.d("mydata","---> title"+modelList.get(0).getName());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }
}