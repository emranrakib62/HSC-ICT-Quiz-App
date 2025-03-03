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

public class Activity32 extends AppCompatActivity {

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
        setContentView(R.layout.activity_32);

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


        questionList.add(new Question("1. বাইনরি সংখ্যা সিস্টেমে মোট কয়টি ডিজিট থাকে?",
                new String[] {"একটি", "দুটি", "তিনটি", "চারটি"}, 1));

        questionList.add(new Question("2. দশমিক সংখ্যা সিস্টেমের পূর্ণরূপ কী?",
                new String[] {"Binary", "Hexadecimal", "Decimal", "Octal"}, 2));

        questionList.add(new Question("3. দশমিক সংখ্যা 25 কে বাইনরি রূপে রূপান্তরিত করলে কী হবে?",
                new String[] {"11000", "11001", "10101", "10011"}, 1));

        questionList.add(new Question("4. অকটাল সংখ্যা সিস্টেমের কোন সংখ্যাগুলি ব্যবহার করা হয়?",
                new String[] {"0 থেকে 9", "0 থেকে 7", "0 থেকে 15", "0 থেকে 8"}, 1));

        questionList.add(new Question("5. হেক্সাডেসিমেল সংখ্যা সিস্টেমের কী সংখ্যা ব্যবহৃত হয়?",
                new String[] {"0 থেকে 9 এবং A থেকে F", "0 থেকে 7", "0 থেকে 10", "0 থেকে Z"}, 0));

        questionList.add(new Question("6. এক দশমিক সংখ্যা 10 এর বাইনরি রূপ কী?",
                new String[] {"1010", "1100", "1110", "1001"}, 0));

        questionList.add(new Question("7. বাইনরি সংখ্যা 1110 কে দশমিক সংখ্যা সিস্টেমে রূপান্তরিত করলে কী হবে?",
                new String[] {"12", "14", "16", "10"}, 1));

        questionList.add(new Question("8. অকটাল সংখ্যা 7 এর বাইনরি রূপ কী?",
                new String[] {"100", "101", "111", "110"}, 2));

        questionList.add(new Question("9. হেক্সাডেসিমেল সংখ্যা 1F কে দশমিক সিস্টেমে রূপান্তরিত করলে কী হবে?",
                new String[] {"29", "31", "27", "33"}, 1));

        questionList.add(new Question("10. সংখ্যা আবিষ্কারের ইতিহাসের সূচনা কোথায় হয়?",
                new String[] {"মিশর", "মেসোপটেমিয়া", "গ্রীস", "ভারত"}, 1));

        questionList.add(new Question("11. বাইনারি যোগে 1 + 1 এর ফলাফল কী?",
                new String[] {"1", "10", "11", "0"}, 1));

        questionList.add(new Question("12. অকটাল সংখ্যা 12 এর বাইনারি রূপ কী?",
                new String[] {"10000", "10100", "11000", "11100"}, 1));

        questionList.add(new Question("13. হেক্সাডেসিমেল সংখ্যা B8 এর দশমিক রূপ কী?",
                new String[] {"184", "192", "176", "200"}, 0));

        questionList.add(new Question("14. বাইনারি সংখ্যা 1001 এর অকটাল রূপ কী?",
                new String[] {"10", "11", "12", "9"}, 1));

        questionList.add(new Question("15. বাইনারি সংখ্যা 1110011 এর দশমিক রূপ কী?",
                new String[] {"55", "113", "97", "121"}, 0));

        questionList.add(new Question("16. অকটাল সংখ্যা 15 এর বাইনরি রূপ কী?",
                new String[] {"11011", "10111", "10011", "11101"}, 0));

        questionList.add(new Question("17. বাইনারি সংখ্যা 1011 এর দশমিক রূপ কী?",
                new String[] {"10", "11", "12", "9"}, 1));

        questionList.add(new Question("18. দশমিক সংখ্যা 9 এর বাইনারি রূপ কী?",
                new String[] {"1001", "1010", "1100", "1110"}, 0));

        questionList.add(new Question("19. হেক্সাডেসিমেল সংখ্যা 8F এর দশমিক রূপ কী?",
                new String[] {"143", "127", "159", "135"}, 0));

        questionList.add(new Question("20. বুলিয়ান বীজগণিতের মূলকথা কী?",
                new String[] {"এটি শুধুমাত্র দুটি মান ব্যবহার করে", "এটি শুধুমাত্র সংখ্যা নিয়ে কাজ করে", "এটি এনক্রিপশন করে", "এটি ডাটাবেজ সংরক্ষণ করে"}, 0));

        questionList.add(new Question("21. সত্যক সারণি কী?",
                new String[] {"এটি একটি হিসাব পদ্ধতি", "এটি একটি টেবিল যা লজিক গেটের আউটপুট দেখায়", "এটি একটি এনক্রিপশন পদ্ধতি", "এটি বাইনারি যোগফল হিসাব করে"}, 1));

        questionList.add(new Question("22. AND গেইটের বৈশিষ্ট্য কী?",
                new String[] {"যেকোনো ইনপুট 1 হলে আউটপুট 1 হবে", "উভয় ইনপুট 1 হলে আউটপুট 1 হবে", "কেবলমাত্র একটি ইনপুট 1 হলে আউটপুট 1 হবে", "এটি ইনপুট বিপরীত আউটপুট দেয়"}, 1));

        questionList.add(new Question("23. NOT গেইটের কাজ কী?",
                new String[] {"এটি দুটি ইনপুট গ্রহণ করে", "এটি ইনপুট বিপরীত আউটপুট দেয়", "এটি শুধুমাত্র 1 আউটপুট দেয়", "এটি এনক্রিপশন করে"}, 1));

        questionList.add(new Question("24. এনকোডার কী?",
                new String[] {"এটি একটি সংকেত রূপান্তরকারী", "এটি একটি স্টোরেজ ইউনিট", "এটি একটি সার্ভার", "এটি একটি ডাটাবেস"}, 0));

        questionList.add(new Question("25. ফ্লিপ-ফ্লপ কী?",
                new String[] {"এটি একটি ডিজিটাল স্টোরেজ এলিমেন্ট", "এটি একটি এনক্রিপশন ইউনিট", "এটি একটি সার্ভার", "এটি একটি সংখ্যা পদ্ধতি"}, 0));



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
                Toast.makeText(Activity32.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
