import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Driver {

  private static void readTwitterData(ArrayList<Sentence> tweets) {
    int ctr = 0;
    try {
      // open the csv file for reading
      File file = new File("C:\\Users\\Cole\\School\\Freshman_Fall\\CS1111\\Class_Project\\Covid-19_Dataset.csv");
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;

      // loop through each line in the csv
      while ((line = reader.readLine()) != null) {
        String strippedLine = line.strip(); // cut off the newline from the line read in
        Sentence sentence = Sentence.convertLine(strippedLine);
        tweets.add(sentence);
        ctr++;
      }
      reader.close(); // Moved outside the loop
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(ctr);
    }
  }

  public static void main(String[] args) {
    ArrayList<Sentence> sentences = new ArrayList<Sentence>();
    
    // Call readTwitterData before trying to use sentences
    readTwitterData(sentences);
    
    // Call printTopWords after populating sentences
    HashMap<String, Integer> wordCounts = printTopWords(sentences);

    // Sort the word counts from highest to lowest
    List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCounts.entrySet());
    Collections.sort(sortedEntries, new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o2.getValue().compareTo(o1.getValue()); // Descending order
        }
    });
      
    // Print the sorted word counts
    System.out.println("\n----- WORD COUNT SUMMARY (HIGHEST TO LOWEST) -----");
    for (Map.Entry<String, Integer> entry : sortedEntries) {
        System.out.println("Word: \"" + entry.getKey() + "\" appears " + entry.getValue() + " times");
    }

    try {
        Thread.sleep(3000); // Pause for 3000 milliseconds (3 seconds)
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    // Print sentence sentiment and text
    System.out.println("\n----- SENTIMENT ANALYSIS -----");
    for (int i = 0; i < sentences.size(); i++) {
      if (!(sentences.get(i).getText().equals(""))) {
        System.out.println(sentences.get(i) + "Sentiment - " + sentences.get(i).getSentiment());
      }
    }
  }

  public static HashMap<String, Integer> printTopWords(ArrayList<Sentence> sentences) {
    HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
    for (int i = 0; i < sentences.size(); i++) {
      Sentence sentence = sentences.get(i);
      ArrayList<String> words = sentence.splitSentence();
      for (int j = 0; j < words.size(); j++) {
        if (wordCounts.containsKey(words.get(j)))
          wordCounts.put(words.get(j), wordCounts.get(words.get(j)) + 1);
        else
          wordCounts.put(words.get(j), 1);
      }
    }
    return wordCounts;
  }
}