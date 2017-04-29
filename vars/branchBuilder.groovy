import org.kohsuke.github.GitHub

def call(String oauthAccessToken) {
  def gh = GitHub.connectUsingOAuth(oauthAccessToken)
}
