package com.gildedrose

class SpecialItem(name: String, daysToExpire: Int, quality: Int) : Item(name, daysToExpire, quality) {
    override fun decreaseSellInDays() {
    }
}