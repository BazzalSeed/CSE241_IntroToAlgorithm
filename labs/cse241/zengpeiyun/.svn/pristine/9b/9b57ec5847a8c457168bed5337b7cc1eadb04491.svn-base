#!/bin/sh

unamestr=`uname`
if [[ "$unamestr" == 'Linux' ]]; then
	java -cp bin:lib/junit.jar lab0.TestLab0
elif [[ "$unamestr" == 'Darwin' ]]; then
	java -cp bin:lib/junit.jar lab0.TestLab0
else
	java -cp "bin;lib/junit.jar" lab0.TestLab0
fi
