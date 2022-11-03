package chaos.unity.guan.color

enum BgColor(override val beginInt: Int) extends AnsiCode:
  case Black extends BgColor(40)
  case Red extends BgColor(41)
  case Green extends BgColor(42)
  case Yellow extends BgColor(43)
  case Blue extends BgColor(44)
  case Magenta extends BgColor(45)
  case Cyan extends BgColor(46)
  case White extends BgColor(47)

  override val endInt: Int = 49

