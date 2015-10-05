#!/bin/sh

echo "Compiling..."

javac -d bin -cp lib/junit.jar src/*.java

if [ $? -ne 0 ] ; then
	exit $?
fi

echo "---------------"
echo "Compiled files:"

for f in src/*.java
do
	echo "$f"
done
