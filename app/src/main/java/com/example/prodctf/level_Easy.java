package com.example.prodctf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class level_Easy extends AppCompatActivity {
    private EditText editHint, editFlag;
    private Button btnCheck;
    private Button btnWeb;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_easy);
        editHint = findViewById(R.id.hint);
        editFlag = findViewById(R.id.flag);
        btnCheck = findViewById(R.id.btn_check);
        btnWeb  = findViewById(R.id.btn_web);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(level_Easy.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Silahkan Tunggu!");
        progressDialog.setCancelable(false);

        btnCheck.setOnClickListener(v -> {
            if(editHint.getText().length()>0 && editFlag.getText().length()>0){
                check(editHint.getText().toString(), editFlag.getText().toString());
            }else {
                Toast.makeText(getApplicationContext(), "Oopss sepertinya salah!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Web(View view) {
        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("https://google.com"));
        startActivity(viewIntent);
    }
    private void check(String hint, String flag){
        //Coding login
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(hint, flag).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && task.getResult()!=null){
                    if(task.getResult().getUser()!=null){
                        reload();
                    }else{
                        Toast.makeText(getApplicationContext(), "Check gagal !", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Check gagal !", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });
    }

    private void reload(){
        startActivity(new Intent(getApplicationContext(), main_level.class));
        Toast.makeText(getApplicationContext(), "The Flag is correct! Choose another question", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }



}