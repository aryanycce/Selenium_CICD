pipeline {

    agent any

    tools {
        maven 'Maven3'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/aryanycce/Selenium_CICD.git'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Verify Report Generated') {
            steps {
                bat 'dir target'
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML(target: [
                        allowMissing: true,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target',
                        reportFiles: 'ExtentReport.html',
                        reportName: 'Extent Automation Report'
                ])
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/*.html', fingerprint: true
        }
    }
}
