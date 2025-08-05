#!/bin/bash
cd /Users/hadjioglo/IdeaProjects/Automation-Framework

# Direct path to the commons-csv JAR file
COMMONS_CSV_JAR="/Users/hadjioglo/.m2/repository/org/apache/commons/commons-csv/1.10.0/commons-csv-1.10.0.jar"

# Build classpath with the required JAR and compiled classes
CP="$COMMONS_CSV_JAR:target/test-classes"

# Run the Java program
java -cp "$CP" TransformerFromCSVtoMD "$@"
