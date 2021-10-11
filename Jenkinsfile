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
                bat 'mvn clean install'
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
            }
        }

        stage("deploy") {

            steps {
                echo 'deploying the application...'
            }
        }
    }
}