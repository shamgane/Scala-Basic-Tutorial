import scala.annotation.tailrec
import java.util._


object HigherOrderFunctions {
  
  def sum(f:Int=>Int, x:Int, y:Int) = {
 
  @tailrec
  def iter(n:Int, acc:Int):Int = {
  	if(n>y) acc
  	else iter(n+1, acc ^ f(n))
  	}
  	iter(x,0)
  	}                                         //> sum: (f: Int => Int, x: Int, y: Int)Int
  
  
  
  
  def product(f:Int=>Int, x:Int, y:Int) = {
  
  @tailrec
  def iter(n:Int, acc:Int):Int = {
  	if(n>y) acc
  	else iter(n+1,acc* f(n))
  	}
  	
  	iter(x,1)
  }                                               //> product: (f: Int => Int, x: Int, y: Int)Int
  
  
  
  val c = 0xF & 48                                //> c  : Int = 0
  
  
  product(z=>z,1,5)                               //> res0: Int = 120
  
  
  // Underscore is wildcard in scala like asterisk in Java
  val fact0: Int=>Int = product(z=>z,1, _)        //> fact0  : Int => Int = HigherOrderFunctions$$$Lambda$9/2088051243@4c203ea1
  
  fact0(10)                                       //> res1: Int = 3628800
  // Converting product function into factorial; called partially applied functions
  
  def mapreduce(
  	map: Int=>Int, // transformation
  	reduce: (Int,  Int) => Int, // always a binary operation (binOp)
  	iden: Int, // Identity value of the reduce binary operation
  	x : Int, // Data param 1
  	y: Int // Data param 2
  	) = {
  	
  	@tailrec
	  def iter(n:Int, acc:Int):Int = {
	  	if(n>y) acc
	  	else iter(n+1,reduce(acc, map(n)))
	  	}
  	
  	iter(x, iden)
  	}                                         //> mapreduce: (map: Int => Int, reduce: (Int, Int) => Int, iden: Int, x: Int, 
                                                  //| y: Int)Int
  	
  	
  	mapreduce(u=>u, (a,b) => a+b, 0, 1, 10)   //> res2: Int = 55
  	mapreduce(u=>u*u, (a,b) => a+b, 0, 1, 10) //> res3: Int = 385
  	mapreduce(u=>u, (a,b) => a*b, 1, 1, 10)   //> res4: Int = 3628800
  	
  	
  	
  	
  	// Multiple argument-lists is called Currying (to honour Haskel Curry)
  	
  	def mapreduce_curry(
  	map: Int=>Int, // transformation
  	reduce: (Int,  Int) => Int, // always a binary operation (binOp)
  	iden: Int, // Identity value of the reduce binary operation
  	)
  	(x : Int, // Data param 1
  	y: Int // Data param 2
  	) = {
  	
  	@tailrec
	  def iter(n:Int, acc:Int):Int = {
	  	if(n>y) acc
	  	else iter(n+1,reduce(acc, map(n)))
	  	}
  	
  	iter(x, iden)
  	}                                         //> mapreduce_curry: (map: Int => Int, reduce: (Int, Int) => Int, iden: Int)(x:
                                                  //|  Int, y: Int)Int
  	
  	mapreduce_curry(u=>u, (a,b) => a+b, 0)( 1, 10)
                                                  //> res5: Int = 55
  	mapreduce_curry(u=>u*u, (a,b) => a+b, 0)( 1, 10)
                                                  //> res6: Int = 385
  	mapreduce_curry(u=>u, (a,b) => a*b, 1)( 1, 10)
                                                  //> res7: Int = 3628800

  
  	val sumInts = mapreduce_curry(u=>u, (a,b)=>a+b,0)_
                                                  //> sumInts  : (Int, Int) => Int = HigherOrderFunctions$$$Lambda$25/968514068@3
                                                  //| 40f438e
  	val sumSqInts = mapreduce_curry(u=>u*u, (a,b)=>a+b,0)_
                                                  //> sumSqInts  : (Int, Int) => Int = HigherOrderFunctions$$$Lambda$28/146817776
                                                  //| 7@19dfb72a
  	val fact1:Int=>Int = mapreduce_curry(u=>u, (a,b)=>a*b, 1)(1,_)
                                                  //> fact1  : Int => Int = HigherOrderFunctions$$$Lambda$29/398887205@7e0ea639


		sumInts(1,10)                     //> res8: Int = 55
		sumSqInts(1,10)                   //> res9: Int = 385
		fact1(7)                          //> res10: Int = 5040

		






}
