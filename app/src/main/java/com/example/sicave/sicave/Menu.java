package com.example.sicave.sicave;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class Menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button btn = (Button)findViewById(R.id.local);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Menu.this,RegLocal.class);
                startActivity(i);
            }
        });
        Button btn2 = (Button)findViewById(R.id.foraneo);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f = new Intent(Menu.this, RegForaneo.class);
                startActivity(f);
            }
        });
        Button btn3 = (Button)findViewById(R.id.clocal);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z = new Intent(Menu.this,Consultalocal.class);
                startActivity(z);
            }
        });
        Button btn4 = (Button)findViewById(R.id.reporte);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(Menu.this,Consulta.class);
                startActivity(c);
            }
        });
    }
}
