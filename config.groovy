
/*
def bucket_name="useast1-nlsn-mediaanalytics-emr"
def app_path="script/jenkinstest"

def delete_path= app_path + "/"
def upload_path= bucket_name + "/" + app_path
*/
class Config {
    // Groovy adds getDEFAULT and no setDEFAULT.
    static final String APP_PATH = 'script/jenkinstest'

    // Groovy adds setMessage/getMessage
    String message

    // Groovy makes method public.
    void message(final String newMessage) {
        this.message = message
    }
}
