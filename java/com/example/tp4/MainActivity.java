package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tp4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = "TP4";
    private TextView view;
    private ActivityMainBinding ui;
    private int compteur = 0;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
        //view=findViewById(R.id.texte);
        //view.setTexte("Bonjour")
        button = findViewById(R.id.button);
        setTitle(getLocalClassName());
        TP4Application app = (TP4Application) getApplicationContext();
        int compteur = app.getCompteur();
        Log.i(TAG, "dans " + getLocalClassName() + ".onCreate");
        ui.button2.setOnClickListener(btn -> {
            // compteur+=2;?
           // int k = app.getCompteur();
         //   app.setCompteur(++k);
            ui.texte.setText("compteur =" + app.getCompteur());
        });
        ui.button3.setOnClickListener(this::onButton3Click);
        ui.button4.setOnClickListener(this);
        ui.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InfosActivity.class);
                startActivity(intent);

            }
        });
        ui.button6.setOnClickListener(this::onButton6Click);
        ui.button7.setOnClickListener(this::onButton7Click);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        int nombre = intent.getIntExtra("nombre", -1);
        ui.texte.setText("Bonjour" + username);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "dans " + getLocalClassName() + ".onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "dans " + getLocalClassName() + ".onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "dans " + getLocalClassName() + ".onResume");
    }


    public void onButton1Click(View view) {
      compteur+=1;
        ui.texte.setText("compteur="+compteur);
    }


   private void onButton3Click(View view) {
       compteur *= 2;
       ui.texte.setText("compteur =" + compteur);
   }




    @Override
    public void onClick(View view) {
   compteur *=5;
    ui.texte.setText("compteur="+compteur);
    }
   public void onButton6Click(View view) {
        Intent intent = new Intent(MainActivity.this, InfosActivity.class);
        startActivity(intent);
        finish();
    }
    public void onButton7Click(View View){
        String url = "https://perso.univ-rennes1.fr/pierre.nerzic/Android";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }



}