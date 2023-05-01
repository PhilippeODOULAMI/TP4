package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.example.tp4.databinding.ActivityLoginBinding;
import com.example.tp4.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {
      private ActivityLoginBinding ui;
      private String username ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
        setTitle(getLocalClassName());
        ui.username.setOnEditorActionListener(this::onEditorAction);
    }
    private boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {


        if (actionId == EditorInfo.IME_ACTION_DONE) {
            username = ui.username.getText().toString();
            int nombre = 1;
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("nombre", nombre);
            startActivity(intent);
            finish();
            return true;
        } else {
            return false;

        }
    }
}