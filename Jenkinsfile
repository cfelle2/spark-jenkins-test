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
        steps {
        dir('/var/jenkins_home/workspace/sparktestbitbucket'){

        pwd(); //Log current directory

        withAWS(region:'us-east-1',credentials:'108383104151') {

             def identity=awsIdentity();//Log AWS credentials

            // Upload files from working directory 'dist' in your project workspace
            s3Upload(bucket:"useast1-nlsn-mediaanalytics-emr/script/jenkinstest", workingDir:'src', includePathPattern:'**/*');
        }

    };
    }
    }

        }
}
