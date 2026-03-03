pipeline {
  agent any

  tools {
    maven 'maven'
    jdk 'Java17'
  }
  stages {

    stage('checkout Code'){
      steps {
        git 'https://github.com/MeghanaGangavarapu/Devops-practice.git'
      }
    }

    stage('Build') {
      steps {
        sh 'mvn clean package'
      } 
    }

    stage('Test') {
      steps { 
        sh 'mvn clean package'
      }
    }

    stage('Run') {
      steps {
        sh 'java -jar target/*.jar'
      }
    }
  }
}
