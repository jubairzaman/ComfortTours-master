package org.bloodbankbd.comforttours;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class germany extends AppCompatActivity {
        Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_germany);
        //Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Australia");
    }

    public void click(View view) {
        Intent intent = new Intent( germany.this,ContactActivity.class);
        startActivity(intent);
    }
}
