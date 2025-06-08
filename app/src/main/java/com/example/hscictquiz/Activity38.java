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

public class Activity38 extends AppCompatActivity {

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
        setContentView(R.layout.activity_38);

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


        questionList.add(new Question("1. মেশিন ভাষা কী?",
                new String[] {"ডিজিটাল কোডের মাধ্যমে কম্পিউটারকে নির্দেশনা", "একটি গাণিতিক পদ্ধতি", "মেশিনের ভাষার শর্ত", "হিউম্যান-রিডেবল কোড"}, 0));

        questionList.add(new Question("2. কম্পাইলার কী?",
                new String[] {"একটি অনুবাদক যা সম্পূর্ণ কোডকে একত্রে রূপান্তরিত করে", "এটি কোডকে একে একে রূপান্তরিত করে", "একটি কোড ডিবাগার", "এটি কোডকে ভাষা নির্ধারণ করে"}, 0));

        questionList.add(new Question("3. অ্যালগরিদম কী?",
                new String[] {"একটি সমস্যা সমাধানের জন্য সুনির্দিষ্ট পদক্ষেপের ধারাবাহিকতা", "একটি গাণিতিক প্রক্রিয়া", "একটি প্রোগ্রামিং ভাষার খসড়া", "ডেটা ফরম্যাটের বিশ্লেষণ"}, 0));

        questionList.add(new Question("4. সি প্রোগ্রামিং ভাষা কী?",
                new String[] {"এটি একটি সাধারণ উচ্চস্তরের প্রোগ্রামিং ভাষা", "এটি একটি মেশিন ভাষা", "এটি শুধুমাত্র গাণিতিক সমীকরণের জন্য ব্যবহৃত", "এটি একটি কম্পাইলারের ভাষা"}, 0));

        questionList.add(new Question("5. প্রোগ্রাম কম্পাইলিং কী?",
                new String[] {"এটি একটি প্রোগ্রামকে মেশিন কোডে রূপান্তরিত করা", "এটি কোড রূপান্তরিত করার জন্য একটি টুল", "এটি কোডের প্রক্রিয়া পরীক্ষা করে", "এটি কোড সম্পাদনা করার একটি পদ্ধতি"}, 0));

        questionList.add(new Question("6. এক্সপ্রেশন (Expression) কী?",
                new String[] {"অপারেটর এবং মানের সমন্বয়", "কোনো নির্দিষ্ট সংখ্যা", "একটি লজিক্যাল স্টেটমেন্ট", "কোনো মেমরি পদ্ধতি"}, 0));

        questionList.add(new Question("7. C প্রোগ্রামের জন্য কোনটা একটি মৌলিক ডেটা টাইপ?",
                new String[] {"int", "float", "char", "double"}, 2));

        questionList.add(new Question("8. যদি একটি ভেরিয়েবল সি প্রোগ্রামে অদৃশ্য হয়ে যায়, তখন সেটা কী নির্দেশ করে?",
                new String[] {"ভেরিয়েবলটি একটি লোকাল স্কোপে আছে", "ভেরিয়েবলটি গ্লোবাল স্কোপে আছে", "ভেরিয়েবলটি ডিফাইন করা হয়নি", "ভেরিয়েবলটির মান ভুল"}, 0));

        questionList.add(new Question("9. সিরিয়াল কোডিং এবং প্যারালাল কোডিং-এর মধ্যে পার্থক্য কী?",
                new String[] {"সিরিয়াল কোডিং একে একে কার্যকর হয়, প্যারালাল কোডিং একাধিক কাজ একসাথে করে", "সিরিয়াল কোডিং একসাথে কাজ করে", "প্যারালাল কোডিং কম গতিতে কাজ করে", "সিরিয়াল কোডিং দ্রুত কাজ করে"}, 0));

        questionList.add(new Question("10. সি প্রোগ্রামে একটি স্টেটমেন্টের শেষে সেমিকোলন কেন প্রয়োজন?",
                new String[] {"স্টেটমেন্টের শেষ সীমানা চিহ্নিত করতে", "এটি একটি কমান্ডের প্রারম্ভ", "এটি একটি কোডের সংকেত", "এটি একটি সিনট্যাক্স ত্রুটি"}, 0));

        questionList.add(new Question("11. কম্পাইলার কী?",
                new String[] {"একটি প্রোগ্রাম যা সম্পূর্ণ কোডকে মেশিন কোডে রূপান্তরিত করে", "একটি টুল যা কোডে ভুল খুঁজে বের করে", "একটি প্রোগ্রাম যা কোড ডিবাগ করে", "এটি কোডের লজিক চেক করে"}, 0));

        questionList.add(new Question("12. কোনটি মেশিন ভাষার উদাহরণ?",
                new String[] {"বাইনারি কোড", "ASCII কোড", "HTML কোড", "Java কোড"}, 0));

        questionList.add(new Question("13. কোনটি সি প্রোগ্রামের বেসিক গঠন?",
                new String[] {"হেডার ফাইল, মেইন ফাংশন, কোড", "কেবল মেইন ফাংশন", "হেডার ফাইল এবং কোড", "অপারেটর এবং ভেরিয়েবল"}, 0));

        questionList.add(new Question("14. ডেটা টাইপের সাইজ কিভাবে নির্ধারণ করা যায়?",
                new String[] {"sizeof অপারেটর দিয়ে", "sizeof() ফাংশন", "লুপ ব্যবহার করে", "স্ট্রিং ফাংশন দিয়ে"}, 0));

        questionList.add(new Question("15. ‘return’ কীভাবে কাজ করে?",
                new String[] {"ফাংশন থেকে একটি মান ফিরিয়ে দেয়", "এটি ফাংশন চালু করে", "এটি প্রোগ্রাম বন্ধ করে", "এটি কোডে চলাচল দেয়"}, 0));

        questionList.add(new Question("16. একটি স্ট্রাকচার কী?",
                new String[] {"একাধিক ডেটা টাইপের একটি গ্রুপ", "একটি বিশেষ ফাংশন", "একটি কোড ব্লক", "একটি ডেটা টাইপ"}, 0));

        questionList.add(new Question("17. কোনটি সি প্রোগ্রামে একটি সার্বজনীন অপারেটর?",
                new String[] {"== (সামান্য সমান)", "&& (এবং)", "* (গুণ)", "+ (যোগ)"}, 0));

        questionList.add(new Question("18. কোনটি একটি সাধারিতামূলক সি অপারেটর?",
                new String[] {"* (গুণ) অপারেটর", "+ (যোগ)", "- (বিয়োগ)", "/ (ভাগ)"}, 0));

        questionList.add(new Question("19. কোনটি সি প্রোগ্রামের গুরুত্বপূর্ণ বৈশিষ্ট্য?",
                new String[] {"কম্পিউটার সিস্টেমের সাথে খুব ঘনিষ্ঠ কাজ করা", "ব্রাউজারের সাথে সংযোগ করা", "এটি একটি উচ্চ স্তরের ভাষা", "এটি একটি সফটওয়্যার উন্নয়ন ভাষা"}, 0));

        questionList.add(new Question("20. কোনটি সি প্রোগ্রামে একটি যৌক্তিক অপারেটর?",
                new String[] {"&& (এবং)", "++ (ইনক্রিমেন্ট)", "== (তুলনা)", "| (অথবা)"}, 0));

        questionList.add(new Question("21. মেশিন ভাষার মধ্যে কোনটি থাকে?",
                new String[] {"বাইনারি কোড", "ASCII কোড", "Hexadecimal কোড", "C প্রোগ্রাম কোড"}, 0));

        questionList.add(new Question("22. কোনটি সি প্রোগ্রামের প্রাথমিক ডেটা টাইপ?",
                new String[] {"int", "float", "char", "string"}, 0));

        questionList.add(new Question("23. ‘switch’ স্টেটমেন্ট কী?",
                new String[] {"একটি নির্দিষ্ট মানের সাথে একাধিক শর্তের মিল খুঁজে বের করা", "এটি একটি লুপ", "এটি একটি শর্তাধীন বিবৃতি", "এটি একটি বায়নরি অপারেটর"}, 0));

        questionList.add(new Question("24. ‘continue’ কী?",
                new String[] {"এটি লুপের পরবর্তী পুনরাবৃত্তি শুরু করে", "এটি লুপ বন্ধ করে", "এটি কোড পুনরায় শুরু করে", "এটি একটি নতুন ফাংশন শুরু করে"}, 0));


        questionList.add(new Question("25. সি প্রোগ্রামে কোনটি একটি সঠিক স্টেটমেন্ট?",
                new String[] {"int a = 5;", "int 5 = a;", "a = 5;", "int a; = 5;"}, 0));

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
                Toast.makeText(Activity38.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
