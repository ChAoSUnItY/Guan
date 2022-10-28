package chaos.unity.guan

final case class Warning(override val commonSpan: Span, 
                         override val labels: List[Label], 
                         override val message: String, 
                         override val tag: String = "warning") extends Report
