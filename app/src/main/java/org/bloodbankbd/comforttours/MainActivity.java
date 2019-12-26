package org.bloodbankbd.comforttours;

import android.content.Intent;
import android.net.MailTo;
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
                Intent gerint = new Intent(MainActivity.this ,germany.class);
                startActivity(gerint);
                return true;
            case R.id.italy:
                Intent iintent = new Intent( MainActivity.this,Italy.class);
                startActivity(iintent);
                return true;
            case R.id.france:
                Intent fraint = new Intent(MainActivity.this ,france.class);
                startActivity(fraint);
                return true;
            case R.id.canada:
                Intent canint = new Intent(MainActivity.this ,canada.class);
                startActivity(canint);
                return true;
            case R.id.spain:

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
                Intent dubint = new Intent(MainActivity.this,dubai.class);
                startActivity(dubint);
                return true;
            case R.id.egypt:
                Intent egint = new Intent(MainActivity.this,egypt.class);
                startActivity(egint);
                return true;
            case R.id.brazil:
                Intent braint = new Intent(MainActivity.this,brazil.class);
                startActivity(braint);
                return true;
            case R.id.hongkong:
                Intent hongint = new Intent(MainActivity.this,hongkong.class);
                startActivity(hongint);
                return true;
            case R.id.japan:
                Intent japint = new Intent(MainActivity.this,japan.class);
                startActivity(japint);
                return true;
            case R.id.malaysia:
                Intent malint = new Intent(MainActivity.this,malaysia.class);
                startActivity(malint);

                return true;
            case R.id.maxico:

                return true;
            case R.id.phillipine:

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
            case R.id.bhutan:
                Intent bhuint = new Intent(MainActivity.this ,bhutan.class);
                startActivity(bhuint);
                return true;
            case R.id.brunai:
                Intent brunint = new Intent(MainActivity.this , brunai.class);
                startActivity(brunint);
                return true;
            case R.id.cambodia:
                Intent camint = new Intent(MainActivity.this,cambodia.class);
                startActivity(camint);
                return true;
            case R.id.china:
                Intent chiint = new Intent(MainActivity.this,china.class);
                startActivity(chiint);
                return true;
            case R.id.indonesia:
                Intent indint = new Intent(MainActivity.this,indonesia.class);
                startActivity(indint);
                return true;
            case R.id.india:
                Intent indiint = new Intent(MainActivity.this,India.class);
                startActivity(indiint);
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

