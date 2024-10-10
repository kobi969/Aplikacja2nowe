package com.example.app2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button enable;
    private EditText name;
    private EditText surname;
    private EditText phone;
    private EditText email;
    private EditText password;
    private EditText r_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        
        enable = findViewById(R.id.button);
        name = findViewById(R.id.editTextText);
        surname = findViewById(R.id.editTextText2);
        phone = findViewById(R.id.editTextPhone2);
        email = findViewById(R.id.editTextTextEmailAddress2);
        password = findViewById(R.id.editTextTextPassword);
        r_password = findViewById(R.id.editTextTextPassword2);


        enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_input = name.getText().toString().trim();
                String surname_input = surname.getText().toString().trim();
                String phone_input = phone.getText().toString().trim();
                String email_input = email.getText().toString().trim();
                String password_input = password.getText().toString().trim();
                String r_password_input = r_password.getText().toString().trim();


                if (name_input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Pole imię musi być wypełnione", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (surname_input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Pole nazwisko musi być wypełnione", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (phone_input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Pole telefon musi być wypełnione", Toast.LENGTH_SHORT).show();
                    return;
                } else if (phone_input.length() < 9) {
                    Toast.makeText(MainActivity.this, "Numer telefonu musi zawierać co najmniej 9 cyfr", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (email_input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Pole Email musi być wypełnione", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email_input).matches()) {
                    Toast.makeText(MainActivity.this, "Niepoprawny adres e-mail", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (password_input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Pole Hasło musi być wypełnione", Toast.LENGTH_SHORT).show();
                    return;
                } else if (password_input.length() < 6) {
                    Toast.makeText(MainActivity.this, "Hasło musi mieć co najmniej 6 znaków", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (r_password_input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Pole Powtórzenie hasła musi być wypełnione", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!password_input.equals(r_password_input)) {
                    Toast.makeText(MainActivity.this, "Hasła nie są identyczne", Toast.LENGTH_SHORT).show();
                    return;
                }


                Log.d("Imię:", name_input);
                Log.d("Nazwisko:", surname_input);
                Log.d("Numer telefonu:", phone_input);
                Log.d("E-mail:", email_input);
                Log.d("Hasło:", password_input);
                Log.d("Powtórzenie Hasła:", r_password_input);


            }
        });
    }
}
