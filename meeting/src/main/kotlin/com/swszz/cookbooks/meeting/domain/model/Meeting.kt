package com.swszz.cookbooks.meeting.domain.model

/**
 * @author: swszz
 */
class Meeting private constructor(
    val type: Type,
) {

    companion object {
        fun initIndividualMeeting(): Meeting {
            return init(Type.INDIVIDUAL)
        }

        fun initGroupMeeting(): Meeting {
            return init(Type.INDIVIDUAL)
        }

        private fun init(type: Type): Meeting {
            return Meeting(type)
        }
    }

    enum class Type {
        GROUP, INDIVIDUAL
    }
}