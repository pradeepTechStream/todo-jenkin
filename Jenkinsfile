pipeline {
    agent any
    tools {
        jdk 'JDK17'
    }
    triggers {
        cron('H 0 * * 1')
    }
    stages {
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
        stage('SonarQube Analysis') {
               steps {
                        withSonarQubeEnv('SonarQube') {
                            bat """
                                mvn sonar:sonar \
                                -Dsonar.projectKey=todo-app \
                                -Dsonar.host.url=http://localhost:9000 \
                                -Dsonar.token=squ_ac36d77e8d461e5f853720404a9abbc04a8fa77d
                            """
                        }
               }
        }
        stage('Docker Build') {
            steps {
                bat '''
                echo Building Docker image...
                docker build -t todo-app:latest .
                '''
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
           }
        }
        stage('Docker Deploy') {
                        steps {
                            bat '''
                            echo Stopping old container (if running)...
                            docker stop todo-app || echo "No container to stop"
                            docker rm todo-app || echo "No container to remove"

                            echo Starting new container...
                            docker run -d --name todo-app -p 8080:8080 todo-app:latest
                            '''
                        }
        }
    }
    post {
       success {
           echo "Build and deployment successful!"
       }
       failure {
           echo "Build failed. Skipping deployment."
       }
    }
}
