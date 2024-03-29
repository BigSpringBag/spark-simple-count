#!/bin/bash

echo "Compiling application..."
sbt assembly

# Directory where spark-submit is defined
# Install spark from https://spark.apache.org/downloads.html
SPARK_HOME=/Users/BSB/spark-2.1.0-bin-hadoop2.6

# JAR containing a simple count
JARFILE=`pwd`/target/scala-2.11/SimpleCount-assembly-1.0.jar

# Run it locally
${SPARK_HOME}/bin/spark-submit --class SimpleCount --master local $JARFILE
