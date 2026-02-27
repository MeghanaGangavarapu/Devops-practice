pipeline {
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
  }
}

