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

public class Activity23 extends AppCompatActivity {

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
        setContentView(R.layout.activity_23);

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

    private void initializeQuestions() {
        questionList = new ArrayList<>();


        // Question 1
        // প্রশ্ন 1
        questionList.add(new Question(
                "1. ফটোডিটেক্টর কী কাজ করে?",
                new String[]{"আলোকে বিদ্যুৎ শক্তিতে রূপান্তরিত করে", "ডেটা প্রেরণ করে", "ফোটন উৎপন্ন করে", "আলো শোষণ করে"},
                0
        ));

// প্রশ্ন 2
        questionList.add(new Question(
                "2. ভয়েস ব্যান্ড সবচেয়ে বেশি ব্যবহৃত হয় কোনটিতে?",
                new String[]{"কম্পিউটার", "টেলিভিশন", "টেলিফোন", "রেডিও"},
                2
        ));

// প্রশ্ন 3
        questionList.add(new Question(
                "3. ন্যারোব্যান্ডের সর্বনিম্ন ডেটা গতি কত bps?",
                new String[]{"১৫০", "১০০", "২০০", "৪৫"},
                3
        ));

// প্রশ্ন 4
        questionList.add(new Question(
                "4. ভয়েস ব্যান্ড সাধারণত কোথায় ব্যবহৃত হয়?",
                new String[]{"রেডিও", "টেলিভিশন", "কম্পিউটার", "টেলিফোন"},
                3
        ));

// প্রশ্ন 5
        questionList.add(new Question(
                "5. মোবাইল ফোন কোন উপায়ে ডেটা আদান-প্রদান করে?",
                new String[]{"হাফ ডুপ্লেক্স", "ফুল ডুপ্লেক্স", "একমুখী যোগাযোগ", "শুধু প্রেরণযোগ্য"},
                1
        ));

// প্রশ্ন 6
        questionList.add(new Question(
                "6. কো-অ্যাক্সিয়াল ক্যাবলের সাধারণ ডেটা স্থানান্তরের হার কত?",
                new String[]{"1 Gbps", "50 Mbps", "100 Mbps", "500 Mbps"},
                2
        ));

// প্রশ্ন 7
        questionList.add(new Question(
                "7. কো-অ্যাক্সিয়াল ক্যাবলের তারকে চারপাশে কী ঘিরে থাকে?",
                new String[]{"প্লাস্টিকের ইনসুলেশন", "ধাতব তার", "কাচের আবরণ", "রাবারের আবরণ"},
                0
        ));

// প্রশ্ন 8
        questionList.add(new Question(
                "8. ডেটা স্থানান্তরের সুবিধা কী?",
                new String[]{"নিরাপদ তথ্য আদান-প্রদান", "দ্রুত ডেটা স্থানান্তর", "কম্পিউটার চিপের মাধ্যমে", "একসঙ্গে অনেক তথ্য পাঠানো"},
                1
        ));

// প্রশ্ন 9
        questionList.add(new Question(
                "9. নেটওয়ার্কে ব্যান্ডউইডথ বেশি থাকলে কী সুবিধা হয়?",
                new String[]{"উচ্চগতির ডেটা স্থানান্তর", "নিরাপদ নেটওয়ার্ক", "কম তথ্য আদান-প্রদান", "এনক্রিপশন সুবিধা"},
                0
        ));

// প্রশ্ন 10
        questionList.add(new Question(
                "10. নিচের কোন নেটওয়ার্ক ক্যাবল সবচেয়ে বেশি ব্যবহৃত হয়?",
                new String[]{"প্যারাবোলিক ক্যাবল", "ফাইবার অপটিক ক্যাবল", "কো-অ্যাক্সিয়াল ক্যাবল", "টুইস্টেড পেয়ার ক্যাবল"},
                3
        ));

// প্রশ্ন 11
        questionList.add(new Question(
                "11. নিচের কোন ক্যাবলে ডেটা স্থানান্তরের গতি সবচেয়ে বেশি?",
                new String[]{"ফাইবার অপটিক ক্যাবল", "টুইস্টেড পেয়ার ক্যাবল", "কো-অ্যাক্সিয়াল ক্যাবল", "কপার ক্যাবল"},
                0
        ));

// প্রশ্ন 12
        questionList.add(new Question(
                "12. STP ক্যাবলের বাইরের স্তরে কী থাকে?",
                new String[]{"ধাতব শিল্ড", "জ্যাকেট বা প্লাস্টিকের আবরণ", "কাচের আবরণ", "প্লাস্টিক ইনসুলেশন"},
                1
        ));

// প্রশ্ন 13
        questionList.add(new Question(
                "13. বর্তমানে ফাইবার অপটিক ক্যাবলে সর্বোচ্চ ডেটা স্থানান্তরের হার কত?",
                new String[]{"10 Mbps-50 Gbps", "500 Mbps-1 Gbps", "1 Gbps-100 Gbps", "2 Gbps-10 Gbps"},
                2
        ));

// প্রশ্ন 14
        questionList.add(new Question(
                "14. কোন প্রযুক্তিটি ওয়্যারলেস PAN নেটওয়ার্কের জন্য ব্যবহার করা হয়?",
                new String[]{"ব্লুটুথ", "Wi-Fi", "GPRS", "FM রেডিও"},
                0
        ));

// প্রশ্ন 15
        questionList.add(new Question(
                "15. রেডিও মডেম ও অ্যান্টেনা কোন ক্ষেত্রে প্রয়োজন হয়?",
                new String[]{"ফাইবার অপটিক", "LTE", "ইথারনেট", "ওয়্যারলেস LAN"},
                3
        ));

// প্রশ্ন 16
        questionList.add(new Question(
                "16. Wi-Fi কী?",
                new String[]{"ওয়্যারলেস LAN", "ওয়্যারড LAN", "ওয়্যারলেস PAN", "ব্লুটুথ"},
                0
        ));

// প্রশ্ন 17
        questionList.add(new Question(
                "17. পাহাড়ি এলাকায় সাশ্রয়ী নেটওয়ার্ক স্থাপনের জন্য কোন প্রযুক্তিটি সবচেয়ে কার্যকর?",
                new String[]{"মাইক্রোওয়েভ", "ফাইবার অপটিক", "রেডিও ওয়েভ", "টেলিফোন লাইন"},
                2
        ));

// প্রশ্ন 18
        questionList.add(new Question(
                "18. বাণিজ্যিকভাবে 3G প্রযুক্তি চালু হয় কোন সালে?",
                new String[]{"২০০১", "২০০৫", "২০১০", "২০১৫"},
                0
        ));

// প্রশ্ন 19
        questionList.add(new Question(
                "19. সাধারণ মোবাইল যোগাযোগ ব্যবস্থা কী ধরনের?",
                new String[]{"টেলিভিশন সম্প্রচার", "কেবলযুক্ত যোগাযোগ", "ইন্টারনেট সংযোগ", "তারবিহীন যোগাযোগ"},
                3
        ));

// প্রশ্ন 20
        questionList.add(new Question(
                "20. WAN নেটওয়ার্কের একটি উদাহরণ কী?",
                new String[]{"LAN", "ইন্টারনেট", "Bluetooth", "Wi-Fi"},
                1
        ));

// প্রশ্ন 21
        questionList.add(new Question(
                "21. কম্পিউটার নেটওয়ার্কের প্রধান উদ্দেশ্য কী?",
                new String[]{"হার্ডওয়্যার ও সফটওয়্যার শেয়ারিং", "নেটওয়ার্ক স্থাপন", "ডেটা ম্যানেজমেন্ট", "একই নেটওয়ার্কে সংযুক্তি"},
                0
        ));

// প্রশ্ন 22
        questionList.add(new Question(
                "22. নিচের কোন ডিভাইস ডেটা ফিল্টার করতে পারে?",
                new String[]{"মডেম", "রাউটার", "সুইচ", "হাব"},
                2
        ));

// প্রশ্ন 23
        questionList.add(new Question(
                "23. নিচের কোন ডিভাইসটি মডুলেটর ও ডিমডুলেটর হিসেবে কাজ করে?",
                new String[]{"মডেম", "সুইচ", "হাব", "রাউটার"},
                0
        ));

// প্রশ্ন 24
        questionList.add(new Question(
                "24. নিচের কোন টপোলজিতে কোনো কেন্দ্রীয় কম্পিউটার থাকে না?",
                new String[]{"রিং টপোলজি", "স্টার টপোলজি", "বাস টপোলজি", "মেশ টপোলজি"},
                0
        ));

// প্রশ্ন 25
        questionList.add(new Question(
                "25. বাস টপোলজির প্রধান অসুবিধা কী?",
                new String[]{"সহজ ইনস্টলেশন", "দ্রুত তথ্য স্থানান্তর", "প্রধান ক্যাবল নষ্ট হলে নেটওয়ার্ক বন্ধ", "স্বতঃস্ফূর্ত মেরামত"},
                2
        ));


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
                Toast.makeText(Activity23.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
