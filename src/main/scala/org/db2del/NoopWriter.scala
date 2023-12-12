package org.db2del

class NoopWriter(options: AppOptions) extends Writer(options) {
  
  override def write(array: Array[String]): Unit = {
    println(array.mkString(", "))
  }
  
}
