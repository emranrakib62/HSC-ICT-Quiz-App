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

public class Activity34 extends AppCompatActivity {

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
        setContentView(R.layout.activity_34);

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


        questionList.add(new Question("1. দশমিক সংখ্যা 8 এর বাইনারি রূপ কী?", new String[] {"100", "1000", "10000", "100000"}, 1));
        questionList.add(new Question("2. হেক্সাডেসিমেল সংখ্যা সিস্টেমে কয়টি ভিন্ন অক্ষর ও সংখ্যা ব্যবহৃত হয়?", new String[] {"8", "10", "12", "16"}, 3));
        questionList.add(new Question("3. অকটাল সংখ্যা 10 এর বাইনারি রূপ কী?", new String[] {"100", "1000", "1010", "1100"}, 1));
        questionList.add(new Question("4. বুলিয়ান বীজগণিতের প্রতিষ্ঠাতা কে?", new String[] {"আলবার্ট আইনস্টাইন", "জর্জ বুল", "ক্যারল ডব্লিউ", "থমাস এডিসন"}, 1));
        questionList.add(new Question("5. OR গেইটের বৈশিষ্ট্য কী?", new String[] {"সব ইনপুট 0 হলে আউটপুট 1", "অন্তত একটি ইনপুট 1 হলে আউটপুট 1", "সব ইনপুট 1 হলে আউটপুট 0", "সর্বদা আউটপুট 0"}, 1));
        questionList.add(new Question("6. একটি XOR গেইটের সত্যক সারণি কেমন হয়?", new String[] {"ইনপুট ভিন্ন হলে আউটপুট 0", "ইনপুট একই হলে আউটপুট 1", "ইনপুট ভিন্ন হলে আউটপুট 1", "এটি কোন সত্যক সারণি থাকে না"}, 2));
        questionList.add(new Question("7. NOR গেইট কিসের বিপরীত?", new String[] {"OR গেইটের বিপরীত", "AND গেইটের বিপরীত", "XOR গেইটের বিপরীত", "NAND গেইটের বিপরীত"}, 0));
        questionList.add(new Question("8. বুলিয়ান বীজগণিতে A + A = ?", new String[] {"A", "0", "1", "A' "}, 0));
        questionList.add(new Question("9. 1010 বাইনারি সংখ্যার দশমিক রূপ কী?", new String[] {"8", "10", "12", "14"}, 1));
        questionList.add(new Question("10. হেক্সাডেসিমেল সংখ্যা A এর দশমিক রূপ কী?", new String[] {"8", "10", "12", "14"}, 1));
        questionList.add(new Question("11. বাইনারি সংখ্যা 111 এর অকটাল রূপ কী?", new String[] {"5", "6", "7", "8"}, 2));
        questionList.add(new Question("12. দশমিক সংখ্যা 50 এর বাইনারি রূপ কী?", new String[] {"110001", "110010", "110100", "111001"}, 1));
        questionList.add(new Question("13. একটি NAND গেইটের সত্যক সারণি কেমন হয়?", new String[] {"AND গেইটের বিপরীত", "OR গেইটের বিপরীত", "XOR গেইটের বিপরীত", "NOT গেইটের বিপরীত"}, 0));
        questionList.add(new Question("14. অকটাল সংখ্যা 25 এর দশমিক রূপ কী?", new String[] {"20", "21", "22", "23"}, 1));
        questionList.add(new Question("15. 1111 বাইনারি সংখ্যার দশমিক রূপ কী?", new String[] {"13", "14", "15", "16"}, 2));
        questionList.add(new Question("16. বুলিয়ান বীজগণিতে A * 1 = ?", new String[] {"A", "0", "1", "A' "}, 0));
        questionList.add(new Question("17. ডিজিটাল ইলেকট্রনিক্সে ফ্লিপ-ফ্লপ কী কাজে ব্যবহৃত হয়?", new String[] {"ডাটা সংরক্ষণ এবং সিকোয়েন্সিয়াল লজিক ডিজাইনে", "এনালগ সিগন্যাল পদ্ধতি", "গণনার কাজ", "কেবল ইনপুট গ্রহণ"}, 0));
        questionList.add(new Question("18. বুলিয়ান বীজগণিতে A + 1 = ?", new String[] {"A", "0", "1", "A' "}, 2));
        questionList.add(new Question("19. দুই বিটের একটি বাইনারি সংখ্যা সর্বোচ্চ কত হতে পারে?", new String[] {"1", "2", "3", "4"}, 2));
        questionList.add(new Question("20. অকটাল সংখ্যা 77 এর দশমিক রূপ কী?", new String[] {"60", "62", "63", "64"}, 2));
        questionList.add(new Question("21. বাইনারি সংখ্যা 1001 এর দশমিক মান কী?", new String[] {"7", "8", "9", "10"}, 2));
        questionList.add(new Question("22. হেক্সাডেসিমেল সংখ্যা FF এর দশমিক মান কী?", new String[] {"245", "250", "255", "260"}, 2));
        questionList.add(new Question("23. বাইনারি সংখ্যা 1010 এর অকটাল রূপ কী?", new String[] {"12", "14", "16", "20"}, 0));
        questionList.add(new Question("24. সংখ্যা পদ্ধতি কয় প্রকার?", new String[] {"2", "3", "4", "5"}, 2));
        questionList.add(new Question("25. দশমিক সংখ্যা 20 এর বাইনারি রূপ কী?", new String[] {"10100", "10110", "11000", "11100"}, 0));


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
                Toast.makeText(Activity34.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
