package com.example

import com.example.plugins.*
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.utils.io.errors.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.parser.Parser

data class Feed(
    val title: String?,
    val link: String?
){
    override fun toString(): String {
        return "Feed(title=$title, link=$link)"
    }

}
//klaxon, jackson, gson, kotlinx.serialization,
//data class Articles()

val rss_site = "http://rss.cnn.com/rss/edition_africa.rss"
val rss_site2 = "https://technovagh.com/feed/"
val rss_site3 = "https://cdn.ghanaweb.com/feed/newsfeed.xml"
val rss_site4 = "https://ghanaiannews.ca/rss-feed/"
val rss_site5 = "https://www.peacefmonline.com/pages/news.xml"
val rss_site6 = "http://www.itnewsafrica.com/feed/"
val rss_site7 = "https://mfidie.com/tech-news/feed/"


suspend fun main() {
    val feeds: MutableList<Feed> = mutableListOf()

    fun parse(doc: Document){
        for (e in doc.select("item")){
            val title = e.select("title").text()
            val description = e.select("description").text()
            val link = e.select("link").text()

//            Filter for news
            if (title.contains("Ghana" ) || description.contains("tech")){
                println("title- $title  link- $link")
                feeds.add(Feed(title, link))
            }
        }
//        println(feeds)
        println(feeds.size)
    }



    try {
        val doc = Jsoup.connect(rss_site7).parser(Parser.xmlParser()).get()
        val doc2 = Jsoup.connect(rss_site).parser(Parser.xmlParser()).get()
        val doc3 = Jsoup.connect(rss_site3).parser(Parser.xmlParser()).get()

        parse(doc)
        parse(doc2)
        parse(doc3)

//        println(feed)

    } catch (e: IOException){
        println(e.stackTrace)
    }
}



