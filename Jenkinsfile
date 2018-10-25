node {

  def gitcredentialsId='12345-1234-4696-af25-123455'
  def giturl='https://github.com/cfelle2/spark-jenkins-test.git'

    stage('Checkout') {

      git branch: 'master',
    //  credentialsId: '12345-1234-4696-af25-123455',
      //url: 'https://github.com/cfelle2/spark-jenkins-test.git'
      url: giturl
    }
    //docker inspect -f . gettyimages/spark Need to add this somewhere
    docker.image('gettyimages/spark').inside {
      stage('UnitTests') {
        sh '/usr/spark-2.3.1/bin/spark-submit src/count.py'
      }
    }
    stage('Upload') {

        def config = load pwd() + '/config.groovy'

        print config.getBucketName()
        print config.getAppPath()
        print config.getDeletePath()
        print config.getUploadPath()

          //dir('/var/jenkins_home/workspace/${WORKSPACE}'){
          dir(''){

            pwd(); //Log current directory

            withAWS(region:'us-east-1',credentials:'108383104151') {

                  def identity=awsIdentity();//Log AWS credentials

                  //Delete the previous version
                  s3Delete(pathStyleAccessEnabled: true, bucket:config.getBucketName(), path:config.getDeletePath())
                  // Upload files from working directory 'dist' in your project workspace
                  s3Upload(bucket:config.getUploadPath(), workingDir:'src', includePathPattern:'**/*');
            }

        };
    }
}
