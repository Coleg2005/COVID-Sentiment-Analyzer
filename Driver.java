import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class Driver{

  private static void readTwitterData(ArrayList<Sentence> tweets){
    int ctr = 0;
    try{
      //open the csv file for reading
      File file = new File("C:\\Users\\Cole\\School\\Freshman_Fall\\CS1111\\Class_Project\\Covid-19_Dataset.csv");
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;

      //loop through each line in the csv

      while ((line = reader.readLine()) != null){
        String strippedLine = line.strip(); //cut off the newline from the line read in
        Sentence sentence = Sentence.convertLine(strippedLine);
        tweets.add(sentence);
        ctr++;
        // reader.close();
      }
    }catch(Exception e){
        e.printStackTrace();
        System.out.println(ctr);}
    }
    public static void main(String[] args){
        ArrayList <Sentence> sentences = new ArrayList<Sentence>();
        HashMap<String,Integer> wordCounts = printTopWords(sentences);
    
        //solution for Twitter data
        readTwitterData(sentences);

       // int sum = 0;

for (int i = 0; i < sentences.size(); i++) {
  if (!(sentences.get(i).getText().equals(""))) {
    System.out.println(sentences.get(i).getSentiment());
    System.out.println(sentences.get(i));
  } 
}

}

public static HashMap<String,Integer> printTopWords(ArrayList<Sentence> sentences){
    HashMap <String,Integer> wordCounts = new HashMap<String,Integer>();
    for(int i = 0; i < sentences.size(); i++){
      Sentence sentence = sentences.get(i);
      ArrayList <String> words = sentence.splitSentence();
      //System.out.println(Arrays.toString(words.toArray()));
      for(int j = 0; j < words.size(); j++){
        if(wordCounts.containsKey(words.get(j)))
          wordCounts.put(words.get(j), new Integer(wordCounts.get(words.get(j)).intValue() + 1));
        else
          wordCounts.put(words.get(j), new Integer(1));
      }
    }

    return wordCounts;
  }
}