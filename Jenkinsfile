pipeline{
    agent any
    
    environment {
        registry = "tusharsharma/spemajordevops"
        
          docker_hub_credentials = credentials('DOCKERHUB')
       
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
                dir("Hero"){
               
                     sh 'mvn clean install'
                }
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
                sh 'echo $docker_hub_credentials_PSW | docker login -u $docker_hub_credentials_USR --password-stdin'
                dir("front-end")
        		{
        			sh 'docker push tusharsharma3/angular-app:latest'	
        		}
        		dir("Hero")
        		{
        			sh 'docker push tusharsharma3/hero:latest'	
        		}
                sh 'docker logout'
            }
        
        }
        stage('Clean Docker Images') {
            steps {
                sh 'docker rmi -f tusharsharma3/hero:latest'
                sh 'docker rmi -f tusharsharma3/angular-app:latest'
            }
        }
        stage('Ansible Deploy') {
             steps {
//                   ansiblePlaybook colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'deploy.yml'
         
                 
             sh 'ansible-playbook deploy.yml -i inventory --extra-vars "ansible_sudo_pass=123456" -e "ansible_python_interpreter=/usr/bin/python3"'
             }
        }
    }
}
