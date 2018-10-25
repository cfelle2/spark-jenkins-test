import groovy.transform.Field
@Field private BucketName = "useast1-nlsn-mediaanalytics-emr"
@Field private AppPath = "script/jenkinstest"
/*
def bucket_name="useast1-nlsn-mediaanalytics-emr"
def app_path="script/jenkinstest"

def delete_path= app_path + "/"
def upload_path= bucket_name + "/" + app_path
/*
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
