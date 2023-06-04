package com.swszz.cookbooks.meeting.domain.model

/**
 * @author: swszz
 */
data class Location(
    val address: String? = null,
    val category: LocationCategory,
) {
    companion object {
        fun of(
            address: String?,
            category: LocationCategory = LocationCategory.DIRECT_INPUT,
        ): Location {
            return Location(address = address, category = category)
        }
    }
}