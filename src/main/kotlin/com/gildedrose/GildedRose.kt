package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            updateQualityBasedOnPositiveSellInDate(i)
            decreaseSellInDays(i)
            updateQualityBasedOnNegativeSellInDate(i)
        }
    }

    private fun updateQualityBasedOnPositiveSellInDate(i: Int) {
        when(items[i].name){
            "Aged Brie" -> {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1
                }
            }
            "Backstage passes to a TAFKAL80ETC concert" -> {
                if (items[i].quality < 50) {
                    when {
                        items[i].daysToExpire < 6 -> items[i].quality += 3
                        items[i].daysToExpire < 11 -> items[i].quality += 2
                        else -> items[i].quality++
                    }
                    if(items[i].quality > 50) items[i].quality = 50
                }
            }
            "Sulfuras, Hand of Ragnaros" -> {
                if (items[i].quality < 50)
                    items[i].quality++
            }
            else -> {
                if (items[i].quality > 0)
                        items[i].quality--
            }
        }
    }

    private fun updateQualityBasedOnNegativeSellInDate(i: Int) {
        if (items[i].daysToExpire < 0) {
            when(items[i].name){
                "Aged Brie" -> {
                    if (items[i].quality < 50) {
                        items[i].quality++
                    }
                }
                "Backstage passes to a TAFKAL80ETC concert" -> items[i].quality = 0
                "Sulfuras, Hand of Ragnaros" -> {}
                else -> items[i].quality--
            }
        }
    }

    private fun decreaseSellInDays(i: Int) {
        when{
            items[i].name != "Sulfuras, Hand of Ragnaros" -> {
                items[i].daysToExpire = items[i].daysToExpire - 1
            }
        }
    }

}

