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

public class Activity18 extends AppCompatActivity {

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
        setContentView(R.layout.activity_18);

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
        questionList.add(new Question("1.বর্তমানের অধিকাংশ যোগাযোগ ও সম্প্রচার ব্যবস্থা মূলত কোন উপাদানের উপর নির্ভরশীল?",
                new String[]{"ইন্টারনেট", "স্যাটেলাইট", "মোবাইল ফোন", "টেলিভিশন"}, 1));

        questionList.add(new Question("2.বিশ্বগ্রাম ধারণার প্রবর্তক কে?",
                new String[]{"নয়েল কিপ", "মার্শাল ম্যাকলুহান", "ইভান পিটারসন", "টিম বার্নার লি"}, 1));

        questionList.add(new Question("3.বিশ্বগ্রাম প্রতিষ্ঠায় সবচেয়ে গুরুত্বপূর্ণ ভূমিকা কোনটি পালন করেছে?",
                new String[]{"টেলিফোন", "টেলিভিশন", "ইন্টারনেট", "মোবাইল ফোন"}, 2));

        questionList.add(new Question("4.www.khanacademy.org কোন ধরনের ওয়েবসাইট?",
                new String[]{"শিক্ষা বিষয়ক ওয়েবসাইট", "গেমিং ওয়েবসাইট", "ই-কমার্স ওয়েবসাইট", "ব্লগ সাইট"}, 0));

        questionList.add(new Question("5.প্লেজিয়ারিজম কী ধরনের অপরাধ?",
                new String[]{"চুরি", "কপিরাইট লঙ্ঘন", "মিথ্যা প্রমাণ", "অবৈধ হ্যাকিং"}, 1));

        questionList.add(new Question("6.বিশ্বগ্রাম কী বোঝায়?",
                new String[]{"বিশ্বের বিভিন্ন ভাষা", "বিশ্বের গ্রামের সম্পর্ক", "বিশ্বের বাণিজ্য", "বিশ্বের উন্নয়ন"}, 1));

        questionList.add(new Question("7.কোন তত্ত্বের ভিত্তিতে ভার্চুয়াল রিয়েলিটি তৈরি হয়?",
                new String[]{"সিমুলেশন তত্ত্ব", "ক্যাশ অন ডেলিভারি", "মোবাইল ব্যাংকিং", "ডেবিট কার্ড"}, 0));

        questionList.add(new Question("8.কম্পিউটার সিমুলেশন কোন ক্ষেত্রে ব্যবহৃত হয়?",
                new String[]{"অ্যাপ ডেভেলপমেন্ট", "ভার্চুয়াল রিয়েলিটি", "ইন্টারনেট ব্রাউজিং", "ক্যাশ ম্যানেজমেন্ট"}, 1));

        questionList.add(new Question("9.ভার্চুয়াল রিয়েলিটি ব্যবহারের কারণে মানুষ কী ধরনের পরিবর্তন অনুভব করতে পারে?",
                new String[]{"বাস্তবতা থেকে বিচ্যুত হতে পারে", "নতুন কিছু শিখতে পারে", "বহু ভাষায় কথা বলতে পারে", "একসাথে অনেক কাজ করতে পারে"}, 0));

        questionList.add(new Question("10.কৃত্রিম বুদ্ধিমত্তার সাহায্যে রোবট কী কাজ করতে পারে?",
                new String[]{"মানুষকে অনুসরণ করতে পারে", "স্বতঃস্ফূর্তভাবে কাজ করতে পারে", "এনিমেশন তৈরি করতে পারে", "কেবল কাজ করতে পারে"}, 1));

        questionList.add(new Question("11.রোবট কি স্বয়ংক্রিয়ভাবে কাজ করতে পারে?",
                new String[]{"না", "হ্যাঁ, কৃত্রিম বুদ্ধিমত্তার সাহায্যে", "হ্যাঁ, তবে কিছু নির্দেশনা প্রয়োজন", "না, এটি শুধু কম্পিউটার দ্বারা পরিচালিত"}, 1));

        questionList.add(new Question("12.রোবটিক্স কী?",
                new String[]{"রোবট বিজ্ঞান", "কম্পিউটার সায়েন্স", "এআই প্রযুক্তি", "বিশ্বব্যাপী যোগাযোগ প্রযুক্তি"}, 0));

        questionList.add(new Question("13.কোন সায়েন্স ফিকশন লেখক প্রথম রোবটিক্স শব্দটি ব্যবহার করেন?",
                new String[]{"আইজ্যাক অসিমভ", "আলবার্ট আইনস্টাইন", "স্টিফেন হকিং", "কার্ল সাগান"}, 0));

        questionList.add(new Question("14.ক্রায়ো সার্জারিতে নাইট্রোজেনের কোন অবস্থার প্রয়োগ করা হয়?",
                new String[]{"গ্যাস", "তরল", "কঠিন", "গলিত"}, 2));

        questionList.add(new Question("15.মহাকাশ গবেষণার জন্য প্রথম মহাকাশ কেন্দ্রের নাম কী?",
                new String[]{"কিসলিভস্কি মহাকাশ কেন্দ্র", "কেপ ক্যানাভেরাল", "বোস্টন স্পেস সেন্টার", "ভেনাস রিসার্চ সেন্টার"}, 0));

        questionList.add(new Question("16.পৃথিবীর কক্ষপথে প্রথম কৃত্রিম উপগ্রহটি কখন উৎক্ষেপিত হয়?",
                new String[]{"১৯৪৫ সালে", "১৯৫৭ সালে", "১৯৬১ সালে", "১৯৬৯ সালে"}, 1));

        questionList.add(new Question("17.প্রথম মহাকাশযানটি কোন দেশে তৈরি হয়?",
                new String[]{"যুক্তরাষ্ট্র", "সোভিয়েত ইউনিয়ন", "চীন", "ভারত"}, 1));

        questionList.add(new Question("18.মানুষকে ইউনিকভাবে শনাক্তকরণের প্রযুক্তি কী?",
                new String[]{"আইডেন্টিফিকেশন কার্ড", "বায়োমেট্রিক্স", "কিউআর কোড", "পাসওয়ার্ড সিস্টেম"}, 1));

        questionList.add(new Question("19.কোন প্রযুক্তি বায়োমেট্রিক্সে ব্যবহৃত হয়?",
                new String[]{"মোবাইল ফোন", "সেন্সর", "টাচ স্ক্রীন", "মোবাইল ক্যামেরা"}, 1));

        questionList.add(new Question("20.একজন ব্যক্তিকে অদ্বিতীয়ভাবে সনাক্ত করার প্রযুক্তি কোনটি?",
                new String[]{"রেটিনা স্ক্যান", "বায়োমেট্রিক্স", "ফেস রিকগনিশন", "স্মার্ট কার্ড"}, 1));

        questionList.add(new Question("21.জীবদেহে পরিবর্তন আনার জন্য কোন প্রযুক্তি প্রয়োজন?",
                new String[]{"জেনেটিক ইঞ্জিনিয়ারিং", "বায়োটেকনোলজি", "ন্যানোটেকনোলজি", "এআই প্রযুক্তি"}, 0));

        questionList.add(new Question("22.জীবদেহের ডিএনএ-এর বিভাজিত একক বৈশিষ্ট্য কোনটি?",
                new String[]{"জিন", "ক্রোমোজোম", "মলিকিউল", "এলিক্সি"}, 0));

        questionList.add(new Question("23.ন্যানো মানে কী?",
                new String[]{"10<sup>-12</sup>", "10<sup>-9</sup>", "10<sup>-6</sup>", "10<sup>-3</sup>"}, 1));

        questionList.add(new Question("24.স্মার্টফোন তৈরিতে ব্যবহৃত ক্ষুদ্র যন্ত্রাংশ ত্রুটিহীনভাবে স্থাপন সম্ভব হচ্ছে কোন প্রযুক্তির সাহায্যে?",
                new String[]{"জেনেটিক ইঞ্জিনিয়ারিং", "ন্যানোটেকনোলজি", "বায়োটেকনোলজি", "কম্পিউটার সিমুলেশন"}, 1));

        questionList.add(new Question("25.ইন্টারনেট ব্যবহার করে অন্যের কম্পিউটারে অবৈধভাবে অনুপ্রবেশ করাকে কী বলা হয়?",
                new String[]{"হ্যাকিং", "ফিশিং", "স্প্যামিং", "ভাইরাস ইঞ্জেকশন"}, 0));





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
                Toast.makeText(Activity18.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
