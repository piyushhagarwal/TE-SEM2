# Hadoop Weather Data Average Assignment

Locate dataset (e.g., sample_weather.txt) for working on weather data which reads the text input files and finds average for temperature, dew point and wind speed.

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

5. - Open Java for Eclipse
    - Create a new Java project
    - Select Java version 1.8
    - Go to libraries >> Add external jars 
        - hadoop >> share >> hadoop >> common >> all jars
        - hadoop >> share >> hadoop >> mapreduce >> all jars
    - Create a new class
    - Copy the code given 
    - Right click on the src >> Export >> Runnable jar file >> select the class with main method >> select the destination folder >> Finish 

6.  Run the jar file

    ```bash
    hadoop jar <`path_of_jar_file`> /31466/input /31466/output
    ```

6. Check the output

    ```bash
    hdfs dfs -cat /31466/output/*
    ```


- Input file will be given in the practical, you just need to copy the path of the files and paste it in the command.
- You have to create the jar file using Eclipse.
- [Youtube video for reference](https://www.youtube.com/watch?v=WLkWLEYDwKk)