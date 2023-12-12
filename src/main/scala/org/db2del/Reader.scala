package org.db2del

import java.nio.file.{LinkOption, Paths, Files}
import scala.io.Source
import scala.util.Using

class Reader(options: AppOptions) {
  
  private def findFile(): String = {
    val path = getClass.getClassLoader.getResource(".").getPath
    val filename = s"$path/${options.fileName}"
    if (!Files.exists(Paths.get(filename), LinkOption.NOFOLLOW_LINKS)) {
      throw new IllegalArgumentException(s"can't find file(\n$filename\n) from classPath")
    }
    filename
  }
  
  /**
   * 读取文件, 并将每一行数据按列分割
   * @param func
   */
  def iterator(func: Array[String] => Unit): Unit = {
    val filePath = findFile()
    println(s"absolute path is \n $filePath")
    Using(Source.fromFile(filePath)) { buf =>
      buf.getLines()
         .map(_.split(options.columnSeparator))
         .foreach(func)
    }
  }
}
