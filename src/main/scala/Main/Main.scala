import org.jsoup.Jsoup

object Main extends App
{
  /**
   *  @author Abel Mathews
   *  @version Jsoup 1.13.1, Scala 2.13.2
   *
   *  A simple program to ask the user for a topic on wikipedia to search. Upon finding a result,
   *  the webpage HTML is scraped and the first paragraph is printed out. This is done with the Jsoup
   *  external library, as it can be used to easily connect and pull text from a webpage.
   *
   *  For my implementation, I started with a while loop when prompting a user for input as the
   *  requirements asked me to continuously prompt in case a user gave a blank input, i.e. no characters or
   *  just spaces. Upon getting valid input, the query is amended to the english wikipedia's address and
   *  connected to with Jsoup. The process of connecting to a webpage,stripping the first paragraph, and printing it
   *  is done in a try catch statement because if an article for the user's query cannot be found, need to handle
   *  that as per the original requirements.
   */

  var query = new String
  while (query.isBlank()) {
    print("What would you like to read about?\n")
    query = scala.io.StdIn.readLine()
  }

  query.replace(" ","_")
  val fullQuery =  "http://en.wikipedia.org/wiki/" + query
  try
    {
      val doc = Jsoup.connect(fullQuery).get()
      val body = doc.select("#mw-content-text")
      val paragraph  = body.select("p").not(".mw-empty-elt")
      println(paragraph.get(0).text())
    }
  catch { case _: Throwable => println("Could not find article.Terminating")}
}
