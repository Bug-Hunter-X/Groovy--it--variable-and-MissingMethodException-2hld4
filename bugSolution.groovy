```groovy
def foo(Closure c) {
  c() 
}

foo { println it }
foo { println it?.toString() } //Safe Navigation Operator

//Alternative approach: Explicitly declare a variable
foo { String value = it; println value.toString()} 
```
Using the safe navigation operator `?.` prevents the error by handling the case where 'it' might be null. Declaring 'it' explicitly as a variable also resolves the issue.