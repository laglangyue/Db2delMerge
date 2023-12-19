package org.db2del

import org.apache.commons.csv.{ CSVFormat, CSVRecord }

import java.io.FileReader
import java.nio.file.{ Files, LinkOption, Paths }
import scala.io.Source
import scala.util.Using
import scala.jdk.CollectionConverters.*
import scala.collection.mutable

class DelReader(options: AppOptions) {

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
  def iterator(func: mutable.Buffer[String] => Unit): Unit = {
    
    val filePath = findFile()
    println(s"absolute path is \n $filePath") \
    Using(new FileReader(filePath)) {
      reader =>
        {
          format().parse(reader)
            .iterator()
            .asScala
            .map(record => record.toList.asScala)
            .foreach(func)
        }
    }
  }

  private def format() = {
    CSVFormat.DEFAULT.builder().setDelimiter(options.delimiter)
      .setQuote(options.quote)
      .build()
  }

  def transform(record: CSVRecord) = {
    record.toList
  }

}
