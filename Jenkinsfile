pipeline {
    agent any

    tools {
        jdk 'JDK 25'
        maven 'Maven-3.10'
    }

    stages {
        stage('Static Verification') {
            steps {
                bat 'where mvn'
                bat 'mvn -version'
                bat 'mvn validate'
            }
        }
    }
}
