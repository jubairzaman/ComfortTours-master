package org.bloodbankbd.comforttours;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        requestButton = findViewById(R.id.requestButton);


        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        country = findViewById(R.id.country);
        occupation = findViewById(R.id.occupation);


        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                new Thread(new Runnable() {

                    public void run() {

                        try {


                            GMailSender sender = new GMailSender(

                                    "techicsdigital@gmail.com",

                                    "techics1234$");





                            String nameString = " Name : "+name.getText().toString();
                            String emailString = " Email : "+email.getText().toString();
                            String phoneString = " Phone : "+phone.getText().toString();
                            String countryString = " Country : "+country.getText().toString();
                            String occupationString = " occupation : "+occupation.getText().toString();

                            String message = nameString+ emailString+ phoneString+countryString+occupationString;

                            sender.sendMail("Good News form App", message,

                                    "techicsdigital@gmail.com",

                                    "jubair.zaman01@gmail.com");









                        } catch (Exception e) {

                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();



                        }

                    }

                }).start();


                Intent intent = new Intent(ContactActivity.this,MainActivity.class);

                startActivity(intent);




            }
        });
    }
}
