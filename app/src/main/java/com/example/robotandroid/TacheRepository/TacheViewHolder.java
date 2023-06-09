package com.example.robotandroid.TacheRepository;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.robotandroid.GammeRepository.Gamme;
import com.example.robotandroid.OperationRepository.EditOperationActivity;
import com.example.robotandroid.OperationRepository.Operation;
import com.example.robotandroid.R;

public class TacheViewHolder extends RecyclerView.ViewHolder {

    private Tache tache;
    private final TextView textViewTypeAction;
    private final Button buttonSuppr;
    private Gamme gamme;
    private Operation operation;

    public TacheViewHolder(View itemView) {
        super(itemView);
        textViewTypeAction = itemView.findViewById(R.id.widget_text_typeAction);
        buttonSuppr = itemView.findViewById(R.id.widget_tache_suppr_button);
    }

    //Pour chaque item tache, on peut uniquement le supprimer
    public void UpdateVisual(Tache tache, Operation operation, Gamme gamme)
    {

        this.operation = operation;
        this.gamme = gamme;
        this.tache = tache;
        buttonSuppr.setOnClickListener(v -> SupprimerTache());
        textViewTypeAction.setText(tache.getTypeAction().toString());
    }

    //On supprime la tache de l'opération et envoie l'opération modifié à l'écran EditOperationActivity.
    public void SupprimerTache(){

        operation.SupprimerTache(this.tache);

        Intent intent = new Intent(textViewTypeAction.getContext(), EditOperationActivity.class);
        intent.putExtra("extragamme",gamme);
        intent.putExtra("numOpe", gamme.getListeOperations().indexOf(operation));
        itemView.getContext().startActivity(intent);
        ((Activity) itemView.getContext()).finish();
    }
}
