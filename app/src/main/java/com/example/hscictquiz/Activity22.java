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

public class Activity22 extends AppCompatActivity {

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
        setContentView(R.layout.activity_22);

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


        questionList.add(new Question("1. কমিউনিকেশন বলতে কী বোঝায়?",
                new String[]{"ডাটা সংরক্ষণ", "বার্তা প্রেরণ, তথ্য প্রবাহ ও গ্রহণ", "নেটওয়ার্কিং ডিভাইস", "ইনপুট/আউটপুট"}, 1));

        questionList.add(new Question("2. ন্যারোব্যান্ড সাধারণত কোথায় ব্যবহৃত হয়?",
                new String[]{"Wi-Fi", "টেলিগ্রাফ", "ব্রডব্যান্ড", "স্যাটেলাইট"}, 1));

        questionList.add(new Question("3. ন্যারোব্যান্ড টেলিফোনের ফ্রিকোয়েন্সি পরিসীমা কত?",
                new String[]{"১০০-২০০০ Hz", "৩০০-৩৪০০ Hz", "৫০০০-১০০০০ Hz", "১০০০০-২০০০০ Hz"}, 1));

        questionList.add(new Question("4. অ্যাসিনক্রোনাস ডেটা ট্রান্সমিশনের সুবিধা কী?",
                new String[]{"উচ্চ ব্যান্ডউইডথ", "প্রাইমারি স্টোরেজ ডিভাইসের প্রয়োজন নেই", "কম খরচের হার্ডওয়্যার", "উচ্চ নির্ভরযোগ্যতা"}, 2));

        questionList.add(new Question("5. ব্রডকাস্ট মোডের একটি উদাহরণ কী?",
                new String[]{"LAN", "টেলিভিশন সম্প্রচার", "Wi-Fi", "ব্লুটুথ"}, 1));

        questionList.add(new Question("6. কো-এক্স ক্যাবলের তারের চারপাশে কী থাকে?",
                new String[]{"কপার শিল্ড", "প্লাস্টিক ইনসুলেশন", "গ্লাস কভার", "অ্যালুমিনিয়াম স্তর"}, 0));

        questionList.add(new Question("7. ডেটা ট্রান্সমিশনের মোড কয়টি?",
                new String[]{"১", "২", "৩", "৪"}, 2));

        questionList.add(new Question("8. ব্রডব্যান্ড নেটওয়ার্ক ব্যবহারের সুবিধা কী?",
                new String[]{"কম গতির ডেটা", "উচ্চ গতির ডেটা ট্রান্সমিশন", "সীমিত ব্যান্ডউইডথ", "বিলম্ব বেশি"}, 1));

        questionList.add(new Question("9. অপটিক্যাল ফাইবার ক্যাবলের সুবিধা কী?",
                new String[]{"ধীরগতির সংযোগ", "রক্ষণাবেক্ষণ কঠিন", "উচ্চ গতির ডেটা স্থানান্তর", "চৌম্বকীয় প্রভাব সংবেদনশীল"}, 2));

        questionList.add(new Question("10. নিম্নলিখিত ক্যাবলগুলোর মধ্যে সবচেয়ে ব্যয়বহুল কোনটি?",
                new String[]{"কো-এক্স ক্যাবল", "টুইস্টেড পেয়ার ক্যাবল", "অপটিক্যাল ফাইবার", "কপার ক্যাবল"}, 2));

        questionList.add(new Question("11. বিশ্বব্যাপী অপটিক্যাল ফাইবার কীভাবে স্থাপন করা হয়েছে?",
                new String[]{"বাতাসে", "ভূগর্ভে", "সমুদ্রের নিচে", "উচ্চ ক্ষমতাসম্পন্ন সিগন্যালের মাধ্যমে"}, 2));

        questionList.add(new Question("12. কোন ক্যাবল ব্যাকবোন ক্যাবল হিসেবে বেশি ব্যবহৃত হয়?",
                new String[]{"কো-এক্স ক্যাবল", "অপটিক্যাল ফাইবার", "টুইস্টেড পেয়ার ক্যাবল", "ইথারনেট ক্যাবল"}, 1));

        questionList.add(new Question("13. অপটিক্যাল ফাইবার ক্যাবলের অন্যতম সুবিধা কী?",
                new String[]{"দ্রুতগতিতে ডেটা স্থানান্তর", "রক্ষণাবেক্ষণ কঠিন", "চৌম্বকীয় প্রভাব সংবেদনশীল", "উচ্চ মূল্যে পাওয়া যায়"}, 0));

        questionList.add(new Question("14. ব্লুটুথের মাধ্যমে তৈরি নেটওয়ার্ককে কী বলা হয়?",
                new String[]{"LAN", "MAN", "WAN", "PAN"}, 3));

        questionList.add(new Question("15. হটস্পট কী?",
                new String[]{"তারযুক্ত নেটওয়ার্ক", "তারবিহীন ইন্টারনেট সংযোগ", "ডাটা সংরক্ষণ পদ্ধতি", "ওয়াইফাই এনক্রিপশন"}, 1));

        questionList.add(new Question("16. মাইক্রোওয়েভের ফ্রিকোয়েন্সি পরিসীমা কত?",
                new String[]{"3MHz-30MHz", "30MHz-300MHz", "300MHz-30GHz", "30GHz-300GHz"}, 2));

        questionList.add(new Question("17. মোবাইল ফোনের কোন প্রজন্ম থেকে SMS সেবা চালু হয়?",
                new String[]{"প্রথম", "দ্বিতীয়", "তৃতীয়", "চতুর্থ"}, 1));

        questionList.add(new Question("18. 4G নেটওয়ার্কে সর্বোচ্চ ডেটা ট্রান্সফারের হার কত?",
                new String[]{"10 Mbps", "50 Mbps", "100 Mbps", "1 Gbps"}, 2));

        questionList.add(new Question("19. ব্লুটুথ নেটওয়ার্ক কী তৈরি করে?",
                new String[]{"LAN", "MAN", "WAN", "PAN"}, 3));

        questionList.add(new Question("20. কোন নেটওয়ার্ক সিস্টেমের পরিসর কয়েক মিটারের মধ্যে সীমাবদ্ধ?",
                new String[]{"LAN", "MAN", "WAN", "PAN"}, 3));

        questionList.add(new Question("21. একটি বিল্ডিংয়ের বিভিন্ন তলায় থাকা পাঁচটি কম্পিউটার থেকে একটি প্রিন্টারে প্রিন্ট করার জন্য কোন নেটওয়ার্ক সবচেয়ে উপযুক্ত?",
                new String[]{"LAN", "MAN", "WAN", "PAN"}, 0));

        questionList.add(new Question("22. বিভিন্ন নেটওয়ার্ক প্রোটোকল সংযুক্ত করতে কোন ডিভাইস ব্যবহার করা হয়?",
                new String[]{"হাব", "সুইচ", "গেটওয়ে", "রাউটার"}, 2));

        questionList.add(new Question("23. কোন ডিভাইস নির্দিষ্ট কম্পিউটারে সিগন্যাল পাঠাতে সহায়তা করে?",
                new String[]{"হাব", "সুইচ", "রাউটার", "মডেম"}, 1));

        questionList.add(new Question("24. নিচের কোনটি নেটওয়ার্ক টপোলজি?",
                new String[]{"BUS", "STAR", "RING", "TREE"}, 0));

        questionList.add(new Question("25. বাস টপোলজিতে ডাটা সংঘর্ষ এড়াতে কী ব্যবহার করা হয়?",
                new String[]{"সুইচ", "টার্মিনেটর", "রাউটার", "হাব"}, 1));


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
                Toast.makeText(Activity22.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
