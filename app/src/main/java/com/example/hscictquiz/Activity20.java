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

public class Activity20 extends AppCompatActivity {

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
        setContentView(R.layout.activity_20);

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
        questionList.add(new Question("1. কোন প্রযুক্তির মাধ্যমে রোগী দূরের ডাক্তারের সাথে সেবা গ্রহণ করতে পারে?",
                new String[]{"ই-মেইল", "টেলিফোন", "ভিডিও কনফারেন্স", "মেসেজিং"}, 3));

        questionList.add(new Question("2. স্কাইপি কী?",
                new String[]{"সামাজিক যোগাযোগ প্ল্যাটফর্ম", "ভিডিও চ্যাট সেবা", "ফাইল আদান-প্রদান সিস্টেম", "অনলাইন বাজার"}, 2));

        questionList.add(new Question("3. তথ্য প্রযুক্তি ও যোগাযোগ প্রযুক্তি-",
                new String[]{"ব্যয় কমাতে সাহায্য করে", "ব্যয় বাড়ায়", "কাজের গতি মন্থর করে", "সংযোগ বিছিন্ন করে"}, 1));

        questionList.add(new Question("4. ‘বিশ্বগ্রাম’ ধারণার সাথে কোন বিষয়টি বিশেষভাবে যুক্ত?",
                new String[]{"ইন্টারনেটের বিস্তার", "টেলিভিশনের উন্নয়ন", "বেতার সম্প্রসারণ", "পত্রিকার জনপ্রিয়তা"}, 2));

        questionList.add(new Question("5. কোন উপায়ে একটি বিজ্ঞাপন বিশ্বব্যাপী ছড়ানো যেতে পারে?",
                new String[]{"ওয়েবসাইটে প্রকাশ করা", "ব্যানার তৈরি করা", "লোকজনের কাছে প্রচার করা", "বিজ্ঞাপন বোর্ড ব্যবহার করা"}, 3));

        questionList.add(new Question("6. আউটসোর্সিং বলতে কী বুঝায়?",
                new String[]{"ইন্টারনেটভিত্তিক কাজ", "বিদেশি বিনিয়োগ", "স্থানীয় ব্যবসা", "কর্মসংস্থান প্রকল্প"}, 1));

        questionList.add(new Question("7. দেশের অর্থনীতির অগ্রগতিতে কী নতুন পরিবর্তন এনেছে?",
                new String[]{"আউটসোর্সিং", "রপ্তানি", "অর্থ প্রেরণ", "ব্যাংকিং সেবা"}, 2));

        questionList.add(new Question("8. আউটসোর্সিং-এর জন্য কোন প্ল্যাটফর্মটি ব্যবহৃত হয়?",
                new String[]{"ওডেস্ক", "ফেসবুক", "টুইটার", "ইনস্টাগ্রাম"}, 3));

        questionList.add(new Question("9. হারবার্ট মার্শাল ম্যাকলুহান-এর কোন বইটি বিখ্যাত?",
                new String[]{"The Gutenberg Galaxy: The Making of Typographic Man", "The Medium is the Message", "Understanding Media", "Digital Revolution"}, 0));

        questionList.add(new Question("10. ভার্চুয়াল রিয়েলিটি ব্যবহার করতে যে যন্ত্রটি পরতে হয় তা কী?",
                new String[]{"ডেটা গ্লাভ", "VR গগলস", "হেডফোন", "কন্ট্রোলার"}, 1));

        questionList.add(new Question("11. ভার্চুয়াল রিয়েলিটিতে কোন উপাদানটি ব্যবহৃত হয়?",
                new String[]{"ত্রিমাত্রিক সিমুলেশন", "ডিজিটাল ক্যামেরা", "ওয়েব ব্রাউজার", "স্মার্টফোন"}, 0));

        questionList.add(new Question("12. কৃত্রিম বুদ্ধিমত্তার একটি গুরুত্বপূর্ণ শাখা কী?",
                new String[]{"মেশিন লার্নিং", "ডেটাবেস ম্যানেজমেন্ট", "ওয়েব ডেভেলপমেন্ট", "ক্লাউড কম্পিউটিং"}, 3));

        questionList.add(new Question("13. কৃত্রিম বুদ্ধিমত্তার সেরা উদাহরণ কোনটি?",
                new String[]{"অ্যালেক্সা", "স্মার্টফোন", "স্মার্ট টিভি", "ইন্টারনেট"}, 2));

        questionList.add(new Question("14. রোবটের কোন ব্যবহার রয়েছে?",
                new String[]{"জটিল সার্জারি", "গাড়ি চালানো", "ফাইল ম্যানেজমেন্ট", "ডাটা এন্ট্রি"}, 1));

        questionList.add(new Question("15. কোন পদ্ধতিতে অ্যাকচুয়েটর ব্যবহৃত হয়?",
                new String[]{"রোবোটিক্স", "ডেটা সায়েন্স", "বায়োমেট্রিক্স", "অ্যানিমেশন"}, 2));

        questionList.add(new Question("16. কোন রোগে ক্রায়োসার্জারি ব্যবহার করা হয়?",
                new String[]{"চর্ম রোগ", "ডায়াবেটিস", "হৃদরোগ", "ক্যান্সার"}, 3));

        questionList.add(new Question("17. মহাকাশযানে প্রথম নারী হিসেবে কে যাত্রা করেন?",
                new String[]{"ভ্যালেনটিনা তেরেশকোভা", "সালি রাইড", "ইলেন মুস", "ক্যালি রাইড"}, 1));

        questionList.add(new Question("18. প্রথম কৃত্রিম উপগ্রহ পৃথিবী থেকে কোন দেশ উৎক্ষেপণ করেছিল?",
                new String[]{"সোভিয়েত ইউনিয়ন", "যুক্তরাষ্ট্র", "চীন", "ভারত"}, 2));

        questionList.add(new Question("19. প্রথম রোবট মহাকাশযান কোথায় পাঠানো হয়?",
                new String[]{"মঙ্গলগ্রহ", "চাঁদ", "বৃহস্পতির দিকে", "শুক্রগ্রহ"}, 3));

        questionList.add(new Question("20. মোবাইল সিম ক্রয়ে কোন প্রযুক্তি ব্যবহার করা হয়?",
                new String[]{"বায়োমেট্রিক্স", "ক্লাউড কম্পিউটিং", "কিউআর কোড", "এনএফসি"}, 0));

        questionList.add(new Question("21. মানুষের শারীরিক বৈশিষ্ট্যগুলির মধ্যে কোনটি গুরুত্বপূর্ণ?",
                new String[]{"চোখের মণি, আঙুলের ছাপ, DNA", "চুলের রঙ, উচ্চতা, ওজন", "গায়ের রঙ, নাকের আকার", "কণ্ঠস্বর, হাঁটার ধরন"}, 1));

        questionList.add(new Question("22. DNA-সমূহ প্রাণীর কোষের নিউক্লিয়াসে প্রবেশ করানোর জন্য কোন পদ্ধতি ব্যবহৃত হয়?",
                new String[]{"মাইক্রো ইনজেকশন", "ন্যানো বট", "বায়োপ্রিন্টিং", "জেনেটিক কোডিং"}, 2));

        questionList.add(new Question("23. ন্যানো প্রযুক্তির জনক হিসেবে কাকে বিবেচনা করা হয়?",
                new String[]{"রিচার্ড ফাইনম্যান", "আলান টুরিং", "আইজ্যাক নিউটন", "স্টিফেন হকিং"}, 3));

        questionList.add(new Question("24. কম্পিউটার অপরাধের মধ্যে কোনটি অন্তর্ভুক্ত?",
                new String[]{"কপিরাইট লঙ্ঘন, অশ্লীল ভিডিও প্রচার, নতুন ব্যাংক একাউন্ট খোলা", "হার্ডওয়্যার চুরি", "ফাইল কম্প্রেশন", "ওয়েব ব্রাউজিং"}, 1));

        questionList.add(new Question("25. ফেসবুক পেজ থেকে গল্প নিয়ে হাসান তার নামে মাদ্রাসা ম্যাগাজিনে ছাপিয়ে দিয়েছে। রাফার কাজটি কোন ধরনের?",
                new String[]{"প্লেজিয়ারিজম", "অভিনব গবেষণা", "সাংবাদিকতা", "ডিজিটাল মার্কেটিং"}, 2));

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
                Toast.makeText(Activity20.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
