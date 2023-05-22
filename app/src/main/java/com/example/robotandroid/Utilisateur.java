package com.example.robotandroid;

import java.io.Serializable;

public class Utilisateur implements Serializable {
    boolean admin;
    String login;
    String mdp;


    public Utilisateur(String leLogin, String leMdp, boolean a)
    {
        this.admin = a;
        this.login=leLogin;
        this.mdp=leMdp;
    }



    public void setMdp(String pwd)
    {
        this.mdp=pwd;
    }


    public void setLogin(String login)
    {
        this.login=login;
    }

    public String getLogin() {
        return this.login;
    }

    public String getMdp() {
        return this.login;
    }
}
