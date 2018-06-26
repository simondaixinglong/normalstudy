package com.simon.designmodel.composite

/**
 * Description:
 * Author:          simondai
 * Version:         V1.0
 * Date:            2018/2/9 09:48
 */
interface AbstractFile {

    fun killVirus()
}

class ImageFile(private val name: String) : AbstractFile {

    override fun killVirus() {
        println("image file $name kill virus")
    }

}


class VideoFile(private val name: String) : AbstractFile {
    override fun killVirus() {
        println("video file $name kill virus")

    }

}

class TextFile(private val name: String) : AbstractFile {
    override fun killVirus() {
        println("text file $name kill virus")

    }

}


class Folder(private val name: String) : AbstractFile {

    var list = mutableListOf<AbstractFile>()

    override fun killVirus() {
        println("folder $name kill virus")

        list.forEach {
            it.killVirus()
        }
    }


    fun add(abstractFile: AbstractFile) {
        list.add(abstractFile)
    }

    fun remove(abstractFile: AbstractFile) {
        list.remove(abstractFile)
    }

    fun getChild(index: Int): AbstractFile {
        return list[index]
    }
}













