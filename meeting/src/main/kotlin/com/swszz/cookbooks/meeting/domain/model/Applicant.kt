package com.swszz.cookbooks.meeting.domain.model

/**
 * @author: swszz
 */
data class Applicant(val id: Long) {
    companion object {
        fun of(id: Long): Applicant {
            return Applicant(id)
        }
    }
}


fun Set<Long>.toApplicants(): Set<Applicant> {
    return this.map { Applicant.of(it) }.toMutableSet()
}