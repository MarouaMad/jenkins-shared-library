#!/usr/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'gihubToken', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t mimi360/maven-app-demo:1.2 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push mimi360/maven-app-demo:1.2'


    }
}