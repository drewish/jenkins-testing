def call(String oAuthAccessToken) {
  def branches = branchesWithLabel('recurly/recurly-app', 'qa4', oAuthAccessToken)
  echo branches
}
