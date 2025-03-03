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

public class Activity43 extends AppCompatActivity {

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
        setContentView(R.layout.activity_43);

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


        questionList.add(new Question("1. সরকারি ডেটাবেজের নিরাপত্তা কোন কারণে গুরুত্বপূর্ণ?",
                new String[] {"তথ্য প্রবাহ গতি বাড়ানো", "যাতে ব্যক্তিগত তথ্য সুরক্ষিত থাকে", "ডেটাবেজে ত্রুটি কমানো", "সর্বশেষ তথ্য প্রদান"}, 1));

        questionList.add(new Question("2. কোন ধরনের ডেটা এনক্রিপশন ব্যবহৃত হয়?",
                new String[] {"বাণিজ্যিক ডেটা", "ব্যক্তিগত ডেটা", "সামাজিক ডেটা", "সরকারি ডেটা"}, 3));

        questionList.add(new Question("3. ডেটাবেজের তথ্য পুনরুদ্ধার কী?",
                new String[] {"ফাইল সংরক্ষণ", "ডেটা এনক্রিপশন", "কুয়েরি ব্যবহার করে তথ্য সংগ্রহ", "তথ্য সংরক্ষণ"}, 2));

        questionList.add(new Question("4. ডেটা সিকিউরিটি জন্য কোন পদ্ধতি ব্যবহার করা হয়?",
                new String[] {"ফাইল ব্যবস্থাপনা", "ব্যক্তিগত তথ্য এনক্রিপশন", "ডেটাবেজ আর্কিটেকচার", "ডেটাবেজ পুনরুদ্ধার"}, 1));

        questionList.add(new Question("5. ডেটাবেজের তথ্য বিশ্লেষণ পদ্ধতি কী?",
                new String[] {"ডেটা সুরক্ষা ব্যবস্থাপনা", "ডেটাবেজের আর্কিটেকচার তৈরি করা", "ডেটা কুয়েরি ব্যবহার করে বিশ্লেষণ", "ডেটা ইন্ডেক্সিং পদ্ধতি"}, 2));

        questionList.add(new Question("6. ডেটাবেজের তথ্য বিশ্লেষণ পদ্ধতি কী?",
                new String[] {"কুয়েরি এবং রিপোর্ট তৈরি", "তথ্য এক্সপোর্ট", "ডেটাবেজ তৈরি", "তথ্য এনক্রিপশন"}, 0));

        questionList.add(new Question("7. ডেটাবেজ টেবিলের কলাম কী?",
                new String[] {"ডেটার একটি সংগ্রহ", "ডেটাবেজের ট্যাগ", "ডেটার একটি নির্দিষ্ট ধরনের স্থান", "তথ্য প্রবাহের স্থান"}, 2));

        questionList.add(new Question("8. ডেটাবেজে কীভাবে ডেটা সংরক্ষণ করা হয়?",
                new String[] {"ফাইল, কোড ও ডিরেক্টরি", "কুয়েরি এবং রিটার্ন দ্বারা", "টেবিল, কলাম ও রো দ্বারা", "তথ্য আর্কাইভিং দ্বারা"}, 2));

        questionList.add(new Question("9. DBMS এর কার্যকারিতা কী?",
                new String[] {"ডেটা বিশ্লেষণ এবং আউটপুট প্রদান", "ফাইল সংরক্ষণ ও ব্যাকআপ", "ডেটা পরিচালনা, সুরক্ষা, এবং পুনরুদ্ধার", "তথ্য এনক্রিপশন ও ইন্ডেক্সিং"}, 2));

        questionList.add(new Question("10. SQL এর ‘SELECT’ কুয়েরি কী কাজ করে?",
                new String[] {"ডেটাবেজে নতুন তথ্য সংযুক্ত করা", "ডেটাবেজ তথ্য মুছে ফেলা", "ডেটাবেজ আপডেট করা", "ডেটাবেজ থেকে তথ্য নির্বাচন করা"}, 3));

        questionList.add(new Question("11. SQL এর ‘INSERT’ কুয়েরি কী কাজ করে?",
                new String[] {"তথ্য নির্বাচিত করা", "ডেটাবেজের তথ্য আপডেট করা", "নতুন ডেটা সন্নিবেশ করা", "তথ্য মুছে ফেলা"}, 2));

        questionList.add(new Question("12. ডেটাবেজের জন্য নিরাপত্তা ব্যবস্থা কেন গুরুত্বপূর্ণ?",
                new String[] {"ডেটাবেজ ম্যানেজমেন্ট", "তথ্য বিশ্লেষণ করা", "তথ্য সুরক্ষিত রাখা", "ডেটা পুনরুদ্ধারের সুবিধা"}, 2));

        questionList.add(new Question("13. DBMS কীভাবে ব্যবহারকারীর ডেটা সুরক্ষা করে?",
                new String[] {"ডেটা ফাইলিং", "ডেটা এক্সপোর্টিং", "ইউজার অথেনটিকেশন ও অথোরাইজেশন", "ডেটা এনক্রিপশন"}, 2));

        questionList.add(new Question("14. SQL-এর ‘DELETE’ কুয়েরি কী কাজ করে?",
                new String[] {"ডেটাবেজ থেকে তথ্য মুছে ফেলা", "ডেটাবেজ আপডেট করা", "নতুন তথ্য সংযুক্ত করা", "তথ্য নির্বাচিত করা"}, 0));

        questionList.add(new Question("15. ডেটাবেজের টেবিল কী?",
                new String[] {"ডেটার কাঠামো এবং উপস্থাপনা", "ফাইল সিস্টেম", "ডেটা স্টোরেজ পদ্ধতি", "ডেটা এনক্রিপশন"}, 0));

        questionList.add(new Question("16. RDBMS এ টেবিলের মধ্যে কীভাবে সম্পর্ক তৈরি হয়?",
                new String[] {"ফরেন কী সম্পর্ক", "অভ্যন্তরীণ কী সম্পর্ক", "ডেটা ফাইলিং পদ্ধতি", "একটি ডেটাবেজ স্কিমা"}, 0));

        questionList.add(new Question("17. ফাংশনাল ডেটাবেজের উপকারিতা কী?",
                new String[] {"ডেটার অর্গানাইজেশন এবং পুনরুদ্ধার", "ডেটা এনক্রিপশন", "ডেটাবেজ ম্যানেজমেন্ট", "ডেটা সিকিউরিটি"}, 0));

        questionList.add(new Question("18. ডেটাবেজের স্কিমা কী?",
                new String[] {"ডেটাবেজের কাঠামো এবং নীতিমালা", "ডেটার নিরাপত্তা ব্যবস্থা", "তথ্য প্রবাহ", "ডেটাবেজ ম্যানেজমেন্ট পদ্ধতি"}, 0));

        questionList.add(new Question("19. ডেটাবেজের কোয়ালিটি কী?",
                new String[] {"ডেটার সঠিকতা এবং সংগঠন", "ডেটা এনক্রিপশন", "ডেটা বিশ্লেষণ", "ডেটাবেজ আর্কিটেকচার"}, 0));

        questionList.add(new Question("20. SQL এর ‘UPDATE’ কুয়েরি কী কাজ করে?",
                new String[] {"ডেটাবেজের তথ্য আপডেট করা", "তথ্য মুছে ফেলা", "নতুন তথ্য যোগ করা", "তথ্য নির্বাচন করা"}, 0));

        questionList.add(new Question("21. ডেটাবেজের ‘ন্যাচারাল কী’ কী?",
                new String[] {"প্রাকৃতিকভাবে বিশিষ্ট এবং ইউনিক তথ্য", "ফরেন কী", "ডেটা রিলেশন", "একটি ফাইল সিস্টেম"}, 0));

        questionList.add(new Question("22. ডেটাবেজের ‘ফরেন কী’ কী?",
                new String[] {"একটি টেবিলের কলাম যা অন্য টেবিলের প্রাথমিক কী হতে পারে", "ফাংশনাল কী", "ডেটা ম্যানেজমেন্ট পদ্ধতি", "একটি ডেটা ফাইল"}, 0));

        questionList.add(new Question("23. ডেটাবেজের ‘প্রাথমিক কী’ কী?",
                new String[] {"একটি ইউনিক কলাম যা সঠিক ডেটা চিহ্নিত করে", "টেবিলের সাধারণ কলাম", "ফরেন কী", "ডেটা আপডেটের পদ্ধতি"}, 0));

        questionList.add(new Question("24. ডেটাবেজের ‘ট্রানজেকশন’ কী?",
                new String[] {"একটি একক কাজ বা অপারেশন", "ডেটাবেজ তৈরি", "ডেটাবেজের স্কিমা", "ডেটা এক্সপোর্ট"}, 0));

        questionList.add(new Question("25. SQL কুয়েরির ‘AND’ অপারেটর কীভাবে কাজ করে?",
                new String[] {"শর্ত অনুযায়ী দুটি কন্ডিশন সঠিক হলে ফলাফল প্রদান করা", "ডেটাবেজ আপডেট করা", "ডেটা ফিল্টার করা", "কুয়েরি নির্বাচন করা"}, 0));

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
                Toast.makeText(Activity43.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
