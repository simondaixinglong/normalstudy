package com.simon.designmodel.composite

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/9 09:34
 */
interface Component {
    fun operation()
}

//叶子组件
interface Leaf : Component

//容器组件
interface Composite : Component {
    fun add(component: Component)
    fun remove(component: Component)
    fun getChild(): Component
}