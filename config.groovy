import groovy.transform.Field
@Field private BucketName = "useast1-nlsn-mediaanalytics-emr"
@Field private AppPath = "script/jenkinstest"

def init(bucketname, apppath) {
    BucketName = bucketname
    AppPath = apppath
}
def getBucketName(){
    return BucketName
}
def getAppPath(){
    return AppPath
}
return this
