time=$(date "+%Y-%m-%d %H:%M:%S").$((`date "+%N"`/1000000))
echo "${time}: begin start"
java -jar ./../target/quarkus-app/quarkus-run.jar