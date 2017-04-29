def call(Closure body) {
  withEnv(['PATH+RBENV=/home/jenkins/.rbenv/bin:/home/jenkins/.rbenv/shims']) {
    body()
  }
}
