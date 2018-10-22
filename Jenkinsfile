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
        stage('S3Upload') {
            agent none
            steps {
                dir('/var/jenkins_home/workspace/sparktestbitbucket'){

                pwd(); //Log current directory

            }
        }
    }
}
