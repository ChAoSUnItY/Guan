package chaos.unity.guan.color

trait AnsiCode:
    val beginInt: Int
    val endInt: Int

    val start: String = f"${AnsiCode.Escape}[${beginInt}m"
    val end: String = f"${AnsiCode.Escape}[${endInt}m"

object AnsiCode:
    val Escape: Char = '\u001B'
    val Reset: String = f"${Escape}[0m"
