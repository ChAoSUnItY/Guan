package chaos.unity.guan

final case class Label(val span: Span, val message: String, val format: String, val hint: String) extends Segment:
  override lazy val isSameLine: Boolean =
    span.isSameLine
  override lazy val isInLine: Int => Boolean =
    span.isInLine
  override lazy val offset: Int =
    span.offset
