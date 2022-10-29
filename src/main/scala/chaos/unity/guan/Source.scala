package chaos.unity.guan

import scala.collection.mutable.ArrayBuffer

final case class Source(val lines: List[Line]):
  def slice(start: Int, end: Int = lines.length - 1): List[Line] =
    lines.slice(start, end)

object Source:

  import scala.io.{BufferedSource, Source as Src}

  def fromResource(filePath: String): Option[Source] =
    fromFile(Src.fromResource(filePath))


  def fromFile(filePath: String): Option[Source] =
    fromFile(Src.fromFile(filePath))

  def fromFile(file: BufferedSource): Option[Source] =
    val lines =
      try file.getLines.toList
      catch {
        case _: Throwable => return None
      } finally file.close
    Some(fromLines(lines))

  def fromLine(line: String): Source =
    Source(List(Line(1, 0, line.length, line)))

  def fromLines(lines: List[String]): Source =
    val lineBuilder = ArrayBuffer[Line]()

    lines.zipWithIndex.scanLeft(0) {
      case (offset, (line, lineNumber)) =>
        lineBuilder += Line(lineNumber + 1, offset, line.length, line)
        offset + line.length
    }

    Source(lineBuilder.toList)