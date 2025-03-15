package com.example.rybakov3;

import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        // Получаем данные из Intent
        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age", 0);

        // Находим TextView и отображаем данные
        TextView tvReceivedData = findViewById(R.id.tvReceivedData);
        tvReceivedData.setText("Name: " + name + ", Age: " + age);
    }

    // Метод для кнопки "Back"
    public void onBack(View view) {
        finish(); // Закрыть активность и вернуться назад
    }
}