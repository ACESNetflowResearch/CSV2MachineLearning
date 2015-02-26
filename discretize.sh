echo "inputTrain="
read inputTrain
echo "inputTest="
read inputTest
echo "outputTrain="
read outputTrain
echo "outputTest="
read outputTest
mvn compile exec:java -Dmain.class=discretize.Discretizer -Dexec.args="$inputTrain $inputTest $outputTrain $outputTest"
