package com.example.telainicial_hiper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TelaOpcoes extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private static final String PREFS_NAME = "AudioPrefs";
    private static final String KEY_AUDIO_PLAYED = "audioPlayed"; //ambas sao constantes que definem o nome do arquivo de preferências compartilhadas (SharedPreferences) e a chave usada para armazenar o estado da reprodução do áudio.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_opcoes);

        //inicaliza o mediaplayer com o audio
      mediaPlayer = MediaPlayer.create(this,R.raw.bem_vindo_hiperabc);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Verificar se o áudio já foi reproduzido usando SharedPreferences
        SharedPreferences prefs= getSharedPreferences(PREFS_NAME, MODE_PRIVATE); //instância de SharedPreferences com o nome AudioPrefs.
        boolean audioPlayed = prefs.getBoolean(KEY_AUDIO_PLAYED, false); // Verifica se o áudio já foi reproduzido anteriormente. Se a chave não existir, retorna false.

        //reproduz o audio se ele ainda nao tiver sido reproduzido
        if(!audioPlayed){
           if(mediaPlayer!=null){
               mediaPlayer.start();
               // Marcar que o áudio foi reproduzido
               SharedPreferences.Editor editor = prefs.edit();
               editor.putBoolean(KEY_AUDIO_PLAYED, true);
               editor.apply();
           }
        }
    }
    
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void Tela_menu_letras(View view) {
            Intent in = new Intent(TelaOpcoes.this, Tela_menu_letras.class); startActivity(in); }

    public void Tela_menu_jogos(View view) {
        Intent in = new Intent(TelaOpcoes.this, Tela_menu_jogos.class); startActivity(in);
    }
}
