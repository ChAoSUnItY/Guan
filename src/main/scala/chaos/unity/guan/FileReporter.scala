package chaos.unity.guan

import java.io.File
import scala.collection.mutable.ArrayBuffer

class FileReporter(private[this] val file: File, private[this] val _reports: List[Report]):
  private[this] val _colored: Boolean = false
  private[this] val _source: Option[Source] = SourceCache.getOrAdd(file)

object FileReporter:
  def report(file: File): FileReporter.FileReportBuilder =
    FileReporter.FileReportBuilder(file)

  class FileReportBuilder(file: File):
    protected[guan] val _reports: ArrayBuffer[Report] = ArrayBuffer()

    def warning(span: Span, message: String, args: Any*): ReportBuilder =
      ReportBuilder(this, span, message.format(args: _*), Warning.apply)

    def build: FileReporter =
      FileReporter(file, _reports.toList)

  class ReportBuilder(val parent: FileReportBuilder, val commonSpan: Span, val message: String, private val ctor: (Span, List[Label], String, String) => Report):
    protected[guan] val _labels: ArrayBuffer[Label] = ArrayBuffer()
    protected[guan] var _tag: String = ""

    def label(span: Span, message: String, args: Any*): LabelBuilder =
      LabelBuilder(this, span, message.format(args: _*))

    def tag(tag: String, args: Any*): Unit =
      _tag = tag.format(args: _*)

    def build: FileReportBuilder =
      parent._reports += ctor(commonSpan, _labels.toList, message, _tag)
      parent

  class LabelBuilder(val parent: ReportBuilder, val span: Span, val message: String):
    protected[guan] var _format: String = ""
    protected[guan] var _hint: String = ""

    def format_=(format: String): Unit =
      _format += format

    def hint_=(hint: String, args: Any*) : Unit =
      _hint = hint.format(args)

    def build: ReportBuilder =
      parent._labels += Label(span, message, _format, _hint)
      parent
