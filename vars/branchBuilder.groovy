import org.kohsuke.github.*
import com.cloudbees.groovy.cps.NonCPS

@NonCPS
def findBranches(String repoName, String lableName, String oAuthAccessToken) {
  def gh = GitHub.connectUsingOAuth(oAuthAccessToken)
  def repo = gh.getRepository(repoName)
  def search = gh.searchIssues().q("repo:${repoName}").q('type:pr').q("label:${lableName}").isOpen()

  def branches = []
  for (issue in search.list()){
    pr = repo.getPullRequest(issue.getNumber())
    prs << pr.getHead().getRef()
  }
  branches
}

def call(String oAuthAccessToken) {
  findBranches('recurly/recurly-app', 'qa4')
}

