package com.swszz.cookbooks.tunejpaquery

import jakarta.persistence.*

@Entity
class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    lateinit var team: Team
    fun preRemove() {
        val team = this.team
        team.members.removeIf { it.id == this.id }
    }
}