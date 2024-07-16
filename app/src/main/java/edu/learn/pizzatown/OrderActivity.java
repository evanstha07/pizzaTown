package edu.learn.pizzatown;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderActivity extends AppCompatActivity {

    TextView cheeseText, mushroomsText, tomatoText, oliveText, basilText, pineappleText;

    Button backBtn, orderBtn;
   Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);
        cheeseText = findViewById(R.id.textCheese);
        mushroomsText = findViewById(R.id.textMushroom);
        tomatoText = findViewById(R.id.textTomato);
        oliveText = findViewById(R.id.textOlive);
        basilText = findViewById(R.id.textBasil);
        pineappleText = findViewById(R.id.textPineapple);
        backBtn = findViewById(R.id.btnBack);
        orderBtn = findViewById(R.id.btnConfirm);



            renderIngrident();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code here for popup menu.
            }
        });



    }

    void renderIngrident(){
        intent = getIntent();
       boolean isCheese = intent.getBooleanExtra("cheese",false);
        if(isCheese){
            cheeseText.setVisibility(View.VISIBLE);
        }

        boolean isMushrooms = intent.getBooleanExtra("mushroom",false);

        if(isMushrooms){
            mushroomsText.setVisibility(View.VISIBLE);
        }

        boolean isTomato = intent.getBooleanExtra("tomato",false);

        if(isTomato){
            tomatoText.setVisibility(View.VISIBLE);
        }

        boolean isOlive = intent.getBooleanExtra("olive",false);

        if(isOlive){
            oliveText.setVisibility(View.VISIBLE);
        }

        boolean isBasil = intent.getBooleanExtra("basil",false);

        if(isBasil){
            basilText.setVisibility(View.VISIBLE);
        }

        boolean isPineapple = intent.getBooleanExtra("pineapple",false);

        if(isPineapple){
            pineappleText.setVisibility(View.VISIBLE);
        }


    }

}