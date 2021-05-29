cd springcloud-api;
mvn install;
cd ..;
cd springcloud-eureka-7001;
mvn install;
nohup java -jar target/springcloud-eureka-7001-1.0-SNAPSHOT.jar &