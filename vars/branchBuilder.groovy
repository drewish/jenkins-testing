import org.kohsuke.github.*

def call(String oauthAccessToken) {
  def repoName = 'recurly/recurly-app'
  def lableName = 'qa4'

  def gh = GitHub.connectUsingOAuth(oauthAccessToken)
  def repo = gh.getRepository(repoName)
  def search = gh.searchIssues().q("repo:${repoName}").q('type:pr').q("label:${lableName}").isOpen()

  def branches = []
  for (issue in search.list()){
    pr = repo.getPullRequest(issue.getNumber())
    prs << pr.getHead().getRef()
  }
  branches
}
