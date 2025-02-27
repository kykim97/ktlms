# 

## Model
www.msaez.io/#/113568664/storming/ktlms

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- analysis
- recommendation
- study
- user
- boundedcontext10121951219512196


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- analysis
```
```
- recommendation
```
 http :8088/recommendations id="id"studentId="studentId"lectureId="lectureId"recommendation="recommendation"
```
- study
```
 http :8088/lectures lectureId="lectureId"강의명="강의명"강의설명="강의설명"파일유형="파일유형"강사명="강사명"documentId="documentId"강의상태="강의상태"강의시작일="강의시작일"강의종료일="강의종료일"수료기준="수료기준"강의분류="강의분류"
```
- user
```
 http :8088/teacherInfos teacherId="teacherId"name="name"teacherNo="teacherNo"
 http :8088/studentInfos studentId="studentId"name="name"studentNo="studentNo"interest="interest"
```
- boundedcontext10121951219512196
```
 http :8088/registrations id="id"lectureId="lectureId"studentId="studentId"achievement="achievement"startingDay="startingDay"endingDay="endingDay"passed="passed"submitted="submitted"
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```
