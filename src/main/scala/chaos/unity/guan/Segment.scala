package chaos.unity.guan

trait Segment {
  lazy val isSameLine: Boolean
  lazy val isInLine: Int => Boolean
  lazy val offset: Int
}
