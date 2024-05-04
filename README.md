# Compression Tool

This application is my solution to the Coding Challenges series "Compression tool". The page to this challenge can be found [here](https://codingchallenges.fyi/challenges/challenge-huffman/).

## Description

The challenge is to build your own command like tool to compress text files.

In the early 1950s David Huffman developed an algorithm to find the optimal prefix code that can be used for lossless data compression.
Given there is usually an unequal distribution of character occurrences in text this can then be used to compress data by giving the most commonly occurring characters the shortest prefix.

To get a gist of the algorithm + the implementation part of Huffman encoding checkout [this page](https://opendsa-server.cs.vt.edu/ODSA/Books/CS3/html/Huffman.html)

## Build

The most popular choice for java projects is eclipse but just as an experiment, I worked on this project using vscode as my IDE. It was easy and did not take much time. I followed the [docs](https://code.visualstudio.com/docs/java/java-tutorial) to setup the java environment. I also used gradle build tools for my project along with version JDK 21. There are no other packages required as such to build this project, this is just a regular java project ( no spring, hibernate etc frameworks needed in the build process).

## Usage

1> Clone this repo and open on vscode.
2> Install jdk version 21
3> Select gradle tools plugin
4> Install the java debugger and java extension pack by Microsoft on vscode
5> Navigate to launch.json file and modify the "args" to include the required file. Existing args is "test.txt" stored in root directory
6> Modify the output file in the main.java to write to a different file

## Run

To run the file. Store all the java files in one directory and complie all of them together. And execute main.java by providing the input file as args
If using vscode simply click on the run button on the top left of window in main.java
