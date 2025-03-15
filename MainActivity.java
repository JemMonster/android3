package com.example.rybakov3;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onNextActivity(View view) {
        EditText etName = findViewById(R.id.etName);
        EditText etAge = findViewById(R.id.etAge);

        String name = etName.getText().toString();
        String ageText = etAge.getText().toString();

        // Проверка на пустые поля
        if (name.isEmpty() || ageText.isEmpty()) {
            Toast.makeText(this, "Please fill in both name and age fields", Toast.LENGTH_SHORT).show();
            return; // Прерываем выполнение метода, если поля пустые
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter a valid age", Toast.LENGTH_SHORT).show();
            return; // Прерываем выполнение метода, если возраст не является числом
        }

        Intent intent = null;

        // Используем if-else вместо switch-case
        int viewId = view.getId();
        if (viewId == R.id.btnLinearLayout) {
            intent = new Intent(this, SecondActivity.class);
        } else if (viewId == R.id.btnRelativeLayout) {
            intent = new Intent(this, ThirdActivity.class);
        } else if (viewId == R.id.btnConstraintLayout) {
            intent = new Intent(this, FourthActivity.class);
        } else if (viewId == R.id.btnFrameLayout) {
            intent = new Intent(this, FifthActivity.class);
        }

        if (intent != null) {
            intent.putExtra("name", name);
            intent.putExtra("age", age);
            startActivity(intent);
        }
    }

    public void onSwitchTheme(View view) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        recreate(); // Перезапуск активности для применения темы
    }
}