package com.gildedrose

class SpecialItem(name: String, daysToExpire: Int, quality: Int) : Item(name, daysToExpire, quality) {
    override fun updateQualityBasedOnPositiveSellInDate() {
        if (quality < 50)
            quality++
    }

    override fun decreaseSellInDays() {
    }
}