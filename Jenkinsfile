pipeline {
    agent any
    // tools not required - because Jenkins running on a local machine (not in Docker-container)
    // tools{
    //     jdk 'jdk17'
    //     maven 'mvn391'
    // }
    stages {
        stage('Maven build'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ArtemYablokov/demo']]])
                // sh 'env | grep -A 1 -e PATH -e JAVA_HOME'
                sh 'mvn --version'
                sh 'java --version'
                sh 'mvn clean install'
            }
        }
        stage('Docker build, push'){
            steps{
                sh 'docker --version'
                sh 'docker build -t yablokov/demo .'

                // sh 'echo $dockerhub_PSW | docker login -u $dockerhub_USR --password-stdin'
                withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u yablokov -p ${dockerhubpwd}'
                }
                sh 'docker push yablokov/demo'
            }
        }
        stage('k8s deploy'){
            steps{
                sh 'minikube version'
                kubernetesDeploy (configs: 'deployment.yml', kubeconfigId: 'k8sconfig')
            }
        }
    }
}