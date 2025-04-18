// import java.util.Arrays;
// import java.util.ArrayList;
// import java.util.Properties;
// import org.ejml.simple.SimpleMatrix;
// import edu.stanford.nlp.ling.CoreAnnotations;
// import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
// import edu.stanford.nlp.pipeline.Annotation;
// import edu.stanford.nlp.pipeline.StanfordCoreNLP;
// import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
// import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
// import edu.stanford.nlp.trees.Tree;
// import edu.stanford.nlp.util.CoreMap;

// import java.security.Timestamp;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;

// public class Sentence {

//   private String text;
//   private String author;
//   private String timestamp;

//   public Sentence(String text, String author, String timestamp){
//     this.text = text;
//     this.author = author;
//     this.timestamp = timestamp;
//   }

//   public void setText(String text){
//     this.text = text;
//   }

//   public String getText(){
//     return text;
//   }

//   public void setAuthor(String author){
//     this.author = author;
//   }

//   public String getAuthor(){
//     return author;
//   }

//   public void setTimestamp(String timestamp){
//     this.timestamp = timestamp;
//   }

//   public String getTimestamp(){
//     return timestamp;
//   }

//   public String toString(){
//     return "{author:" + author + ", sentence:\"" + text + "\", timestamp:\"" + timestamp + "\"}";
//   }

//     // for Twitter COVID dataset
//     public static Sentence convertLine(String line){
//       //System.out.println(line);
//       String[] pieces = new String[8];

//       String basket = "";
//       int ctr = 0;
//       boolean startQuote = false;
//       for(int i = 0; i < line.length(); i++){
//         if (line.charAt(i) == ',' && startQuote == false){
//           pieces[ctr] = basket;
//           basket = "";
//           ctr++;
//         } else if (line.charAt(i) == '"'){
//           startQuote = ! startQuote;
//         } else{
//           basket += line.charAt(i);
//         }
//       }
//       pieces[ctr] = basket;
//       //System.out.println(Arrays.toString(pieces));
//       String date = pieces[2];
//       String username = pieces[4];
//       String tweet = pieces[7];
//       if(tweet == null){
//         tweet = "empty";
//       }
//       tweet = tweet.replaceAll("\"", ""); //removes double quotations from tweet
//       tweet = tweet.replaceAll("\\.", ""); //removes periods from tweet
//       tweet = tweet.replaceAll(",", ""); //removes commas from tweet
//       tweet = tweet.replaceAll("!", ""); //removes exclamations from tweet
//       // you could have included more/other punctuation here to remove as well
  
//       //clean the date from "4/19/2020 0:00" to "April 19 2020"
//       //System.out.println(date);
//       if(date == null)
//         date = "April 19 2020";
//       String [] datePieces = date.split(" ");
//       String first = datePieces[0];
//       datePieces = first.split("/");
//       String month = datePieces[0];
//       if (month.equals("1"))
//         month = "January";
//       else if (month.equals("2"))
//         month = "February";
//       else if (month.equals("3"))
//         month = "March";
//       else if (month.equals("4"))
//         month = "April";
//       else if (month.equals("5"))
//         month = "May";
//       else if (month.equals("6"))
//         month = "June";
//       else if (month.equals("7"))
//         month = "July";
//       else if (month.equals("8"))
//         month = "August";
//       else if (month.equals("9"))
//         month = "September";
//       else if (month.equals("10"))
//         month = "October";
//       else if (month.equals("11"))
//         month = "November";
//       else if (month.equals("12"))
//         month = "December";

//         if (datePieces == null || datePieces.length < 3)
//                date = "April 20 2020";
//         else
//              date = month + " " + datePieces[1] + " 20" +  datePieces[2];
  
//       String author = username;
//       String text = tweet;
//       return new Sentence(text, author, date);
//     }

// public String getDate() {
//   return date;
// }

// public ArrayList<String> splitSentence(){

//         String [] stopwordsArr = {"a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren't", "as", "at", "be", "because", "been", "before", "being", "below", "between", "both", "but", "by", "can't", "cannot", "could", "couldn't", "did", "didn't", "do", "does", "doesn't", "doing", "don't", "down", "during", "each", "few", "for", "from", "further", "had", "hadn't", "has", "hasn't", "have", "haven't", "having", "he", "he'd", "he'll", "he's", "her", "here", "here's", "hers", "herself", "him", "himself", "his", "how", "how's", "i", "i'd", "i'll", "i'm", "i've", "if", "in", "into", "is", "isn't", "it", "it's", "its", "itself", "let's", "me", "more", "most", "mustn't", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "or", "other", "ought", "our", "ours ourselves", "out", "over", "own", "same", "shan't", "she", "she'd", "she'll", "she's", "should", "shouldn't", "so", "some", "such", "than", "that", "that's", "the", "their", "theirs", "them", "themselves", "then", "there", "there's", "these", "they", "they'd", "they'll", "they're", "they've", "this", "those", "through", "to", "too", "under", "until", "up", "very", "was", "wasn't", "we", "we'd", "we'll", "we're", "we've", "were", "weren't", "what", "what's", "when", "when's", "where", "where's", "which", "while", "who", "who's", "whom", "why", "why's", "with", "won't", "would", "wouldn't", "you", "you'd", "you'll", "you're", "you've", "your", "yours", "yourself", "yourselves"}; //from https://www.ranks.nl/stopwords
//         ArrayList <String> stopwords = new ArrayList<String>(Arrays.asList(stopwordsArr));
    
//         ArrayList <String> cleaned = new ArrayList<String>();
    
//         String [] pieces = text.split(" ");
//         for(int i = 0; i < pieces.length; i++){
//           String word = pieces[i].toLowerCase();
//           if(!stopwords.contains(word) && word.strip().length() > 0)
//             cleaned.add(word);
//         }
//         return cleaned;
//       }

// public int getSentiment(){
//         String tweet = this.text;
//         Properties props = new Properties();
//         props.setProperty("annotators", "tokenize, ssplit, pos, parse, sentiment");
//         StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
//         Annotation annotation = pipeline.process(tweet);
//         CoreMap sentence = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0);
//         Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
//         return RNNCoreAnnotations.getPredictedClass(tree);
//     }
//     private String content;
//     private String date;

//     // Constructor and other methods...

//     public Sentence(String content, String date) {
//         this.content = content;
//         this.date = date;
//     }
//     public boolean keep(String temporalRange) {
//       // Parse the temporalRange into start and end dates
//       String[] dateRange = temporalRange.split("-");
//       String startDateString = dateRange[0].trim();
//       String endDateString = dateRange[1].trim();

//       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd yyyy");

//       LocalDate startDate = LocalDate.parse(startDateString, formatter);
//       LocalDate endDate = LocalDate.parse(endDateString, formatter);

//       System.out.println(startDate);
//       System.out.println(endDate);
//       // Parse the sentence date into LocalDate
//       String dateToCheck = "May 31 2009-Jun 02 2009";
//       LocalDate sentenceDate = LocalDate.parse(dateToCheck, formatter);

//   // Check if the sentence date is within the specified range
//   return !sentenceDate.isBefore(startDate) && !sentenceDate.isAfter(endDate);

//   Sentence sentence1 = new Sentence("This is a tweet from May 31 2009.", "May 31 2009");
//   Sentence sentence2 = new Sentence("Another tweet from Jun 01 2009.", "Jun 01 2009");
//   Sentence sentence3 = new Sentence("A tweet from Jun 03 2009.", "Jun 03 2009");

//   // List of sentences
//   ArrayList<Sentence> allSentences = new ArrayList<>();
//   allSentences.add(sentence1);
//   allSentences.add(sentence2);
//   allSentences.add(sentence3);

//   // Temporal range to filter
//   temporalRange = "May 31 2009-Jun 02 2009";

//   // Filter sentences within the specified temporal range
//   ArrayList<Sentence> filteredSentences = filterSentencesByTemporalRange(allSentences, temporalRange);

//   // Print the filtered sentences
//   System.out.println("Sentences within the specified temporal range:");
//   for (Sentence sentence : filteredSentences) {
//       System.out.println(sentence.getText() + " - " + sentence.getDate());
//   }
// }

// // Function to filter sentences by temporal range
// private static ArrayList<Sentence> filterSentencesByTemporalRange(ArrayList<Sentence> allSentences, String temporalRange) {
//   ArrayList<Sentence> filteredSentences = new ArrayList<>();

//   for (Sentence sentence : allSentences) {
//       if (sentence.keep(temporalRange)) {
//           filteredSentences.add(sentence);
//       }
//   }

//   return filteredSentences;
// }
// }
    
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Properties;
import org.ejml.simple.SimpleMatrix;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Sentence {

  private String text;
  private String author;
  private String timestamp;
  private String date;

  public Sentence(String text, String author, String timestamp) {
    this.text = text;
    this.author = author;
    this.timestamp = timestamp;
    this.date = timestamp; // Assuming timestamp and date are the same initially
  }

  public Sentence(String text, String date) {
    this.text = text;
    this.date = date;
    this.timestamp = date; // Assuming timestamp and date are the same initially
    this.author = ""; // Default value for author
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDate() {
    return date;
  }

  public String toString() {
    return "{author:" + author + ", sentence:\"" + text + "\", timestamp:\"" + timestamp + "\"}";
  }

  // for Twitter COVID dataset
  public static Sentence convertLine(String line) {
    //System.out.println(line);
    String[] pieces = new String[8];

    String basket = "";
    int ctr = 0;
    boolean startQuote = false;
    for(int i = 0; i < line.length(); i++) {
      if (line.charAt(i) == ',' && startQuote == false) {
        pieces[ctr] = basket;
        basket = "";
        ctr++;
      } else if (line.charAt(i) == '"') {
        startQuote = !startQuote;
      } else {
        basket += line.charAt(i);
      }
    }
    pieces[ctr] = basket;
    //System.out.println(Arrays.toString(pieces));
    String date = pieces[2];
    String username = pieces[4];
    String tweet = pieces[7];
    if(tweet == null) {
      tweet = "empty";
    }
    tweet = tweet.replaceAll("\"", ""); //removes double quotations from tweet
    tweet = tweet.replaceAll("\\.", ""); //removes periods from tweet
    tweet = tweet.replaceAll(",", ""); //removes commas from tweet
    tweet = tweet.replaceAll("!", ""); //removes exclamations from tweet
    // you could have included more/other punctuation here to remove as well
  
    //clean the date from "4/19/2020 0:00" to "April 19 2020"
    //System.out.println(date);
    if(date == null)
      date = "April 19 2020";
    String[] datePieces = date.split(" ");
    String first = datePieces[0];
    datePieces = first.split("/");
    String month = datePieces[0];
    if (month.equals("1"))
      month = "January";
    else if (month.equals("2"))
      month = "February";
    else if (month.equals("3"))
      month = "March";
    else if (month.equals("4"))
      month = "April";
    else if (month.equals("5"))
      month = "May";
    else if (month.equals("6"))
      month = "June";
    else if (month.equals("7"))
      month = "July";
    else if (month.equals("8"))
      month = "August";
    else if (month.equals("9"))
      month = "September";
    else if (month.equals("10"))
      month = "October";
    else if (month.equals("11"))
      month = "November";
    else if (month.equals("12"))
      month = "December";

    if (datePieces == null || datePieces.length < 3)
      date = "April 20 2020";
    else
      date = month + " " + datePieces[1] + " 20" + datePieces[2];
  
    String author = username;
    String text = tweet;
    return new Sentence(text, author, date);
  }

  public ArrayList<String> splitSentence() {
    String[] stopwordsArr = {"a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren't", "as", "at", "be", "because", "been", "before", "being", "below", "between", "both", "but", "by", "can't", "cannot", "could", "couldn't", "did", "didn't", "do", "does", "doesn't", "doing", "don't", "down", "during", "each", "few", "for", "from", "further", "had", "hadn't", "has", "hasn't", "have", "haven't", "having", "he", "he'd", "he'll", "he's", "her", "here", "here's", "hers", "herself", "him", "himself", "his", "how", "how's", "i", "i'd", "i'll", "i'm", "i've", "if", "in", "into", "is", "isn't", "it", "it's", "its", "itself", "let's", "me", "more", "most", "mustn't", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "or", "other", "ought", "our", "ours ourselves", "out", "over", "own", "same", "shan't", "she", "she'd", "she'll", "she's", "should", "shouldn't", "so", "some", "such", "than", "that", "that's", "the", "their", "theirs", "them", "themselves", "then", "there", "there's", "these", "they", "they'd", "they'll", "they're", "they've", "this", "those", "through", "to", "too", "under", "until", "up", "very", "was", "wasn't", "we", "we'd", "we'll", "we're", "we've", "were", "weren't", "what", "what's", "when", "when's", "where", "where's", "which", "while", "who", "who's", "whom", "why", "why's", "with", "won't", "would", "wouldn't", "you", "you'd", "you'll", "you're", "you've", "your", "yours", "yourself", "yourselves"}; //from https://www.ranks.nl/stopwords
    ArrayList<String> stopwords = new ArrayList<String>(Arrays.asList(stopwordsArr));
    
    ArrayList<String> cleaned = new ArrayList<String>();
    
    String[] pieces = text.split(" ");
    for(int i = 0; i < pieces.length; i++) {
      String word = pieces[i].toLowerCase();
      if(!stopwords.contains(word) && word.strip().length() > 0)
        cleaned.add(word);
    }
    return cleaned;
  }

  public int getSentiment() {
    String tweet = this.text;
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize, ssplit, pos, parse, sentiment");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    Annotation annotation = pipeline.process(tweet);
    CoreMap sentence = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0);
    Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
    return RNNCoreAnnotations.getPredictedClass(tree);
  }

  public boolean keep(String temporalRange) {
    try {
      // Parse the temporalRange into start and end dates
      String[] dateRange = temporalRange.split("-");
      String startDateString = dateRange[0].trim();
      String endDateString = dateRange[1].trim();

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd yyyy");

      LocalDate startDate = LocalDate.parse(startDateString, formatter);
      LocalDate endDate = LocalDate.parse(endDateString, formatter);

      // Parse the sentence date into LocalDate
      LocalDate sentenceDate = LocalDate.parse(this.date, formatter);

      // Check if the sentence date is within the specified range
      return !sentenceDate.isBefore(startDate) && !sentenceDate.isAfter(endDate);
    } catch (Exception e) {
      System.out.println("Error parsing date: " + e.getMessage());
      return false;
    }
  }

  // Static method to filter sentences by temporal range
  public static ArrayList<Sentence> filterSentencesByTemporalRange(ArrayList<Sentence> allSentences, String temporalRange) {
    ArrayList<Sentence> filteredSentences = new ArrayList<>();

    for (Sentence sentence : allSentences) {
      if (sentence.keep(temporalRange)) {
        filteredSentences.add(sentence);
      }
    }

    return filteredSentences;
  }
  
  // Example of how to use these methods (typically would be in a main class)
  public static void exampleUsage() {
    // Create sample sentences
    Sentence sentence1 = new Sentence("This is a tweet from May 31 2009.", "May 31 2009");
    Sentence sentence2 = new Sentence("Another tweet from Jun 01 2009.", "Jun 01 2009");
    Sentence sentence3 = new Sentence("A tweet from Jun 03 2009.", "Jun 03 2009");

    // List of sentences
    ArrayList<Sentence> allSentences = new ArrayList<>();
    allSentences.add(sentence1);
    allSentences.add(sentence2);
    allSentences.add(sentence3);

    // Temporal range to filter
    String temporalRange = "May 31 2009-Jun 02 2009";

    // Filter sentences within the specified temporal range
    ArrayList<Sentence> filteredSentences = filterSentencesByTemporalRange(allSentences, temporalRange);

    // Print the filtered sentences
    System.out.println("Sentences within the specified temporal range:");
    for (Sentence sentence : filteredSentences) {
      System.out.println(sentence.getText() + " - " + sentence.getDate());
    }
  }
}
