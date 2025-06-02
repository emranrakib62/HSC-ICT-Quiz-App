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

public class Activity24 extends AppCompatActivity {

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
        setContentView(R.layout.activity_24);

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

        questionList.add(new Question("1. ট্রান্সমিশন সিস্টেম থেকে ডেটা সিগন্যাল গ্রহণের জন্য কোন ডিভাইসটি ব্যবহৃত হয়?",
                new String[]{"ট্রান্সমিটার", "রমডেম", "কম্পিউটার", "সিগন্যাল এনকোডার"}, 1)); // Correct answer is option 2 (index 1)

        questionList.add(new Question("2. ডেটা স্থানান্তরের গতি বা হারকে কী বলা হয়?",
                new String[]{"ব্যান্ডউইথ", "বিট রেট", "প্যাকেট রেট", "ফ্রিকোয়েন্সি"}, 0)); // Correct answer is option 1 (index 0)

        questionList.add(new Question("3. যখন একটি চ্যানেল প্রতি সেকেন্ডে ৪৪০০ বিট ডেটা স্থানান্তরিত করে, তখন তার ব্যান্ডউইথ কত হবে?",
                new String[]{"৪৪০০ Kbps", "৪৪০০ bps", "৪৪০০ Gbps", "৪৪০০ Mbps"}, 1)); // Correct answer is option 2 (index 1)

        questionList.add(new Question("4. ডেটা ট্রান্সমিশনের একক কোনটি?",
                new String[]{"Gbps", "bps", "Mbps", "Hz"}, 1)); // Correct answer is option 2 (index 1)

        questionList.add(new Question("5. কম্পিউটার ও প্রজেক্টরের মধ্যে ডেটা সঞ্চালন কোন ধরনের মোডে হয়?",
                new String[]{"হাফ-ডুপ্লেক্স", "সিমপ্লেক্স", "ফুল-ডুপ্লেক্স", "ডুয়াল-মোড"}, 1)); // Correct answer is option 2 (index 1)

        questionList.add(new Question("6. ট্যুইস্টেড পেয়ার ক্যাবলের সাধারণ রঙ কী?",
                new String[]{"সাদা", "কালো", "লাল", "নীল"}, 0)); // Correct answer is option 1 (index 0)

        questionList.add(new Question("7. কে-অ্যাক্সিয়াল ক্যাবল সাধারণত কীভাবে ডেটা প্রেরণ করে?",
                new String[]{"200 Mbps", "1 Gbps", "10 Mbps", "500 Mbps"}, 0)); // Correct answer is option 1 (index 0)

        questionList.add(new Question("8. ডেটা ট্রান্সমিশন কোন মোডে সাধারণত ব্যবহার হয়?",
                new String[]{"ফুল-ডুপ্লেক্স", "হাফ-ডুপ্লেক্স", "সিমপ্লেক্স", "ডুয়াল-মোড"}, 1)); // Correct answer is option 2 (index 1)

        questionList.add(new Question("9. অপটিক্যাল ফাইবারের মাধ্যমে ডেটা কিভাবে প্রেরণ করা হয়?",
                new String[]{"রেডিও তরঙ্গ", "আলোর মাধ্যমে", "ইলেকট্রনিক সংকেত", "ম্যাগনেটিক সংকেত"}, 1)); // Correct answer is option 2 (index 1)

        questionList.add(new Question("10. অপটিক্যাল ফাইবার কিভাবে তৈরি হয়?",
                new String[]{"তামা", "কাঁচের তন্তু", "আলুমিনিয়াম", "স্টেইনলেস স্টিল"}, 1)); // Correct answer is option 2 (index 1)

        questionList.add(new Question("11. কো-অ্যাক্সিয়াল ক্যাবলের অন্যতম সুবিধা কী?",
                new String[]{"ট্রান্সমিশন লস কম", "বেশি গতি", "কম খরচ", "নিরাপদ সংযোগ"}, 0)); // Correct answer is option 1 (index 0)

        questionList.add(new Question("12. WIMAX টাওয়ার সর্বাধিক কত মাইল পর্যন্ত সেবা প্রদান করতে পারে?",
                new String[]{"১০০", "৫০", "৩০", "২০"}, 1)); // Correct answer is option 3 (index 2)

        questionList.add(new Question("13. একাধিক দেশের মধ্যে যোগাযোগের জন্য কোনটি ব্যবহার করা হয়?",
                new String[]{"স্যাটেলাইট", "ওয়াইফাই", "অপটিক্যাল ফাইবার", "এডিএসএল"}, 0)); // Correct answer is option 1 (index 0)

        questionList.add(new Question("14. দেশের অভ্যন্তরে যোগাযোগের জন্য কোনটি ব্যবহার করা হয়?",
                new String[]{"টেরিস্ট্রিয়াল", "স্যাটেলাইট", "ইন্টারনেট", "বেতার সংযোগ"}, 0)); // Correct answer is option 1 (index 0)

        questionList.add(new Question("15. Wi-Max বেস স্টেশন কত দূরত্ব পর্যন্ত ইন্টারনেট সংযোগ প্রদান করতে পারে?",
                new String[]{"10 km-50 km", "1 km-10 km", "50 km-100 km", "100 km-500 km"}, 1)); // Correct answer is option 2 (index 1)

        questionList.add(new Question("16. মোবাইল ফোনের আবিষ্কারক কে?",
                new String[]{"ড. সিগমন্ড ফ্রয়েড", "ড. মার্টিন কুপার", "অ্যালান টিউরিং", "জেসন শো"}, 1)); // Correct answer is option 2 (index 1)

        questionList.add(new Question("17. চতুর্থ প্রজন্মের মোবাইল প্রযুক্তি কোনটি?",
                new String[]{"Wi-Fi, 4G, 5G", "GPRS, EDGE, 4G", "WiMax, 3GPP LTE, ওয়াইফাই", "CDMA, 3G, Wi-Fi"}, 2)); // Correct answer is option 3 (index 2)

        questionList.add(new Question("18. একই ভবনে বিভিন্ন কক্ষে কম্পিউটার নেটওয়ার্ক কিভাবে সংযুক্ত করা হয়?",
                new String[]{"LAN", "WAN", "MAN", "PAN"}, 0)); // Correct answer is option 1 (index 0)

        questionList.add(new Question("19. WAN নেটওয়ার্ক মূলত কোন ধরনের?",
                new String[]{"একটি শহর কেন্দ্রিক নেটওয়ার্ক", "বিশ্বব্যাপী নেটওয়ার্ক", "একটি অফিস নেটওয়ার্ক", "একটি কক্ষ নেটওয়ার্ক"}, 1)); // Correct answer is option 2 (index 1)

        questionList.add(new Question("20. কয়েকটি ভিন্ন নেটওয়ার্ক সংযুক্ত করার জন্য কোন ডিভাইসটি ব্যবহৃত হয়?",
                new String[]{"সুইচ", "রাউটার", "মডেম", "হাব"}, 1)); // Correct answer is option 2 (index 1)

        questionList.add(new Question("21. কোন ডিভাইসটি অ্যানালগ সংকেতকে ডিজিটাল সংকেতে রূপান্তরিত করে?",
                new String[]{"ব্রিজ", "মডেম", "হাব", "রাউটার"}, 1)); // Correct answer is option 2 (index 1)

        questionList.add(new Question("22. কম্পিউটার নেটওয়ার্কে কয় ধরনের টপোলজি ব্যবহার করা হয়?",
                new String[]{"৪", "৬", "৩", "৫"}, 1)); // Correct answer is option 2 (index 1)

        questionList.add(new Question("23. একটি কেন্দ্রীয় কম্পিউটারের সাথে একাধিক কম্পিউটার সংযুক্ত হওয়ার সংগঠনটি কী?",
                new String[]{"রিং টপোলজি", "স্টার টপোলজি", "হাইব্রিড টপোলজি", "বুশ টপোলজি"}, 1)); // Correct answer is option 2 (index 1)

        questionList.add(new Question("24. অপটিক্যাল ফাইবারের প্রধান সুবিধা কী?",
                new String[]{"কম লস এবং উচ্চ গতিতে ডেটা প্রেরণ", "কম খরচ", "সহজ রক্ষণাবেক্ষণ", "নিরাপদ সংযোগ"}, 0)); // Correct answer is option 1 (index 0)

        questionList.add(new Question("25. Wi-Fi সিগন্যাল কত দুরত্ব পর্যন্ত কাজ করতে পারে?",
                new String[]{"৫০০ মিটার", "১০০ মিটার", "২০০ মিটার", "৩০০ মিটার"}, 1)); // Correct answer is option 2 (index 1)



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
                Toast.makeText(Activity24.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
