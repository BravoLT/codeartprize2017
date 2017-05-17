package io.github.shekibobo.counter

import org.junit.Test
import pl.allegro.finance.tradukisto.ValueConverters
import kotlin.test.expect


class CounterTest {
  @Test fun testCount() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val count = Counter(numbers).count()
    expect(count) { 19 }
  }
}

class Counter(val numbers: List<Int>) {
  val converter = ValueConverters.ENGLISH_INTEGER

  fun count(): Int {
    return numbers.sumBy { converter.asWords(it).replace(" ", "").replace("-", "").length }
  }
}

