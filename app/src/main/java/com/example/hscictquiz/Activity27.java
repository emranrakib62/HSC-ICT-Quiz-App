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

public class Activity27 extends AppCompatActivity {

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
        setContentView(R.layout.activity_27);

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


        questionList.add(new Question("1. অর্ডারড লিস্ট তৈরি করতে কোন HTML ট্যাগ ব্যবহৃত হয়?",
                new String[] {"<ul>", "<li>", "<ol>", "<dl>"}, 2));

        questionList.add(new Question("2. ওয়েব ঠিকানার শেষে যে অংশ থাকে, তাকে কী বলা হয়?",
                new String[] {"URL", "ডোমেইন নেম", "প্রোটোকল", "সার্ভার"}, 1));

        questionList.add(new Question("3. HTML-এ লিংক তৈরির সঠিক সিনট্যাক্স কী?",
                new String[] {"<link>xyz.com</link>", "<a>xyz.com</a>", "<a href='xyz.com'> Link text </a>", "<href>xyz.com</href>"}, 2));

        questionList.add(new Question("4. HTML-এ ওপেনিং ও ক্লোজিং ট্যাগের মাঝে যা থাকে, তাকে কী বলে?",
                new String[] {"এট্রিবিউট", "কনটেন্ট", "এলিমেন্ট", "ট্যাগ"}, 1));

        questionList.add(new Question("5. 'pic-1.jpg' নামের ছবি ওয়েবপেজে যোগ করার জন্য সঠিক HTML কোড কী?",
                new String[] {"<image src='pic-1.jpg'>", "<img href='pic-1.jpg'>", "<img src='pic-1.jpg'>", "<picture src='pic-1.jpg'>"}, 2));

        questionList.add(new Question("6. HTML-এ <p> </p> ট্যাগের ব্যবহার কী?",
                new String[] {"ছবি দেখাতে", "শিরোনাম তৈরি করতে", "একটি অনুচ্ছেদ তৈরি করতে", "টেবিল তৈরি করতে"}, 2));

        questionList.add(new Question("7. ইন্টারনেটের সংক্ষিপ্ত নাম কী?",
                new String[] {"web", "www", "net", "inet"}, 2));

        questionList.add(new Question("8. টেবিলের শিরোনাম (heading) প্রদর্শনের জন্য কোন ট্যাগ ব্যবহৃত হয়?",
                new String[] {"<thead>", "<th>", "<title>", "<header>"}, 1));

        questionList.add(new Question("9. HTML ফর্মে অপশন গ্রুপ করার জন্য কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<option>", "<select>", "<optgroup>", "<group>"}, 2));

        questionList.add(new Question("10. নিচের কোন হেডিং ট্যাগের আকার সবচেয়ে ছোট?",
                new String[] {"<h1>", "<h3>", "<h5>", "<h6>"}, 3));

        questionList.add(new Question("11. HTML-এর বৈশিষ্ট্য কী?",
                new String[] {"এটি সহজেই ব্যবহারযোগ্য", "এটি ওপেন-সোর্স প্রযুক্তি", "দুইটি উত্তরই সঠিক", "শুধু প্রোগ্রামাররা ব্যবহার করতে পারে"}, 2));

        questionList.add(new Question("12. ওয়েব ব্রাউজার কোনটি?",
                new String[] {"Google Chrome", "Microsoft Word", "Adobe Photoshop", "Windows Explorer"}, 0));

        questionList.add(new Question("13. HTML-এ নতুন লাইন শুরু করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<break>", "<nl>", "<br>", "<lb>"}, 2));

        questionList.add(new Question("14. HTML-এ <a> ট্যাগের মধ্যে লিংকের ঠিকানা নির্ধারণ করতে কোন অ্যাট্রিবিউট ব্যবহৃত হয়?",
                new String[] {"link", "src", "href", "target"}, 2));

        questionList.add(new Question("15. HTML-এ ইমেজের আকার পরিবর্তন করতে কোন অ্যাট্রিবিউট ব্যবহার করা হয়?",
                new String[] {"size", "width এবং height", "scale", "resize"}, 1));

        questionList.add(new Question("16. HTML-এ বুলেট লিস্ট তৈরি করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<ul>", "<ol>", "<li>", "<dl>"}, 0));

        questionList.add(new Question("17. HTML ফর্মে ব্যবহারকারীর ইনপুট নেওয়ার জন্য কোন ট্যাগ ব্যবহৃত হয়?",
                new String[] {"<enter>", "<input>", "<textbox>", "<form>"}, 1));

        questionList.add(new Question("18. HTML-এ সেলের ব্যাকগ্রাউন্ড রঙ নির্ধারণ করতে কোন অ্যাট্রিবিউট ব্যবহৃত হয়?",
                new String[] {"bgcolor", "background", "color", "style"}, 0));

        questionList.add(new Question("19. HTML-এ লিংক নতুন ট্যাবে বা নির্দিষ্ট স্থানে খোলার জন্য কোন অ্যাট্রিবিউট ব্যবহৃত হয়?",
                new String[] {"open", "newtab", "target", "window"}, 2));

        questionList.add(new Question("20. HTML ফাইল সংরক্ষণ করতে কোন এক্সটেনশন ব্যবহার করা হয়?",
                new String[] {".doc", ".html", ".txt", ".htm"}, 1));

        questionList.add(new Question("21. HTML-এ একটি ওয়েবসাইটের শিরোনাম বা হেডার তৈরি করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<header>", "<head>", "<title>", "<h1>"}, 0));

        questionList.add(new Question("22. HTML-এ ছবির জন্য ক্যাপশন যোগ করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<caption>", "<figcaption>", "<alt>", "<title>"}, 1));

        questionList.add(new Question("23. HTML-এ ছবি ও টেক্সট একসাথে প্রদর্শনের জন্য কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<div>", "<figure>", "<imgtext>", "<textimg>"}, 1));

        questionList.add(new Question("24. HTML-এ কি ধরণের ট্যাগ ব্যবহৃত হয়?",
                new String[] {"কাঠামোগত (structural) ট্যাগ", "স্টাইলিং ট্যাগ", "ইন্টারেক্টিভ ট্যাগ", "সবগুলোই"}, 3));

        questionList.add(new Question("25. HTML-এ টেবিল তৈরি করতে কোন ট্যাগ ব্যবহার করা হয়?",
                new String[] {"<table>", "<tab>", "<tr>", "<td>"}, 0));


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
                Toast.makeText(Activity27.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
