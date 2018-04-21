package com.example.lmnop.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizActivity extends Activity {

    private TextView mScoreView, mQuestion;
    private ImageView mImageView;
    private Button mTrueButton, mFalseButton;

    private boolean mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = (TextView)findViewById(R.id.points);
        mImageView = (ImageView)findViewById(R.id.imageView);
        mQuestion = (TextView)findViewById(R.id.question);
        mTrueButton = (Button)findViewById(R.id.trueButton);
        mFalseButton = (Button)findViewById(R.id.falseButton);

        updateQuestion();

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswer == true) {
                    mScore++;
                    updateScore(mScore);

                    if (mQuestionNumber == QuizBook.questions.length) {
                      Intent i = new Intent(QuizActivity.this,
                              ResultsActivity.class);
                      Bundle bundel = new Bundle();
                      bundel.putInt("finalScore", mScore);
                      i.putExtras(bundel);
                      QuizActivity.this.finish();
                      startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }

                else {
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this,
                                ResultsActivity.class);
                        Bundle bundel = new Bundle();
                        bundel.putInt("finalScore", mScore);
                        i.putExtras(bundel);
                        QuizActivity.this.finish();
                        startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswer == false) {
                    mScore++;
                    updateScore(mScore);

                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this,
                                ResultsActivity.class);
                        Bundle bundel = new Bundle();
                        bundel.putInt("finalScore", mScore);
                        i.putExtras(bundel);
                        QuizActivity.this.finish();
                        startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }

                else {
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this,
                                ResultsActivity.class);
                        Bundle bundel = new Bundle();
                        bundel.putInt("finalScore", mScore);
                        i.putExtras(bundel);
                        QuizActivity.this.finish();
                        startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }
            }
        });
    }

    private void updateQuestion() {
        mImageView.setImageResource(QuizBook.images[mQuestionNumber]);
        mQuestion.setText(QuizBook.questions[mQuestionNumber]);
        mAnswer = QuizBook.answers[mQuestionNumber];
        mQuestionNumber++;
    }

    public void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }
}
