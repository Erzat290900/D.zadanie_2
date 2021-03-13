package com.example.dzadanie2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.internal.DescendantOffsetUtils;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private EditText editText2;
    private EditText editText3;
    private TextView textView;
    private Button button;

    String name;

    final static String nameVariableKey = "NAME_VARIABLE";
    static String textViewTexKey = "TEXTVIEW_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.EditText);
        editText2 = (EditText) findViewById(R.id.EditText2);
        editText3 = (EditText) findViewById(R.id.EditText3);
        textView = (TextView) findViewById(R.id.TextView);
        button = (Button) findViewById(R.id.Button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a, b, c, d;
                String S1 = editText.getText().toString();
                String S2 = editText2.getText().toString();
                String S3 = editText3.getText().toString();

                a = Double.parseDouble(S1);
                b = Double.parseDouble(S2);
                c = Double.parseDouble(S3);

                d = a + b + c;
                String S = Double.toString(d);

                textView.setText(S);


            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(nameVariableKey, name);
        TextView textView = (TextView) findViewById(R.id.TextView);
        outState.putString(textViewTexKey, textView.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        name = savedInstanceState.getString(nameVariableKey);
        String textViewTex = savedInstanceState.getString(textViewTexKey);
        TextView textView = (TextView) findViewById(R.id.TextView);
        textView.setText(textViewTex);

    }

    public void saveResult(View view) {
        EditText editText = (EditText) findViewById(R.id.EditText);
        name = editText.getText().toString();
    }

    public void getResult(View view) {

        TextView nameView = (TextView) findViewById(R.id.TextView);
        nameView.setText(name);
    }
}