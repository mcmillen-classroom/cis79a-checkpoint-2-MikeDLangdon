package com.mikelangdon.quizapp;

public class Question {
    private int mTextResId;
    private boolean mAnswer;
    private int mHintTextResId;

    public Question(int textResId, int HintTextResId, boolean answer) {
        mTextResId = textResId;
        mHintTextResId = HintTextResId;
        mAnswer = answer;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public int getHintTextResId() {
        return mHintTextResId;
    }

    public void setHintTextResId(int hintTextResId) {
        mHintTextResId = hintTextResId;
    }

    public boolean getAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
