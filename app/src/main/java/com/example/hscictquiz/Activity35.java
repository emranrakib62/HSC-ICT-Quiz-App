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

public class Activity35 extends AppCompatActivity {

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
        setContentView(R.layout.activity_35);

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


        questionList.add(new Question("1. 8-বিট ডিকোডার কী কাজ করে?", new String[] {"এটি ইনপুট সিগন্যালকে ডিকোড করে", "এটি ইনপুট সিগন্যালকে এনকোড করে", "এটি ইনপুট সিগন্যালের সিঙ্ক্রোনাইজেশন করে", "এটি একাধিক ফ্লিপ-ফ্লপ ব্যবহার করে"}, 0));
        questionList.add(new Question("2. 2-বিট বাইনারি ইনপুটের জন্য 4-লাইন ডিকোডারের আউটপুট কত?", new String[] {"2", "3", "4", "5"}, 2));
        questionList.add(new Question("3. 2-বিট বাইনারি সংখ্যার 2's complement কী হবে?", new String[] {"00", "01", "10", "11"}, 2));
        questionList.add(new Question("4. ফ্লিপ-ফ্লপ কি?", new String[] {"একটি ডাটা সঞ্চয় ইউনিট", "একটি সংখ্যার গেট", "একটি গাণিতিক ফাংশন", "একটি লজিকাল সিস্টেম"}, 0));
        questionList.add(new Question("5. D ফ্লিপ-ফ্লপের কাজ কি?", new String[] {"ডাটা স্টোর করা", "ডাটা পাল্টানো", "ডাটা প্রদর্শন করা", "ডাটা কম্পাইল করা"}, 0));
        questionList.add(new Question("6. একটি 3-বিট বাইনারি সংখ্যার 2's complement রূপ কী হবে?", new String[] {"011", "100", "110", "111"}, 1));
        questionList.add(new Question("7. এনকোডার কি কাজ করে?", new String[] {"ইনপুট সংকেতকে কোডে রূপান্তরিত করা", "আউটপুট সংকেতকে ডিকোড করা", "সংখ্যাকে বাইনারিতে রূপান্তরিত করা", "সিনক্রোনাইজেশন করা"}, 0));
        questionList.add(new Question("8. 4 ইনপুটের জন্য 16-লাইন এনকোডারের আউটপুট কত?", new String[] {"4", "5", "6", "7"}, 1));
        questionList.add(new Question("9. S-R ফ্লিপ-ফ্লপের কোন আউটপুট অস্থির থাকতে পারে?", new String[] {"S=0, R=0", "S=1, R=0", "S=0, R=1", "S=1, R=1"}, 3));
        questionList.add(new Question("10. AND গেটের আউটপুট কি হবে যদি ইনপুট দুটি 1 ও 0 হয়?", new String[] {"0", "1", "2", "3"}, 0));
        questionList.add(new Question("11. XOR গেটের আউটপুট কি হবে যদি ইনপুট দুটি 1 হয়?", new String[] {"0", "1", "2", "3"}, 0));
        questionList.add(new Question("12. OR গেটের আউটপুট কী হবে যদি ইনপুট দুটি 1 ও 0 হয়?", new String[] {"1", "0", "2", "3"}, 0));
        questionList.add(new Question("13. NOT গেটের আউটপুট কি?", new String[] {"ইনপুটের বিপরীত", "ইনপুটের সাথে সামঞ্জস্যপূর্ণ", "ইনপুটকে গুণিতক করে", "ইনপুট যোগ করে"}, 0));
        questionList.add(new Question("14. 4-বিট বাইনারি সংখ্যার 2's complement কী হবে?", new String[] {"0000", "1111", "1000", "0111"}, 2));
        questionList.add(new Question("15. একটি টু-ইনপুট AND গেটের আউটপুট কী হবে যদি দুটি ইনপুট 0 হয়?", new String[] {"1", "0", "2", "3"}, 1));
        questionList.add(new Question("16. 8-বিট এনকোডার কীভাবে কাজ করে?", new String[] {"এটি একাধিক ইনপুট সংকেতকে কোডে রূপান্তরিত করে", "এটি একটি বাইনারি সংখ্যা প্রদর্শন করে", "এটি একাধিক সিগন্যালকে এনালগ করে", "এটি সিগন্যাল ফিল্টার করে"}, 0));
        questionList.add(new Question("17. 2-এর সম্পূরক রূপান্তর প্রক্রিয়া কী?", new String[] {"প্রথমে ইনপুটকে বিপরীত করে তারপর 1 যোগ করা", "প্রথমে 1 যোগ করে তারপর বিপরীত করা", "শুধু 1 যোগ করা", "কোনো পরিবর্তন প্রয়োজন নয়"}, 0));
        questionList.add(new Question("18. N-bit বাইনারি সংখ্যা S-এর 2's complement কীভাবে নির্ধারণ করা হয়?", new String[] {"প্রথমে সংখ্যা উল্টো করা তারপর 1 যোগ করা", "প্রথমে 1 যোগ করা তারপর উল্টো করা", "সংখ্যাকে উল্টো না করেই 1 যোগ করা", "শুধু সংখ্যা উল্টো করা"}, 0));
        questionList.add(new Question("19. D ফ্লিপ-ফ্লপে ইনপুট D এর সাথে কোন সম্পর্ক থাকে?", new String[] {"এটি ইনপুট মান স্টোর করে", "এটি ইনপুটকে ফ্লিপ করে", "এটি ইনপুটটি সংরক্ষণ করে", "এটি ইনপুটের সিগন্যাল পরিবর্তন করে"}, 0));
        questionList.add(new Question("20. একটি এনকোডার সর্বোচ্চ কতটি ইনপুট নেবে?", new String[] {"2", "4", "8", "16"}, 3));
        questionList.add(new Question("21. 4-বিট বাইনারি সংখ্যা 1011-এর 2's complement কী হবে?", new String[] {"0101", "1101", "1010", "1100"}, 1));
        questionList.add(new Question("22. লজিক্যাল গেট গুলোর মধ্যে কোনটি সর্বাধিক ব্যবহৃত হয়?", new String[] {"AND", "OR", "XOR", "NOT"}, 0));
        questionList.add(new Question("23. ডিজিটাল সিস্টেমে, 1-bits এর কোন গেট কমপ্লিমেন্ট নেয়?", new String[] {"AND", "OR", "NOT", "XOR"}, 2));
        questionList.add(new Question("24. এনকোডারের প্রধান কাজ কী?", new String[] {"ডেটা কোডিং", "ডেটা ডিকোডিং", "ডেটা রূপান্তর", "ডেটা সংরক্ষণ"}, 0));
        questionList.add(new Question("25. 8-বিট বাইনারি সংখ্যা 10010111 এর 2's complement কী হবে?", new String[] {"01101001", "11101001", "11101100", "01110001"}, 0));



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
                Toast.makeText(Activity35.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
