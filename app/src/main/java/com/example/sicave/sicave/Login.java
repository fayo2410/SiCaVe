package com.example.sicave.sicave;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn = (Button)findViewById(R.id.entrar);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user=((EditText)findViewById(R.id.user)).getText().toString();
                String pass=((EditText)findViewById(R.id.password)).getText().toString();
                EditText usuario=(EditText)findViewById(R.id.user);
                EditText password=(EditText)findViewById(R.id.password);
                if (user.equals("admin") && pass.equals("123")){
                    Intent nvo=new Intent(Login.this,Menu.class);
                    startActivity(nvo);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
                    usuario.setText("");
                    password.setText("");

                }
            }
        });
    }
}

