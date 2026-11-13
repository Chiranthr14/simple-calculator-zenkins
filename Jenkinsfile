
pipeline {
    agent any

    tools {
        jdk 'JDK 25'
        maven 'Maven-3.10'
    }

    options {
        timestamps()
    }

    stages {

        // 1. Checkout source code
        stage('Checkout SCM') {
            steps {
                echo 'Checking out source code from Git...'
                checkout scm
            }
        }

        // 2. SCM Synchronization
        stage('SCM Synchronization') {
            steps {
                echo 'Checking Git synchronization...'
                bat 'git status'
            }
        }

        // 3. Static Verification
        stage('Static Verification') {
            steps {
                echo 'Checking Java and Maven configuration...'

                bat 'java -version'
                bat 'where mvn'
                bat 'mvn -version'

                echo 'Validating Maven POM...'
                bat 'mvn validate'
            }
        }

        // 4. Compilation
        stage('Compilation') {
            steps {
                echo 'Compiling Simple Calculator...'
                bat 'mvn clean compile'
            }
        }

        // 5. Automated Testing
        stage('Automated Testing') {
            steps {
                echo 'Executing JUnit 5 tests...'
                bat 'mvn test'
            }
        }

        // 6. Recording Test Results
        stage('Recording Test Results') {
            steps {
                echo 'Publishing JUnit test reports...'

                junit(
                    testResults: '**/target/surefire-reports/TEST-*.xml',
                    allowEmptyResults: false
                )
            }
        }
    }

    post {
        success {
            echo 'SUCCESS: Simple Calculator built and tested successfully!'
        }

        failure {
            echo 'FAILURE: Check Console Output for errors.'
        }

        always {
            echo 'Pipeline execution completed.'
        }
    }
}
