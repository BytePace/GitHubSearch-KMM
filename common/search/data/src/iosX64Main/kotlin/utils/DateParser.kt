package utils

import platform.Foundation.*

actual class DateParser actual constructor() {
    private val datePattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

    /**
     * Parse date from string to milliseconds since 1 January 1970
     *
     * @param dateString String representation of date, given from server
     * @return [Long] Milliseconds
     * */
    actual fun parseTimeMillis(dateString: String): Long {
        val dateFormatter = NSDateFormatter().apply {
            dateFormat = datePattern
        }
        val date = dateFormatter.dateFromString(dateString.trim())?.timeIntervalSince1970
        return date?.toLong() ?: 0
    }

}