package com.example.sicave.sicave;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.impl.client.DefaultHttpClient;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class RegForaneo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_foraneo);
    }
    public void btnreg (View v){
        Thread nt = new Thread(){
            @Override
            public void run(){
                final EditText nombre = (EditText)findViewById(R.id.etnombre);
                final EditText apaterno = (EditText)findViewById(R.id.etpaterno);
                final EditText placa = (EditText)findViewById(R.id.etplaca);
                final EditText cajon = (EditText)findViewById(R.id.etcajon);
                final String res;
                res=regisGet(nombre.getText().toString(),apaterno.getText().toString(),placa.getText().toString(),cajon.getText().toString());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(RegForaneo.this,"Registro exitoso" , Toast.LENGTH_SHORT).show();
                        nombre.setText("");
                        apaterno.setText("");
                        placa.setText("");
                        cajon.setText("");
                    }
                });
            }
        };
        nt.start();
    }
    public String regisGet(String nombre, String apaterno,String placa, String cajon){
        HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        HttpResponse response = null;
        String parametros = "?nombre=" + nombre + "&apaterno=" + apaterno + "&placa=" + placa + "&cajon=" + cajon;
        //HttpGet httpget = new HttpGet("http://192.168.0.7:8080/Sicave/PutData.php" + parametros );
        HttpGet httpget = new HttpGet("http://192.168.43.170:8080/Sicave/PutData.php" + parametros );
        //HttpGet httpget = new HttpGet("http://192.168.137.1:8080/Sicave/PutData.php" + parametros );
        try{
            response= httpClient.execute(httpget,localContext);
        }catch (Exception e){
        }return  response.toString();
    }
}
