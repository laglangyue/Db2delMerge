import org.db2del.*

@main
def main(): Unit = {
  val option: AppOptions = AppOptions("hello.del", Set(5))
  
  val reader = new Reader(option)
  val writer = new NoopWriter(option)
  reader.iterator(writer.write)
}