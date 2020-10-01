package de.filiperamalho.gum

import com.fasterxml.jackson.annotation.JsonFormat
import de.filiperamalho.gum.utils.minus
import de.filiperamalho.gum.utils.plus
import java.time.LocalDate
import java.time.Period
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.ceil

class Homework(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        var duedate: LocalDate,
        var duehour: Int,
        var subject: String = "",
        var pdf: String = "",
        var pertaskdepth: Boolean = true,
        var tasks: ArrayList<Task> = ArrayList(),
        var uuid: UUID = UUID.randomUUID(),
        var subtaskdepth: Int = 0){


    fun addTask(task: Task){
        tasks.add(task)
    }

    fun setTask(tasks: ArrayList<Task>){
        this.tasks = tasks
    }

    private fun getAvailableDays():Int{
        return Period.between(getFirstDay(), getLastDay()).days+1
    }

    private fun getLastDay(): LocalDate{
        var lastday = duedate
        if (duehour < 22 && getDaysBetween() != 0) {
            lastday -= 1
        }
        return lastday
    }

    private fun getFirstDay(): LocalDate{
        var firstday = LocalDate.now()
        if (getDaysBetween() > 3) {
            firstday += 1
        }
        return firstday
    }

    private fun getDaysBetween(): Int{
        return  Period.between(LocalDate.now(), duedate).days
    }

    init {
        if (getDaysBetween() < 0) {
            throw IllegalArgumentException("Due date can't be before today's date!")
        }
    }

    private fun getTotalWeight():Int{
        var totalweight = 0
        for(i in tasks){
            if(!i.done) {
                totalweight += i.getWeight()
            }
        }
        return totalweight
    }

    fun tasksperday() {
        if (getTotalWeight() == 0) {
            return
        }
        val datelist = ArrayList<LocalDate>()
        var assigndate = getFirstDay()
        val tasksperday = ceil(getTotalWeight() / getAvailableDays().toDouble()).toInt()
        repeat(getAvailableDays() - 1) {
            repeat(tasksperday) {
                if(datelist.size < getTotalWeight()){
                    datelist.add(assigndate)
                }
            }
            assigndate = assigndate.plusDays(1)
        }
        while (datelist.size < getTotalWeight()) {
            datelist.add(getLastDay())
        }

        val alltasks = ArrayList<Task>()
        if(pertaskdepth) {
            for (i in tasks) {
                alltasks += i.getTotalTasks()
            }
        }else{
            for (i in tasks) {
                alltasks += i.getTotalTasks(subtaskdepth)
            }
        }

        var i = 0; var j = 0

        while(j != getTotalWeight()){
            alltasks[i].todoDate = datelist[j]
            if(alltasks[i].subtasks.size > 0){
                for(task in alltasks[i].subtasks){
                    task.todoDate = datelist[j]
                }
            }
            j += alltasks[i].getWeight()
            i += 1
        }

    }
}