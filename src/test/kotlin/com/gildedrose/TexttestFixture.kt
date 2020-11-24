package com.gildedrose

import com.model.*

fun main(args: Array<String>) {

    println("OMGHAI!")

    val items = arrayOf(CommonItem("+5 Dexterity Vest", 10, 20), //
            CheeseItem("Aged Brie", 2, 0), //
            CommonItem("Elixir of the Mongoose", 5, 7), //
            SpecialItem("Sulfuras, Hand of Ragnaros", 0, 80), //
            SpecialItem("Sulfuras, Hand of Ragnaros", -1, 80),
            BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            BackStagePassItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            CommonItem("Conjured Mana Cake", 3, 6))

    val app = GildedRose(items)

    var days = 2
    if (args.size > 0) {
        days = Integer.parseInt(args[0]) + 1
    }

    for (i in 0..days - 1) {
        println("-------- day $i --------")
        println("name, sellIn, quality")
        for (item in items) {
            println(item)
        }
        println()
        app.updateQuality()
    }


}
