
/*
def bucket_name="useast1-nlsn-mediaanalytics-emr"
def app_path="script/jenkinstest"

def delete_path= app_path + "/"
def upload_path= bucket_name + "/" + app_path
*/
import groovy.transform.Field
@Field private First = null

def init(first) {
    First = first
}
def test1(){
    //add code for this method
}
def test2(){
    First.test2()
}
return this
