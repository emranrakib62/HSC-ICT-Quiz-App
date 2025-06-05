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

public class Activity33 extends AppCompatActivity {

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
        setContentView(R.layout.activity_33);

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


        questionList.add(new Question("1. কম্পিউটারে ব্যবহৃত ক্ষুদ্রতম তথ্য একক কী?",
                new String[] {"Bit", "Byte", "Kilobyte", "Megabyte"}, 0));

        questionList.add(new Question("2. দশমিক সংখ্যা 50 এর বাইনারি রূপ কী?",
                new String[] {"110010", "101010", "111100", "100110"}, 0));

        questionList.add(new Question("3. অকটাল সংখ্যা 25 এর বাইনারি রূপ কী?",
                new String[] {"10101", "10011", "11001", "11010"}, 2));

        questionList.add(new Question("4. বাইনারি সংখ্যা 10101 এর দশমিক রূপ কী?",
                new String[] {"19", "21", "23", "25"}, 1));

        questionList.add(new Question("5. হেক্সাডেসিমেল সংখ্যা 2A এর দশমিক রূপ কী?",
                new String[] {"40", "42", "44", "46"}, 1));

        questionList.add(new Question("6. অকটাল সংখ্যা 31 এর বাইনারি রূপ কী?",
                new String[] {"11001", "11101", "10001", "10101"}, 0));

        questionList.add(new Question("7. বাইনারি সংখ্যা 11011 এর অকটাল রূপ কী?",
                new String[] {"32", "26", "33", "27"}, 3));

        questionList.add(new Question("8. দশমিক সংখ্যা 75 এর বাইনারি রূপ কী?",
                new String[] {"1001011", "1011011", "1101011", "1111011"}, 1));

        questionList.add(new Question("9. বাইনারি সংখ্যা 10010 এর দশমিক রূপ কী?",
                new String[] {"16", "17", "18", "19"}, 2));

        questionList.add(new Question("10. হেক্সাডেসিমেল সংখ্যা 3F এর বাইনারি রূপ কী?",
                new String[] {"111100", "111110", "111111", "111010"}, 2));

        questionList.add(new Question("11. লজিক গেট কয় প্রকার?",
                new String[] {"2", "3", "5", "7"}, 1));

        questionList.add(new Question("12. OR গেইটের বৈশিষ্ট্য কী?",
                new String[] {"যেকোনো ইনপুট 1 হলে আউটপুট 1 হবে", "উভয় ইনপুট 1 হলে আউটপুট 1 হবে", "কেবলমাত্র একটি ইনপুট 1 হলে আউটপুট 1 হবে", "এটি ইনপুট বিপরীত আউটপুট দেয়"}, 0));

        questionList.add(new Question("13. NAND গেইটের আউটপুট কেমন হয়?",
                new String[] {"AND গেইটের বিপরীত", "OR গেইটের বিপরীত", "NOT গেইটের বিপরীত", "XOR গেইটের বিপরীত"}, 0));

        questionList.add(new Question("14. XOR গেইটের কাজ কী?",
                new String[] {"উভয় ইনপুট 1 হলে আউটপুট 1", "একটি ইনপুট 1 হলে আউটপুট 1", "উভয় ইনপুট 0 হলে আউটপুট 1", "এটি ইনপুট বিপরীত আউটপুট দেয়"}, 1));

        questionList.add(new Question("15. NOR গেইট কী?",
                new String[] {"OR গেইটের বিপরীত", "AND গেইটের বিপরীত", "NAND গেইটের বিপরীত", "NOT গেইটের বিপরীত"}, 0));

        questionList.add(new Question("16. কম্পিউটারের মস্তিষ্ক কাকে বলা হয়?",
                new String[] {"মেমোরি", "হার্ডড্রাইভ", "সিপিইউ", "মাদারবোর্ড"}, 2));

        questionList.add(new Question("17. র‌্যাম কী?",
                new String[] {"একটি স্থায়ী মেমোরি", "একটি অস্থায়ী মেমোরি", "একটি অপারেটিং সিস্টেম", "একটি প্রসেসর"}, 1));

        questionList.add(new Question("18. SSD কী?",
                new String[] {"একটি সফটওয়্যার", "একটি স্টোরেজ ডিভাইস", "একটি হার্ডওয়্যার পোর্ট", "একটি নেটওয়ার্ক ডিভাইস"}, 1));

        questionList.add(new Question("19. USB-এর পূর্ণরূপ কী?",
                new String[] {"Universal Service Bus", "Unique Serial Bus", "Universal Serial Bus", "Unified Storage Bus"}, 2));

        questionList.add(new Question("20. IP Address কী?",
                new String[] {"একটি সফটওয়্যার", "একটি হার্ডওয়্যার", "একটি নেটওয়ার্ক ঠিকানা", "একটি ডাটাবেজ"}, 2));

        questionList.add(new Question("21. কৃত্রিম বুদ্ধিমত্তা কী?",
                new String[] {"একটি সফটওয়্যার", "একটি হার্ডওয়্যার", "কম্পিউটারের চিন্তা করার ক্ষমতা", "একটি প্রোগ্রামিং ভাষা"}, 2));

        questionList.add(new Question("22. কম্পাইলার কী?",
                new String[] {"একটি অপারেটিং সিস্টেম", "একটি প্রোগ্রামিং টুল", "একটি হার্ডওয়্যার", "একটি সার্ভার"}, 1));

        questionList.add(new Question("23. সফটওয়্যার কয় প্রকার?",
                new String[] {"1", "2", "3", "4"}, 2));

        questionList.add(new Question("24. কীবোর্ড কী ধরনের ইনপুট ডিভাইস?",
                new String[] {"গ্রাফিক্যাল", "অডিও", "টেক্সট", "ডিজিটাল"}, 2));

        questionList.add(new Question("25. ক্লাউড কম্পিউটিং কী?",
                new String[] {"কম্পিউটার ক্লাস্টারিং", "অনলাইনে ডাটা সংরক্ষণ এবং প্রসেসিং", "কম্পিউটার নেটওয়ার্ক", "একটি স্টোরেজ ডিভাইস"}, 1));


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
                Toast.makeText(Activity33.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
