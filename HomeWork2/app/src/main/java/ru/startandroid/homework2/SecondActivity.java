package ru.startandroid.homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private EditText editSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editSecond = findViewById(R.id.editSecond);
        String temp = getIntent().getExtras().getString("KEY");
        TextView textView = findViewById(R.id.textSecond);
        textView.setText(temp);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("MY_KEY", editSecond.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
