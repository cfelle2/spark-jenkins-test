node {

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
                  def filelist=s3FindFiles(bucket:'useast1-nlsn-mediaanalytics-emr', path:'script/jenkinstest/', glob:'**/count.py')    

                  print filelist.size()
                  for (String item : filelist) {
                    print item
                  }
                  s3Copy(fromBucket:'useast1-nlsn-mediaanalytics-emr', fromPath:'script/jenkinstest/count.py', toBucket:'useast1-nlsn-mediaanalytics-emr', toPath:'script/jenkinstest_temp/count.py')
                  // Upload files from working directory 'dist' in your project workspace
                  s3Upload(bucket:"useast1-nlsn-mediaanalytics-emr/script/jenkinstest", workingDir:'src', includePathPattern:'**/*');
            }

        };
    }
}
