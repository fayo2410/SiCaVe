package com.example.sicave.sicave;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
public class localinexit extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localinexit);
        Bundle bundle = getIntent().getExtras();
        EditText lblMensaje = (EditText) findViewById(R.id.dato);
        lblMensaje.setText(bundle.getString("variable"));
    }
    public void btnentrar (View v){
        Thread nt = new Thread() {
            @Override
            public void run() {
                final EditText id = (EditText) findViewById(R.id.dato);
                final EditText cajon = (EditText) findViewById(R.id.cajon);
                final String res;
                res = regisGet(id.getText().toString(), cajon.getText().toString());
                runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(localinexit.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                                id.setText("");
                                cajon.setText("");
                            }
                        });
                    }
                };
                nt.start();
            }
        public String regisGet(String id, String cajon) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpResponse response = null;
            String parametros = "?id=" + id + "&cajon=" + cajon;
            //HttpGet httpget = new HttpGet("http://192.168.0.7:8080/Sicave/PutData.php" + parametros );
            HttpGet httpget = new HttpGet("http://192.168.43.170:8080/Sicave/PutDataentrada.php" + parametros);
            //HttpGet httpget = new HttpGet("http://192.168.137.1:8080/Sicave/PutDataentrada.php" + parametros);
            try {
                response = httpClient.execute(httpget, localContext);

            } catch (Exception e) {

            }
            return response.toString();
        }
    public void btnsalida (View v){
        Thread nt = new Thread() {
            @Override
            public void run() {
                final EditText id = (EditText) findViewById(R.id.dato);
                final EditText cajon = (EditText) findViewById(R.id.cajon);
                final String res;
                res = regisGet2(id.getText().toString(), cajon.getText().toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(localinexit.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                        id.setText("");
                        cajon.setText("");
                    }
                });
            }
        };
        nt.start();
    }
    public String regisGet2(String id, String cajon) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        HttpResponse response = null;
        String parametros = "?id=" + id + "&cajon=" + cajon;
        //HttpGet httpget = new HttpGet("http://192.168.0.7:8080/Sicave/PutData.php" + parametros );
        HttpGet httpget = new HttpGet("http://192.168.43.170:8080/Sicave/PutDatasalida.php" + parametros);
        //HttpGet httpget = new HttpGet("http://192.168.137.1:8080/Sicave/PutDataentrada.php" + parametros);
        try {
            response = httpClient.execute(httpget, localContext);

        } catch (Exception e) {

        }
        return response.toString();
    }

}
