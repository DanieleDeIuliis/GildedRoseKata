package com.model

class CheeseItem(name: String, daysToExpire: Int, quality: Int) : Item(name, daysToExpire, quality) {
    override fun updateQualityBasedOnPositiveSellInDate() {
        if (quality < 50)
            quality++
    }

    override fun updateQualityBasedOnNegativeSellInDate() {
        if (daysToExpire < 0 && quality < 50) {
            quality++
        }
    }

}