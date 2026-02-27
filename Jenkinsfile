
pipeline {
  agent any
  options { timestamps() }
  stages {
    stage('Checkout') {
      steps {
        git url: 'https://github.com/MeghanaGangavarapu/devops.git',
            branch: 'main',
            credentialsId: 'github-pat'
      }
    }
    stage('Verify') {
      steps {
        sh 'git log -1 --oneline || true'
        sh 'ls -la'
      }
    }
  }
}
