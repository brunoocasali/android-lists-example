package com.brunoocasali.listexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DataIncludeActivity extends Activity {

    public static String PUBLIC_STATIC_STRING_IDENTIFIER = "name";
    private EditText fieldName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_include);
        setTitle("Inclusão de dados!");

        fieldName = (EditText) findViewById(R.id.editText);
    }

    public void add(View view){
        Intent intent = new Intent();

        intent.putExtra(PUBLIC_STATIC_STRING_IDENTIFIER, fieldName.getText().toString());
        setResult(Activity.RESULT_OK, intent);

        finish();
    }
}
