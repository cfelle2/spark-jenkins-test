node {
    def app_path="script/jenkinstest"
    def bucket_name="useast1-nlsn-mediaanalytics-emr"
    def bucket_path="useast1-nlsn-mediaanalytics-emr/script/jenkinstest"
    def upload_path= + "/" + app_path

    stage('Checkout') {
      git branch: 'master',
    //  credentialsId: '12345-1234-4696-af25-123455',
      url: 'https://github.com/cfelle2/spark-jenkins-test.git'
    }
    //docker inspect -f . gettyimages/spark Need to add this somewhere
    docker.image('gettyimages/spark').inside {
      stage('UnitTests') {
        sh '/usr/spark-2.3.1/bin/spark-submit src/count.py'
      }
    }
    stage('Upload') {

          //dir('/var/jenkins_home/workspace/${WORKSPACE}'){
          dir(''){

            pwd(); //Log current directory

            withAWS(region:'us-east-1',credentials:'108383104151') {

                  def identity=awsIdentity();//Log AWS credentials


                  s3Delete(pathStyleAccessEnabled: true, bucket:bucket_name, path:appname)
                  // Upload files from working directory 'dist' in your project workspace
                  //s3Upload(bucket:bucket_path, workingDir:'src', includePathPattern:'**/*');
            }

        };
    }
}
