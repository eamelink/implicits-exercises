object ImplicitsExercises1 extends App{
  
  
  // Exercise 1.1: Implicit conversions  
  {
    
    case class User(lastname: String)
    case class FullUser(firstname: Option[String], lastname: String)
    
    def formatFullUser(user: FullUser): String = {
      "First name: " + user.firstname.getOrElse("n/a") + ", last name: " + user.lastname 
    }
    
    // Write some code below this line, to make the last line in this block work
    ???
    
    // The following line should compile!
    val formattedUser = formatFullUser(User("Bakker"))
  }
  
  // Using implicits in the way of exercise 1 is not very common. More common
  // is using implicits for 'adding' methods to existing types, like the following
  // two exercises.
  
  // Exercise 1.2: Custom implicit conversions
  {
    
    class IntOps(i: Int) {
      def negate = -i
      def raiseWith(j: Int) = i + j 
    }
    
    // Write code below, to make the last lines in this block work:
    ???
    
    // The following lines should compile!
    50.negate       // should return -50
    50 raiseWith 30 // should return 80
  }
  
  // Exercise 1.3: Implicit classes
  {
    // The pattern of a custom class and an implicit conversion to that class are so common,
    // that in Scala 2.10 implicit classes were introduced, that do both in one go.
    // Rewrite the previous exercise with an implicit class
    ???
    
    // The following lines should compile!
    50.negate       // should return -50
    50 raiseWith 30 // should return 80
  }
  
}

// The pattern used in Exercise 1.2 and Exercise 1.3 is sometimes called the 'Pimp My Library' pattern.
// A methode like 'raiseWith' is said to be 'pimped on' Int.