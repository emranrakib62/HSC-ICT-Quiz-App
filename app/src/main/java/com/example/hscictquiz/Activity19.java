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

public class Activity19 extends AppCompatActivity {

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
        setContentView(R.layout.activity_19);

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
        questionList.add(new Question("1. তথ্য ও যোগাযোগ প্রযুক্তির বিকাশে সবচেয়ে বড় অবদান কোনটির?",
                new String[]{"ইন্টারনেট", "কম্পিউটার", "মোবাইল ফোন", "টেলিভিশন"}, 1));

        questionList.add(new Question("2. তথ্য প্রযুক্তি বলতে কি বোঝায়?",
                new String[]{"ডেটা সঞ্চয় ও ব্যবহার সম্পর্কিত প্রযুক্তি", "তথ্য সংগ্রহ এবং প্রক্রিয়া করার প্রযুক্তি", "কম্পিউটার নেটওয়ার্কিং", "প্রোগ্রামিং"}, 1));

        questionList.add(new Question("3. টেলিভিশন কি ধরনের যোগাযোগ ব্যবস্থা?",
                new String[]{"দ্বিমুখী যোগাযোগ ব্যবস্থা", "একমুখী যোগাযোগ ব্যবস্থা", "ইন্টারনেটভিত্তিক যোগাযোগ", "সরাসরি সম্প্রচার ব্যবস্থা"}, 1));

        questionList.add(new Question("4. গ্লোবাল ভিলেজ প্রতিষ্ঠায় সবচেয়ে বড় ভূমিকা কোনটির?",
                new String[]{"টেলিভিশন", "মোবাইল ফোন", "ইন্টারনেট", "রেডিও"}, 2));

        questionList.add(new Question("5. হার্বার্ট মার্শাল ম্যাকলুহান কোন দেশের বাসিন্দা ছিলেন?",
                new String[]{"যুক্তরাষ্ট্র", "কানাডা", "যুক্তরাজ্য", "অস্ট্রেলিয়া"}, 1));

        questionList.add(new Question("6. অনলাইনে ব্যবসা-বাণিজ্য করার নাম কি?",
                new String[]{"টেলিকমার্স", "ই-কমার্স", "ডিজিটাল মার্কেটিং", "সাইবার ট্রেডিং"}, 1));

        questionList.add(new Question("7. সবচেয়ে জনপ্রিয় সামাজিক যোগাযোগ মাধ্যম কোনটি?",
                new String[]{"Twitter", "Instagram", "Facebook", "LinkedIn"}, 2));

        questionList.add(new Question("8. গ্লোবাল ভিলেজ প্রতিষ্ঠায় সবচেয়ে গুরুত্বপূর্ণ উপাদান কি?",
                new String[]{"মোবাইল নেটওয়ার্ক", "ইন্টারনেট", "ক্যাবল টিভি", "রেডিও"}, 1));

        questionList.add(new Question("9. ই-কমার্স সম্পর্কিত কোন শব্দটি?",
                new String[]{"ডেবিট কার্ড", "ক্রেডিট কার্ড", "বিটকয়েন", "ডিজিটাল ওয়ালেট"}, 1));

        questionList.add(new Question("10. ভার্চুয়াল রিয়েলিটির বৈশিষ্ট্য কোনটি?",
                new String[]{"বাস্তব দৃশ্য প্রতিফলন", "কাল্পনিক জগতে বিচরণ", "কম্পিউটার এনিমেশন", "দুই মাত্রিক পরিবেশ"}, 1));

        questionList.add(new Question("11. এক্সপার্ট সিস্টেম বলতে কি?",
                new String[]{"অ্যালগরিদম", "অ্যাপ্লিকেশন", "প্রোগ্রামিং ভাষা", "ডাটাবেজ"}, 1));

        questionList.add(new Question("12. কৃত্রিম বুদ্ধিমত্তা দিয়ে রোবটের কাজ কীভাবে উন্নত করা হয়?",
                new String[]{"মেশিন লার্নিং", "অ্যালগরিদমের মাধ্যমে", "হার্ডওয়্যার আপগ্রেড", "ডাটা এনালিটিক্স"}, 1));

        questionList.add(new Question("13. কোনটি কম্পিউটার সিস্টেমের অংশ নয়?",
                new String[]{"নিজস্ব বুদ্ধি", "অপারেটিং সিস্টেম", "স্টোরেজ", "প্রসেসর"}, 0));

        questionList.add(new Question("14. মানুষের জন্য কঠিন কাজগুলো কোন প্রযুক্তি দিয়ে সহজ হয়?",
                new String[]{"বায়োমেট্রিক্স", "কৃত্রিম বুদ্ধিমত্তা", "ক্লাউড কম্পিউটিং", "বিগ ডাটা"}, 1));

        questionList.add(new Question("15. অত্যধিক ঠান্ডায় টিস্যুর ওপর কোন পদ্ধতি ব্যবহৃত হয়?",
                new String[]{"জেনেটিক ইঞ্জিনিয়ারিং", "ক্রায়োসার্জারি", "ন্যানোটেকনোলজি", "রেডিওথেরাপি"}, 1));

        questionList.add(new Question("16. ক্রায়োগ্রোব বলতে কি বোঝায়?",
                new String[]{"মাইক্রোচিপ", "ক্রায়োসার্জারিতে ব্যবহৃত পেন্সিলের মতো যন্ত্র", "জেনেটিক কোড", "ডিএনএ বিশ্লেষণ"}, 1));

        questionList.add(new Question("17. চাঁদে অবতরণকারী প্রথম মানব মহাকাশযানটি কী?",
                new String[]{"সয়ুজ", "অ্যাপোলো-১১", "ভোস্টক-১", "চ্যালেঞ্জার"}, 1));

        questionList.add(new Question("18. BRRI এর ব্যবহৃত প্রযুক্তি কোনটি?",
                new String[]{"বায়োমেট্রিক্স", "জেনেটিক ইঞ্জিনিয়ারিং", "ন্যানোটেকনোলজি", "মাইক্রোচিপ"}, 1));

        questionList.add(new Question("19. আণবিক পর্যায়ে ধাতু পরিবর্তন ও নিয়ন্ত্রণ করার প্রযুক্তি কোনটি?",
                new String[]{"কৃত্রিম বুদ্ধিমত্তা", "ন্যানোটেকনোলজি", "জেনেটিক ইঞ্জিনিয়ারিং", "বায়োইনফরমেটিক্স"}, 1));

        questionList.add(new Question("20. কম্পিউটার অপরাধের মধ্যে কী অন্তর্ভুক্ত?",
                new String[]{"স্প্যাম ইমেল", "সফটওয়্যার পাইরেসি, প্লেজিয়ারিজম, ডেটা চুরি", "ফিশিং", "ভাইরাস অ্যাটাক"}, 1));

        questionList.add(new Question("21. কোন প্রযুক্তির মাধ্যমে বিভিন্ন হরমোন তৈরি করা যায়?",
                new String[]{"বায়োমেট্রিক্স", "জেনেটিক ইঞ্জিনিয়ারিং", "ন্যানোটেকনোলজি", "রোবোটিক্স"}, 1));

        questionList.add(new Question("22. জিন ফাইন্ডিং গবেষণায় কোন প্রযুক্তি ব্যবহৃত হয়?",
                new String[]{"বায়োইনফরমেটিক্স", "জেনেটিক ইঞ্জিনিয়ারিং", "মেশিন লার্নিং", "বায়োমেট্রিক্স"}, 0));

        questionList.add(new Question("23. নতুন পণ্যের ডিজাইন তৈরিতে কোন প্রযুক্তি প্রয়োজন?",
                new String[]{"CAD", "CAM", "3D Printing", "AI"}, 0));

        questionList.add(new Question("24. মহাকাশে প্রথম চন্দ্রযান পাঠিয়েছিল কোন দেশ?",
                new String[]{"যুক্তরাষ্ট্র", "সোভিয়েত ইউনিয়ন", "চীন", "জাপান"}, 1));

        questionList.add(new Question("25. মানুষ প্রথম চাঁদে অবতরণ করে কোন সালে?",
                new String[]{"১৯৫৭", "১৯৬৯", "১৯৭৫", "১৯৮১"}, 1));

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
                Toast.makeText(Activity19.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
