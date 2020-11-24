package com.model


class BackStagePassItem(name: String, daysToExpire: Int, quality: Int) : Item(name, daysToExpire, quality) {
    override fun updateQualityBasedOnPositiveSellInDate() {
        if (quality < 50) {
            when {
                daysToExpire < 6 -> quality += 3
                daysToExpire < 11 -> quality += 2
                else -> quality++
            }
            if(quality > 50) quality = 50
        }
    }

    override fun updateQualityBasedOnNegativeSellInDate() {
        if (daysToExpire < 0)
            quality = 0
    }
}