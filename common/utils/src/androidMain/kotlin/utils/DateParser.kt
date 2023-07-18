package utils

import java.text.SimpleDateFormat
import java.util.Locale

actual class DateParser {
    private val datePattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    /**
     * Parse date from string to milliseconds since 1 January 1970
     *
     * @param dateString String representation of date, given from server
     * @return [Long] Milliseconds
     * */
    actual fun parseTimeMillis(dateString: String): Long {
        val formatter = SimpleDateFormat(datePattern, Locale.getDefault())
        val date = formatter.parse(dateString)
        return date.time
    }
}