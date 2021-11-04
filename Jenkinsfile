pipeline {

    agent any

    tools {
            maven 'Maven 3.6.3'
    }

    stages {

        stage("build") {

            steps {
                echo 'building the application...'
                bat 'mvn -version'
                bat 'mvn clean install -DskipTests'
            }
        }

        stage("docker build") {

            steps {
                echo 'building the docker image...'
                bat 'docker version'
                bat 'docker build -t spring-boot-app .'
                bat 'docker tag spring-boot-app hardikjain2098/spring-boot-app:spring-boot-app'
                bat 'docker image list'
            }
        }

        stage("docker push") {

            steps {
                echo 'pushing the docker image to docker hub...'
                withCredentials([usernamePassword(credentialsId: 'docker-credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    bat "docker login -u ${USERNAME} -p ${PASSWORD}"
                }
                bat 'docker push hardikjain2098/spring-boot-app:spring-boot-app'
                bat 'docker rmi spring-boot-app'
                bat 'docker rmi hardikjain2098/spring-boot-app:spring-boot-app'
            }
        }

        stage("deploy") {

            steps {
                echo 'deploying the application...'
                withKubeConfig([credentialsId: 'minikube-certificate']) {
                    bat 'kubectl version'
                    bat 'kubectl delete deployment spring-boot-app'
                    bat 'kubectl delete service spring-boot-app-service'
                    bat 'kubectl apply -f deployment.yml'
                    bat 'kubectl get all'
                }
            }
        }
    }
}