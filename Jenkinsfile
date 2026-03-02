pipeline {
  agent any

  environment {
    // Adjust if your agents have a different Java installed
    JAVA_HOME = tool name: 'JDK17', type: 'hudson.model.JDK' // OPTIONAL: only if you actually have a tool named JDK17
    PATH = "${JAVA_HOME}/bin:${env.PATH}"
  }

  options {
    timestamps()
    ansiColor('xterm')
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
        sh 'chmod +x mvnw || true'
      }
    }

    stage('Build & Test') {
      steps {
        sh './mvnw -B -e clean verify'
      }
      post {
        always {
          junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
      }
    }

    stage('Package') {
      steps {
        sh './mvnw -B package -DskipTests'
      }
    }

    stage('Archive Artifacts') {
      steps {
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }
  }
}
       
        
