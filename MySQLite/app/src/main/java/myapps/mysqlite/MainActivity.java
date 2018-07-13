package myapps.mysqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button button1;
    SOLiteDB sqLiteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        sqLiteDB = new SOLiteDB(this);

        editText1 = findViewById(R.id.edittext1);
        editText2 = findViewById(R.id.edittext2);
        button1 = findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = editText1.getText().toString();
                String pass = editText2.getText().toString();

                try {
                   sqLiteDB.show(name, pass);


                }
                catch (Exception e){

                    Toast.makeText(MainActivity.this, ""+e, Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
