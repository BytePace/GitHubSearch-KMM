package utils

expect class DateParser() {

    /**
     * Parse date from string to milliseconds since 1 January 1970
     *
     * @param dateString String representation of date, given from server
     * @return [Long] Milliseconds
     * */
    fun parseTimeMillis(dateString: String): Long
}