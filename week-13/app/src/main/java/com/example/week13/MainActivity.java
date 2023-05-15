package com.example.week13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.week13.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    LocalDataManager localDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        localDataManager = new LocalDataManager();


    }
    Button button = (Button) findViewById(R.id.saveBtn);
    void F_SetData() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.infoView.getText().equals(""))
                    localDataManager.setSharedPreference(getApplicationContext(), "name", binding.infoView.getText().toString());
            }
        });
    }

    /*@OnClick(R.id.showBtn)
    void F_GetData() {
        String isim = localDataManager.getSharedPreference(getApplicationContext(), "name", "");
        Toast.makeText(this, isim, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.deleteBtn)
    void F_ClearData() {
        localDataManager.clearSharedPreference(getApplicationContext());
    }

    @OnClick(R.id.deleteBtn)
    void F_RemoveData() {
        localDataManager.removeSharedPreference(getApplicationContext(), "name");
    }*/
}