package chaos.unity.guan

import java.io.File
import scala.collection.mutable

object SourceCache:
  val sources: mutable.Map[File, Source] = mutable.Map()

  def getOrAdd(file: File): Option[Source] =
    sources.get(file).orElse({
      import scala.io.Source as Src
      val source = Source.fromFile(Src.fromResource(file.getPath))
      source match
        case Some(src) =>
          sources += (file -> src)
          source
        case None =>
          source
    })