package chaos.unity.guan

import java.io.File

class SourceCachingTest extends munit.FunSuite {
  test("Test file to Source") {
    val source = Source.fromResource("SourceDummy.java")
    assert(source.isDefined)
  }

  test("Test caching file source") {
    val file = File("SourceDummy.java")
    val firstCachedSource = SourceCache.getOrAdd(file)
    assert(firstCachedSource.isDefined)
    val secondCachedSource = SourceCache.getOrAdd(file)
    assert(secondCachedSource.isDefined)
    assert(firstCachedSource.get.eq(secondCachedSource.get)) // Check no object duplication
  }
}
