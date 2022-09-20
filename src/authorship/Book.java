/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authorship;

import java.util.ArrayList;

/**
 *
 * @author lindz
 */
public class Book {

    private String title;
    private String allWords;
    private Author writer;
    private ArrayList<Sentence> sentences;
    double average = 0.0;

    public Book(String title, String allWords) {
        this.sentences = new ArrayList<>();
        this.title = title;
        this.allWords = allWords;

        String[] temp = allWords.split("[!?.]");
        for (String sent : temp) {
            Sentence sentence = new Sentence(sent);
            sentences.add(sentence);
        }
    }

//    public ArrayList getSentences() {
//        return sentences;
//    }
    public double getAverageWordLength() {
        double sum = 0.0;
        for (Sentence sentence : sentences) {
            sum += sentence.getAverageWordLength();
        }
        return sum / sentences.size();
    }

    public double getAvg(double statistic, double book) {
        double i;

        if (book == 1) {
            average = statistic;
        } else if (book > 1) {
            i = statistic * book;
            average = i / book;
        }
        return average;
    }

//    public double getAverageWordPerSentence(){
//        return words.size()/sentences.size();
//    }
    public Book() {
    }

    @Override
    public String toString() {
        return (title);

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAllWords(String allWords) {
        this.allWords = allWords;
    }

    public String getTitle() {
        return title;
    }

    public String getAllWords() {
        return allWords;
    }

    public void setWriter(Author writer) {
        this.writer = writer;
    }

    public Author getWriter() {
        return writer;
    }

}
