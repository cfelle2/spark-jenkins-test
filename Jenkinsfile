pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
                docker {
                    image 'gettyimages/spark'
                }
            }
            steps {
                sh '/usr/spark-2.3.1/bin/spark-submit src/count.py'
            }
        }
    }
}
