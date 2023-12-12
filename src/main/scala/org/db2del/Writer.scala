package org.db2del

/**
 * 写入
 */
trait Writer(options: AppOptions) {
  
  def write(array: Array[String]): Unit
  
}
