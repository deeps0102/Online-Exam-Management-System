export CLASSPATH=$CLASSPATH:./mysql-connector-java-8.0.22/mysql-connector-java-8.0.22.jar

javac gui/*.java base/*.java -Xlint:unchecked
java gui.myframe
