package com.example.traductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mv;

    private EditText edit1;
    private Button traducir;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        this.edit1=findViewById(R.id.etPalabra);
        this.traducir=findViewById(R.id.btTraducir);
        this.resultado=findViewById(R.id.tvTraduccion);

        mv.getTraduccion().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String resul) {
                resultado.setText(resul);
            }
        });

        this.traducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mv.traducir(edit1.getText().toString());
            }
        });
    }
}