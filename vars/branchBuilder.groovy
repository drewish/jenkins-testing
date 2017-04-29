//import org.kohsuke.github.GitHub
import java.net.URL

def call(String oauthAccessToken) {
//  def gh = GitHub.connectUsingOAuth(oauthAccessToken)
  echo new URL("http://example.org/").text

  // github_get("https://api.github.com/repos/recurly/#{repo}/issues?per_page=100&state=open&labels=#{URI.escape(label)}")
}
