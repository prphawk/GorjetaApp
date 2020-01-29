package com.maymay.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editValor;
    private SeekBar barPorcentagem;
    private TextView textGorjeta, textTotal, textPorcentagem;
    private double porcentagem = 0, valorConta = 0, valorGorjeta = 0, valorTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.TextInputValor);
        textPorcentagem = findViewById(R.id.textViewPorcentagem);
        textTotal = findViewById(R.id.textViewTotal);
        textGorjeta = findViewById(R.id.textViewGorjeta);
        barPorcentagem = findViewById(R.id.seekBarPorcentagem);

        barPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textPorcentagem.setText(progress + "%");
                porcentagem = progress;
                calcularGorjeta();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcularGorjeta(){

        String valor = editValor.getText().toString();
        if(valor.equals("")){

        }else{
            valorConta = Double.parseDouble(valor);
            valorGorjeta = (valorConta * porcentagem) / 100;
            valorTotal = valorConta + valorGorjeta;
            textGorjeta.setText("R$" + String.format("%.2f", valorGorjeta));
            textTotal.setText("R$" + String.format("%.2f", valorTotal));
        }
    }
}
