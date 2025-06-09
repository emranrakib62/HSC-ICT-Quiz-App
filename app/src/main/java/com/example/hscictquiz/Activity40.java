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

public class Activity40 extends AppCompatActivity {

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
        setContentView(R.layout.activity_40);

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


        questionList.add(new Question("1. প্রোগ্রামিং ভাষা কী?",
                new String[] {"একটি নির্দিষ্ট কম্পিউটার ভাষা যা নির্দেশনা দেয়", "ভাষার মাধ্যমে কম্পিউটারে নির্দেশনা প্রদান", "ফাংশনাল ভাষা", "কোডিংয়ের ভাষা"}, 1));

        questionList.add(new Question("2. কোনটি একটি জনপ্রিয় উচ্চস্তরের প্রোগ্রামিং ভাষা?",
                new String[] {"পাইথন", "সি", "রুবি", "জাভা"}, 1));

        questionList.add(new Question("3. প্রোগ্রামের সংগঠন কী?",
                new String[] {"ফাংশনাল স্ট্রাকচার", "প্রোগ্রাম কোড", "ভেরিয়েবল এর ব্যবহার", "প্রোগ্রামটির কাঠামো এবং নিয়মাবলী"}, 3));

        questionList.add(new Question("4. সুডোকোড কী?",
                new String[] {"একটি কোডিং স্টাইল", "অ্যালগরিদমের সহজ এবং প্রাকৃতিক ভাষায় বর্ণনা", "কোডের অ্যালগরিদম", "সাময়িক কোড"}, 1));

        questionList.add(new Question("5. C ভাষার প্রোগ্রামের গঠন কী?",
                new String[] {"টাইপ, মেইন, রিটার্ন", "ফাংশন, অ্যালগরিদম, কোড", "অবজেক্ট, ক্লাস, মেথড", "হেডার, ফাংশন, মেইন ফাংশন"}, 3));

        questionList.add(new Question("6. চলক (Variable) কী?",
                new String[] {"কোডের অংশ", "যে মান পরিবর্তন হয়", "একটি স্ট্রিং", "একটি ইনপুট ফাইল"}, 1));

        questionList.add(new Question("7. অ্যারে (Array) কী?",
                new String[] {"একই ধরনের ডেটার একটি সংগ্রহ", "বিভিন্ন ডেটার তালিকা", "ফাংশনের集合", "কোডিং স্টাইল"}, 0));

        questionList.add(new Question("8. ফাংশন কলের মাধ্যমে কোন কাজ সম্পন্ন করা হয়?",
                new String[] {"কোড পর্যালোচনা করা", "একটি স্টেটমেন্ট সম্পন্ন করা", "নির্দিষ্ট ফাংশনের কোড কার্যকর করা", "একটি রিটার্ন ভ্যালু প্রদান"}, 2));

        questionList.add(new Question("9. যখন ‘break’ স্টেটমেন্ট ব্যবহার করা হয়, তখন কী ঘটে?",
                new String[] {"একটি নতুন কোড চালু হয়", "স্টেটমেন্ট বন্ধ হয়", "লুপ বা সুইচ স্টেটমেন্ট থেকে বের হয়ে আসে", "ফাংশন বন্ধ হয়ে যায়"}, 2));

        questionList.add(new Question("10. কোনটি একটি প্রাথমিক ডেটা টাইপ?",
                new String[] {"char", "double", "int", "float"}, 2));

        questionList.add(new Question("11. প্রোগ্রামিং ভাষা কী?",
                new String[] {"একটি কোড লেখার ভাষা", "একটি প্রোগ্রামিং স্টাইল", "বিভিন্ন ফাংশন সংক্রান্ত ভাষা", "একটি নির্দিষ্ট কম্পিউটার ভাষা যা নির্দেশনা দেয়"}, 3));

        questionList.add(new Question("12. ‘if’ স্টেটমেন্টের কাজ কী?",
                new String[] {"ফাংশন কল করা", "ডেটা ইনপুট নেওয়া", "শর্তের উপর ভিত্তি করে সিদ্ধান্ত গ্রহণ", "স্ট্রিং সংরক্ষণ করা"}, 2));

        questionList.add(new Question("13. অ্যারে কী?",
                new String[] {"একাধিক একই ধরনের মানের একটি সংগ্রহ", "স্ট্রিং এর তালিকা", "কোড সংকলন", "একটি সংখ্যা"}, 0));

        questionList.add(new Question("14. স্টেটমেন্ট কী?",
                new String[] {"ফাংশনাল কোড", "কোডের একক অপারেশন", "একটি ডেটা সাইন", "কোডের সিদ্ধান্ত"}, 1));

        questionList.add(new Question("15. ‘continue’ স্টেটমেন্টের কাজ কী?",
                new String[] {"কোড থেকে বেরিয়ে আসা", "সুইচ স্টেটমেন্ট শেষ করা", "ফাংশন বন্ধ করা", "লুপের পরবর্তী পুনরাবৃত্তি শুরু করা"}, 3));

        questionList.add(new Question("16. সি প্রোগ্রামে কোনটি একটি অপারেটর?",
                new String[] {"+ (যোগ)", "- (বিয়োগ)", "* (গুণ)", "/ (ভাগ)"}, 0));

        questionList.add(new Question("17. সি প্রোগ্রামে কীভাবে একটি ফাংশন ডিক্লেয়ার করা হয়?",
                new String[] {"function_name(parameters); return_type", "return_type function_name(parameters);", "function_name; return_type(parameters)", "parameters function_name(return_type);"}, 1));

        questionList.add(new Question("18. সি প্রোগ্রামে ‘scanf’ কীভাবে কাজ করে?",
                new String[] {"স্ট্রিং প্রক্রিয়া করে", "কোডের ফলাফল সংরক্ষণ করে", "ব্যবহারকারীর ইনপুট গ্রহণ করে", "আউটপুট প্রদর্শন করে"}, 2));

        questionList.add(new Question("19. প্যারামিটার কী?",
                new String[] {"একটি ভেরিয়েবল", "ফাংশনের ইনপুট মান", "স্ট্রিং", "ফাংশনের আউটপুট"}, 1));

        questionList.add(new Question("20. সি প্রোগ্রামে একটি কনস্ট্যান্ট কী?",
                new String[] {"একটি ইনপুট ফাইল", "একটি অপারেটর", "একটি পরিবর্তনশীল যা এর মান পরিবর্তন হয় না", "একটি ভেরিয়েবল"}, 2));

        questionList.add(new Question("21. প্রোগ্রামিং ভাষার প্রধান উদ্দেশ্য কী?",
                new String[] {"ফাংশন তৈরি", "কোড লেখা", "ডেটা অ্যাক্সেস", "কম্পিউটারকে নির্দেশনা প্রদান করা"}, 3));

        questionList.add(new Question("22. ফাংশন ব্যবহারের মূল উদ্দেশ্য কী?",
                new String[] {"কোডের পুনরায় ব্যবহারের সুবিধা সৃষ্টি করা", "স্ট্রিং প্রক্রিয়া করা", "একটি আউটপুট প্রদর্শন করা", "ফাইল সংরক্ষণ করা"}, 0));

        questionList.add(new Question("23. সি প্রোগ্রামে কীভাবে একটি স্ট্রিং যোগ করা হয়?",
                new String[] {"printf() ফাংশন দিয়ে", "strcat() ফাংশন দিয়ে", "scanf() ফাংশন দিয়ে", "strlen() ফাংশন দিয়ে"}, 1));

        questionList.add(new Question("24. ফ্লোচার্টে কোন চিহ্নটি ডেটার ইনপুট বা আউটপুট নির্দেশ করে?",
                new String[] {"বৃত্তাকার চিহ্ন", "আয়তাকার চিহ্ন", "হীরক চিহ্ন", "তীর চিহ্ন"}, 1));



        questionList.add(new Question("25. কোনটি সি প্রোগ্রামের একটি স্ট্রাকচার?",
                new String[] {"class", "struct", "array", "function"}, 1));


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
                Toast.makeText(Activity40.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
