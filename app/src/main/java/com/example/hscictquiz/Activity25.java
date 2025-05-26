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

public class Activity25 extends AppCompatActivity {

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
        setContentView(R.layout.activity_25);

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


        questionList.add(new Question("1. ট্রান্সমিশন সিস্টেমের কোন উপাদানটি অন্তর্ভুক্ত?",
                new String[] {"ডিভাইস", "কেবল", "প্রোটোকল", "এনকোডিং"}, 0));

        questionList.add(new Question("2. bps এর পূর্ণরূপ কী?",
                new String[] {"bit per second", "bits per second", "bytes per second", "binary per second"}, 1));

        questionList.add(new Question("3. কোন ব্যান্ডের ব্যান্ডউইথ বেশি?",
                new String[] {"১০ kbps", "১ mbps বা অধিক", "৫ mbps", "৫০ kbps"}, 1));

        questionList.add(new Question("4. কোন মাধ্যমটি দ্রুতগতির ডেটা ট্রান্সফার করতে সক্ষম?",
                new String[] {"ডায়াল আপ", "ব্রড ব্যান্ড", "ফাইবার অপটিক", "কো-অ্যাক্সিয়াল ক্যাবল"}, 1));

        questionList.add(new Question("5. কোন ডেটা প্রবাহের ধরন একমুখী?",
                new String[] {"ডুপ্লেক্স", "সিমপ্লেক্স", "হাফ ডুপ্লেক্স", "ফুল ডুপ্লেক্স"}, 1));

        questionList.add(new Question("6. কোর, ক্ল্যাডিং এবং জ্যাকেট দিয়ে কোনটি তৈরি হয়?",
                new String[] {"টুইস্টেড পেয়ার", "অপটিক্যাল ফাইবার", "কো-অ্যাক্সিয়াল ক্যাবল", "সার্কিট বোর্ড"}, 1));

        questionList.add(new Question("7. টুইস্টেড পেয়ার ক্যাবলের সাধারণ রং কোনটি?",
                new String[] {"সাদা", "নীল", "সবুজ", "লাল"}, 0));

        questionList.add(new Question("8. কোন ডিভাইসটি ফুল ডুপ্লেক্স মোডে কাজ করে?",
                new String[] {"ফ্যাক্স", "মোবাইল ফোন, ল্যান্ড ফোন", "ডায়াল আপ", "ওয়াইফাই"}, 1));

        questionList.add(new Question("9. ফুল ডুপ্লেক্স মোডে কাজ করে কোন ডিভাইস?",
                new String[] {"ফ্যাক্স", "মোবাইল ফোন, ল্যান্ড ফোন", "ডায়াল আপ", "ওয়াইফাই"}, 1));

        questionList.add(new Question("10. কো-অ্যাক্সিয়াল ক্যাবলের প্রধান উপাদান কোনটি?",
                new String[] {"তামার তার", "অ্যালুমিনিয়াম", "প্লাস্টিক", "ফাইবার অপটিক"}, 0));

        questionList.add(new Question("11. কো-অ্যাক্সিয়াল ক্যাবল কত ভাগে বিভক্ত?",
                new String[] {"দুই", "তিন", "চার", "পাঁচ"}, 1));

        questionList.add(new Question("12. সর্বাধিক গতিতে ডেটা ট্রান্সফার করার জন্য কোন মাধ্যমটি ব্যবহৃত হয়?",
                new String[] {"কপার ক্যাবল", "ফাইবার অপটিক ক্যাবল", "টুইস্টেড পেয়ার", "সুইচ"}, 1));

        questionList.add(new Question("13. কপার ওয়্যার টুইস্ট করার ফলে কি হয়?",
                new String[] {"EMI বৃদ্ধি পায়", "EMI কমে", "ব্যান্ডউইথ বাড়ে", "তাপমাত্রা বাড়ে"}, 1));

        questionList.add(new Question("14. কোন IEEE স্ট্যান্ডার্ডটি Wi-Fi এর জন্য প্রযোজ্য?",
                new String[] {"802.3", "802.5", "802.11", "802.15"}, 2));

        questionList.add(new Question("15. পৃথিবী থেকে স্যাটেলাইট সাধারণত কত উচ্চতায় স্থাপন করা হয়?",
                new String[] {"২৪,০০০ km", "৩৬,০০০ km", "৫০,০০০ km", "৬০,০০০ km"}, 1));

        questionList.add(new Question("16. স্যাটেলাইট মাইক্রোওয়েভ সিগন্যাল সাধারণত কোন দিকে মুখ করে থাকে?",
                new String[] {"ভূমি", "আকাশ", "পৃথিবী", "সূর্য"}, 1));

        questionList.add(new Question("17. ওয়্যারলেস একসেস পয়েন্টকে সাধারণত কি বলা হয়?",
                new String[] {"হটস্পট", "রাউটার", "সুইচ", "মডেম"}, 0));

        questionList.add(new Question("18. ব্লুটুথ এর উদ্ভাবক কোন প্রতিষ্ঠান?",
                new String[] {"স্যামসাং", "এরিকসন", "নোকিয়া", "ইনটেল"}, 1));

        questionList.add(new Question("19. GSM এর পূর্ণরূপ কী?",
                new String[] {"Global System for Mobile Communication", "General System for Mobile Communication",
                        "Global Software for Mobile Communication", "General Software for Mobile Communication"}, 0));

        questionList.add(new Question("20. বিশ্বের সবচেয়ে বড় এলাকা জুড়ে কোন নেটওয়ার্ক কাজ করে?",
                new String[] {"LAN", "WAN", "MAN", "PAN"}, 1));

        questionList.add(new Question("21. Wi-Max কোন ধরনের নেটওয়ার্কে ব্যবহৃত হয়?",
                new String[] {"LAN", "WAN", "MAN", "PAN"}, 2));

        questionList.add(new Question("22. কম্পিউটার নেটওয়ার্কের জন্য যে কার্ড ব্যবহৃত হয় তাকে কী বলা হয়?",
                new String[] {"NIC", "মডেম", "রাউটার", "সুইচ"}, 0));

        questionList.add(new Question("23. মডেমের মাধ্যমে অ্যানালগ সংকেত ডিজিটাল সংকেতে রূপান্তরিত হয়, এ প্রক্রিয়াটি কী বলা হয়?",
                new String[] {"ডিমডুলেশন", "মডুলেশন", "ডিকোডিং", "এনকোডিং"}, 0));

        questionList.add(new Question("24. মডেমের কাজ কী?",
                new String[] {"ডেটা পাঠানো, ডেটা গ্রহণ", "সিগনাল তৈরি", "কেবল পরিবর্তন", "নেটওয়ার্ক সংযোগ"}, 0));

        questionList.add(new Question("25. ক্লাউড কম্পিউটিং এর কোন সুবিধাটি সবচেয়ে গুরুত্বপূর্ণ?",
                new String[] {"বড় ডেটা", "সাশ্রয়ী ও সহজলভ্য", "এনক্রিপশন", "ডেডিকেটেড সার্ভার"}, 1));



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
                Toast.makeText(Activity25.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
