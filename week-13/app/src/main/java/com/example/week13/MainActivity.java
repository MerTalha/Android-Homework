package com.example.week13;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.week13.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    LocalDataManager localDataManager;
    String locationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        localDataManager = new LocalDataManager();
        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    localDataManager.setSharedPreference(getApplicationContext(), "name", binding.nameTxt.getText().toString());
                    localDataManager.setSharedPreference(getApplicationContext(), "location", binding.locationTxt.getText().toString());
                    localDataManager.setSharedPreference(getApplicationContext(), "year", binding.yearTxt.getText().toString());
            }
        });
        binding.showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isim = localDataManager.getSharedPreference(getApplicationContext(), "name", "");
                String location = localDataManager.getSharedPreference(getApplicationContext(), "location", "");
                String year = localDataManager.getSharedPreference(getApplicationContext(), "year","");
                String text = isim + " " + location + " " + year;
                binding.infoView.setText(text);
            }
        });
        binding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                localDataManager.clearSharedPreference(getApplicationContext());
                binding.infoView.setText("Lokasyon, isim ve yıl burada gözükür./Başarıyla siilindi.");
            }
        });
    }
}