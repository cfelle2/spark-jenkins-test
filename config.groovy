import groovy.transform.Field
@Field private BucketName = null
//@Field private AppPath = "script/jenkinstest"

def init(bucketname, apppath) {
    BucketName = bucketname
  //  AppPath = apppath
}
def getBucketName(){
    //return BucketName
    return "useast1-nlsn-mediaanalytics-emr"
}
//def getAppPath(){
//    return AppPath
//}
return this
