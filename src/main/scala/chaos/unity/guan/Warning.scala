package chaos.unity.guan

final case class Warning(override val commonSpan: Span, 
                         override val labels: List[Label], 
                         override val message: String, 
                         override val tag: String = "warning") extends Report:
  override def apply(commonSpan: Span, labels: List[Label], message: String, tag: String): Report = 
    Warning(commonSpan, labels, message, tag)
                         