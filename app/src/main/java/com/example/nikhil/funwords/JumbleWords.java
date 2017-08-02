package com.example.nikhil.funwords;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JumbleWords extends AppCompatActivity {

    static int i=0;
    TextView qid, word, hint;
    EditText answer;
    Word w;
    List<Word> list;
    String ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumble_words);


        Wordlist wordlist = new Wordlist(getAssets());

        list = wordlist.getList();

        qid = (TextView) findViewById(R.id.questionid);
        word = (TextView) findViewById(R.id.word);
        hint = (TextView) findViewById(R.id.hint);
        answer = (EditText) findViewById(R.id.u_answer);
        w = list.get(i);
        qid.setText("Q" + String.valueOf(i+1));
        word.setText(getJumbledWord(w.getWord()));
        hint.setText("Hint: " + w.getHint());
    }

    public void next(View view){

        if (i == 9){
            i = 0;
        }
        else {
            i++;
        }

        ans = answer.getText().toString().toLowerCase();
        w.setUanswer(ans);

        w = list.get(i);
        qid.setText("Q" + String.valueOf(i+1));
        word.setText(getJumbledWord(w.getWord()));
        hint.setText("Hint: " + w.getHint());
        answer.setText("");
    }

    public void submit(View view){
        ans = answer.getText().toString().toLowerCase();
        w.setUanswer(ans);

        int res = 0;
        for (Word w : list){
            if (w.getWord().toLowerCase().equals(w.getUanswer())){
                res ++ ;
            }
        }

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("Result", res);
        startActivity(intent);
    }

    public String getJumbledWord(String wd){
        char ch ;
        String x ;
        char[] word = wd.toCharArray();
        for(int i=0 ; i<word.length ; i++)
        {
            int l = (int) (Math.random()*word.length);
            int t = (int) (Math.random()*word.length);
            ch = word[l];
            word[l] = word[t];
            word[t] = ch ;
        }
        x = new String(word);

        return x;
    }

}
