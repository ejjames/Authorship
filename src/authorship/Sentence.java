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
public class Sentence {

    private String originalText;
    public ArrayList<String> words;

    public double getAverageWordLength() {
        double sum = 0.0;
        for (String word : words) {
            sum += word.length();
        }
        if (words.isEmpty()) {
            return 0.0;
        }
        return sum / words.size();
    }

    public Sentence(String wordText) {
        this.words = new ArrayList<>();
        this.originalText = wordText;
        String[] temp = wordText.split("[\t \n]");
        for (String token : temp) {
            String word = token.replaceAll("\\W", "");
            if (word.length() > 0) {
                words.add(word);
            }
        }
    }

    //    public ArrayList<String> getWords(){
//        return words;
//    }
//    
}
