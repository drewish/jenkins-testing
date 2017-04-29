// vars/sayHello.groovy
def call(String name = 'human') {
    // Any valid steps can be called from this code, just like in other
    // Scripted Pipeline
    env.each{
        key, value -> echo key;
    }
    echo "Hello, ${name}."
}
