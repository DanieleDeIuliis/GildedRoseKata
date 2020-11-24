package com.gildedrose

open class Item(var name: String, var daysToExpire: Int, var quality: Int) {
//    override fun toString(): String {
//        return this.name + ", " + this.sellIn + ", " + this.quality
//    }
    open fun updateQualityBasedOnPositiveSellInDate() {}
    open fun updateQualityBasedOnNegativeSellInDate() {
        quality--
    }
    open fun decreaseSellInDays() {
        daysToExpire--
    }
}