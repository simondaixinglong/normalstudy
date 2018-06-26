package com.simon.kotlin

import org.junit.Test

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/11/10 19:36
 */
class One {

    @Test
    fun TestList() {

        println(45 % 10)

        //原生字符串使用三个引号(""")
        //原生字符串和转义字符串内部都支持模板。 如果你需要在原生字符串中表示字面值 $ 字符（它不支持反斜杠转义），你可以用下列语法：
        var a = """this is why we play"""
        var i = "abc"
        var s = "i.length is ${i.length}"

        val price = """
                    ${'$'}9.99
                    """
        println(i)
        println(a)

//        Kotlin 的类型系统旨在从我们的代码中消除 NullPointerException。NPE 的唯一可能的原因可能是
//        显式调用 throw NullPointerException()；
//        使用了下文描述的 !! 操作符；
//        外部 Java 代码导致的；
//        对于初始化，有一些数据不一致（如一个未初始化的 this 用于构造函数的某个地方）。

//        安全调用操作符，写作 ?.
        a?.length
//        如果 a 非空，就返回 a.length，否则返回 null，这个表达式的类型是 Int?。

//        Elvis 操作符
//        val l: Int = if (a != null) a.length else -1
//        val l = a?.length ?: -1
//        如果 ?: 左侧表达式非空，elvis 操作符就返回其左侧表达式，否则返回右侧表达式。 请注意，当且仅当左侧为空时，才会对右侧表达式求值。

//        !! 操作符

//        第三种选择是为 NPE 爱好者准备的：非空断言运算符（!!）将任何值转换为非空类型，若该值为空则抛出异常。我们可以写 b!! ，这会返回一个非空的 b 值 （例如：在我们例子中的 String）或者如果 b 为空，就会抛出一个 NPE 异常：



//        Kotlin 同 C# 和 Gosu 类似，能够扩展一个类的新功能而无需继承该类或使用像装饰者这样的任何类型的设计模式。 这通过叫做 扩展 的特殊声明完成

//        声明一个扩展函数，我们需要用一个 接收者类型 也就是被扩展的类型来作为他的前缀

//        我们经常创建一些只保存数据的类。 在这些类中，一些标准函数往往是从数据机械推导而来的。在 Kotlin 中，这叫做 数据类 并标记为 data

//        data class User(val name: String, val age: Int)

//        编译器自动从主构造函数中声明的所有属性导出以下成员：
//
//        equals()/hashCode() 对；
//        toString() 格式是 "User(name=John, age=42)"；
//        componentN() 函数 按声明顺序对应于所有属性；
//        copy() 函数（见下文）。
//        在很多情况下，我们需要复制一个对象改变它的一些属性，但其余部分保持不变，copy() 函数就是为此而生成。



//        Lambda 表达式简短的概述：
//
//        lambda 表达式总是被大括号括着；
//        其参数（如果有的话）在 -> 之前声明（参数类型可以省略）；
//        函数体（如果存在的话）在 -> 后面。

//        一个 lambda 表达式只有一个参数是很常见的。 如果 Kotlin 可以自己计算出签名，它允许我们不声明唯一的参数，并且将隐含地为我们声明其名称为 it
//        我们可以使用限定的返回语法从 lambda 显式返回一个值。否则，将隐式返回最后一个表达式的值。因此，以下两个片段是等价的：

//        ints.filter {
//            val shouldFilter = it > 0
//            shouldFilter
//        }
//
//        ints.filter {
//            val shouldFilter = it > 0
//            return@filter shouldFilter
//        }

//        它允许你在 Kotlin 所支持的平台上复用代码

//        在一个多平台项目中，你可以将平台之间共享的代码放到一个公共模块中，并将平台相关的部分放到特定的平台模块中依赖





    }
}