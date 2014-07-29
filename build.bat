javac -cp ".;GLPKSolverPack.jar;SCPSolver.jar" *.java
echo "BUILD FINISHED"
java -cp ".;GLPKSolverPack.jar;SCPSolver.jar" matchmaker 35 
