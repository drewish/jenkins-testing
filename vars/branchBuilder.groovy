import org.kohsuke.github.*
import com.cloudbees.groovy.cps.NonCPS

def call(String oauthAccessToken) {
  findBranches('recurly/recurly-app', 'qa4')
}

@NonCPS
def findBranches(String oauthAccessToken, String repoName, String lableName) {
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
