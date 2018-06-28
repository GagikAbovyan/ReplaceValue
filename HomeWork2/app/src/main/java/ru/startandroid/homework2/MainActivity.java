package ru.startandroid.homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textMain;
    private EditText editMain;
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textMain = findViewById(R.id.textMain);
        editMain = findViewById(R.id.editMain);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("KEY", editMain.getText().toString());
                startActivityForResult(intent, 69);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 69){
            if (resultCode == RESULT_OK && data != null){
                Toast.makeText(MainActivity.this,"2", Toast.LENGTH_LONG).show();
                message = data.getStringExtra("MY_KEY");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                textMain.setText(message);
            }
        }
    }

}
