CP		= lib/*:bin
TESTIFACES = bin/SameFileName.class bin/NoMethod.class bin/OneMethod.class bin/ManyMethods.class bin/ReturnTypes.class bin/ParameterTypes.class bin/ParameterNumber.class bin/StaticMethods.class bin/ExceptionMethods.class bin/CustomClasses.class bin/IdentifierCharacters.class
CLASSES = bin/Circle.class bin/Rectangle.class bin/Square.class

.SILENT : test

all : $(CLASSES) $(TESTIFACES) bin/myDifferenceListener.class bin/RegressionHelpers.class bin/J2WsdlRegrTest.class

# This is meant be used like "$(make test) <TestClassName>" in a shell
test :
	echo 'java -cp $(CP) org.junit.runner.JUnitCore' 

%.class : bin/%.class 

bin/%.class : src/%.java
	javac -classpath "$(CP)" -d bin "$<"

purge :
	rm -fr bin/*.class wsdl/*
