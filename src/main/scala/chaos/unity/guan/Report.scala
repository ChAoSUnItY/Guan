package chaos.unity.guan

trait Report {
  val commonSpan: Span
  val labels: List[Label]
  val message: String
  val tag: String
}
