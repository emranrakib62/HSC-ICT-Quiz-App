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

public class Activity28 extends AppCompatActivity {

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
        setContentView(R.layout.activity_28);

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


        questionList.add(new Question("1. ওয়েবপেজ তৈরি করতে কোন কোড ব্যবহার করা হয়?",
                new String[] {"HTML", "CSS", "JavaScript", "সবগুলো"}, 3));

        questionList.add(new Question("2. ইন্টারনেটে পরস্পরের সাথে সংযুক্ত হাইপারটেক্সট ডকুমেন্টকে কী বলা হয়?",
                new String[] {"ওয়েব ব্রাউজার", "ওয়েবসাইট", "ওয়েব সার্ভার", "ওয়েব পেজ"}, 1));

        questionList.add(new Question("3. HTML-এ সবচেয়ে ছোট শিরোনাম (heading) প্রদর্শনের জন্য কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<h1>", "<h3>", "<h5>", "<h6>"}, 3));

        questionList.add(new Question("4. Google.com কী?",
                new String[] {"একটি সোশ্যাল মিডিয়া", "একটি সার্চ ইঞ্জিন", "একটি ই-মেইল সার্ভিস", "একটি ওয়েবসাইট হোস্টিং সার্ভিস"}, 1));

        questionList.add(new Question("5. ওয়েবপেজে 1000x800 পিক্সেলের 'image.jpg' নামের ছবি দেখাতে নিচের কোন কোডটি সঠিক?",
                new String[] {"<img src='image.jpg' width='1000' height='800'>", "<image src='image.jpg' size='1000x800'>", "<img href='image.jpg' width='1000' height='800'>", "<picture src='image.jpg' width='1000' height='800'>"}, 0));

        questionList.add(new Question("6. ওয়েবপেজ তৈরির জন্য কোন ভাষা ব্যবহার করা হয়?",
                new String[] {"Python", "Java", "HTML", "C++"}, 2));

        questionList.add(new Question("7. বাঁকা (italic) লেখা প্রদর্শনের জন্য কোন HTML ট্যাগ ব্যবহৃত হয়?",
                new String[] {"<italic>", "<b>", "<i>", "<em>"}, 2));

        questionList.add(new Question("8. নিচের কোনটি একটি সঠিক URL?",
                new String[] {"www.abc.com/xYz", "www,abc,com/xYz", "http:/abc.com/xYz", "ftp.abc.com/xYz"}, 0));

        questionList.add(new Question("9. HTML ফর্মের ড্রপডাউন মেনুর জন্য কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<drop>", "<option>", "<select>", "<dropdown>"}, 1));

        questionList.add(new Question("10. HTML-এ ফন্টের নাম পরিবর্তনের জন্য কোন অ্যাট্রিবিউট ব্যবহৃত হয়?",
                new String[] {"font", "face", "style", "type"}, 1));

        questionList.add(new Question("11. ওয়েবপেজের ঠিকানাকে কী বলা হয়?",
                new String[] {"IP", "HTTP", "URL", "DNS"}, 2));

        questionList.add(new Question("12. HTML-এ ওয়েবপেজ তৈরির জন্য কোন ফাইল এক্সটেনশন ব্যবহার করা হয়?",
                new String[] {".doc", ".exe", ".html, .htm", ".css"}, 2));

        questionList.add(new Question("13. HTML-এ পেজের প্রধান অংশ শুরু করার জন্য কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<main>", "<head>", "<body>", "<section>"}, 2));

        questionList.add(new Question("14. <img> ট্যাগের জন্য ছবির ঠিকানা নির্ধারণ করতে কোন অ্যাট্রিবিউট ব্যবহার করা হয়?",
                new String[] {"href", "src", "link", "alt"}, 1));

        questionList.add(new Question("15. HTML-এ একটি অ্যাঙ্কর লিংক (হাইপারলিংক) তৈরি করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<link>", "<a>", "<href>", "<hyperlink>"}, 1));

        questionList.add(new Question("16. HTML-এ প্যারাগ্রাফ তৈরি করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<text>", "<p>", "<paragraph>", "<para>"}, 1));

        questionList.add(new Question("17. HTML ফর্মে ডাটা জমা দিতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<submit>", "<input>", "<form action='submit'>", "<button>"}, 2));

        questionList.add(new Question("18. HTML-এ একটি টেবিলের সীমানা নির্ধারণ করতে কোন অ্যাট্রিবিউট ব্যবহৃত হয়?",
                new String[] {"border", "outline", "frame", "line"}, 0));

        questionList.add(new Question("19. HTML-এ ক্রমানুসার তালিকা (ordered list) তৈরি করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<ul>", "<li>", "<ol>", "<dl>"}, 2));

        questionList.add(new Question("20. HTML-এ টেবিলের কলাম তৈরি করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<col>", "<column>", "<td>", "<th>"}, 0));

        questionList.add(new Question("21. HTML-এ লিস্ট আইটেম (list item) তৈরি করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<list>", "<li>", "<ul>", "<ol>"}, 1));

        questionList.add(new Question("22. HTML-এ টেবিলের সারি (row) তৈরি করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<row>", "<tr>", "<td>", "<th>"}, 1));

        questionList.add(new Question("23. HTML-এ ওয়েবপেজের টাইটেল নির্ধারণ করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<meta>", "<title>", "<head>", "<header>"}, 1));

        questionList.add(new Question("24. HTML-এ একটি ইনপুট ফিল্ড তৈরি করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<input>", "<text>", "<field>", "<form>"}, 0));

        questionList.add(new Question("25. HTML-এ লিংকের রঙ পরিবর্তন করতে কোন CSS প্রপার্টি ব্যবহার করা হয়?",
                new String[] {"color", "link-color", "text-color", "href-color"}, 0));



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
                Toast.makeText(Activity28.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
