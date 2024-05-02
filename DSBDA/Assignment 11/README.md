# Hadoop Word Count Assignment

Write a code in JAVA for a simple Word Count application that counts the number of occurrences of each word in a given input set using the Hadoop Map-Reduce framework on local-standalone set-up.

## Steps

0. Files >> Home >> hadoop >> sbin -> open in terminal

1. Start hadoop services

    ```bash
    start-all.sh
    ```

2. Go to `localhost:9870` to check the status of the services.

3. Create a directory in HDFS

    ```bash
    hdfs dfs -mkdir /31466
    ```

4. Create an input directory and put the `input.txt` file in it.

    ```bash
    hadoop dfs -mkdir /31466/input
    hadoop dfs -put <`path_of_input_file`> /31466/input
    ```

5.  Run the jar file

    ```bash
    hadoop jar <`path_of_jar_file`> wordcount /31466/input /31466/output
    ```

6. Check the output

    ```bash
    hdfs dfs -cat /31466/output/*
    ```


- Jar file and input file will be given in the practical, you just need to copy the path of the files and paste it in the command.
- [Youtube video for reference](https://www.youtube.com/watch?v=ETZa3c3AFI8)