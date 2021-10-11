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

        stage("test") {

            steps {
                echo 'testing the application...'
            }
        }

        stage("deploy") {

            steps {
                echo 'deploying the application...'
            }
        }
    }
}