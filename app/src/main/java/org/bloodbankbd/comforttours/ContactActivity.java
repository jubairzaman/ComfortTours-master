package org.bloodbankbd.comforttours;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {


    private Button requestButton;
    private EditText name;
    private EditText email;
    private EditText phone;
    private EditText country;
    private EditText occupation;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        //Toolbar
        //Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Australia");


        requestButton = findViewById(R.id.requestButton);

        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {

                    public void run() {

                        try {

                            GMailSender sender = new GMailSender(
                                    "ctourapp@gmail.com",
                                    "CtCt123123");
                            String nameString = "Name: "+name.getText().toString();
                            String emailString = "Email: "+email.getText().toString();
                            String phoneString = "Phone: "+phone.getText().toString();
                            String countryString = "Country: "+country.getText().toString();
                            String occupationString = "occupation: "+occupation.getText().toString();

                            String Message = nameString+ emailString+ phoneString+countryString+occupationString;

                            //sender.addAttachment(Environment.getExternalStorageDirectory().getPath()+"/image.jpg");

                            sender.sendMail("Good News", Message,

                                    "ctourapp@gmail.com",

                                    "jubair.zaman01@gmail.com");


                        } catch (Exception e) {

                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();



                        }

                    }

                }).start();
            }
        });
    }
}
