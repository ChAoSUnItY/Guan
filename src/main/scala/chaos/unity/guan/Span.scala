package chaos.unity.guan

final case class Span(val startPosition: Position, val endPosition: Position):
  lazy val isSameLine: Boolean =
    startPosition.line == endPosition.line
  lazy val isInLine: Int => Boolean =
    line => startPosition.line to endPosition.line contains line
  lazy val offset: Int =
    if (startPosition.line != endPosition.line || startPosition.pos > endPosition.pos) -1 else endPosition.pos - startPosition.pos

  def expand(span: Option[Span]): Span = span match
    case None => copy()
    case Some(_span) => _span match
      case Span(_, endPos) if endPos.line < startPosition.line => copy()
      case Span(_, endPos) if endPos.line == startPosition.line && endPos.pos < startPosition.pos => copy()
      case Span(_, endPos) => Span(startPosition, endPos)

object Span:
  def range(startLine: Int, endLine: Int): Span =
    Span(Position(startLine, 0), Position(endLine, 0))

  def range(line: Int, startPos: Int, endPos: Int): Span =
    Span(Position(line, startPos), Position(line, endPos))

  def range(startLine: Int, startPos: Int, endLine: Int, endPos: Int): Span =
    Span(Position(startLine, startPos), Position(endLine, endPos))
