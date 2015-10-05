#!/bin/sh

unamestr=`uname`
if [[ "$unamestr" == 'Linux' ]]; then
	java -cp bin:lib/junit.jar lab3.TestLab3
elif [[ "$unamestr" == 'Darwin' ]]; then
	java -cp bin:lib/junit.jar lab3.TestLab3
else
	java -cp "bin;lib/junit.jar" lab3.TestLab3
fi
