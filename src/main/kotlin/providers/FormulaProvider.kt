package providers

import HTMLString
import java.io.File

fun provideFormula(): HTMLString {
   var inFormula = false;
   var formulas = mutableListOf<String>()

   File("math.tex").inputStream().bufferedReader().useLines { lines -> lines.forEach {
      if (it == "\\[") {
         inFormula = true
         formulas.add("")
      } else if (it == "\\]") {
         inFormula = false
      } else if (inFormula) {
         formulas[formulas.lastIndex] += it + "\n"
      }
   } }

   return "\\[" + formulas[(Math.random() * formulas.size).toInt()] + "\\]"
}