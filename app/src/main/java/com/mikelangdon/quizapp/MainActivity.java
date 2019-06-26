package com.mikelangdon.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;
    private TextView mScoreTextView;
    // trying to use multiple layouts
    //private LinearLayout mLinearLayout;

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPreviousButton;
    private ImageButton mHintButton;

    private Question[] mQuestions;


    private int mIndex;
    private int mScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mPreviousButton = (ImageButton) findViewById(R.id.previous_button);
        mHintButton = (ImageButton) findViewById(R.id.hint_button);

        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mPreviousButton.setOnClickListener(this);
        mHintButton.setOnClickListener(this);
// experiment
//        mLinearLayout = (LinearLayout) findViewById(R.id.main_layout);
//        findViewById(R.id.last_page).setVisibility(View.GONE);
        mTextView = (TextView) findViewById(R.id.question_text_view);
        mScoreTextView = (TextView) findViewById(R.id.score_text_view);


        // Initialize an array of questions
        mQuestions = new Question[6];  // change this number if adding more questions
        mIndex = 0;

        mQuestions[0] = new Question(R.string.question_1, R.string.question_1_hint, false);
        mQuestions[1] = new Question(R.string.question_2, R.string.question_2_hint, true);
        mQuestions[2] = new Question(R.string.question_3, R.string.question_3_hint,false);
        mQuestions[3] = new Question(R.string.question_4, R.string.question_4_hint,true);
        mQuestions[4] = new Question(R.string.question_5, R.string.question_5_hint, false);
        mQuestions[5] = new Question(R.string.question_6, R.string.question_6_hint, true);


        mScoreTextView.setText("Score: " + mScore);
        mTextView.setText(mQuestions[mIndex].getTextResId());
//        mScoreTextView.setText(mScore);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.true_button) {
            checkAnswer(true);
        }
        else if (v.getId() == R.id.false_button) {
            checkAnswer(false);
        }
        else if (v.getId() == R.id.next_button) {

            // Increment the index by 1
            mIndex++;
            if (mIndex == mQuestions.length - 1) {


//                mLinearLayout = (LinearLayout) findViewById(R.id.last_page);
//                findViewById(R.id.main_layout).setVisibility(View.GONE);
//                mTextView = (TextView) findViewById(R.id.text_view2);


                mScoreTextView.setText("Score: " + mScore);
                mTextView.setText(mQuestions[mIndex].getTextResId());
                try {
                    sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(0);

            }



            // Change text in view.
            mScoreTextView.setText("Score: " + mScore);
            mTextView.setText(mQuestions[mIndex].getTextResId());
        }
        else if (v.getId() == R.id.previous_button) {
            // Decrement the index by 1
            mIndex--;
            // The following 'if statement' prevents the user from trying to
            // select a previous question when there are no more previous questions
            // to select.
            if (mIndex < 0) {
                mIndex = 0;
            }

            // Change text in view.
            mScoreTextView.setText("Score: " + mScore);
            mTextView.setText(mQuestions[mIndex].getTextResId());

        }
        else if (v.getId() == R.id.hint_button) {
            Toast myToast = Toast.makeText(this, mQuestions[mIndex].getHintTextResId(), Toast.LENGTH_LONG);
            myToast.setGravity(Gravity.BOTTOM, 0, 10);
            myToast.show();

        }

    }

    public boolean checkAnswer(boolean userInput) {
        // check if answer matches the user's answer
        if (mQuestions[mIndex].getAnswer() == userInput) {

            mScore++;
            mScoreTextView.setText("Score: " + mScore);
            Toast myToast = Toast.makeText(this, "You are correct!", Toast.LENGTH_SHORT);
            myToast.setGravity(Gravity.TOP, 0, 10);
            myToast.show();

            return true;
        }
        else {
            mScoreTextView.setText("Score: " + mScore);
            Toast myToast = Toast.makeText(this, "You are incorrect :(", Toast.LENGTH_SHORT);
            myToast.setGravity(Gravity.TOP, 0, 10);
            myToast.show();

            return false;
        }
    }
}
