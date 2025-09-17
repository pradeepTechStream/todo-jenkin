pipeline {
    agent any
    stages {
        tools {
            jdk 'JDK17'
        }
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/pradeepTechStream/todo-jenkin.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
           }
        }
    }
}
