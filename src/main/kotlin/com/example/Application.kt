package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.utils.io.errors.*
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.parser.Parser

val rss_site = "http://rss.cnn.com/rss/edition_africa.rss"
val rss_site2 = "https://technovagh.com/feed/"
val rss_site3 = "https://cdn.ghanaweb.com/feed/newsfeed.xml"
val rss_site4 = "https://ghanaiannews.ca/rss-feed/"
val rss_site5 = "https://www.peacefmonline.com/pages/news.xml"
val rss_site6 = "http://www.itnewsafrica.com/feed/"
val rss_site7 = "https://mfidie.com/tech-news/feed/"

fun main() {
    val elements: MutableList<Element> = ArrayList()
    try {
        val doc = Jsoup.connect(rss_site7).parser(Parser.xmlParser()).get()
        val doc2 = Jsoup.connect(rss_site).parser(Parser.xmlParser()).get()


//        for (e in doc.select("item")) {
//            elements.add(e)
//            val title = e.select("title").text()
//            val description = e.select("description").text()
//            val link = e.select("link").text()
////                if (title.contains("tech" ) || description.contains("tech")){
//            println("title- $title  link- $link")
////                }
//        }
//        for (e in doc2.select("item")) {
//            elements.add(e)
//            val title = e.select("title").text()
//            val description = e.select("description").text()
//            val link = e.select("link").text()
//                if (title.contains("tech" ) || description.contains("tech")){
//            println("title- $title  link- $link")
//                }
//        }
    } catch (e: IOException){
        e.stackTrace
    }

    fun parse(doc: Document){
        for (e in doc.select("item")){
            val title = e.select("title").text()
            val description = e.select("description").text()
            val link = e.select("link").text()
            if (title.contains("tech" ) || description.contains("tech")){
                println("title- $title  link- $link")
            }
        }
    }

}


