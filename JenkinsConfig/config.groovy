import groovy.transform.Field

@Field private BucketName = null
@Field private AppDir = null

def init(bucketname, appdir) {
    BucketName = bucketname
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
