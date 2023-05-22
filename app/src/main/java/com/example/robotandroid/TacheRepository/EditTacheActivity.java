package com.example.robotandroid.TacheRepository;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.robotandroid.AbstractActivity;
import com.example.robotandroid.OperationRepository.EditOperationActivity;
import com.example.robotandroid.OperationRepository.Operation;
import com.example.robotandroid.R;

public class EditTacheActivity extends AbstractActivity {
    private Operation operation;
    private Tache tache;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_tache);

        //Déclaration et instanciation des boutons, opération et tache

        //uneoperation = (Operation) getIntent().getSerializableExtra("extraope");
        //tache = (Tache) getIntent().getSerializableExtra("extratache");
        int numOpe = getIntent().getIntExtra("numOpe",-2);
        int numTache = getIntent().getIntExtra("numTache",-2);
        operation = controleur.gammeEnCreation.getListeOperations().get(numOpe);
        tache = operation.getListeTaches().get(numTache);

        //Affichage et edition d'une seule tache.
        RadioButton buttonTurnRight = findViewById(R.id.radioButton_turnRight);
        RadioButton buttonTurnLeft = findViewById(R.id.radioButton_turnLeft);
        RadioButton buttonWait = findViewById(R.id.radioButton_wait);
        RadioButton buttonGrab = findViewById(R.id.radioButton_grab);
        RadioButton buttonDrop = findViewById(R.id.radioButton_drop);

        buttonTurnRight.setChecked(tache.getTypeAction().equals(Tache.TypeAction.TournerDroite));
        buttonTurnLeft.setChecked(tache.getTypeAction().equals(Tache.TypeAction.TournerGauche));
        buttonWait.setChecked(tache.getTypeAction().equals(Tache.TypeAction.Attendre));
        buttonGrab.setChecked(tache.getTypeAction().equals(Tache.TypeAction.Attraper));
        buttonDrop.setChecked(tache.getTypeAction().equals(Tache.TypeAction.Poser));

        ImageButton buttonRetourOpe = findViewById(R.id.imagebutton_retourOpération);
        buttonRetourOpe.setOnClickListener(v -> RetourMenuOpe());
        Button buttonValiderTache = findViewById(R.id.button_validerTache);
        buttonValiderTache.setOnClickListener(v -> ValiderEdition());
    }
    public void RetourMenuOpe()
    {
        Intent menuOpe = new Intent(this, EditOperationActivity.class);

        menuOpe.putExtra("numOpe", controleur.gammeEnCreation.getListeOperations().indexOf(operation));
        startActivity(menuOpe);
        finish();
    }

    //Sauvegarde de la tache
    @SuppressLint("NonConstantResourceId")
    public void ValiderEdition()
    {
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radioButton_turnRight:
                tache.setTypeAction(Tache.TypeAction.TournerDroite);
                break;
            case R.id.radioButton_turnLeft:
                tache.setTypeAction(Tache.TypeAction.TournerGauche);
                break;
            case R.id.radioButton_wait:
                tache.setTypeAction(Tache.TypeAction.Attendre);
                break;
            case R.id.radioButton_grab:
                tache.setTypeAction(Tache.TypeAction.Attraper);
                break;
            case R.id.radioButton_drop:
                tache.setTypeAction(Tache.TypeAction.Poser);
                break;
        }

        RetourMenuOpe();
    }

    @Override
    protected void onStop() {
        //this.ValiderEdition();
        super.onStop();
    }
}