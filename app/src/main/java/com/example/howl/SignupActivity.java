package com.example.howl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    public static final String TAG = "SignupActivity";
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextSignUpPassword;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSignUpPassword = findViewById(R.id.editTextSignupPassword);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Signup On Click!");
                if (!(editTextEmail.getText().toString().contains("@"))) {
                    Toast.makeText(SignupActivity.this, "Incorrect Email Format", Toast.LENGTH_SHORT).show();
                    return;
                }
                String username = getUsernameFromEmail(editTextEmail);
                Log.i(TAG, username);
                String password = editTextSignUpPassword.getText().toString();
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                signUpUser(username,password, name, email);
            }
        });
    }

    private void signUpUser(String username, String password, String name, String email) {
        Log.i(TAG, "Attempting to sign up user " + username + " , " + name);
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.put("name", name);
        user.put("email", email);
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Error with signing up " + username, e);
                    return;
                }
                goMainActivity();
            }
        });
    }

    private String getUsernameFromEmail(EditText editTextEmail) {
        int symbolLocation = editTextEmail.getText().toString().indexOf("@");
        return editTextEmail.getText().toString().substring(0, symbolLocation);
    }

    private void goMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}