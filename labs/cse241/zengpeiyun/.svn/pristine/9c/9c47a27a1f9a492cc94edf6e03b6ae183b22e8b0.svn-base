#!/bin/sh

echo "Compiling..."

javac -d bin -Xlint:deprecation -cp lib/junit.jar src/*.java

echo "---------------"
echo "Compiled files:"

for f in src/*.java
do
	echo "$f"
done
