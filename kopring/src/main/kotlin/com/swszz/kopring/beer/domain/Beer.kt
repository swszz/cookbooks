package com.swszz.kopring.beer.domain

/**
 * 맥주 도메인
 * @author: swszz
 */
data class Beer(val type: Type,
                val size: Size,
                val count: Int = 0) {
    companion object {
        /**
         * 맥주 생성
         */
        fun create(type: Type, size: Size, count: Int = 0): Beer {
            return Beer(type, size, count)
        }
    }

    /**
     * 맥주 타입
     */
    enum class Type {
        TEMPT,
        GUINNESS,
        OTHER
    }

    /**
     * 맥주 사이즈
     */
    enum class Size(private val milliLiter: Int) {
        SMALL(300),
        MEDIUM(500),
        LARGE(700)
    }
}