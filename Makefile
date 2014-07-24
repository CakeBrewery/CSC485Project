default: clean build run

build: clean
	javac *.java

clean:
	rm -rf *.class

test: clean
	javac test.java && java test

t: clean
	javac test.java && java test

run:
	java matchmaker
