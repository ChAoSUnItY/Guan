package chaos.unity.guan.color

enum FgColor(override val beginInt: Int) extends AnsiCode:
  case Black extends FgColor(30)
  case Red extends FgColor(31)
  case Green extends FgColor(32)
  case Yellow extends FgColor(33)
  case Blue extends FgColor(34)
  case Magenta extends FgColor(35)
  case Cyan extends FgColor(36)
  case White extends FgColor(37)
  case GRAY extends FgColor(90)
  case GREY extends FgColor(90)

  override val endInt: Int = 39
