def call(String oAuthAccessToken) {
  def branches = branchesWithLabel('recurly/recurly-app', 'qa4', oAuthAccessToken)
  branches.each {
    echo "pretend to merge $it"
  }
}
