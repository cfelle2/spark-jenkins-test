pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
                docker {
                    image 'gettyimages:spark'
                }
            }
            steps {
                sh 'bin/spark-submit src/count.py' 
            }
        }
    }
}
