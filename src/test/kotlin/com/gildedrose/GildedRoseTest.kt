package com.gildedrose

import com.model.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GildedRoseTest {


    @Test
    fun foo() {
        val items = arrayOf<Item>(CommonItem("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)

    }

    @Test
    fun testMaxQualityAlreadyReached(){
        val items: Array<Item> = arrayOf(CheeseItem("Aged Brie", 0, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, items.first().quality)
    }

    @Test
    fun decreaseQualityCommonItem(){
        val items: Array<Item> = arrayOf(CommonItem("Peppers", 1, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, items.first().quality)
    }

    @Test
    fun maxIncreaseQualityBackStageItem(){
        val items: Array<Item> = arrayOf(BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 1, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(13, items.first().quality)
    }

    @Test
    fun mediumIncreaseQualityBackStageItem(){
        val items: Array<Item> = arrayOf(BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 8, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(12, items.first().quality)
    }

    @Test
    fun normalIncreaseQualityBackStageItem(){
        val items: Array<Item> = arrayOf(BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 30, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(11, items.first().quality)
    }

    @Test
    fun commonItemSellInDecrease() {
        val items = arrayOf<Item>(CommonItem("foo", 0, 3))
        val app = GildedRose(items)
        app.updateQuality()
        assertTrue(app.items[0].daysToExpire < 0)
    }

    @Test
    fun commonItemQualityDecrease() {
        val items = arrayOf<Item>(CommonItem("foo", 1, 3))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, items.first().quality)
    }
    @Test
    fun commonItemQualityOverSellInDateDecreaseDouble() {
        val items = arrayOf<Item>(CommonItem("foo", 0, 3))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, items.first().quality)
    }

    @Test
    fun backstagePassOverSellInQualityDropsToZero(){
        val items: Array<Item> = arrayOf(BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, items.first().quality)
    }

    @Test
    fun agedBrieOverSellInDateIncreaseQuality() {
        val items = arrayOf<Item>(CheeseItem("Aged Brie", 0, 3))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(5, items.first().quality)
    }

    @Test
    fun specialItemNoDaysToExpireUpdate(){
        val items = arrayOf<Item>(SpecialItem("Sulfuras, Hand of Ragnaros", 0, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, items.first().daysToExpire)
    }

    @Test
    fun specialItemQualityUpdate(){
        val items = arrayOf<Item>(SpecialItem("Sulfuras, Hand of Ragnaros", 0, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(81, items.first().quality)
    }

}


