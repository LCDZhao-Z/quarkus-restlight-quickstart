time=$(date "+%Y-%m-%d %H:%M:%S").$((`date "+%N"`/1000000))
echo "${time}: begin start"
./../target/quarkus-restlight-quickstart-1.0.0-SNAPSHOT-runner