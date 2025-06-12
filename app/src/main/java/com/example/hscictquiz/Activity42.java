package com.example.hscictquiz;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import soup.neumorphism.NeumorphCardView;

public class Activity42 extends AppCompatActivity {

    private TextView questionText;
    private TextView timerText;
    private TextView resultText;
    private RadioGroup optionsGroup;
    private NeumorphCardView submitButton;
    private ProgressBar progressBar;

    private List<Question> questionList;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int totalQuestions;
    private CountDownTimer countDownTimer;
    private MediaPlayer correctSound;
    private MediaPlayer wrongSound;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_42);

        questionText = findViewById(R.id.questionText);
        timerText = findViewById(R.id.timerText);
        resultText = findViewById(R.id.resultText);
        optionsGroup = findViewById(R.id.optionsGroup);
        submitButton = findViewById(R.id.submitButton);
        progressBar = findViewById(R.id.progressBar);

        // Initialize sounds
        correctSound = MediaPlayer.create(this, R.raw.cute);
        wrongSound = MediaPlayer.create(this, R.raw.error);

        // Initialize questions
        initializeQuestions();

        totalQuestions = questionList.size();
        progressBar.setMax(totalQuestions);

        // Display the first question
        displayQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    @SuppressLint("SuspiciousIndentation")
    private void initializeQuestions() {
        questionList = new ArrayList<>();


        questionList.add(new Question("১. ডেটাবেজ ম্যানেজমেন্টের ধারণা কী?",
                new String[] {"ডেটা ব্যবহার করার পদ্ধতি", "ডেটা রক্ষা করার পদ্ধতি", "ডেটা সংরক্ষণ, সংগঠন ও পরিচালনার পদ্ধতি", "ডেটা এনক্রিপশনের পদ্ধতি"}, 2));

        questionList.add(new Question("২. ডেটাবেজ ম্যানেজমেন্ট সিস্টেম (DBMS) কী?",
                new String[] {"ডেটা বিশ্লেষণের পদ্ধতি", "ডেটা সুরক্ষিত করার পদ্ধতি", "ডেটা পরিচালনা করার সফটওয়্যার", "ডেটা সন্নিবেশ করার পদ্ধতি"}, 2));

        questionList.add(new Question("৩. DBMS এর প্রাথমিক কাজগুলো কী?",
                new String[] {"ডেটা সংরক্ষণ, প্রবাহ ও পুনরুদ্ধার", "ডেটা এনক্রিপশন, ডেটা ম্যানেজমেন্ট", "ডেটা নিরাপত্তা ও ব্যাকআপ", "ডেটা সংরক্ষণের সফটওয়্যার তৈরি করা"}, 0));

        questionList.add(new Question("৪. রিলেশনাল ডেটাবেজ ম্যানেজমেন্ট সিস্টেম (RDBMS) কী?",
                new String[] {"ডেটা রক্ষা করা হয়", "ডেটা আউটপুট প্রদান করা হয়", "ডেটা টেবিল আকারে সংরক্ষণ করা হয়", "ডেটা এক্সপোর্ট করা হয়"}, 2));

        questionList.add(new Question("৫. রিলেশনাল ডেটাবেজ ম্যানেজমেন্ট সিস্টেমের বৈশিষ্ট্য কী?",
                new String[] {"ডেটা টেবিল আকারে সংরক্ষণ, সম্পর্ক সৃষ্টি", "ডেটা একত্রিত ও সংরক্ষণ করা", "ডেটা রিলেশন তৈরি করা", "ডেটা ইন্ডেক্সিং ও এনক্রিপশন"}, 0));

        questionList.add(new Question("৬. রিলেশনাল ডেটাবেজ ম্যানেজমেন্ট সিস্টেমের ব্যবহার কী?",
                new String[] {"ডেটা এক্সপোর্ট করা", "ডেটা সংগ্রহ ও সংরক্ষণ", "ডেটা ব্যবস্থাপনা, কুয়েরি তৈরি, রিপোর্ট তৈরির জন্য", "ডেটা বিশ্লেষণ, ডেটা সুরক্ষা"}, 2));

        questionList.add(new Question("৭. ডেটাবেজ তৈরি করার জন্য কোন পদক্ষেপ নিতে হয়?",
                new String[] {"টেবিল সাজানো, কুয়েরি তৈরি", "স্কিমা ডিজাইন, টেবিল তৈরি", "কোড লেখা, ফাংশন তৈরি", "ডেটাবেজ ইন্ডেক্সিং, প্রোগ্রামিং"}, 1));

        questionList.add(new Question("৮. কুয়েরি কী?",
                new String[] {"ডেটা এক্সপোর্ট ফাইল", "ডেটা সংরক্ষণ পদ্ধতি", "ডেটাবেজ থেকে তথ্য অনুসন্ধানের ভাষা", "ডেটা টেবিলের একটি অংশ"}, 2));

        questionList.add(new Question("৯. ডেটাবেজ সাজানোর জন্য কোন পদক্ষেপ প্রযোজ্য?",
                new String[] {"ডেটাবেজ তৈরি করা", "ফাংশন তৈরি করা", "টেবিল তৈরি ও কুয়েরি সাজানো", "ডেটা ইন্ডেক্সিং ও এনক্রিপশন"}, 2));

        questionList.add(new Question("১০. ডেটাবেজ ইন্ডেক্স করার কাজ কী?",
                new String[] {"ডেটা বিশ্লেষণ করা", "ডেটা ইমপোর্ট করা", "তথ্য দ্রুত খোঁজার জন্য ডেটাবেজে ইন্ডেক্স তৈরি করা", "ডেটা সংরক্ষণ করা"}, 2));

        questionList.add(new Question("১১. ডেটাবেজ রিলেশন কী?",
                new String[] {"ডেটা সুরক্ষার পদ্ধতি", "টেবিলগুলির মধ্যে সম্পর্ক", "তথ্য পুনরুদ্ধার পদ্ধতি", "ডেটা সংরক্ষণের পদ্ধতি"}, 1));

        questionList.add(new Question("১২. কর্পোরেট ডেটাবেজের ব্যবহার কী?",
                new String[] {"বিভিন্ন ছোট প্রতিষ্ঠানগুলির ডেটাবেজ পরিচালনা", "ব্যক্তিগত ডেটাবেজ পরিচালনা", "বড় প্রতিষ্ঠানগুলোর ডেটা পরিচালনা", "সরকারি প্রতিষ্ঠানের ডেটাবেজ পরিচালনা"}, 2));

        questionList.add(new Question("১৩. সরকারি প্রতিষ্ঠানে ডেটাবেজের ব্যবহার কী?",
                new String[] {"ব্যবহারকারীর ডেটা নিরাপত্তা", "সরকারি কার্যক্রমের তথ্য সংগ্রহ ও পরিচালনা", "ডেটা এনক্রিপশন", "ব্যক্তিগত তথ্য সংরক্ষণ"}, 1));

        questionList.add(new Question("১৪. ডেটা সিকিউরিটি কী?",
                new String[] {"ডেটা বিশ্লেষণ পদ্ধতি", "ডেটা সুরক্ষার পদ্ধতি", "ডেটা এক্সপোর্ট করার পদ্ধতি", "ডেটার নিরাপত্তা নিশ্চিত করার পদ্ধতি"}, 3));

        questionList.add(new Question("১৫. ডেটা এনক্রিপশন কী?",
                new String[] {"ডেটা আউটপুট প্রদর্শন করা", "ডেটা সুরক্ষিত রাখা", "ডেটা রিলেশন তৈরি করা", "ডেটাকে নিরাপদ করার জন্য এনক্রিপ্ট করা"}, 3));

        questionList.add(new Question("১৬. DBMS কি ধরনের ডেটাবেজ ব্যবস্থাপনা করে?",
                new String[] {"রিলেশনাল", "নন-রিলেশনাল", "অবজেক্ট-রিলেশনাল", "হায়ারার্কিকাল"}, 0));

        questionList.add(new Question("১৭. RDBMS এর কোন বৈশিষ্ট্যটি গুরুত্বপূর্ণ?",
                new String[] {"তথ্য এনক্রিপশন", "ফাইল ইন্ডেক্সিং", "ডেটার সঠিকতা এবং সম্পর্ক বজায় রাখা", "তথ্য পুনরুদ্ধার"}, 2));

        questionList.add(new Question("১৮. RDBMS এ ডেটার প্রধান উপাদান কী?",
                new String[] {"ফাইল", "টেবিল", "ডিরেক্টরি", "ব্লক"}, 1));

        questionList.add(new Question("১৯. SQL কী?",
                new String[] {"স্ট্রাকচার্ড কুয়েরি ল্যাঙ্গুয়েজ", "সিকিউরিটি কুয়েরি ল্যাঙ্গুয়েজ", "স্টোরেজ কুয়েরি ল্যাঙ্গুয়েজ", "স্ট্যাটিক কুয়েরি ল্যাঙ্গুয়েজ"}, 0));

        questionList.add(new Question("২০. ডেটাবেজের সঠিক আর্কিটেকচার কী?",
                new String[] {"কনসেপ্টুয়াল, লজিক্যাল, ফিজিক্যাল", "লজিক্যাল, পিজিক্যাল, স্টোরেজ", "ফিজিক্যাল, ফাইল, স্টোরেজ", "কনসেপ্টুয়াল, স্টোরেজ, পিজিক্যাল"}, 0));

        questionList.add(new Question("২১. DBMS এর নিরাপত্তা ব্যবস্থা কী?",
                new String[] {"ফাইল সিকিউরিটি", "ডেটাবেজ ব্যাকআপ", "ইউজার অথেনটিকেশন এবং অথোরাইজেশন", "ক্লাউড স্টোরেজ"}, 2));

        questionList.add(new Question("২২. কুয়েরি ব্যবহার করে কোন তথ্য পাওয়া যায়?",
                new String[] {"ডেটাবেজ থেকে তথ্য", "ডেটাবেজের সিকিউরিটি", "ডেটাবেজ ইন্ডেক্স", "ডেটাবেজ ব্যাকআপ"}, 0));

        questionList.add(new Question("২৩. ফাংশনাল ডেটাবেজের একটি বৈশিষ্ট্য কী?",
                new String[] {"ডেটার পুনরুদ্ধার গতি", "ফাইলের সিকিউরিটি", "ব্যক্তিগত ডেটাবেজ ব্যবস্থাপনা", "ডেটা স্টোরেজ টেবিল আকারে"}, 3));

        questionList.add(new Question("২৪. কোন ডেটাবেজ মডেল ডেটা আকারে টেবিল গঠন করে?",
                new String[] {"রিলেশনাল ডেটাবেজ মডেল", "হায়ারার্কিকাল ডেটাবেজ মডেল", "নেটওয়ার্ক ডেটাবেজ মডেল", "অবজেক্ট-ওরিয়েন্টেড মডেল"}, 0));

        questionList.add(new Question("২৫. ডেটাবেজ রিলেশন তৈরি করার কাজটি কী?",
                new String[] {"ডেটার শ্রেণী তৈরি", "টেবিলগুলির মধ্যে সম্পর্ক সৃষ্টি", "ডেটা পুনরুদ্ধার", "কুয়েরি তৈরি"}, 1));


    }





    private void displayQuestion() {
        if (currentQuestionIndex < questionList.size()) {
            Question currentQuestion = questionList.get(currentQuestionIndex);
            questionText.setText(currentQuestion.getQuestion());

            // Clear previous options
            optionsGroup.clearCheck();
            optionsGroup.removeAllViews();

            // Dynamically add radio buttons for options
            for (int i = 0; i < currentQuestion.getOptions().length; i++) {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(currentQuestion.getOptions()[i]);
                radioButton.setId(i);
                optionsGroup.addView(radioButton);
            }

            // Update progress bar
            progressBar.setProgress(currentQuestionIndex);

            // Start timer
            startTimer();
        } else {
            // Quiz finished
            countDownTimer.cancel();
            showResults();
            submitButton.setEnabled(false);
        }
    }

    private void startTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        countDownTimer = new CountDownTimer(50000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerText.setText("Time Left: " + millisUntilFinished / 1000 + "s");
            }

            @Override
            public void onFinish() {
                Toast.makeText(Activity42.this, "Time's up!", Toast.LENGTH_SHORT).show();
                currentQuestionIndex++;
                displayQuestion();
            }
        }.start();
    }

    private void checkAnswer() {
        int selectedOptionId = optionsGroup.getCheckedRadioButtonId();
        if (selectedOptionId == -1) {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
            return;
        }

        Question currentQuestion = questionList.get(currentQuestionIndex);
        if (selectedOptionId == currentQuestion.getCorrectAnswerIndex()) {
            score++;
            correctSound.start();
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            wrongSound.start();
            Toast.makeText(this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
        }

        currentQuestionIndex++;
        displayQuestion();
    }

    private void showResults() {
        String resultMessage = "Quiz Finished!\nCorrect Answers: " + score + "/" + totalQuestions + "\nWrong Answers: " + (totalQuestions - score);
        resultText.setText(resultMessage);
        resultText.setVisibility(View.VISIBLE);

        // Show final progress in progress bar
        progressBar.setProgress(totalQuestions);

        // Show dialog with Restart and Home options
        new android.app.AlertDialog.Builder(this)
                .setTitle("Quiz Completed")
                .setMessage(resultMessage)
                .setCancelable(false)
                .setPositiveButton("Restart", (dialog, which) -> {
                    // Restart the quiz
                    currentQuestionIndex = 0;
                    score = 0;
                    resultText.setVisibility(View.GONE);
                    displayQuestion();
                    submitButton.setEnabled(true);
                })
                .setNegativeButton("Home", (dialog, which) -> {
                    // Navigate to home (you can customize this action)
                    finish();
                })
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (correctSound != null) correctSound.release();
        if (wrongSound != null) wrongSound.release();
        if (countDownTimer != null) countDownTimer.cancel();
    }

    private static class Question {
        private final String question;
        private final String[] options;
        private final int correctAnswerIndex;

        public Question(String question, String[] options, int correctAnswerIndex) {
            this.question = question;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getOptions() {
            return options;
        }

        public int getCorrectAnswerIndex() {
            return correctAnswerIndex;
        }
    }
}
