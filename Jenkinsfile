pipeline {
    agent any
    
    stages {
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
        
        stage('Verify Report Exists') {
            steps {
                bat 'dir target'
            }
        }
    }
    
    // The post block runs after all stages have been evaluated
    post {
        always {
            // Run the publishHTML step directly, without wrapping it in a 'stage'
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target',
                reportFiles: 'ExtentReport.html',
                reportName: 'Extent Automation Report'
            ])
        }
    }
}
