import scala.io.StdIn._
import org.jsoup._

object Main extends App
{
  var query = new String
  while (query == null)
  {
    println("What would you like to read about? Or type 'exit' to conclude.\n")
    query = scala.io.StdIn.readLine()
    if (query == null)
      println("No input given")
    else
    {

    }
  }
}
