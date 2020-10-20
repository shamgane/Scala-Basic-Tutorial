object Functions {
                                                  
  // Variable declaration ...
  val i = 5
  
  // Function declaration ...
  def fn = 5   // def defines a function
  
  // Functions in Scala are just like data. They are called first class functions
  // and have all the abilities that any normal variable has in Imperative Programming
 
  lazy val a = 6
  a
  a
  
  // Lazy expressions creates and assigns a memory location for the variable but does not allocate
  // the value for it until the expression is invoked.
  
  def f = 4+1
  f
  f
  
  
  
  // Parameterized function ...
  def fn1(x:Int) = x
  
  // Mapping int space to int space (Mathematically domain and range)
  // fn1: Int => Int
  
  
  // Two parameter functions ...
  def fn2(x:Int, y:Int) = x/y
  // fn2: (Int,Int) => Int
  // Maps from Int x Int cartesian product to a single Int
  
  def fn3(x:Int, y:Int): Double = x.toFloat/y
  
  def fact(n :Int):Int = if (n<=1) n else fact(n-1)*n
  
  fact(5)
  fact(20)
 
  fact(2000)
  
  // For bigger 'n' values we will have 'StackOverflowException'
  
  def fact1(n :Int):BigInt = if (n<=1) n else fact1(n-1)*n
  fact1(200)
  
  def fact2(n:Int, accumulator:BigInt):BigInt = {
  	if (n<=1) accumulator;
  	else fact2(n-1, accumulator*n) ;
  	}
  	
  fact2(5,1)
  
  /*
  
  fact2(5,1)
  	fact2(4,5)
  		fact2(3, 20)
  			fact2(2, 60)
  				fact(1, 120)
  
  
  */
  
  // Nested Functions. factorial is the wrapper function
  
  def factorial(n1:Int) = {
  
	  @tailrec
	  def iter(n:Int, accumulator:BigInt):BigInt = {
	  	if (n<=1) accumulator
	  	else iter(n-1, accumulator*n)
	  }
	  	
	  iter(n1,1);
  }
  
  factorial(10)
  
  
  
}
