package com.example.a03exercicio02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputConsumoMedio;
    private EditText inputLitroRestante;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputConsumoMedio = findViewById(R.id.inputConsumoMedio);
        inputLitroRestante = findViewById(R.id.inputLitroRestante);
        tvResultado = findViewById(R.id.tvResultado);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> calculaAltonomia());
    }

    private void calculaAltonomia() {
        float litroRestante = Float.parseFloat(inputLitroRestante.getText().toString());
        float consumoMedio = Float.parseFloat(inputConsumoMedio.getText().toString());
        float autonomia = (litroRestante * consumoMedio)*1000;
        tvResultado.setText(getString(R.string.txt_resultado)+" " + autonomia +"m");
    }
}