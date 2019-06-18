package com.mikelangdon.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mTrueButton;
    private Button mFalseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);

        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView myTextView = (TextView) v;
        Toast myToast = Toast.makeText(this, "You just clicked " + myTextView.getText(), Toast.LENGTH_SHORT);
        myToast.setGravity(Gravity.TOP, 0, 10);
        myToast.show();

    }
}
