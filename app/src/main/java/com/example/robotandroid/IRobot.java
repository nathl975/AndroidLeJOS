package com.example.robotandroid;

import com.example.robotandroid.GammeRepository.Gamme;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public interface IRobot {
    public void creerGamme(Gamme g);

    public void modifierGamme(Gamme g);

    public void supprimerGamme(String idGamme);

    public void executerGamme(String idGamme);

    public HashMap<String, Gamme> recupererGammes();

    public void connecter(String login, String pwd);

    public void deconnecter();

    public void creerCompte(String login, String pwd);

    public void supprimerCompte(String login);

    public HashMap<String, String> recupererLogs();

    public JSONObject recupererStatut();

    void envoyerMessage(String message) throws IOException;

    public void ouvrir(String ip) throws IOException;

    public void fermer();
}
