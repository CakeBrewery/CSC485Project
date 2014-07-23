default: clean build run

build: clean
	javac *.java

clean:
	rm -rf *.class

run:
	java matchmaker
