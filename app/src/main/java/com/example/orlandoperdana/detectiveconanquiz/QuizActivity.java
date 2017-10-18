package com.example.orlandoperdana.detectiveconanquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class QuizActivity extends AppCompatActivity{
    Button submit;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }

    private void checkQuestionOneAnswers(){
        CheckBox questionOneRan = (CheckBox) findViewById(R.id.checkboxQuestAnswerRan);
        CheckBox questionOneMitsuhiko = (CheckBox) findViewById(R.id.checkboxQuestAnswerMitsuhiko);
        CheckBox questionOneAyumi = (CheckBox) findViewById(R.id.checkboxQuestAnswerAyumi);
        boolean isQuestionOneRanChecked = questionOneRan.isChecked();
        boolean isQuestionOneMitsuhikoChecked = questionOneMitsuhiko.isChecked();
        boolean isQuestionOneAyumiChecked = questionOneAyumi.isChecked();

        if(isQuestionOneMitsuhikoChecked && !isQuestionOneRanChecked && isQuestionOneAyumiChecked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionTwoAnswers(){
        RadioButton radioButtonAgasa = (RadioButton) findViewById(R.id.radio_agasa);
        boolean isQuestionTwoAgasaChecked = radioButtonAgasa.isChecked();
        if (isQuestionTwoAgasaChecked){
            correctAnswers +=1;
        }
    }

    private String getQuestionThreeUserInput(){
        EditText inputUserFullName = (EditText) findViewById(R.id.answerInputUserFullName);
        String name = inputUserFullName.getText().toString();
        return name;
    }

    private void checkQuestionThreeAnswers(){
        String name = getQuestionThreeUserInput();
        if(name.trim().equalsIgnoreCase("shinichi kudo")){
            correctAnswers += 1;
        }
    }

    private void checkQuestionFourAnswers(){
        RadioButton radioButtonAptx = (RadioButton) findViewById(R.id.radio_aptx);
        boolean isQuestionTwoAptxChecked = radioButtonAptx.isChecked();
        if(isQuestionTwoAptxChecked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionFiveAnswers(){
        CheckBox questionFiveVodka = (CheckBox) findViewById(R.id.checkboxQuestVodka);
        CheckBox questionFiveJodie = (CheckBox) findViewById(R.id.checkboxQuestJodie);
        CheckBox questionFiveGin = (CheckBox) findViewById(R.id.checkboxQuestGin);
        boolean isQuestionFiveVodkaChecked = questionFiveVodka.isChecked();
        boolean isQuestionFiveJodieChecked = questionFiveJodie.isChecked();
        boolean isQuestionFiveGinChecked = questionFiveGin.isChecked();

        if(isQuestionFiveVodkaChecked && !isQuestionFiveJodieChecked && isQuestionFiveGinChecked){
            correctAnswers += 1;
        }
    }

    private void checkAllQuestions(){
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswers();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
    }

    private void resetCounterCorrectAnswers(){
        correctAnswers = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener(){
        public void onClick(final View v){
            checkAllQuestions();
            Toast.makeText(QuizActivity.this, "Correct Answers: " + correctAnswers + "/5",
                    Toast.LENGTH_LONG).show();
            resetCounterCorrectAnswers();
        }
    };

    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //pesan keluar
        builder.setMessage("Keluar dari Aplikasi ini?")
                .setCancelable(false)
                //button keluar
                .setPositiveButton("Ya", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        finish();
                        moveTaskToBack(true);
                        System.exit(0);
                    }
                })
                //button batal
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
