package com.swszz.cookbooks.tunejpaquery

import jakarta.persistence.*

@Entity
class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @OneToMany(
        mappedBy = "team",
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        orphanRemoval = true
    )
    var members: MutableList<Member> = mutableListOf<Member>()

    fun addMember(member: Member) {
        this.members.add(member)
        member.team = this
    }
}