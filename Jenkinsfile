pipeline {

    agent any

    tools {
            maven 'Maven 3.6.3'
    }

    stages {

        stage("build") {

            steps {
                echo 'building the application...'
                bat 'mvn clean install'
            }
        }

        stage("docker") {

            steps {
                echo 'building the docker image...'
                bat 'docker version'
                bat 'cd'
                bat 'dir'
//                 bat 'docker build -t spring-boot-app .'
//                 bat 'docker image list'
//                 bat 'docker tag spring-boot-app hardikjain2098/spring-boot-app:spring-boot-app'
            }
        }

        stage("deploy") {

            steps {
                echo 'deploying the application...'
            }
        }
    }
}