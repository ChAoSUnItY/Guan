package chaos.unity.guan

trait Report extends ((Span, List[Label], String, String) => Report) {
  val commonSpan: Span
  val labels: List[Label]
  val message: String
  val tag: String
  
  def apply(commonSpan: Span, labels: List[Label], message: String, tag: String): Report
}
