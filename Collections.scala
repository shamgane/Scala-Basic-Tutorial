import scala.annotation.tailrec

object Collections {

	val l0 = List(1,2,3,4,5,6,7,8,9,10)       //> l0  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
	
	// Cons Operator
	val l1 = 0 :: l0                          //> l1  : List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
	
	l0.::(0)                                  //> res0: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
	
	val i = 0                                 //> i  : Int = 0
	
	//Everything is an Object in Scala
	i + 5                                     //> res1: Int = 5
	i.+(5)                                    //> res2: Int = 5
	1.+(2.+(3.+(4)))                          //> res3: Int = 10
	
	
	// Dot operator can be invoked on any variable or contant because everything is an object
	// Primitive types are also ojects
	// Associativity is based on the position of the calling object
	// Cons is right associative ; + is left associative
	
	// Scala supports operator overloading
	// Operators (only few specifiic ones) can be used as function names in Scala
	
	l1 ::: l0 //concatenation                 //> res4: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7
                                                  //| , 8, 9, 10)
  // A copy of L1 is created and the tail is concatenated
	// Also called structure sharing
	// Cons creates a copy of both lists
	
	l1                                        //> res5: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
	
	val l2 : List[Int] = List()

	// Pattern matching
	val l = l2 match {
	case Nil => 0
	case List(_) => 1
	case List(_,_) => 2
	case List(0,_,0) => 3
	case _ => l2.length
	}
	
		
	// Reversing Lists
	
	/*
	
	rev (1,2,3,4,5)
		rev(2,3,4,5) :: List(1)
			rev(3,4,5) :: List(2) :: List(1)
	
	*/
	
	def reverse (l: List[Int]) : List[Int] = l match {
		case Nil => Nil
		case x :: ys => reverse(ys) ::: List(x)
	
	}
	
	reverse(l0)
	
	
	// Mapping a list
	
	def map( f: Int => Int, l: List[Int]) : List[Int] = l match {
		case Nil => Nil
		case x :: ys => map(f, ys) ::: List(f(x))
	}
	
	map(x=>x*x, l0)



  def reverse1(list: List[Int]) = {
		@tailrec
    def reverse_tailrec(l: List[Int], acc: List[Int]): List[Int] = l match {
      case Nil     => acc
      case x :: ys => reverse_tailrec(ys, List(x) ::: acc) ::: List(x)

    }

    reverse_tailrec(l0, Nil)

  }

	reverse1(l0)


// My trial... Need to check
def map_tr( f: Int => Int, l: List[Int]) = {
	
	def iter( f: Int => Int, l: List[Int], acc : List[Int]): List[Int] = l match {
		case Nil => acc
		case x::ys => iter(f, ys, acc.::(f(x)))
	
	}
	
	iter(f: Int => Int, l: List[Int] , List())
	
	}

map_tr(a=>a*a, l0)
	
	
val l3 = List( "Apple", "Banana", "Cranberry", "Dragnofruit", "Elephant Yam")
                                                  //> l3  : List[String] = List(Apple, Banana, Cranberry, Dragnofruit, Elephant Ya
                                                  //| m)
// Type Parameters...
def reverse2[T](list : List[T]) = {

	def reverse_tailrec(l: List[T], acc: List[T]): List[T] = l match {
      case Nil     => acc
      case x :: ys => reverse_tailrec(ys, List(x) ::: acc) ::: List(x)

    }

    reverse_tailrec(list, Nil)
}                                                 //> reverse2: [T](list: List[T])List[T]

reverse2(l3)                                      //> res6: List[String] = List(Elephant Yam, Dragnofruit, Cranberry, Banana, App
                                                  //| le, Elephant Yam, Dragnofruit, Cranberry, Banana, Apple)



def map1[T,U] (f : T => U, l:List[T]) : List[U] = l match {
	case Nil => Nil
	case x :: ys => f(x) :: map1(f,ys)
	
}

map1[Int, Double](x=> scala.math.sqrt(x),l0)


// List[Int], List[Double] are completely different
// If Int is a subtype of double then List[Int] subtype of List[Double]? No



}
