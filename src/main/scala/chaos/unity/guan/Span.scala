package chaos.unity.guan

final case class Span(val startPosition: Position, val endPosition: Position) {
    lazy val isSameLine: Boolean = startPosition.line == endPosition.line
    lazy val isInLine: Int => Boolean = (line) => startPosition.line to endPosition.line contains line
}
