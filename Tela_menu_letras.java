package com.example.telainicial_hiper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela_menu_letras extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_tela_menu_letras);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Tela_alfabeto(View view) {
        Intent in = new Intent(Tela_menu_letras.this, TelaAlfabeto.class); startActivity(in);
    }

    public void Tela_voltar_opcoes(View view) {
        Intent in = new Intent(Tela_menu_letras.this, TelaOpcoes.class); startActivity(in);
    }

    public void Tela_Traco_A(View view){
        Intent in= new Intent(Tela_menu_letras.this, Tela_traco_letraA.class); startActivity(in);
    }
}
