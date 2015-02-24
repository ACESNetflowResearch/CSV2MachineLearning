echo "inputTrain="
read inputTrain
echo "inputTest="
read inputTest
echo "outputTrain="
read outputTrain
echo "outputTest="
read outputTest
mvn compile exec:java -Dmain.class=discretize.Discretizer -DinputTrain=$inputTrain -DinputTest=$inputTest -DoutputTrain=$outputTrain -DoutputTest=$outputTest
