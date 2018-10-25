import groovy.transform.Field

@Field private BucketName = "useast1-nlsn-mediaanalytics-emr"
@Field private AppDir = "jeninstest"
//@Field private AppPath = "script/jenkinstest"

def init(bucketname, appdir) {
    BucketName = bucketname
    //AppPath = apppath
    AppDir = appdir
}
def getBucketName(){
    return BucketName
}
def getAppPath(){
    return  "script/" + AppDir
}
def getDeletePath(){
    return getAppPath() + "/"
}
def getUploadPath(){
    return BucketName + "/" + getAppPath()
}

return this
