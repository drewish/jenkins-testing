import org.kohsuke.github.*

//import java.net.URL
//import groovy.json.JsonSlurper

def call(String oauthAccessToken, String query) {
  def gh = GitHub.connectUsingOAuth(oauthAccessToken)
  def search = gh.searchIssues().q('repo:recurly/recurly-app').q('type:pr').q('label:qa4')
  echo search.list
//repo:recurly/recurly-app type:pr label:qa4 state:open

//  JsonSlurper
//  req.add_field "Authorization", "token #{ENV['GITHUB_TOKEN']}"
//  req.add_field "Content-Type", "application/json"
//  echo new URL("http://example.org/").text

  // github_get("https://api.github.com/repos/recurly/#{repo}/issues?per_page=100&state=open&labels=#{URI.escape(label)}")
}
