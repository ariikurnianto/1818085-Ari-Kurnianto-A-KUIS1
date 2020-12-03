package id.ac.itn.toko;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sbuka, Stutup;
    private EditText Enama, Ebuka, Etutup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sbuka = i.getStringExtra("Ibuka");
        Stutup = i.getStringExtra("Itutup");

        Enama = (EditText) findViewById(R.id.updel_nama);
        Ebuka = (EditText) findViewById(R.id.updel_buka);
        Etutup = (EditText) findViewById(R.id.updel_tutup);

        Enama.setText(Snama);
        Ebuka.setText(Sbuka);
        Etutup.setText(Stutup);

        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sbuka = String.valueOf(Ebuka.getText());
                Stutup = String.valueOf(Etutup.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama toko",
                            Toast.LENGTH_SHORT).show();
                } else if (Sbuka.equals("")){
                    Ebuka.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jam buka",
                            Toast.LENGTH_SHORT).show();
                } else if (Stutup.equals("")){
                    Ebuka.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jam tutup",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateToko(new Toko(Sid, Snama, Sbuka, Stutup));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteToko(new Toko(Sid, Snama, Sbuka, Stutup));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

