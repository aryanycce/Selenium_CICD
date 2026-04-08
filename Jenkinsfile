pipeline {

    agent any

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

        stage('Run UI + API Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Verify Reports Generated') {
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

        stage('Publish TestNG Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }

    }
}
