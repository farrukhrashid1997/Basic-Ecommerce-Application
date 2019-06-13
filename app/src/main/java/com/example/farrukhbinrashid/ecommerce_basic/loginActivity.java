package com.example.farrukhbinrashid.ecommerce_basic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    private EditText userId, password;
    private Button loginbtn;
    private String username = "Admin";
    private String passs = "Admin1234";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userId = (EditText)findViewById(R.id.login_edit_text);
        password = (EditText)findViewById(R.id.password_edit_text);
        loginbtn = (Button)findViewById(R.id.login_button);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
    }

    private void userLogin()
    {
     String usern = userId.getText().toString();
     String pass = password.getText().toString();

     if(TextUtils.isEmpty(usern))
     {
         Toast.makeText(this,"Please enter a username",Toast.LENGTH_SHORT).show();
     }
     else if(TextUtils.isEmpty(pass))
     {
         Toast.makeText(this,"Please enter your password",Toast.LENGTH_SHORT).show();
     }
     else
     {
       userLoggedIn(usern,pass);
     }

    }

    private void userLoggedIn(String usern, String pass)
    {
     if(usern.equals(username))
     {
         if(pass.equals(passs))
         {
             Toast.makeText(this, "Logged In Sucessfully", Toast.LENGTH_SHORT).show();
             Intent intent = new Intent(loginActivity.this,HomeActivity.class);
             startActivity(intent);
         }
     }

    }
}
