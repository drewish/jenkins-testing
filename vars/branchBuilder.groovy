import org.kohsuke.github.*

//import java.net.URL
//import groovy.json.JsonSlurper

def call(String oauthAccessToken) {
  def repoName = 'recurly/recurly-app'
  def lableName = 'qa4'
  def gh = GitHub.connectUsingOAuth(oauthAccessToken)
  def repo = gh.getRepository(repoName)
  // repo:recurly/recurly-app type:pr label:qa4 state:open

  def search = gh.searchIssues().q("repo:${repoName}").q('type:pr').q("label:${lableName}").isOpen()
  def prs = []
  for (issue in search.list()){
    pr = repo.getPullRequest(issue.getNumber())
    println pr
    println pr.getHead().getRef()
    prs << pr
  }


  /// each GHIssue@5152b3be[owner=<null>,assignee=<null>,assignees={},state=open,number=8696,comments=0,labels=[org.kohsuke.github.GHIssue$Label@16bb7ccc],title=Removing unused PAPI code,milestone=<null>,url=https://api.github.com/repos/recurly/recurly-app/issues/8696,id=225163226]


//  JsonSlurper
//  req.add_field "Authorization", "token #{ENV['GITHUB_TOKEN']}"
//  req.add_field "Content-Type", "application/json"
//  echo new URL("http://example.org/").text

  // github_get("https://api.github.com/repos/recurly/#{repo}/issues?per_page=100&state=open&labels=#{URI.escape(label)}")
}
