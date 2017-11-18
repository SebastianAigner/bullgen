package providers

import com.ppolivka.namegenerator.Generator
import com.ppolivka.namegenerator.impl.KatzBackoffGenerator
import java.io.File

class CorporationNameProvider() {

    fun provide() : String {

        val inputStream = File("corporation_names.txt").inputStream()
        val lineList = mutableSetOf<String>()

        inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }

        var generator: Generator = KatzBackoffGenerator(lineList, 4, 0.001f)
        println(generator.generate())
        return ""
    }
}