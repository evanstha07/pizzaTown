package edu.learn.pizzatown;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderActivity extends AppCompatActivity {

    TextView cheeseText, mushroomsText, tomatoText, oliveText, basilText, pineappleText;

    Button backBtn, orderBtn;
    Intent intent;
    Spinner sizeSpinner, quanitySpinner;

    String[] quantity = {"1 pack", "2 packs", "3 packs", "4 people", "5 people"};
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
        sizeSpinner = findViewById(R.id.pizzaType);

        quanitySpinner = findViewById(R.id.quantity);





        renderIngrident();

        ArrayAdapter adapter = new
                ArrayAdapter(OrderActivity.this,
                android.R.layout.simple_spinner_item,
                quantity);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        quanitySpinner.setAdapter(adapter);

        registerForContextMenu(orderBtn);

        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Log.d("items", item);
                Toast.makeText(OrderActivity.this, item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // leave it

            }
        });


        quanitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Log.d("items", item);
                Toast.makeText(OrderActivity.this, item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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

                showPopupMenu(v);

            }
        });



    }

    void showPopupMenu(View v){

        PopupMenu popupMenu = new PopupMenu(OrderActivity.this,v);

        popupMenu.inflate(R.menu.pop_up_menu);
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.popup1:
                        Toast.makeText(OrderActivity.this, "Take away Set", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.popup2:
                        Toast.makeText(OrderActivity.this, "Dine Set", Toast.LENGTH_SHORT).show();
                        return true;

                    default:
                        return false;
                }


            }
        });



    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_first_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.contextmenu1:
                sizeSpinner.setSelection(1);
                quanitySpinner.setSelection(2);
                return true;

            case R.id.contextmenu2:
                sizeSpinner.setSelection(2);
                quanitySpinner.setSelection(3);
                return true;

            case R.id.contextmenu3:
                sizeSpinner.setSelection(1);
                quanitySpinner.setSelection(4);
                return true;

            default:
                return super.onContextItemSelected(item);
        }


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