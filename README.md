# Zerubbabel

![Zerubbabel aka Zrubbie](zerubbabel.jpg?raw=true "Zerubbabel aka Zrubbie")

This is an attempt to solve a problem in different languages using a functional programming paradigm, in order to compare the different implementations.

## The Problem

How many times does the word God appear in the Bible? And how about Jesus? Is there more love than hate in the bible? How about sheep vs goats? And most importantly, is there really a guy named Zerubbabel in the Bible? In this project, we intend to analyze the bible text and create a dictionary with words as keys and the number of appearances as values, in order to draw some conclusions about the questions above.

## Implementation

The implementation should contain the following parts:

### The project
Want to add a new implementation? Add a new folder with the specific language you want to implement it in. 

### The text
A text file called bible.txt resides in the root folder. Copy it to your project and read it in your program.

### The words
Read all the words in the text file into a list or an array. Make them all lowercase.
 
### The filters
* remove empty words using the following regex: **^\w+**
* remove the following boring words: **the, and, of, to, that, for, in, i, his, a, with, it, be, is, not, they, thou**

### The dictionary 
Group the words with words as keys and the number of places in which they appear as values. This should be the return value of your function.

## Tests

In order to test your implementation, create the following tests and make them green:

| Title | value to test | expected result |
--------|---------------|-----------------|
| The Bible should contain many different words | length of the dictionary | 9582 |
| God should appear a lot of times | # of times "god" appears in the dictionary | 2303 |
| Jesus should be there too | # of times "jesus" appears in the dictionary | 777 |
| There's more love than hate in the bible | # of times "love" appears in the dictionary compared with # of times "hate" does | "love" should be bigger than "hate" |
| There's more sheep than goats in the bible | # of times "sheep" appears in the dictionary compared with # of times "goat" does | "sheep" should be bigger than "goat" |
| Boring words should be removed | # of times "the", "and" or "of" appear in the dictionary | 0 or null |
| Oh, and there should be a guy named Zerubbabel | # of times "zerubbabel" appears in the dictionary | 11 |
### 
