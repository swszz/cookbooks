package com.swszz.cookbooks.tunejpaquery

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @author: swszz
 */
@Service
class HelloService(private val teamRepository: TeamRepository, private val memberRepository: MemberRepository) {

    @Transactional
    fun create() {
        val team = Team()
        val member = Member()
        val member2 = Member()

        team.addMember(member)
        team.addMember(member2)

        teamRepository.save(team);
    }

    @Transactional
    fun remove() {
        memberRepository.findAll()[0].preRemove()
    }
}