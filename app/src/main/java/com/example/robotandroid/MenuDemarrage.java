package com.example.robotandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.StringRes;

import com.example.robotandroid.GammeRepository.Gamme;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuDemarrage extends AbstractActivity {

    //Activity par défaut implémentant l'ensemble des premieres actions : Mode manuel, Mode Panne, Mode Automatique, Connexion et Liste Gamme
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        IRobot robot = new WifiListener();
        Controleur.initControleur(robot);

        super.onCreate(savedInstanceState);

        //On instancie les boutons avec le renvoi vers les fonctions/actions
        setContentView(R.layout.activity_menu_demarrage);
        Button buttonGamme = findViewById(R.id.buttonGamme);
        buttonGamme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMenuGamme();
            }
        });
        Button buttonConnexion = findViewById(R.id.buttonConnect);
        buttonConnexion.setOnClickListener(v -> OpenListeAppareilWifi());

        Button buttonDeconnexion = findViewById(R.id.buttonDisconnect);
        buttonDeconnexion.setVisibility(View.GONE);
        buttonDeconnexion.setOnClickListener(v -> {
            controleur.utilisateurConnecté = null;
            buttonDeconnexion.setVisibility(View.GONE);
            buttonConnexion.setVisibility(View.VISIBLE);
        });


        Button buttonAuto = findViewById(R.id.buttonAuto);
        buttonAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controleur.mode("auto");
            }
        });

        Button buttonPanne = findViewById(R.id.buttonPanne);
        Button buttonRepair = findViewById(R.id.buttonRepair);
        buttonRepair.setVisibility(View.GONE);
        buttonPanne.setOnClickListener(v -> {
            controleur.mode("panne");
            buttonRepair.setVisibility(View.VISIBLE);
            buttonAuto.setEnabled(false);
            buttonGamme.setEnabled(false);
            buttonPanne.setEnabled(false);
        });

        buttonRepair.setOnClickListener(l -> {
            controleur.mode("repa");
            buttonRepair.setVisibility(View.GONE);
            buttonAuto.setEnabled(true);
            buttonGamme.setEnabled(true);
            buttonPanne.setEnabled(true);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (controleur.utilisateurConnecté != null) {
            findViewById(R.id.buttonConnect).setVisibility(View.GONE);
            findViewById(R.id.buttonDisconnect).setVisibility(View.VISIBLE);
        }
    }

    //On génère la liste par défaut du programme, il reste à prendre en charge le chargement d'une liste de gamme sauvegardée.
    public void OpenMenuGamme()
    {
        //TODO : ListeGammeActivity.listeGammes = controleur.recupererGammes();
       Intent menu = new Intent(this, ListGammeActivity.class);
       startActivity(menu);
    }
// On renvoie vers la liste des appareils Wifi .
    public void OpenListeAppareilWifi(){
        Intent listeAppareilWifi = new Intent(this, listeAppareilWifi.class);
        startActivity(listeAppareilWifi);
    }
}