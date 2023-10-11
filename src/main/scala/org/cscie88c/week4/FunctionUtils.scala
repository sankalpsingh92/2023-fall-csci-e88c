package org.cscie88c.week4

object FunctionUtils {
  
  // complete the implementation of the higher order functions below
  def applyNtimes(n: Int)(x: Int)(f: Int => Int): Int = {

    var a = x;
    
    for(i <- 1 to n){
        a = f(a);
    }
    a

  }

  def myPositivePower(x: Int, n: Int): Int = {
    if (n == 0) {
      1
    } else {
      applyNtimes(n-1)(x)((a : Int) =>  a * x)
    }
  }

  def deferredExecutor(name: String)(f: Int => Int): Int => Int = {
    (x: Int) => {
      println(s"running on deferred executor ${name} with value ${x}")
      f(x)
    }
  }
}
