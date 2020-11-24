package com.model

class SpecialItem(name: String, daysToExpire: Int, quality: Int) : Item(name, daysToExpire, quality) {
    override fun updateQualityBasedOnPositiveSellInDate() {
            quality++
    }

    override fun decreaseSellInDays() {
    }

    override fun updateQualityBasedOnNegativeSellInDate() {
    }
}