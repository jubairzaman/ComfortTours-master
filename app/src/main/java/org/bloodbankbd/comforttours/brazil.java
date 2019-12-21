package org.bloodbankbd.comforttours;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class brazil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brazil);
    }

    public void click(View view) {
        Intent intent = new Intent(brazil.this,ContactActivity.class);
        startActivity(intent);
    }
}
