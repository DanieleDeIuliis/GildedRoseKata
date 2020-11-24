package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            updateQualityOfItem(item)
        }
    }

    private fun updateQualityOfItem(item: Item) {
        item.updateQualityBasedOnPositiveSellInDate()
        item.decreaseSellInDays()
        item.updateQualityBasedOnNegativeSellInDate()
    }
}

