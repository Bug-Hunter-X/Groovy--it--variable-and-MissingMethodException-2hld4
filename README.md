# Groovy Implicit 'it' Variable and MissingMethodException

This example demonstrates a subtle issue in Groovy related to the implicit 'it' variable within closures and its interaction with methods requiring explicit parameters.

## Bug Description

When passing a closure to a function and using the implicit 'it' variable with a method that expects a parameter (like toString()), a `MissingMethodException` can be thrown, even if 'it' is clearly defined in the context.

## Code Example

The file 'bug.groovy' contains the following code that produces the unexpected error.

```groovy
def foo(Closure c) {
  c()
}

foo { println it }
foo { println it.toString() }
```
The first call to `foo` works fine. However, the second call throws `MissingMethodException: No signature of method: java.lang.String.toString() is applicable for argument types: (groovy.lang.Closure) values: [it]`. This is because Groovy tries to invoke `toString()` on the closure 'it' instead of on the value the closure should represent.

## Solution

The file 'bugSolution.groovy' provides a corrected version of the code.
