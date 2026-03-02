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
=======
  agent any

  stages {
    stage('Checkout') {
      steps {
        git url: 'https://github.com/MeghanaGangavarapu/Devops-practice.git',
            branch: 'main',
            credentialsId: 'github-pat'
      }
    }

    stage('Build') {
      steps {
        echo "Building..."
      }
    }
    
stage('Test') {
            steps {
                echo "Test Success!"
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploy Success!"

  }
}
  }
}

>>>>>>> d3997892ecc0c2c9ce993b31791b9c3759f0997f
