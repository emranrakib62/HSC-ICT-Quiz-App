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

public class Activity29 extends AppCompatActivity {

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
        setContentView(R.layout.activity_29);

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


        questionList.add(new Question("1. ইন্টারনেটে যে কম্পিউটারে ওয়েবসাইট সংরক্ষিত থাকে, তাকে কী বলা হয়?",
                new String[] {"ডোমেইন নেম", "হোস্ট সার্ভার", "ব্রাউজার", "ISP"}, 1));

        questionList.add(new Question("2. ওয়েবপেজে হাইপারলিংক যুক্ত করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<link>", "<a>", "<p>", "<h1>"}, 1));

        questionList.add(new Question("3. HTML-এ ফন্টের আকার পরিবর্তন করতে কোন অ্যাট্রিবিউট ব্যবহার করা হয়?",
                new String[] {"size", "font", "text", "style"}, 1));

        questionList.add(new Question("4. ওপেনিং এবং ক্লোজিং ট্যাগের মধ্যে থাকা সব কিছু একত্রে কী বলে?",
                new String[] {"HTML এলিমেন্ট", "HTML অ্যাট্রিবিউট", "HTML ট্যাগ", "HTML কোড"}, 0));

        questionList.add(new Question("5. ড্রপডাউন মেনু তৈরি করতে কোন HTML ট্যাগ ব্যবহৃত হয়?",
                new String[] {"<menu>", "<list>", "<dropdown>", "<select>"}, 3));

        questionList.add(new Question("6. ওয়েবসাইটের কাঠামো কেমন হয়?",
                new String[] {"এটি সাধারণত হোমপেজ ভিত্তিক", "এটি শুধুমাত্র একটি পেজের সমষ্টি", "এটি শুধুমাত্র CSS দ্বারা তৈরি", "এটি শুধুমাত্র HTML দ্বারা তৈরি"}, 0));

        questionList.add(new Question("7. HTML-এ <b> ট্যাগের ব্যবহার কী?",
                new String[] {"টেক্সট ইটালিক করতে", "টেক্সট আন্ডারলাইন করতে", "টেক্সট বোল্ড করতে", "টেক্সট কালার পরিবর্তন করতে"}, 2));

        questionList.add(new Question("8. প্রতিটি ওয়েবসাইটের স্বতন্ত্র পরিচিতিকে কী বলা হয়?",
                new String[] {"URL", "IP অ্যাড্রেস", "ডোমেইন নেম", "প্রটোকল"}, 2));

        questionList.add(new Question("9. HTML-এ ফর্ম তৈরির জন্য কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<input>", "<form>", "<table>", "<div>"}, 1));

        questionList.add(new Question("10. HTML-এর উদ্ভাবক কে?",
                new String[] {"বিল গেটস", "টিম বার্নার্স-লি", "মার্ক জাকারবার্গ", "ডেনিস রিচি"}, 1));

        questionList.add(new Question("11. ISP-এর সম্পূর্ণ রূপ কী?",
                new String[] {"Internet System Protocol", "Internal Service Port", "Internet Service Provider", "International Service Protocol"}, 2));

        questionList.add(new Question("12. একটি URL-এর প্রধান অংশ কী কী?",
                new String[] {"(প্রোটোকল নেম, হোস্ট নেম)", "(ডোমেইন নেম, IP অ্যাড্রেস)", "(HTML, CSS)", "(টাইটেল, ডেসক্রিপশন)"}, 0));

        questionList.add(new Question("13. HTML-এ নথির শিরোনাম (document header) তৈরি করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<head>", "<header>", "<title>", "<h1>"}, 0));

        questionList.add(new Question("14. HTML-এ ছবি প্রদর্শনের জন্য কোন ট্যাগ ব্যবহৃত হয়?",
                new String[] {"<image>", "<img>", "<pic>", "<photo>"}, 1));

        questionList.add(new Question("15. HTML-এ আনঅর্ডারড (বুলেট) লিস্ট তৈরি করতে কোন ট্যাগ ব্যবহৃত হয়?",
                new String[] {"<ol>", "<ul>", "<li>", "<dl>"}, 1));

        questionList.add(new Question("16. HTML-এ টেবিলের শিরোনাম (heading cell) তৈরি করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<th>", "<td>", "<tr>", "<table>"}, 0));

        questionList.add(new Question("17. HTML ফর্মে একাধিক অপশন যুক্ত করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<select>", "<option>", "<input>", "<checkbox>"}, 0));

        questionList.add(new Question("18. HTML-এ ইমেজ লোড না হলে বিকল্প টেক্সট প্রদর্শনের জন্য কোন অ্যাট্রিবিউট ব্যবহার করা হয়?",
                new String[] {"src", "alt", "href", "title"}, 1));


        questionList.add(new Question("19. HTML-এ নতুন প্যারাগ্রাফ শুরু করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<br>", "<p>", "<h1>", "<div>"}, 1));

        questionList.add(new Question("20. ওয়েবপেজে টেবিল তৈরি করতে কোন HTML ট্যাগ ব্যবহৃত হয়?",
                new String[] {"<table>", "<tr>", "<td>", "<th>"}, 0));

        questionList.add(new Question("21. HTML-এ লিস্ট আইটেম তৈরি করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<li>", "<list>", "<ul>", "<ol>"}, 0));

        questionList.add(new Question("22. CSS-এ রঙ নির্ধারণ করতে কোন প্রপার্টি ব্যবহার করা হয়?",
                new String[] {"background", "color", "font-color", "text-style"}, 1));

        questionList.add(new Question("23. HTML-এ লিংক তৈরি করতে কোন অ্যাট্রিবিউট ব্যবহার করা হয়?",
                new String[] {"src", "href", "link", "url"}, 1));

        questionList.add(new Question("24. HTML-এ ইনপুট ফিল্ড তৈরি করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<text>", "<form>", "<input>", "<button>"}, 2));


        questionList.add(new Question("25. HTML-এ সবচেয়ে বড় শিরোনাম ট্যাগ কোনটি?",
                new String[] {"<h1>", "<h6>", "<head>", "<title>"}, 0));



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
                Toast.makeText(Activity29.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
