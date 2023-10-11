package org.cscie88c.week4

import org.cscie88c.testutils.{StandardTest}

class ListUtilsTest extends StandardTest {
  "ListUtils" when {
    "calling ones" should {
      "return the correct value" in {
        ListUtils.ones(5) shouldBe(List(1.0,1.0,1.0,1.0,1.0))
      }
    
    }

    "calling zeros" should {
      "return the correct value" in {
        ListUtils.zeros(5) shouldBe(List(0.0,0.0,0.0,0.0,0.0))
      }
    
    }
   "unit test for function charCounts verifying the character frequencies for the string - Hello world" should {
      "return the correct value" in {
        ListUtils.charCounts("Hello world") shouldBe(Map(' ' -> 1, 'l' -> 3, 'H' -> 1, 'r' -> 1, 'w' -> 1, 'o' -> 2, 'd' -> 1, 'e' -> 1))
      }
    
    }

    "unit test for function charCounts verifying that the sentence -The quick brown fox jumps over the lazy dog- is a pangram i.e., contains all letters of the alphabet" should {
      "return the correct value" in {
        ListUtils.charCounts("The quick brown fox jumps over the lazy dog").keySet.filter(x => x.isLetter).map(x => x.toLower) shouldBe(Set('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'))
      }
    }

    "unit test for function topN" should {
      "return the correct value" in {
        ListUtils.topN(2)(Map('e' -> 1, 'l' -> 3, 'H' -> 1, 'W' -> 1, 'r' -> 1, 'o' -> 2, 'd' -> 1)) shouldBe(Map('l' -> 3, 'o' -> 2))
      }
    
    }
  
  }

}
