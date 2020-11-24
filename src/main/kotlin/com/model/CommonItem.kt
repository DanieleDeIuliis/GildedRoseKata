package com.model

class CommonItem(name: String, daysToExpire: Int, quality: Int) : Item(name, daysToExpire, quality) {
    override fun updateQualityBasedOnPositiveSellInDate() {
        if (quality > 0)
            quality--
    }

    override fun updateQualityBasedOnNegativeSellInDate() {
        if (daysToExpire < 0)
            quality--
    }
}