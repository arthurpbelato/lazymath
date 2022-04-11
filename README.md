# API LazyMath

An API who solve some math problems in a easy way. I created this project to train java and object oriented skills like generics and reflection.

The idea behind this API is to get the answers of math problems using the same route for an formula, independent of the variable to be calculated.

Here's an exemple:

Supposing we have a right triangle with legs *a* and *b*, and the hypotenuse *c*, where *a = 3*, *b = 4* we can build this request body:
  
    {
      "a": 3,
      "b": 4
    }

And send a post request to the *"/api/pythagorean-theorem"* endpoint. This will return the following response:

    {
      "a": 3.0,
      "b": 4.0,
      "c": 5.0
    }

In the same way, we can send just one leg and the hypotenuse to get the remaining leg, like:

    {
      "a": 3,
      "c": 5
    }

or

    {
      "b": 4,
      "c": 5
    }

will return the same object above.
For general purposes, the response is always a double value.
