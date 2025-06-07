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

public class Activity37 extends AppCompatActivity {

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
        setContentView(R.layout.activity_37);

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


        questionList.add(new Question("1. প্রোগ্রামের ধারণা কী?",
                new String[] {"প্রোগ্রাম একটি গাণিতিক সমীকরণ", "প্রোগ্রাম একটি কোডের সিকোয়েন্স", "প্রোগ্রাম একটি সমস্যা সমাধানের পদ্ধতি", "প্রোগ্রাম একটি অপারেটিং সিস্টেম"}, 1));

        questionList.add(new Question("2. অ্যাসেম্বলি ভাষা কী?",
                new String[] {"মেশিন ভাষার মানব-পাঠযোগ্য রূপ", "ডেটা সঞ্চালনের মাধ্যম", "একটি গাণিতিক পদ্ধতি", "একটি উচ্চ স্তরের ভাষা"}, 0));

        questionList.add(new Question("3. ইন্টারপ্রিটার কী?",
                new String[] {"একটি ডিবাগার", "একটি অনুবাদক যা কোড একে একে রূপান্তরিত করে", "একটি সফটওয়্যার আপডেটার", "একটি টুল যা কোডকে ফাইল আকারে রূপান্তরিত করে"}, 1));

        questionList.add(new Question("4. ফ্লোচার্ট কী?",
                new String[] {"গ্রাফিক্যাল পদ্ধতিতে অ্যালগরিদমের চিত্র", "ডেটা ইন্সট্রাকশন সিকোয়েন্স", "একটি কোড ট্রেসিং মেথড", "একটি কোড সম্পাদনার পদ্ধতি"}, 0));

        questionList.add(new Question("5. সি এবং সি++ এর মধ্যে পার্থক্য কী?",
                new String[] {"সি প্রোগ্রামিংয়ের কোডের গঠন", "সি++ একটি অবজেক্ট ওরিয়েন্টেড ভাষা, সি নয়", "সি এবং সি++ এর কোন পার্থক্য নেই", "সি++ শুধুমাত্র উন্নত প্রযুক্তি ব্যবহার করে"}, 1));

        questionList.add(new Question("6. ডেটা টাইপ কী?",
                new String[] {"ডেটার একটি নির্দিষ্ট শ্রেণী", "ডেটা সংরক্ষণের পদ্ধতি", "একটি সংখ্যা", "মেমরি সাইজের ধারণা"}, 0));

        questionList.add(new Question("7. কীওয়ার্ড (Keyword) কী?",
                new String[] {"বিশেষ প্রোগ্রামিং শব্দ যা সিস্টেম দ্বারা রিজার্ভড", "কোনো ভেরিয়েবলের নাম", "একটি সাধারণ স্টেটমেন্ট", "একটি অপারেটর"}, 0));

        questionList.add(new Question("8. সি প্রোগ্রামে ‘return’ কী কাজ করে?",
                new String[] {"ফাংশনকে বন্ধ করে", "ফাংশন থেকে ফলাফল ফেরত পাঠায়", "একটি নতুন ফাংশন কল করে", "ফাংশনের মধ্যে মান সেট করে"}, 1));

        questionList.add(new Question("9. কোনটি একটি লজিক্যাল অপারেটর?",
                new String[] {"++ (ইনক্রিমেন্ট)", "&& (এবং)", "== (তুলনা)", "|| (অথবা)"}, 3));

        questionList.add(new Question("10. সি প্রোগ্রামে ফাংশনের ডিক্লেয়ারেশন এবং ডিফিনিশন মধ্যে পার্থক্য কী?",
                new String[] {"ডিক্লেয়ারেশন হলো ফাংশনের সিগনেচার, ডিফিনিশন হলো ফাংশনের বাস্তবায়ন", "ডিফিনিশন হলো ফাংশনের প্যারামিটার", "ডিক্লেয়ারেশন কোডের পুনরাবৃত্তি", "ডিফিনিশন হলো কোডের বডি"}, 0));

        questionList.add(new Question("11. কোনটি একটি কম্পিউটার সিস্টেমের হার্ডওয়্যার উপাদান?",
                new String[] {"CPU", "Java", "HTML", "Python"}, 0));

        questionList.add(new Question("12. অ্যাসেম্বলি ভাষা কী?",
                new String[] {"মেশিন ভাষার মানব-পাঠযোগ্য রূপ", "উচ্চ স্তরের ভাষা", "একটি ক্লাস ভিত্তিক ভাষা", "অ্যাক্সেস কন্ট্রোল সিস্টেম"}, 0));

        questionList.add(new Question("13. ফ্লোচার্ট কী?",
                new String[] {"গ্রাফিক্যাল উপস্থাপনা যা একটি অ্যালগরিদমের ধারাবাহিকতা দেখায়", "একটি গাণিতিক সমীকরণ", "ফাংশনের একটি অংশ", "কোনো লজিক্যাল গ্রাফ"}, 0));

        questionList.add(new Question("14. কীওয়ার্ড কী?",
                new String[] {"প্রোগ্রামিং ভাষার রিজার্ভড শব্দ", "অপারেটর", "ফাংশন নাম", "ভেরিয়েবলের নাম"}, 0));

        questionList.add(new Question("15. ফাংশন কলের সময় কোনটি ঘটে?",
                new String[] {"ফাংশনের কোড কার্যকর হয়", "ফাংশন কল করা হয় না", "ফাংশন রিটার্ন হয়", "ফাংশন ব্যর্থ হয়"}, 0));

        questionList.add(new Question("16. কোনটি সি প্রোগ্রামে সঠিক সিনট্যাক্স?",
                new String[] {"printf(“Hello World”);", "print(Hello World);", "printf(Hello World);", "System.out.println(Hello World);"}, 2));

        questionList.add(new Question("17. সি প্রোগ্রামে কীভাবে একটি স্ট্রিং ঘোষণা করা হয়?",
                new String[] {"String str = “Hello”;", "char str[] = “Hello”;", "char str = 'Hello';", "String str = 'Hello';"}, 1));

        questionList.add(new Question("18. স্ট্রিং এর সাথে কীভাবে সি প্রোগ্রামে যোগফল করা হয়?",
                new String[] {"str_add() ফাংশন ব্যবহার করে", "strcat() ফাংশন ব্যবহার করে", "string_add() ব্যবহার করে", "add() ফাংশন ব্যবহার করে"}, 1));

        questionList.add(new Question("19. একটি ফাংশন ঘোষণা এবং ডিফাইন করার মধ্যে পার্থক্য কী?",
                new String[] {"ডিক্লেয়ারেশন হলো সিগনেচার, ডিফাইনেশন হলো বাস্তবায়ন", "ডিফিনিশন শুধুমাত্র ফাংশনের প্যারামিটার", "ডিক্লেয়ারেশন কোডের পুনরাবৃত্তি", "ডিফিনিশন হলো কোডের বডি"}, 0));

        questionList.add(new Question("20. অ্যালগরিদম কোন ধরনের কার্যকলাপ?",
                new String[] {"একটি সমাধান পদ্ধতির পদক্ষেপসমূহ", "একটি গাণিতিক পদ্ধতি", "একটি কোড বিশ্লেষণ", "কোনো প্রোগ্রামিং ভাষা"}, 0));

        questionList.add(new Question("21. ফাংশন প্যারামিটার কি?",
                new String[] {"ফাংশনের ভেরিয়েবল", "ফাংশনে পাস করা মান", "ফাংশনের নাম", "ফাংশনের রিটার্ন টাইপ"}, 1));

        questionList.add(new Question("22. অ্যাসেম্বলি ভাষার কি সুবিধা রয়েছে?",
                new String[] {"এটি গাণিতিক ভাষা", "এটি মেশিন ভাষার পঠনযোগ্য রূপ", "এটি অবজেক্ট ওরিয়েন্টেড", "এটি লজিক্যাল ভাষা"}, 1));

        questionList.add(new Question("23. অ্যারে কীভাবে ডিক্লেয়ার করা হয়?",
                new String[] {"array_name[size] data_type;", "data_type array_name[size];", "data_type[size] array_name;", "array_name data_type[size];"}, 0));

        questionList.add(new Question("24. কোনটি সি প্রোগ্রামে একটি প্রাথমিক অপারেটর?",
                new String[] {"+ (যোগ)", "- (বিয়োগ)", "* (গুণ)", "/ (ভাগ)"}, 0));

        questionList.add(new Question("25. সি প্রোগ্রামের কোন অংশটি মূল কোড ধারণ করে?",
                new String[] {"printf() ফাংশন", "start() ফাংশন", "int main()", "main() ফাংশন"}, 3));

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
                Toast.makeText(Activity37.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
