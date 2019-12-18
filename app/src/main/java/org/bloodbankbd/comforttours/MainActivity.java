package org.bloodbankbd.comforttours;

import android.content.Intent;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity implements android.support.v7.widget.PopupMenu.OnMenuItemClickListener, PopupMenu.OnMenuItemClickListener {

    ViewFlipper viewFlipper;
    Toolbar toolbar;
    Button contactBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar

        contactBtn =  findViewById(R.id.contactBtn);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Comfort Title");

        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });

        //Notification

        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successful";
                        if (!task.isSuccessful()) {
                            msg = "Faild";
                        }
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });


        int images[] = {R.drawable.sld1, R.drawable.sld2, R.drawable.sld3, R.drawable.sld4};
        //Slider
        viewFlipper = findViewById(R.id.viewflipper);

        for (int image : images) {
            flipperimages(image);
        }



    }

    public void flipperimages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(1800);
        viewFlipper.setAutoStart(true);

        //Annimation

        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    public void showpopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_manu);
        popup.show();

    }

    @Override
    public boolean onMenuItemClick(MenuItem Item) {

        switch (Item.getItemId()) {
            case R.id.australia:
                Intent intent = new Intent(MainActivity.this,Australia.class);
                startActivity(intent);
                return true;
            case R.id.germany:
                Toast.makeText(this,"Germany",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.italy:
                Toast.makeText(this,"Italy",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.france:
                Toast.makeText(this,"France",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.canada:

                return true;
            case R.id.Spain:

                return true;
            case R.id.switzerland:

                return true;
            case R.id.turkey:

                return true;
            case R.id.usa:

                return true;
            case R.id.uk:

                return true;
            case R.id.dubai:

                return true;
            case R.id.egypt:

                return true;
            case R.id.brazil:

                return true;
            case R.id.hongkong:

                return true;
            case R.id.japan:

                return true;
            case R.id.malaysia:

                return true;
            case R.id.maxico:

                return true;
            case R.id.philipine:

                return true;
            case R.id.morocco:

                return true;
            case R.id.russia:

                return true;
            case R.id.singapore:

                return true;
            case R.id.southKoria:

                return true;
            case R.id.thiland:

                return true;

            default:
                return false;
        }

    }


    public void open(View view) {
        Intent browseintent = new Intent(MainActivity.this,AirTikets.class);
        startActivity(browseintent);
    }



}

