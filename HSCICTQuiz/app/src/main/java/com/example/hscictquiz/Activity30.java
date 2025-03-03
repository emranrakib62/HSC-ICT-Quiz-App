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

public class Activity30 extends AppCompatActivity {

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
        setContentView(R.layout.activity_30);

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


        questionList.add(new Question("1. বর্তমানে HTML-এর সর্বশেষ সংস্করণ কী?",
                new String[] {"HTML4", "HTML5", "XHTML", "HTML3"}, 1));

        questionList.add(new Question("2. URL-এর সম্পূর্ণ রূপ কী?",
                new String[] {"Universal Resource Locator", "Uniform Resource Locator", "Universal Resource Locator", "Uniform Retrieval Locator"}, 1));

        questionList.add(new Question("3. টেক্সট গাঢ় করতে (বোল্ড) কোন HTML ট্যাগ ব্যবহৃত হয়?",
                new String[] {"<i>", "<b>", "<strong>", "<u>"}, 1));

        questionList.add(new Question("4. কোন চিহ্ন সেমিকোলন নামে পরিচিত?",
                new String[] {":", ".", ";", ","}, 2));

        questionList.add(new Question("5. http://www.example.com -এ সর্বশেষ অংশটিকে কী বলা হয়?",
                new String[] {"URL", "ডোমেইন নেম", "পথ", "পোর্ট"}, 1));

        questionList.add(new Question("6. নিচের কোন HTML ট্যাগটির ক্লোজিং ট্যাগ থাকে না?",
                new String[] {"<p>", "<br>", "<h1>", "<a>"}, 1));

        questionList.add(new Question("7. HTML-এ ওয়েব লিংকের সম্পূর্ণ ঠিকানা লেখার সঠিক উপায় কী?",
                new String[] {"<a href=url> link text </a>", "<link href=url> text </link>", "<url> link text </url>", "<a link=url> text </a>"}, 0));

        questionList.add(new Question("8. নিচের কোডটি দেখুন: <p>This is <br> a paragraph </p> এখানে <br> দ্বারা কী বোঝানো হয়েছে?",
                new String[] {"নতুন প্যারাগ্রাফ", "টেবিল", "লাইনব্রেক", "শিরোনাম"}, 2));

        questionList.add(new Question("9. ওয়েবসাইটের প্রধান পেজকে কী বলা হয়?",
                new String[] {"হোমপেজ", "টাইটেল পেজ", "ল্যান্ডিং পেজ", "এডমিন পেজ"}, 0));

        questionList.add(new Question("10. HTML-এ টেবিলের তথ্যবহুল সেল তৈরি করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<td>", "<th>", "<tr>", "<table>"}, 0));

        questionList.add(new Question("11. ডোমেইন নেম কী?",
                new String[] {"ওয়েবসাইটের স্বতন্ত্র নাম", "এটি IP অ্যাড্রেসের সমতুল্য", "এটি ওয়েবসাইটের শিরোনাম", "এটি HTTP প্রোটোকলের অংশ"}, 0));

        questionList.add(new Question("12. HTML-এ একটি পেজ থেকে অন্য পেজে যাওয়ার উপায় কী?",
                new String[] {"Hyperlink", "Anchor Tag", "Redirect", "JavaScript"}, 0));

        questionList.add(new Question("13. ওয়েবসাইট তৈরি করতে কী প্রয়োজন?",
                new String[] {"কেবল CSS", "ব্যান্ডউইথ ও স্টোরেজ স্পেস", "HTML ও JavaScript", "ফ্রেমওয়ার্ক"}, 1));

        questionList.add(new Question("14. HTML-এ ওয়েবপেজের শিরোনাম (title) নির্ধারণ করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<head>", "<title>", "<h1>", "<meta>"}, 1));

        questionList.add(new Question("15. ওয়েবপেজে CSS যুক্ত করতে কোন HTML ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<link>", "<style>", "<css>", "<head>"}, 0));

        questionList.add(new Question("16. HTML-এ ফন্টের আকার পরিবর্তন করতে কোন CSS প্রোপার্টি ব্যবহার করা হয়?",
                new String[] {"font-weight", "font-size", "text-align", "font-family"}, 1));

        questionList.add(new Question("17. HTML-এ টেবিলের একটি সাধারণ সেল তৈরি করতে কোন ট্যাগ ব্যবহৃত হয়?",
                new String[] {"<td>", "<th>", "<tr>", "<table>"}, 0));

        questionList.add(new Question("18. HTML-এ সাব হেডিং (উপশিরোনাম) তৈরি করতে কোন ট্যাগ ব্যবহৃত হয়?",
                new String[] {"<h1>", "<h2>", "<h3>", "<h4>"}, 1));

        questionList.add(new Question("19. HTML-এ কোন ট্যাগটি ব্যবহার করলে ক্রমানুসার তালিকা তৈরি হয়?",
                new String[] {"<ol>", "<ul>", "<li>", "<menu>"}, 0));

        questionList.add(new Question("20. URL-এর কোন অংশে ওয়েবসাইটের ঠিকানা থাকে?",
                new String[] {"পথ", "ডোমেইন নেম", "প্রোটোকল", "কোড"}, 1));

        questionList.add(new Question("21. ওয়েবসাইটের তথ্য সংরক্ষণ করার জন্য কোন ধরনের সার্ভার ব্যবহার করা হয়?",
                new String[] {"ডাটাবেস সার্ভার", "ফাইল সার্ভার", "হোস্ট সার্ভার", "ক্লাউড সার্ভার"}, 2));

        questionList.add(new Question("22. HTML-এ ডিভাইস স্ক্রীনে উপাদান সজ্জিত করতে কোন প্রোপার্টি ব্যবহার করা হয়?",
                new String[] {"position", "style", "display", "align"}, 0));

        questionList.add(new Question("23. ওয়েবসাইটের জন্য কোন ধরনের ভাষা ব্যবহার করা হয়?",
                new String[] {"JavaScript", "Python", "Java", "PHP"}, 0));

        questionList.add(new Question("24. HTML-এর কোন ট্যাগে মেটা তথ্য রাখা হয়?",
                new String[] {"<header>", "<meta>", "<body>", "<footer>"}, 1));

        questionList.add(new Question("25. HTML-এ লিস্ট আইটেমের জন্য কোন ট্যাগ ব্যবহৃত হয়?",
                new String[] {"<li>", "<ol>", "<ul>", "<item>"}, 0));



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
                Toast.makeText(Activity30.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
