package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nameEt,learningEt;
    private TextView nameTv,learningTv;

    private String NAME_KEY = "NameOfPerson";
    private String LEARNING_KEY = "StudyName" ;

    private String mName;
    private String mStudyName;

    private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.example.sharedpref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEt = findViewById(R.id.nameEt);
        learningEt = findViewById(R.id.whatLearningEt);
        nameTv = findViewById(R.id.nameTv);
        learningTv = findViewById(R.id.learningTv);

        mPreferences = getSharedPreferences(sharedPrefFile,MODE_PRIVATE);
        callSaveDetails();
    }

    public void saveDetails(View view) {
        mName = nameEt.getText().toString();
        mStudyName = learningEt.getText().toString();
        SharedPreferences.Editor preferenceEditor = mPreferences.edit();
        preferenceEditor.putString(NAME_KEY,mName);
        preferenceEditor.putString(LEARNING_KEY,mStudyName);
        preferenceEditor.apply();
        callSaveDetails();
    }

    private void callSaveDetails() {
        nameTv.setText(mPreferences.getString(NAME_KEY,mName));
        learningTv.setText(mPreferences.getString(LEARNING_KEY,mStudyName));
    }

    public void clearallDetails(View view) {
        SharedPreferences.Editor preferenceEditor = mPreferences.edit();
        preferenceEditor.clear();
        preferenceEditor.apply();

        nameTv.setText(mPreferences.getString(NAME_KEY,mName));
        learningTv.setText(mPreferences.getString(LEARNING_KEY,mStudyName));

    }
}