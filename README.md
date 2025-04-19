# COVID-19 Twitter Analysis Project

## Overview
Takes a CSV of over 1 Million tweets about COVID-19 and analyzes the sentiment behind them assigning positive or negative thoughts about each tweet as well as the number of times each word appeared in the dataset.

## Features
- Parses and processes tweets from a CSV dataset
- Sentiment analysis of tweets using Stanford CoreNLP
- Word frequency analysis (counts occurrences of words after removing stopwords)
- Temporal filtering based on tweet dates

## Code Structure
The project consists of two main Java classes:

### Sentence.java
- Represents a tweet with text, author, timestamp, and date
- Provides methods for:
  - Converting CSV lines to Sentence objects
  - Splitting sentences into words (removing stopwords)
  - Performing sentiment analysis using Stanford CoreNLP
  - Filtering tweets based on date ranges

### Driver.java
- Main application class
- Reads the Twitter dataset from CSV
- Processes tweets and counts word frequencies
- Displays sorted word counts (most frequent first)
- Shows sentiment analysis results for each tweet

## Dependencies
- Stanford CoreNLP (for sentiment analysis)
- EJML (Efficient Java Matrix Library)
- Java Time API (for date processing)

## Dataset
The code reads from a CSV file containing COVID-19 related tweets. The expected CSV format has at least 8 columns, including:
- Column 3: Date information
- Column 5: Username
- Column 8: Tweet content

## How It Works
1. The application reads tweets from the CSV file
2. Each tweet is processed to:
   - Clean the text (remove punctuation)
   - Format the date properly
   - Extract the username
3. The application performs two main analyses:
   - Word frequency analysis: counts non-stopwords and displays them sorted by frequency
   - Sentiment analysis: determines the sentiment score of each tweet

## How To Use It

### Step 1: Clone the Repository

Git clone this repository into your folder of choice using 
  ```bash
    git clone https://github.com/Coleg2005/COVID-Sentiment-Analyzer
  ```
 and make a folder inside called lib.


### Step 2: Download Needed Files

If you don't have JDK (Java Development Kit) installed, install it [here](https://www.oracle.com/java/technologies/downloads/).

Then download these 3 dependencies and put them into the lib folder.

Install the zip folder [here](https://nlp.stanford.edu/software/stanford-corenlp-full-2018-10-05.zip)

From the zip folder, you only need one file:
    ```bash
    stanford-corenlp-3.9.2.jar
    ```

The second & third file you will need can be found [here](https://repo1.maven.org/maven2/com/googlecode/efficient-java-matrix-library/ejml/0.23/ejml-0.23.jar) and [here](https://nlp.stanford.edu/software/stanford-english-corenlp-2018-10-05-models.jar)

Put these 3 files in the lib folder

6. **Compile the project:**
        
    - **MacOS/Linux:**
        ```bash
        javac -cp "lib/*:." -d . src/*.java
        ```
    - **Windows:**
        ```bash
        javac -cp "lib/*;." -d . src/*.java
        ```
7. **Run the project:**

    - **MacOS/Linux:**

        ```bash
        java -cp "lib/*:." src.Driver
        ```

    - **Windows:**
        ```bash
        java -cp "lib/*;." src.Driver
        ```

## Example Output
The application produces two main sections of output:

### Word Count Summary
![Word Count Summary](./assests/Word_Count.png)

### Sentiment Analysis
![Sentiment Analysis](./assests/Sentiment_Analysis.png)
