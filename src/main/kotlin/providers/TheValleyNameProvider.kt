package providers

import com.ppolivka.namegenerator.Generator
import com.ppolivka.namegenerator.impl.KatzBackoffGenerator
import java.io.File

class TheValleyNameProvider() {

    fun provide() : String {

        val inputStream = File("startup_names.txt").inputStream()
        val lineList = mutableSetOf<String>()

        inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it)} }

        var generator: Generator = KatzBackoffGenerator(lineList, 2, 0.001f)
        return generator.generate()
    }
}