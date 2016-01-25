/**
 * Created by KanzakiMirai on 1/24/16.
 */
class Scala(private var context: String = "generic") {
  def this(a: Int) {
    this(a.toString)
  }

  def myString(): String = {
    val string = "My "
    val newString = string + "String -> " + this.context
    newString
  }
}