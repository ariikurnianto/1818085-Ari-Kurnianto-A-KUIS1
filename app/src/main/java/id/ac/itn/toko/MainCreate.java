package id.ac.itn.toko;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Ebuka, Etutup;
    private String Snama, Sbuka, Stutup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ebuka = (EditText) findViewById(R.id.create_buka);
        Etutup = (EditText) findViewById(R.id.create_tutup);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sbuka = String.valueOf(Ebuka.getText());
                Stutup = String.valueOf(Etutup.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama toko",
                            Toast.LENGTH_SHORT).show();
                } else if (Sbuka.equals("")){
                    Ebuka.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jam buka",
                            Toast.LENGTH_SHORT).show();
                } else if (Stutup.equals("")){
                    Etutup.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jam tutup",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Ebuka.setText("");
                    Etutup.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateToko(new Toko(null, Snama, Sbuka, Stutup));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

