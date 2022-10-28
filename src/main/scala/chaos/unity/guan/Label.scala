package chaos.unity.guan

final case class Label(val span: Span, val message: String) extends Segment:
  private var _format: String = ""
  private var _hint: String = ""

  override lazy val isSameLine: Boolean =
    span.isSameLine
  override lazy val isInLine: Int => Boolean =
    span.isInLine
  override lazy val offset: Int =
    span.offset
  
  def format(): String =
    _format
  def appendFormat(format: String): Unit =
    _format += format

  def hint(): String =
    _hint
  def hint_=(hint: String): Unit =
    _hint = hint
