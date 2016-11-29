package com.wisnu_krn.recyclerviewexample.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by private on 27/11/2016.
 */

public class DummyData {
    private static List<Word> wordList = new ArrayList<>();

    public static List<Word> dummy(){
        wordList.add(new Word("Wisnu","Kurniawan"));
        wordList.add(new Word("Alan", "Dwi"));
        wordList.add(new Word("Intan", "Pratiwi"));
        wordList.add(new Word("Desy", "Tri"));
        wordList.add(new Word("Desi", "rahma"));
        wordList.add(new Word("Rochmat", "Mulya"));
        wordList.add(new Word("Rohmat", "Haryadi"));
        return wordList;
    }
}
