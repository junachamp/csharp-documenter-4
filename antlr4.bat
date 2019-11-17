SET CLASSPATH=.;C:\apps\ANTLR\antlr-4.7.2-complete.jar;%CLASSPATH%;
java org.antlr.v4.Tool CSharpParser.g4
javac *.java
javac CSharpParser*.java Main.java translate.java
cls
java translate.java entrada.txt
