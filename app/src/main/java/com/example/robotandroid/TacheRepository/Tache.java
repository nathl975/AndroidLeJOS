package com.example.robotandroid.TacheRepository;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Tache implements Serializable {
    private String id;
    private String description;
    private TypeAction typeAction;

    public enum TypeAction {
        @SerializedName("wait")
        Attendre,

        @SerializedName("turnL")
        TournerGauche,
        @SerializedName("turnR")
        TournerDroite,
        @SerializedName("grab")
        Attraper,
        @SerializedName("drop")
        Poser;
    }

    public Tache(String id, String description, TypeAction typeAction)
    {
        this.id = id;
        this.description = description;
        this.typeAction = typeAction;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeAction getTypeAction() {
        return this.typeAction;
    }

    public void setTypeAction(TypeAction typeAction) {
        this.typeAction = typeAction;
    }
}
