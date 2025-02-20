```groovy
def foo(Closure c) {
  c() 
}

foo { println it } //This works
foo { println it.toString() } //This throws MissingMethodException
```