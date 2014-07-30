"%ProgramFiles(x86)%\Java\jdk1.7.0_45\bin\javac" -cp ".;GLPKSolverPack.jar;SCPSolver.jar" *.java
echo "BUILD FINISHED"
"%ProgramFiles(x86)%\Java\jdk1.7.0_45\bin\java" -cp ".;GLPKSolverPack.jar;SCPSolver.jar" matchmaker 55 
