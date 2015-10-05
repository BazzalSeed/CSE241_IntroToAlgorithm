#!/bin/sh

unamestr=`uname`
if [[ "$unamestr" == 'Linux' ]]; then
	java -cp bin:lib/junit.jar lab2.TestLab2
elif [[ "$unamestr" == 'Darwin' ]]; then
	java -cp bin:lib/junit.jar lab2.TestLab2
else
	java -cp "bin;lib/junit.jar" lab2.TestLab2
fi