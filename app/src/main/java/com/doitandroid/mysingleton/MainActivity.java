package com.doitandroid.mysingleton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrayList;
    InitializationOnDemandHolderIdiom singleton = InitializationOnDemandHolderIdiom.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        arrayList = new ArrayList<>();
        Button button;
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i=0; i<10000; i++ ) {
                    String uuid = UUID.randomUUID().toString().replace("-", "");
                    arrayList.add(uuid);
                }

                singleton.object = arrayList;

            }
        });

        Button button2;

        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitializationOnDemandHolderIdiom get_singleton = InitializationOnDemandHolderIdiom.getInstance();
                get_singleton.object = null;
                get_singleton = null;
                if (singleton.object != null){
                    Toast.makeText(getApplicationContext(), singleton.object.get(singleton.object.size() - 1), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "It's null", Toast.LENGTH_SHORT).show();

                }

            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0; i<10000; i++){
                    singleton.userItemArrayList.add(new UserItem("username",
                            "userIDID",
                            "userFullName",
                            "userPhoto",
                            new ArrayList<UserItem>(),
                            new ArrayList<UserItem>(),
                            false,
                            true,
                            true));
                }
            }
        });


    }
}
