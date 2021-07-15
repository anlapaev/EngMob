package com.example.eng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {

    private static final String TAG = "SignInActivity";

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputName;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputConfirmPassword;

    private Button loginSignUpButton;
    private TextView toggleLoginSignUpTextView;

    private  boolean isLoginModeActive;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        textInputEmail = findViewById(R.id.textInputEmail);
        textInputName = findViewById(R.id.textInputName);
        textInputPassword = findViewById(R.id.textInputPassword);
        textInputConfirmPassword = findViewById(R.id.textInputConfirmPassword);

        loginSignUpButton = findViewById(R.id.loginSignUpButton);
        toggleLoginSignUpTextView = findViewById(R.id.toggleLoginSignUp);

        auth = FirebaseAuth.getInstance();
    }

    private boolean validateEmail(){
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if(emailInput.isEmpty()){
            textInputEmail.setError("Пожалуйста, введите вашу почту!");
            return false;
        } else{
            textInputEmail.setError("");
            return true;
        }
    }

    private boolean validateName(){
        String nameInput = textInputName.getEditText().getText().toString().trim();

        if(nameInput.isEmpty()){
            textInputName.setError("Пожалуйста, введите ваше имя!");
            return false;
        } else if(nameInput.length() > 15){
            textInputName.setError("Длина имени должна быть меньше 15 символов!");
            return false;
        } else{
            textInputName.setError("");
            return true;
        }
    }

    private boolean validatePassword(){
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();


        if(passwordInput.isEmpty()){
            textInputPassword.setError("Пожалуйста, введите пароль!");
            return false;
        } else if(passwordInput.length() < 7){
            textInputPassword.setError("Длина пароля должна быть больше 6 символов!");
            return false;
        } else{
            textInputPassword.setError("");
            return true;
        }
    }

    private boolean validateConfirmPassword(){
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();
        String confirmPasswordInput = textInputConfirmPassword.getEditText().getText().toString().trim();

        if(!passwordInput.equals(confirmPasswordInput)){
            textInputPassword.setError("Пароли должны соответствовать!");
            return false;
        } else{
            textInputPassword.setError("");
            return true;
        }
    }

    public void loginSignUpUser(View view) {
        if (!validateEmail() | !validateName() | !validatePassword()){
            return;
        }

        if(isLoginModeActive){
            auth.signInWithEmailAndPassword(textInputEmail.getEditText().getText().toString().trim(), textInputPassword.getEditText().getText().toString().trim())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = auth.getCurrentUser();
                                //updateUI(user);
                                Intent intent = new Intent("activity_main_menu");
                                startActivity(new Intent(SignInActivity.this,
                                        activity_main_menu.class));
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(SignInActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }
                        }
                    });
        } else {

            if (!validateEmail() | !validateName() | !validatePassword() | !validateConfirmPassword()){
                return;
            }

            auth.createUserWithEmailAndPassword(textInputEmail.getEditText().getText().toString().trim(), textInputPassword.getEditText().getText().toString().trim())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = auth.getCurrentUser();
                                //updateUI(user);
                                Intent intent = new Intent("activity_main_menu");
                                startActivity(new Intent(SignInActivity.this,
                                        activity_main_menu.class));
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(SignInActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                // updateUI(null);
                            }
                        }
                    });
        }
        }



    public void toggleLoginSignUp(View view) {

        if(isLoginModeActive){
            isLoginModeActive = false;
            loginSignUpButton.setText("Зарегистрироваться");
            toggleLoginSignUpTextView.setText("Или, войди в аккаунт");
            textInputConfirmPassword.setVisibility(View.VISIBLE);
        } else{
            isLoginModeActive = true;
            loginSignUpButton.setText("Войти в аккаунт");
            toggleLoginSignUpTextView.setText("Или, зарегистрируй аккаунт");
            textInputConfirmPassword.setVisibility(View.GONE);
        }
    }
}