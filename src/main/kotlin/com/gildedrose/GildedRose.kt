package com.gildedrose

import com.model.Item

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            item.updateQualityAndDaysToExpire()
        }
    }
}

