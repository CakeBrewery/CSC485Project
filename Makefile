default: clean build run

build: clean
	javac *.java

clean:
	rm -rf *.class

test: clean
	javac test.java && java test

t: clean
	javac test.java && java test

mac: clean
	javac -cp $CLASSPATH:GLPKSolverPack.jar:SCPSolver.jar *.java

run:
	java -cp $CLASSPATH:GLPKSolverPack.jar:SCPSolver.jar matchmaker 30
