package com.swszz.cookbooks.meeting.domain.model

/**
 * @author: swszz
 */
data class Organizer(override val id: Long) : User(id) {
    companion object {
        fun of(id: Long): Organizer {
            return Organizer(id)
        }
    }
}