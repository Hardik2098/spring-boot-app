pipeline {

    agent any

    tools {
            maven 'Maven'
            jdk 'OpenJDK-11'
    }

    stages {

        stage("build") {

            steps {
                echo 'building the application...'
                echo "PATH = ${PATH}"
                echo "M2_HOME = ${M2_HOME}"
                echo "JAVA_HOME = ${JAVA_HOME}"
//                 sh 'mvn -Dmaven.test.failure.ignore=true install'
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