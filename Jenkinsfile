@Library('jenkins-shared-library')_
pipeline {
    agent any

    stages {
        stage('Bumb Version') {
            steps {
                script{
                    bumpVersion()
                }
                
            }
        }
    }
}
