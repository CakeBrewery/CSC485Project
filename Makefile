default: clean build run

build: clean
	javac -cp $$CLASSPATH:GLPKSolverPack.jar:SCPSolver.jar *.java

clean:
	rm -rf *.class

test: clean
	javac test.java && java test

t: clean
	javac test.java && java test

run:
	java -cp $$CLASSPATH:GLPKSolverPack.jar:SCPSolver.jar matchmaker 30
