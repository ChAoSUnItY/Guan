@main def hello: Unit = 
  println("Hello world!")
  println(msg)
  println(a(1))

def msg = "I was compiled by Scala 3. :)"
def a = List(1, 2)