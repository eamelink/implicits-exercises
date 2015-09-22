import java.util.Calendar

/**
 * This application uses a logger to log what it's doing.
 * Currently, it's annoying that we have to pass around the 'logSettings' manually.
 * 
 * Exercises:
 * 1) Pass the log settings around implicitly.
 * 2) How would you provide a 'default' `LogSettings` instance, for if we want to log
 *    without defining a custom `LogSettings`?
 * 3) Suppose that you generally want to log without the datetime, but you do want it for the 
 *    last log statement, where you log 'Bye'. How do you do that?
 */
object ImplicitsExercises3 extends App {

  val logSettings = LogSettings(true, " - ", Some(60))  
  Logger.log("Hello!", logSettings)
  val sum = Calculator.calculateSum(42, 42, logSettings)
  Logger.log("This is a really really really really really really long and I do mean really really really long line. Really.", logSettings)
  Logger.log("Bye", logSettings)
    
}


case class LogSettings(printDateTime: Boolean, separator: String, maxLength: Option[Int])

object Logger { 
  def log(msg: String, logSettings: LogSettings) = {
    if(logSettings.printDateTime) {
      print(Calendar.getInstance().getTime() + logSettings.separator)
    }
    
    val printMsg = logSettings.maxLength map { length => 
      if(msg.length > length) msg.take(length - 1) + "…"
      else msg 
    } getOrElse msg 
    println(printMsg)
  }
}


object Calculator {
  def calculateSum(i: Int, j: Int, logSettings: LogSettings) = {
    Logger.log(s"Calculating sum of $i and $j", logSettings)
    i + j
  }
}




