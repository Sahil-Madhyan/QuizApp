package com.example.quizapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class JavaQuiz extends AppCompatActivity {

    private TextView questionTV,questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore=0,questionAttempted=0,currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_quiz);
        Objects.requireNonNull(getSupportActionBar()).hide();
        questionTV= findViewById(R.id.idTVQuestion);
        questionNumberTV=findViewById(R.id.idTVQuestionAttempted);
        option1Btn=findViewById(R.id.idBtnOption1);
        option2Btn=findViewById(R.id.idBtnOption2);
        option3Btn=findViewById(R.id.idBtnOption3);
        option4Btn=findViewById(R.id.idBtnOption4);
        quizModelArrayList= new ArrayList<>();
        random=new Random();
        getQuizQuestion(quizModelArrayList);
        currentPos=random.nextInt(quizModelArrayList.size());
        setDatatoViews(currentPos);
        option1Btn.setOnClickListener(v -> {
            if (quizModelArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option1Btn.getText().toString().trim())) {
                currentScore++;
            }
            questionAttempted++;
            currentPos = random.nextInt(quizModelArrayList.size());
            setDatatoViews(currentPos);
        });

        option2Btn.setOnClickListener(v -> {
            if (quizModelArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option2Btn.getText().toString().trim())) {
                currentScore++;
            }
            questionAttempted++;
            currentPos = random.nextInt(quizModelArrayList.size());
            setDatatoViews(currentPos);
        });

        option3Btn.setOnClickListener(v -> {
            if (quizModelArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option3Btn.getText().toString().trim())) {
                currentScore++;
            }
            questionAttempted++;
            currentPos = random.nextInt(quizModelArrayList.size());
            setDatatoViews(currentPos);
        });

        option4Btn.setOnClickListener(v -> {
            if (quizModelArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option4Btn.getText().toString().trim())) {
                currentScore++;
            }
            questionAttempted++;
            currentPos = random.nextInt(quizModelArrayList.size());
            setDatatoViews(currentPos);
        });

    }

    @SuppressLint("SetTextI18n")
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog =new BottomSheetDialog(JavaQuiz.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet, findViewById(R.id.idLLScore));
        TextView scoreTV =bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizBtn= bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is \n"+currentScore+"/5");
        restartQuizBtn.setOnClickListener(v -> {
            currentPos =random.nextInt(quizModelArrayList.size());
            setDatatoViews(currentPos);
            questionAttempted=0;
            currentScore=0;
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }
    @SuppressLint("SetTextI18n")
    private void setDatatoViews(int currentPos){
        questionNumberTV.setText("Questions Attempted : "+questionAttempted+ "/5");
        if(questionAttempted ==5) {
            showBottomSheet();
        }
        else {
            questionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModelArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModelArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModelArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModelArrayList.get(currentPos).getOption4());
        }

    }

    private void getQuizQuestion(ArrayList<QuizModel> quizModelArrayList) {
        quizModelArrayList.add(new QuizModel("Which provides runtime environment for java byte code to be executed","JDK","JVM","JRE","JAVAC","JVM"));
        quizModelArrayList.add(new QuizModel("Which of the following are not java keywords?","double","switch","then","instanceof","then"));
        quizModelArrayList.add(new QuizModel("Java language was originally called as?","Sumatra","J++","Oak","Pine","Oak"));
        quizModelArrayList.add(new QuizModel("Which one is a template for creating different objects?","Array","Class","Interface","Method","Class"));
        quizModelArrayList.add(new QuizModel("Which of the operator is used to allocate memory to array variable in Java?","alloc","malloc","new malloc","new","new"));

    }
}