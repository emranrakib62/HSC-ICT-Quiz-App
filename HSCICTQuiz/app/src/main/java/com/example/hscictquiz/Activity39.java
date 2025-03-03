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

public class Activity39 extends AppCompatActivity {

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
        setContentView(R.layout.activity_39);

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


        questionList.add(new Question("1. প্রোগ্রামিং ভাষার কোন প্রজন্ম কম্পিউটার ভাষার একেবারে কাছাকাছি?",
                new String[] {"প্রথম প্রজন্ম", "দ্বিতীয় প্রজন্ম", "তৃতীয় প্রজন্ম", "চতুর্থ প্রজন্ম"}, 1));

        questionList.add(new Question("2. অনুবাদক প্রোগ্রাম কী?",
                new String[] {"ইনপুট কোডকে আউটপুট কোডে রূপান্তরিত করে", "কোডকে ডিবাগ করে", "ভুল কোড ঠিক করে", "ফাইল সিস্টেম পরিচালনা করে"}, 2));

        questionList.add(new Question("3. প্রোগ্রাম উন্নয়নের ধাপসমূহ কী?",
                new String[] {"অ্যালগরিদম, কোডিং, ডিবাগিং", "ডিবাগিং, টেস্টিং, কোডিং", "ডিজাইন, কোডিং, ডিবাগিং", "টেস্টিং, ডিজাইন, কোডিং"}, 3));

        questionList.add(new Question("4. প্রোগ্রাম ডিজাইন মডেল কী?",
                new String[] {"প্রোগ্রাম ডিজাইন করার একটি কাঠামো", "প্রোগ্রাম লিখার একটি প্রযুক্তি", "ফাংশন কলের একটি প্রক্রিয়া", "ডিবাগিং পদ্ধতি"}, 2));

        questionList.add(new Question("5. সি প্রোগ্রামের গঠন বৈশিষ্ট্য কী?",
                new String[] {"ফাংশন ভিত্তিক গঠন", "অবজেক্ট ভিত্তিক গঠন", "প্রসেস ভিত্তিক গঠন", "ডেটা ভিত্তিক গঠন"}, 1));

        questionList.add(new Question("6. অপারেটর (Operator) কী?",
                new String[] {"একটি চিহ্ন যা কোনো নির্দিষ্ট কাজ সম্পাদন করে", "একটি সংখ্যা যা গণনা করে", "একটি স্টেটমেন্ট যা কোড চালায়", "একটি মেমরি অ্যাড্রেস"}, 0));

        questionList.add(new Question("7. ফাংশন (Function) কী?",
                new String[] {"কোডের একটি পুনরায় ব্যবহৃত অংশ", "এটি একটি ভেরিয়েবল", "এটি একটি অপারেটর", "এটি একটি লুপ"}, 3));

        questionList.add(new Question("8. ডেটা টাইপ ‘int’ এর উদ্দেশ্য কী?",
                new String[] {"পূর্ণসংখ্যা মান সংরক্ষণ", "দশমিক সংখ্যা সংরক্ষণ", "স্ট্রিং সংরক্ষণ", "বুলিয়ান মান সংরক্ষণ"}, 2));

        questionList.add(new Question("9. ‘sizeof’ অপারেটরটি কি কাজ করে?",
                new String[] {"একটি ডেটা টাইপের সাইজ নির্ধারণ করে", "কোডে সঠিক অপারেটর খুঁজে বের করে", "ডেটা টাইপ কনভার্ট করে", "এটি একটি মেমরি অপারেশন পরিচালনা করে"}, 3));

        questionList.add(new Question("10. প্রোগ্রাম কোডের মধ্যে ‘continue’ স্টেটমেন্ট ব্যবহার করলে কী হবে?",
                new String[] {"পরবর্তী ইটারেশনে চলে যাবে", "প্রোগ্রাম শেষ হবে", "লুপের ভিতরের কোডে চলবে", "কোড থেকে বেরিয়ে আসবে"}, 1));

        questionList.add(new Question("11. কম্পিউটার প্রোগ্রাম কী?",
                new String[] {"একটি নির্দেশনামালা যা কম্পিউটারকে কাজ করতে বলে", "এটি একটি ফাংশন", "এটি একটি কনফিগারেশন ফাইল", "এটি একটি ডেটাবেস প্রশ্ন"}, 2));

        questionList.add(new Question("12. সি প্রোগ্রামে কোন ডেটা টাইপটি দশমিক সংখ্যা ধারণ করতে ব্যবহার হয়?",
                new String[] {"float", "int", "char", "string"}, 3));

        questionList.add(new Question("13. পয়েন্টার কী?",
                new String[] {"এটি একটি ভেরিয়েবল যা অন্য একটি ভেরিয়েবলের মেমরি ঠিকানা ধারণ করে", "এটি একটি সংখ্যা", "এটি একটি স্ট্রিং", "এটি একটি ডেটা টাইপ"}, 2));

        questionList.add(new Question("14. কোনটি সি প্রোগ্রামে ভেরিয়েবল ডিক্লেয়ারেশনের উদাহরণ?",
                new String[] {"int a;", "int; a", "a = int", "int = a;"}, 0));

        questionList.add(new Question("15. ডাটা টাইপ ‘double’ কী ধারণ করে?",
                new String[] {"দশমিক সংখ্যা, বড় সাইজের", "পূর্ণসংখ্যা", "স্ট্রিং", "বুলিয়ান মান"}, 1));

        questionList.add(new Question("16. সি প্রোগ্রামে একটি অ্যারে ঘোষণা করা হয় কিভাবে?",
                new String[] {"int a[10];", "a[10] int;", "array int[10];", "int[10] a;"}, 2));

        questionList.add(new Question("17. কোনটি একটি সি প্রোগ্রামের কন্ট্রোল স্ট্রাকচার?",
                new String[] {"if, switch, for, while", "for, while", "switch, do", "if, else"}, 0));

        questionList.add(new Question("18. ডেটা টাইপ ‘long’ কী ধারণ করে?",
                new String[] {"বড় ধরনের পূর্ণসংখ্যা", "স্ট্রিং", "ছোট পূর্ণসংখ্যা", "দশমিক সংখ্যা"}, 3));

        questionList.add(new Question("19. সি প্রোগ্রামে ‘for’ লুপের সঠিক সিনট্যাক্স কী?",
                new String[] {"for(initialization; condition; increment/decrement) { //code }", "for(condition; initialization; increment) { //code }", "for(increment; condition; initialization) { //code }", "for(initialization; increment; condition) { //code }"}, 1));

        questionList.add(new Question("20. ‘switch’ স্টেটমেন্ট কী?",
                new String[] {"একাধিক শর্ত যাচাই করে সিদ্ধান্ত গ্রহণ", "ফাংশন কলের মাধ্যমে কাজ শুরু", "এটি একটি ডিবাগিং স্টেটমেন্ট", "এটি একটি কোড অপটিমাইজার"}, 2));

        questionList.add(new Question("21. কোনটি সি প্রোগ্রামের একটি বৈশিষ্ট্য?",
                new String[] {"এটি একটি নির্দিষ্ট কম্পিউটার ভাষা", "এটি একটি লাইব্রেরি ভাষা", "এটি একটি গ্রাফিকাল ভাষা", "এটি একটি স্ক্রিপ্ট ভাষা"}, 0));

        questionList.add(new Question("22. ‘#include’ কি?",
                new String[] {"এটি একটি নির্দেশনা যা অন্য ফাইলকে অন্তর্ভুক্ত করে", "এটি একটি মেমরি অপারেশন", "এটি একটি কনফিগারেশন ফাইল", "এটি একটি স্ট্রিং অপারেটর"}, 1));

        questionList.add(new Question("23. অ্যালগরিদমের প্রধান উপাদান কী?",
                new String[] {"ইনপুট, প্রসেস, আউটপুট", "ডিবাগিং, কোডিং, টেস্টিং", "ভেরিয়েবল, ফাংশন, কোড", "পরিবর্তন, স্টেটমেন্ট, লুপ"}, 2));

        questionList.add(new Question("24. সি প্রোগ্রামে কীভাবে একটি ফাংশন ডিক্লেয়ার করা হয়?",
                new String[] {"return_type function_name(parameters);", "function_name(parameters); return_type", "function_name; return_type(parameters)", "parameters function_name(return_type);"}, 3));

        questionList.add(new Question("25. কোনটি একটি ডেটা টাইপ যা পূর্ণসংখ্যা ধারণ করে?",
                new String[] {"int", "char", "float", "string"}, 2));


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
                Toast.makeText(Activity39.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
