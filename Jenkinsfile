pipeline{
    agent any
    
    environment {
        registry = "tusharsharma/spemajordevops"
        registryCredential = 'DOCKERHUB'
       
    }
    
    stages {
        stage('Git clone') {
            steps {
                git url: 'https://github.com/tushar170255/speMajorDevOps.git', branch: 'master'
                // credentialsId: 'Github-token'
            }
        }
        stage('Install dependency') {
            steps {
               
                sh 'mvn clean install'
                
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t tusharsharma3/hero ./Hero'
                 sh 'docker build -t tusharsharma3/angular-app ./frontend'
                
            }
        }
        stage('Docker Push') {
            steps {
                script{
                    withCredentials([string(credentialsId:'DOCKERHUB',variable:'dockerhub')]){
                        sh 'docker login -u tusharsharma3 -p ${dockerhub}'
                        sh 'docker push tusharsharma3/hero:latest'
                         sh 'docker push tusharsharma3/angular-app:latest'
                        
                    }
                    
                }
            }
        }
        stage('Clean Docker Images') {
            steps {
                sh 'docker rmi -f tusharsharma3/hero:latest'
                sh 'docker rmi -f tusharsharma3/angular-app: latest'
            }
        }
        stage('Ansible Deploy') {
             steps {
                  ansiblePlaybook colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'deploy.yml'
             }
        }
    }
}
