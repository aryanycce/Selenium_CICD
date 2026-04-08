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
                // Runs the tests. If this fails, the pipeline skips the remaining stages 
                // but WILL still run the 'post' block below.
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
            stage('Publish Report') {
                // Publishes the report whether the build/tests passed or failed
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
}
