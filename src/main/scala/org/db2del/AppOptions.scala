package org.db2del

/**
 * Options for merge db2.del and db2.lob
 *
 * @param fileName        filename, we would find file from classpath
 * @param lobColumns      defined the columns which should be merge
 * @param rowSeparator    rowSeparator
 * @param columnSeparator columnSeparator
 */
case class AppOptions(
  fileName: String,
  lobColumns: Set[Int],
  columnSeparator: String = ","
)

