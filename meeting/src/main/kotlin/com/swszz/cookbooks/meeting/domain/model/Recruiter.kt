package com.swszz.cookbooks.meeting.domain.model

/**
 * @author: swszz
 */
data class Recruiter(override val id: Long) : User(id) {
    companion object {
        fun of(id: Long): Recruiter {
            return Recruiter(id)
        }
    }
}

fun Set<Long>.toRecruiters(): Set<Recruiter> {
    return this.map { Recruiter.of(it) }.toSet()
}