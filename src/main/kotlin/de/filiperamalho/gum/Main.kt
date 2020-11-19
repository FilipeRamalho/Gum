package de.filiperamalho.gum

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.File
import java.io.PrintWriter
import kotlin.text.Typography.copyright

fun main(args: Array<String>) {
    for (arg in args) {
        println(arg)
    }

    //TODO GUI Für Dateneingabe,-ausgabe

    val mapper = jacksonObjectMapper()
    mapper.registerKotlinModule()
    mapper.registerModule(JavaTimeModule())
    var jsonString: String = File({}.javaClass.classLoader.getResource("test.json").toURI()).readText(Charsets.UTF_8)
    val homework: List<Homework> = mapper.readValue(jsonString)

    //TODO Harmonize weight and taskdepth
    // Current problem is you can go for example depth=2, but the weight is defined at depth=1
    // Either don't allow this, so weight as to have same depth definition or deeper or calculate the weight
    // So an check or correction has to implemented here before data processing begins
    // Maybe with an recursive function ?
    // Could try out TDD here

    println("GUM - Universitäts-Manager $copyright 2020")
    for (h in homework) {
        for (j in h.tasks) {
            j.todoDate = null
            for (i in j.subtasks) {
                i.todoDate = null
            }
        }
        h.tasksperday()
        for (j in h.tasks) {
            println("${j.number} ${j.title}")
            for (i in j.subtasks) {
                println("    " + i.title + " " + i.todoDate.toString())
            }
        }
    }

    jsonString = mapper.writeValueAsString(homework)
    val writer = PrintWriter(File({}.javaClass.classLoader.getResource("test2.json").toURI()))
    writer.append(jsonString)
    writer.close()
}