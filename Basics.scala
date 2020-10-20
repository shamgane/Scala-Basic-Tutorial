object Basics {
  
  println("My first Scala worksheet")             //> My first Scala worksheet
  
  val i = 1                                       //> i  : Int = 1
  //Immutable if used with val keyword
  
  var f = 3.5f                                    //> f  : Float = 3.5
  f = 4.3f
  f                                               //> res0: Float = 4.3
  
  // There are no primitive data types. There are only classes eg: Double
  
  //Char type...
  val c = '\u2089'                                //> c  : Char = â‚‰
  
  //Type conversion..
  c.toInt                                         //> res1: Int = 8329
  c.toDouble                                      //> res2: Double = 8329.0
  f.toInt                                         //> res3: Int = 4
  f                                               //> res4: Float = 4.3
  
  val l = 10L //long                              //> l  : Long = 10
  var b : BigInt = 10000080945883L                //> b  : BigInt = 10000080945883
  b.toString.length                               //> res5: Int = 14
  b = b*b*b*b*b*b*b*b*b*b
  b                                               //> res6: BigInt = 1000080948831569834677127615222888797154873320614505535021197
                                                  //| 0419898843922530767330289809158750131661075659372081054681349763227449
  b.toString.length                               //> res7: Int = 131
  
  //
  // 28th August 2020
  //
  
  
  //Scala List is immutable with val
  val l0 = List(1,2,3,4,5,6,7,8,9)                //> l0  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val l1 = List(1.1,2.2,3,4,5,6,7)                //> l1  : List[Double] = List(1.1, 2.2, 3.0, 4.0, 5.0, 6.0, 7.0)
  // Recursive List(1, List(2, List(3,...
  
  var ls = List(1,2,3,4)                          //> ls  : List[Int] = List(1, 2, 3, 4)
  // ls(2) = 33 shows error even though var is used because Lists are immutable
  
  // Scala Array can be modified
  val a0 = Array(1,2,3,4,5,6,7,8,9)               //> a0  : Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
  l0.head                                         //> res8: Int = 1
  l1.tail                                         //> res9: List[Double] = List(2.2, 3.0, 4.0, 5.0, 6.0, 7.0)
	l0.tail.tail.head                         //> res10: Int = 3
	
	val l2 = List()                           //> l2  : List[Nothing] = List()
	val l3 = Nil                              //> l3  : scala.collection.immutable.Nil.type = List()

	l0(3)                                     //> res11: Int = 4
	
	a0(3)                                     //> res12: Int = 4
	
	a0(3) = 56
	a0                                        //> res13: Array[Int] = Array(1, 2, 3, 56, 5, 6, 7, 8, 9)

	// l0(3) = 56 List is Immutable; shows error

	a0.head                                   //> res14: Int = 1
	a0.tail                                   //> res15: Array[Int] = Array(2, 3, 56, 5, 6, 7, 8, 9)
	
	// Array and Lists are similar in functionality but very different from a time comeplexity level
	
	// List creates pointers pointing from one value to another during the time of creation

	val l4 = List("A", "B", "C")              //> l4  : List[String] = List(A, B, C)
	val l5 = List("A","B", 3.5)               //> l5  : List[Any] = List(A, B, 3.5)
	// Any is the parent type of all data types in Scala
	// Any has 2 types 1. AnyRef  2. AnyVal
	
	val byte:Boolean = true                   //> byte  : Boolean = true
	val l6 = List(3.5,4)                      //> l6  : List[Double] = List(3.5, 4.0)
	val l7 = List(true,3.5,4)                 //> l7  : List[AnyVal] = List(true, 3.5, 4)
	val l8 = List(byte,3.5,4)                 //> l8  : List[AnyVal] = List(true, 3.5, 4)
	val l9 = List(List(1,2,3),"A")            //> l9  : List[java.io.Serializable] = List(List(1, 2, 3), A)
	// This is called Type Calculus
	
	val l10 = List(List(1,2,3),Array("A"))    //> l10  : List[java.io.Serializable] = List(List(1, 2, 3), Array(A))
	val l11 = List(List(1,2,3), new java.lang.Object())
                                                  //> l11  : List[Object] = List(List(1, 2, 3), java.lang.Object@64616ca2)
  
  val l12 :List[AnyRef] = List(List(1,2,3), new java.lang.Object())
                                                  //> l12  : List[AnyRef] = List(List(1, 2, 3), java.lang.Object@13fee20c)
   

   val samp = "AM"                                //> samp  : String = AM
   
   val sampc = 'A'                                //> sampc  : Char = A
   
   val samplist = List('A',3.5)                   //> samplist  : List[Double] = List(65.0, 3.5)
   // ***Char, Int and all other convertable gets converted to Double when they are present with Char in List
   
   val sl2 = List("A",3.5)                        //> sl2  : List[Any] = List(A, 3.5)
   
   val sl3 = List('A','B',3.5)                    //> sl3  : List[Double] = List(65.0, 66.0, 3.5)
   
   val sl4 = List('A','B',3.5,4.4)                //> sl4  : List[Double] = List(65.0, 66.0, 3.5, 4.4)
   
   val sl5 = List('A', 'B', 3.5,4)                //> sl5  : List[Double] = List(65.0, 66.0, 3.5, 4.0)
   
}
