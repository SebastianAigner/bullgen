import com.google.gson.JsonObject
import java.util.HashMap
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson



typealias HTMLString = String

interface SlideGenerator {
    fun generate(keywords: Array<String>): HTMLString

}