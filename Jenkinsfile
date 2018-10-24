node {

  //def config = load 'config.groovy'

  def bucket_name="useast1-nlsn-mediaanalytics-emr"
  def app_path="script/jenkinstest"

  def delete_path= app_path + "/"
  def upload_path= bucket_name + "/" + app_path


    def config = load 'config.groovy'

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

          print config.apppath

          //dir('/var/jenkins_home/workspace/${WORKSPACE}'){
          dir(''){

            pwd(); //Log current directory

            withAWS(region:'us-east-1',credentials:'108383104151') {

                  def identity=awsIdentity();//Log AWS credentials

                  //Delete the previous version
                  s3Delete(pathStyleAccessEnabled: true, bucket:bucket_name, path:delete_path)
                  // Upload files from working directory 'dist' in your project workspace
                  s3Upload(bucket:upload_path, workingDir:'src', includePathPattern:'**/*');
            }

        };
    }
}
