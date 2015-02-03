CP		= lib/*:bin

.SILENT : test

all : bin/ManyMethods.class bin/myDifferenceListener.class bin/NoMethod.class bin/RegressionHelpers.class bin/J2WsdlRegrTest.class

# This is meant be used like "$(make test) <TestClassName>" in a shell
test :
	echo 'java -cp $(CP) org.junit.runner.JUnitCore' 

bin/%.class : src/%.java
	javac -classpath "$(CP)" -d bin "$<"

presentation : doc/presentation/presentation.pdf

%.pdf : %.tex
	texexec --purge --result="$*" "$<"

purge :
	rm -fr bin/*.class wsdl/*
