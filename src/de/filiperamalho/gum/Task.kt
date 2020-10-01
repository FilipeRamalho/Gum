package de.filiperamalho.gum

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

class Task(
        var title: String,
        var points: Int,
        var number: String,
        private var weight: Int = 0,
        var done: Boolean = false,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        var todoDate: LocalDate? = null,
        var id: UUID = UUID.randomUUID(),
        var subtasks: ArrayList<Task> = ArrayList(),
        var subtaskdepth: Int = 0) {

    fun getWeight(): Int {
        return if (weight == 0) {
            var totalweight = 0
            for (i in subtasks) {
                if (!i.done) {
                    totalweight += i.getWeight()
                }
            }
            totalweight
        } else {
            weight
        }
    }

    @JsonIgnore
    fun getTotalTasks(): ArrayList<Task> {
        return getTotalTasks(subtaskdepth)
    }

    //TODO Reconsider name, as it really isn't descriptive
    // To consider, it's the total at a certain nesting level
    fun getTotalTasks(subtaskdepth: Int): ArrayList<Task> {
        val totaltask = ArrayList<Task>()
        if (subtaskdepth == 0) {
            totaltask += this
            return totaltask
        }
        for (i in subtasks) {
            if (!i.done) {
                if(subtaskdepth-1 < i.subtaskdepth) {
                    totaltask += i.getTotalTasks(subtaskdepth - 1)
                }else{
                    totaltask += i.getTotalTasks()
                }
            }
        }
        return totaltask
    }

    //TODO
    // Needs getString(), returns deepest Tasks with date
    // FOR EXAMPLE
    // 2 Gram-Schmidtsches Orthogonalisierungsverfahren
    //    a) 2020-06-29
    //    b) 2020-06-30
    // NOT
    // 3 Operatoren
    //    a) null
    //    b) 2020-07-01
    //    c) 2020-07-02
    // INSTEAD
    // 3 Operatoren
    //    a)
    //      i) 2020-06-30
    //      ii) 2020-06-30
    //      iii) 2020-06-30
    //      iv) 2020-06-30
    //    b) 2020-07-01
    //    c) 2020-07-02
    // null shall never be returned !!!
}