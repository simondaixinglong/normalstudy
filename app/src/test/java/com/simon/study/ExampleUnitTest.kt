package com.simon.study

import com.alibaba.fastjson.JSON
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)

        println(JSON.parse("[\"welcome\",\"main\",\"dialog\"]"))
        println(JSON.parse("{\"platform\":\"android\",\"bundleId\":\"com.zhan.ieltsword\",\"positionList\":[\"welcome\",\"main\",\"dialog\"],\"timestamp\":1532060668325,\"appVersion\":\"1.2.5\",\"appName\":\"雅思单词\",\"commonAppVersion\":\"1.2.5\",\"commonAppName\":\"雅思单词\"}"))

    }
}
