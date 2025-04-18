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

## Example Output
The application produces two main sections of output:

### Word Count Summary
