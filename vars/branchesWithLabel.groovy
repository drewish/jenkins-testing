import org.kohsuke.github.*

@NonCPS
def call(String repoName, String lableName, String oAuthAccessToken) {
  def gh = GitHub.connectUsingOAuth(oAuthAccessToken)
  def repo = gh.getRepository(repoName)
  def search = gh.searchIssues().q("repo:${repoName}").q('type:pr').q("label:${lableName}").isOpen()
  def branches = []
  for (issue in search.list()) {
    // TODO consider filtering by merge-able status
    branches << repo.getPullRequest(issue.getNumber()).getHead().getRef()
  }
  branches
}
