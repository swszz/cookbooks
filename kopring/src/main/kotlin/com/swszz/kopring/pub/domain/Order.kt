package com.swszz.kopring.pub.domain

/**
 * 주문 도메인
 * @author: swszz
 */
class Order(val key: String, val status: Status = Status.NONE) {

    private val items: MutableList<Item> = mutableListOf()

    fun addItem(item: Item) = this.items.add(item)

    enum class Status {
        NONE, IN_PROGRESSED, FINISHED
    }
}