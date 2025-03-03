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

public class Activity45 extends AppCompatActivity {

    private TextView questionText;
    private TextView timerText;
    private TextView resultText;
    private RadioGroup optionsGroup;
    private Button submitButton;
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
        setContentView(R.layout.activity_45);

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


        questionList.add(new Question("1. সরকারি ডেটাবেজের নিরাপত্তা কোন কারণে গুরুত্বপূর্ণ?",
                new String[] {"তথ্য প্রবাহ গতি বাড়ানো", "যাতে ব্যক্তিগত তথ্য সুরক্ষিত থাকে", "সর্বশেষ তথ্য প্রদান", "ডেটাবেজে ত্রুটি কমানো"}, 1));

        questionList.add(new Question("2. কোন ধরনের ডেটা এনক্রিপশন ব্যবহৃত হয়?",
                new String[] {"বাণিজ্যিক ডেটা", "সামাজিক ডেটা", "সরকারি ডেটা", "ব্যক্তিগত ডেটা"}, 3));

        questionList.add(new Question("3. ডেটাবেজের তথ্য পুনরুদ্ধার কী?",
                new String[] {"ফাইল সংরক্ষণ", "তথ্য সংরক্ষণ", "ডেটা এনক্রিপশন", "কুয়েরি ব্যবহার করে তথ্য সংগ্রহ"}, 3));

        questionList.add(new Question("4. ডেটা সিকিউরিটি জন্য কোন পদ্ধতি ব্যবহার করা হয়?",
                new String[] {"ডেটাবেজ আর্কিটেকচার", "ব্যক্তিগত তথ্য এনক্রিপশন", "ফাইল ব্যবস্থাপনা", "ডেটাবেজ পুনরুদ্ধার"}, 1));

        questionList.add(new Question("5. ডেটাবেজের তথ্য বিশ্লেষণ পদ্ধতি কী?",
                new String[] {"ডেটা কুয়েরি ব্যবহার করে বিশ্লেষণ", "ডেটাবেজের আর্কিটেকচার তৈরি করা", "ডেটা সুরক্ষা ব্যবস্থাপনা", "ডেটা ইন্ডেক্সিং পদ্ধতি"}, 0));

        questionList.add(new Question("6. কোন ধরণের ডেটাবেজ মডেল টেবিল গঠন করে?",
                new String[] {"রিলেশনাল", "অবজেক্ট-ওরিয়েন্টেড", "নেটওয়ার্ক", "হায়ারার্কিকাল"}, 0));

        questionList.add(new Question("7. রিলেশনাল ডেটাবেজের ব্যবহারের সুবিধা কী?",
                new String[] {"ফাইল সিকিউরিটি", "ডেটা একাধিক টেবিলে সংরক্ষণ ও সম্পর্ক স্থাপন", "ডেটা বিশ্লেষণ", "ডেটা এনক্রিপশন"}, 1));

        questionList.add(new Question("8. SQL ব্যবহার করে কেমন কুয়েরি তৈরি করা যায়?",
                new String[] {"ডেটাবেজ আর্কিটেকচার তৈরি", "ডেটা সংশোধন, যুক্তি এবং প্রতিবেদন তৈরি", "ফাইল সংরক্ষণ", "ডেটা এনক্রিপশন"}, 1));

        questionList.add(new Question("9. RDBMS এর একটি গুরুত্বপূর্ণ উপাদান কী?",
                new String[] {"ডেটাবেজ সিকিউরিটি", "ডিরেক্টরি", "টেবিল", "ডেটা ইমপোর্ট"}, 2));

        questionList.add(new Question("10. DBMS এর সর্বাধিক ব্যবহৃত ভাষা কী?",
                new String[] {"SQL", "Python", "Java", "C"}, 0));

        questionList.add(new Question("11. ডেটাবেজে সিকিউরিটি ব্যবস্থার মধ্যে কোনটি অন্তর্ভুক্ত?",
                new String[] {"ফাইল সিকিউরিটি", "ডেটাবেজ ব্যাকআপ", "ইউজার অথেনটিকেশন", "ক্লাউড স্টোরেজ"}, 2));

        questionList.add(new Question("12. ডেটাবেজের জন্য সর্বোত্তম পদ্ধতি কী?",
                new String[] {"নিরাপত্তা, ব্যাকআপ ও কুয়েরি অপটিমাইজেশন", "ফাইল সিকিউরিটি", "ব্যক্তিগত ডেটা এনক্রিপশন", "ডেটাবেজ আর্কিটেকচার ডিজাইন"}, 0));

        questionList.add(new Question("13. ডেটাবেজে সম্পর্ক তৈরি করা হয় কিভাবে?",
                new String[] {"ডেটাবেজের মডেল তৈরি", "ফাইল সিকিউরিটি", "টেবিলের মধ্যে সম্পর্ক স্থাপন", "ডেটা এনক্রিপশন"}, 2));

        questionList.add(new Question("14. DBMS কোনটি অধিক নিরাপত্তা প্রদান করে?",
                new String[] {"ফাইল সিকিউরিটি", "ডেটাবেজ ব্যাকআপ", "ক্লাউড স্টোরেজ", "ইউজার অথেনটিকেশন"}, 3));

        questionList.add(new Question("15. RDBMS এর মধ্যে কোন টেবিল সবচেয়ে গুরুত্বপূর্ণ?",
                new String[] {"ডেটা টেবিল", "ফাইল টেবিল", "ইন্ডেক্স টেবিল", "ব্যাকআপ টেবিল"}, 0));


        questionList.add(new Question("16. ডেটাবেজে প্রাইমারি কি কী?",
                new String[] {"ডেটাবেজ সিকিউরিটি কৌশল", "এটি ডেটা এনক্রিপশন", "বিশেষভাবে চিহ্নিত একটি রেকর্ড", "ডেটা বিশ্লেষণ"}, 2));

        questionList.add(new Question("17. DBMS কোন ধরনের ডেটা প্রক্রিয়া করে?",
                new String[] {"হায়ারার্কিকাল ডেটা", "নেটওয়ার্ক ডেটা", "অবজেক্ট-ওরিয়েন্টেড ডেটা", "রিলেশনাল ডেটা"}, 3));

        questionList.add(new Question("18. SQL তে কীভাবে ডেটা ইনসার্ট করা হয়?",
                new String[] {"INSERT INTO", "UPDATE", "SELECT", "DELETE"}, 0));

        questionList.add(new Question("19. ডেটাবেজে এনক্রিপশন কিভাবে কাজ করে?",
                new String[] {"ডেটা সুরক্ষা বৃদ্ধি", "ডেটা এনক্রিপ্ট করা হয় যাতে অন্য কেউ পড়তে না পারে", "ডেটা আউটপুট প্রদর্শন", "ডেটা বিশ্লেষণ"}, 1));

        questionList.add(new Question("20. DBMS কোন পদ্ধতিতে ডেটা সুরক্ষা নিশ্চিত করে?",
                new String[] {"ইউজার অথেনটিকেশন এবং অথোরাইজেশন", "ফাইল সিকিউরিটি", "ক্লাউড স্টোরেজ", "ডেটাবেজ ব্যাকআপ"}, 0));

        questionList.add(new Question("21. RDBMS এ ডেটা কীভাবে সম্পর্কিত হয়?",
                new String[] {"টেবিলের মধ্যে সম্পর্ক সৃষ্টি করে", "ডেটাবেজ আর্কিটেকচার তৈরি", "ডেটা এনক্রিপশন", "ফাইল সংরক্ষণ"}, 0));

        questionList.add(new Question("22. DBMS এর নিরাপত্তা ব্যবস্থা কীভাবে কাজ করে?",
                new String[] {"ডেটাবেজ পুনরুদ্ধার", "ফাইল সিকিউরিটি", "ব্যক্তিগত তথ্য এনক্রিপশন", "ইউজার অথেনটিকেশন ও অথোরাইজেশন পদ্ধতি"}, 3));

        questionList.add(new Question("23. ডেটাবেজের পণ্য সিস্টেম কী?",
                new String[] {"ডেটাবেজ ম্যানেজমেন্ট সিস্টেম", "ডেটা এনক্রিপশন সফটওয়্যার", "ফাইল ব্যবস্থাপনা সিস্টেম", "ক্লাউড স্টোরেজ সিস্টেম"}, 0));

        questionList.add(new Question("24. SQL তে ডেটা কীভাবে নির্বাচন করা হয়?",
                new String[] {"SELECT * FROM", "INSERT INTO", "UPDATE", "DELETE"}, 0));

        questionList.add(new Question("25. DBMS কোন ক্ষেত্রে বেশি ব্যবহার হয়?",
                new String[] {"গবেষণা ডেটাবেজ", "ব্যক্তিগত ডেটাবেজ", "ব্যবসা ও প্রাতিষ্ঠানিক ডেটাবেজ", "প্রোগ্রামিং ডেটাবেজ"}, 2));
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
                Toast.makeText(Activity45.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
