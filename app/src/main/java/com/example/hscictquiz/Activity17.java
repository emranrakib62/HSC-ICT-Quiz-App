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

public class Activity17 extends AppCompatActivity {

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
        setContentView(R.layout.activity_17);

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
        questionList.add(new Question("1. টেলিযোগাযোগের মাধ্যমে সভা করার প্রক্রিয়াকে কী বলা হয়?", new String[]{"ভিডিও কনফারেন্স", "টেলিকনফারেন্স", "অডিও কনফারেন্স", "চ্যাট সেশন"}, 1));

        questionList.add(new Question("2. কোন আবিষ্কারটি যোগাযোগ ব্যবস্থাকে ব্যাপকভাবে উন্নত করেছে?", new String[]{"টেলিফোন", "টেলিভিশন", "রেডিও", "ইন্টারনেট"}, 0));

        questionList.add(new Question("3. ইন্টারনেটের মাধ্যমে ঘরে বসে কাজের সুযোগ পাওয়া কীভাবে পরিচিত?", new String[]{"ফ্রিল্যান্সিং", "আউটসোর্সিং", "পার্ট-টাইম কাজ", "টেলিযোগাযোগ"}, 1));

        questionList.add(new Question("4. ফ্রিল্যান্সিং বলতে কী বোঝায়?", new String[]{"কোনো কোম্পানির জন্য কাজ করা", "স্বাধীনভাবে কাজ করা", "একই শহরে কাজ করা", "একজন কর্মচারী হিসেবে কাজ করা"}, 1));

        questionList.add(new Question("5. বিশ্বগ্রামের মেরুদণ্ড হিসেবে কী পরিচিত?", new String[]{"ইন্টারনেট", "কানেকটিভিটি", "মোবাইল ফোন", "কম্পিউটার"}, 1));

        questionList.add(new Question("6. কোন প্রযুক্তির মাধ্যমে আমরা ঘরে বসেই বিশ্বকে হাতের মুঠোয় নিতে পারি?", new String[]{"কম্পিউটার", "টেলিভিশন", "ইন্টারনেট", "মোবাইল ফোন"}, 2));

        questionList.add(new Question("7. ইন্টারনেটের মাধ্যমে ব্যবসা পরিচালনাকে কী বলা হয়?", new String[]{"ই-কমার্স", "ফ্রিল্যান্সিং", "ড্রপশিপিং", "আউটসোর্সিং"}, 0));

        questionList.add(new Question("8. আমাদের দেশে বর্তমানে প্রচলিত শিক্ষাব্যবস্থার পাশাপাশি নতুন ধরনের শিক্ষাব্যবস্থা কী?", new String[]{"শ্রেণিকক্ষ শিক্ষা", "ওয়েবভিত্তিক ও ইন্টারনেটভিত্তিক", "প্রাইভেট টিউশন", "ই-লাইব্রেরি"}, 1));

        questionList.add(new Question("9. বাস্তবের মতো অনুভূতি তৈরি করা, তবে বাস্তব নয় এমন কল্পনাকে কী বলা হয়?", new String[]{"অগমেন্টেড রিয়েলিটি", "ভার্চুয়াল রিয়েলিটি", "সাইবার রিয়েলিটি", "মেটাভার্স"}, 1));

        questionList.add(new Question("10. সাধারণভাবে ভার্চুয়াল রিয়েলিটির পরিবেশ কেমন হয়?", new String[]{"এক-মাত্রিক", "দ্বি-মাত্রিক", "ত্রী-মাত্রিক", "চতুর্মাত্রিক"}, 2));

        questionList.add(new Question("11. ভার্চুয়াল রিয়েলিটিতে ছবিগুলোকে জীবন্ত দেখানোর জন্য কোন প্রযুক্তি ব্যবহৃত হয়?", new String[]{"দ্বি-মাত্রিক", "ত্রী-মাত্রিক", "চতুর্মাত্রিক", "হাইপার রিয়েলিটি"}, 1));

        questionList.add(new Question("12. কৃত্রিম বুদ্ধিমত্তা কোন প্রজন্মের কম্পিউটার প্রযুক্তিতে সংযোজন করা হয়েছে?", new String[]{"তৃতীয়", "চতুর্থ", "পঞ্চম", "ষষ্ঠ"}, 2));

        questionList.add(new Question("13. মেশিন লার্নিং বলতে কী বোঝায়?", new String[]{"যন্ত্রকে শেখানো এবং তার থেকে সিদ্ধান্ত গ্রহণের ক্ষমতা অর্জন", "মানুষকে শেখানো", "কম্পিউটার প্রোগ্রামিং", "সফটওয়্যার ডেভেলপমেন্ট"}, 0));

        questionList.add(new Question("14. মেশিন লার্নিং-এর একটি উদাহরণ কী?", new String[]{"রোবটিক্স", "চ্যাটবট", "ডাটা অ্যানালাইসিস", "ওয়েব সার্চ"}, 1));

        questionList.add(new Question("15. কৃত্রিম বুদ্ধিমত্তার মূল উপাদান কী?", new String[]{"ডেটা এবং অ্যালগরিদম", "হার্ডওয়্যার", "নিউরাল নেটওয়ার্ক", "প্রসেসর"}, 0));

        questionList.add(new Question("16. কৃত্রিম বুদ্ধিমত্তা ব্যবহারের প্রধান ক্ষেত্র কী?", new String[]{"বুদ্ধিবৃত্তিক বিজ্ঞান", "সাধারণ গণিত", "সাংগঠনিক ব্যবস্থাপনা", "শিল্প বিপ্লব"}, 0));

        questionList.add(new Question("17. 'Cryo' শব্দটির অর্থ কী?", new String[]{"তাপ", "শীতল", "বরফের মতো ঠান্ডা", "আর্দ্রতা"}, 2));

        questionList.add(new Question("18. 'কিউরিসিটি' নামক মহাকাশযান কোন গ্রহে পাঠানো হয়েছে?", new String[]{"শুক্র", "বুধ", "মঙ্গলগ্রহ", "বৃহস্পতি"}, 2));

        questionList.add(new Question("19. কোন প্রযুক্তির মাধ্যমে মানুষকে অনন্যভাবে শনাক্ত করা যায়?", new String[]{"বায়োমেট্রিক্স", "ডিএনএ পরীক্ষা", "চিহ্নিতকরণ কার্ড", "স্মার্ট কার্ড"}, 0));

        questionList.add(new Question("20. বায়োইনফরমেটিক্সের একটি বৈশিষ্ট্য কী?", new String[]{"ডিজিটাল ডেটা", "জৈবিক ডেটার সমাহার", "বায়োলজিক্যাল ক্যালকুলেশন", "জেনেটিক অ্যানালাইসিস"}, 1));

        questionList.add(new Question("21. GMO বলতে কী বোঝায়?", new String[]{"Genetically Modified Organism", "General Medical Operation", "Genomic Micro Organism", "Genetic Molecular Operation"}, 0));

        questionList.add(new Question("22. জেনেটিক ইঞ্জিনিয়ারিং বাণিজ্যিকভাবে কোন ক্ষেত্রে ব্যবহৃত হচ্ছে?", new String[]{"শিক্ষাক্ষেত্রে", "কৃষিক্ষেত্রে", "স্বাস্থ্যসেবায়", "প্রযুক্তি উন্নয়নে"}, 1));

        questionList.add(new Question("23. আণবিক পর্যায়ে পদার্থ পরিবর্তন ও নিয়ন্ত্রণের প্রযুক্তি কী?", new String[]{"জেনেটিক ইঞ্জিনিয়ারিং", "ন্যানোটেকনোলজি", "বায়োটেকনোলজি", "ফার্মাসিউটিক্যাল কেমিস্ট্রি"}, 1));

        questionList.add(new Question("24. ন্যানো-অবজেক্ট কোথা থেকে তৈরি হয়?", new String[]{"অণুজীব থেকে", "মলিকুলার কম্পোনেন্ট থেকে", "ন্যানো রোবট থেকে", "জিনোম সিকোয়েন্সিং থেকে"}, 1));

        questionList.add(new Question("25. কম্পিউটার ইথিকস-এর নির্দেশনা মোট কতটি?", new String[]{"৫", "১০", "১৫", "২০"}, 1));







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
                Toast.makeText(Activity17.this, "Time's up!", Toast.LENGTH_SHORT).show();
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
