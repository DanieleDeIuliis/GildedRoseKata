package com.model

abstract class Item(var name: String, var daysToExpire: Int, var quality: Int) {

    fun updateQualityAndDaysToExpire(){
        updateQualityBasedOnPositiveSellInDate()
        decreaseSellInDays()
        updateQualityBasedOnNegativeSellInDate()
    }
    abstract fun updateQualityBasedOnPositiveSellInDate()
    abstract fun updateQualityBasedOnNegativeSellInDate()
    open fun decreaseSellInDays() {
        daysToExpire--
    }
}