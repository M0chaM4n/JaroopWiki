import java.io.IOException

import scala.io.StdIn._
import org.jsoup._
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

object Main extends App
{
  var query = new String

    print("What would you like to read about?\n")
    query = scala.io.StdIn.readLine()

  if (query == null)
      println("No input given")
    else
    {
      query.replace(" ","_")
      val fullQuery =  "http://en.wikipedia.org/wiki/" + query
      try
        {
          val doc = Jsoup.connect(fullQuery).get()
          val body = doc.select("#mw-content-text")
          val text  = body.select("p").not(".mw-empty-elt")
          print(text.get(0).text())
        }
      catch { case _: Throwable => println("Could not find article.Terminating")}
      System.exit(1)
    }

}

