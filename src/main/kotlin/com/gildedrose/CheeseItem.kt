package com.gildedrose

class CheeseItem(name: String, daysToExpire: Int, quality: Int) : Item(name, daysToExpire, quality) {
    override fun updateQualityBasedOnPositiveSellInDate() {
        super.updateQualityBasedOnPositiveSellInDate()
    }

    override fun updateQualityBasedOnNegativeSellInDate() {
        super.updateQualityBasedOnNegativeSellInDate()
    }

}