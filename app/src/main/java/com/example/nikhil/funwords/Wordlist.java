package com.example.nikhil.funwords;

import android.app.Activity;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nikhil on 02-08-2017.
 */

public class Wordlist {

    AssetManager assetManager;

    public Wordlist(AssetManager assetManager){
        this.assetManager = assetManager;
    }

    public List<Word> getList(){
        ArrayList<Word> arrayList = new ArrayList<>();

        try {
            InputStream inputStream =  assetManager.open("words.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            String[] words = new String[5];

            try{
                while ((line = bufferedReader.readLine()) != null){
                    Word word = new Word();
                    words = line.split(",");
                    word.setWord(words[0]);
                    word.setHint(words[1]);
                    arrayList.add(word);
                }
            }catch (Exception e){

            }

        }catch (Exception e){

        }

        Collections.shuffle(arrayList);

        return arrayList.subList(0,10);
    }
}
