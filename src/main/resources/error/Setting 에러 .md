# Setting 에러

Spring boot  환경 설정 

- 문제

Cause: invalid source release: 11

- 문제원인

start.spring.io에서 자바의 버젼을 11로 설정하였는데  다른버젼으로 되어있어서 발생하는 에러 

- 해결

File → Project Structure → Project → Project SDK 버전 확인(Java 11) 

File → Settings → Build, Execution, Deployment → Build Tools → Gradle → Gradle JVM 버전 확인(Java11)