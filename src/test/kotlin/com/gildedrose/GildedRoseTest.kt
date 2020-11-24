package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GildedRoseTest {


    @Test
    fun foo() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)

    }

    @Test
    fun testMaxQualityAlreadyReached(){
        val items = arrayOf(Item("Aged Brie", 0, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, items.first().quality)
    }

    @Test
    fun decreaseQualityCommonItem(){
        val items = arrayOf(Item("Peppers", 1, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, items.first().quality)
    }

    @Test
    fun increaseQualitySpecialItem(){
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 1, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(13, items.first().quality)
    }

    @Test
    fun commonItemSellInDecrease() {
        val items = arrayOf<Item>(Item("foo", 0, 3))
        val app = GildedRose(items)
        app.updateQuality()
        assertTrue(app.items[0].sellIn < 0)
    }

    @Test
    fun commonItemQualityDecrease() {
        val items = arrayOf<Item>(Item("foo", 1, 3))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, items.first().quality)
    }
    @Test
    fun commonItemQualityOverSellInDateDecreaseDouble() {
        val items = arrayOf<Item>(Item("foo", 0, 3))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, items.first().quality)
    }

    @Test
    fun backstagePassOverSellInQualityDropsToZero(){
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, items.first().quality)
    }

    @Test
    fun AgedBrieOverSellInDateIncreaseQuality() {
        val items = arrayOf<Item>(Item("Aged Brie", 0, 3))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(5, items.first().quality)
    }


}


