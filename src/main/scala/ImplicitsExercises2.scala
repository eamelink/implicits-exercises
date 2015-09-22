/**
 * Given the Expression algebra for expressions,
 * 
 * Exercises:
 * 1) Pimp a method 'evaluate' on the `Expression` type that evaluates an expression.
 * 2) Add the concept of divisions to the algebra. How would you handle division by zero? 
 */
object ImplicitsExercises2 extends App {
    
    sealed trait Expression
    case class Literal(value: Int) extends Expression
    case class Add(left: Expression, right: Expression) extends Expression
    case class Multiply(left: Expression, right: Expression) extends Expression
    case class Subtract(left: Expression, right: Expression) extends Expression
    
}