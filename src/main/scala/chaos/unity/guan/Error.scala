package chaos.unity.guan

final case class Error(override val commonSpan: Span,
                       override val labels: List[Label],
                       override val message: String,
                       override val tag: String = "error") extends Report
