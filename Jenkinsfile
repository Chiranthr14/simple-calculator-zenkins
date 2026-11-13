
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

        // 1. Checkout SCM
        stage('Checkout SCM') {
            steps {
                echo 'Checking out source code...'
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
                echo 'Checking Java and Maven...'

                bat 'java -version'
                bat 'mvn -version'
                bat 'mvn validate'
            }
        }

        // 4. Compilation
        stage('Compilation') {
            steps {
                echo 'Compiling calculator project...'
                bat 'mvn clean compile'
            }
        }

        // 5. Automated Testing
        stage('Automated Testing') {
            steps {
                echo 'Running JUnit tests...'
                bat 'mvn test'
            }
        }

        // 6. Recording Test Results
        stage('Recording Test Results') {
            steps {
                echo 'Checking generated test reports...'

                bat '''
                    if not exist target\\surefire-reports (
                        echo ERROR: Test reports folder not found!
                        exit /b 1
                    )

                    dir target\\surefire-reports
                '''

                junit(
                    testResults: 'target/surefire-reports/TEST-*.xml',
                    allowEmptyResults: false
                )
            }
        }
    }

    post {
        success {
            echo 'SUCCESS: Calculator project built and tested!'
        }

        failure {
            echo 'FAILURE: Please check Console Output.'
        }

        always {
            echo 'Jenkins pipeline execution completed.'
        }
    }
}
