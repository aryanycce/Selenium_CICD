pipeline {

    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/aryanycce/Selenium_CICD.git'}}

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML(target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target',
                        reportFiles: 'ExtentReport.html',
                        reportName: 'Extent Report'
                ])
            }
        }
    }
}
