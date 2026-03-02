pipeline {
    agent any

    tools {
        maven 'Maven-3.9'   // Ensure this matches the Maven installation name in Jenkins
        jdk 'JDK-17'        // Ensure this matches your Jenkins JDK installation
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/MeghanaGangavarapu/Devops-practice.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests=false'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package Application') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
        success {
            echo "Build successful!"
        }
        failure {
            echo "Build failed!"
        }
    }
}
  
