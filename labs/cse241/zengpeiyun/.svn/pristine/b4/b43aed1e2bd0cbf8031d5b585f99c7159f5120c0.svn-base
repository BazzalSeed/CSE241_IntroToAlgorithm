#!/bin/sh

unamestr=`uname`
if [[ "$unamestr" == 'Linux' ]]; then
	java -cp bin:lib/junit.jar lab1.TestLab1
elif [[ "$unamestr" == 'Darwin' ]]; then
	java -cp bin:lib/junit.jar lab1.TestLab1
else
	java -cp "bin;lib/junit.jar" lab1.TestLab1
fi