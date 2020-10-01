import de.filiperamalho.gum.Homework
import de.filiperamalho.gum.Task
import de.filiperamalho.gum.main
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import de.filiperamalho.gum.utils.plus
import java.lang.IllegalArgumentException
import java.time.LocalDate
/**
internal class HomeworkTest {

    @BeforeEach
    fun setUp() {
        main(arrayOf("no-args"))
    }

    //TODO Redo Test files structure
    //TODO NEEDS SERIOUS REDOING !!!!
    //TODO Add test for Subtasks
    //TODO Add test for Sub...Subtasks
    //TODO Add test for getTotalTasks() of Task.class
    //TODO Add test for getWeight() of Task.class
    //TODO Add test for getTotalWeight() of Homework.class
    //TODO Add test for getters of Homework.class
    //TODO Add test for getters of Homework.class
    //TODO Add test for separable Tasks
    //TODO Add test for console I/O and file I/O
    //TODO When File I/O  tested, then switch tests to use file configurations.
    //TODO After that develop through TDD

    @Test
    fun tasksperday() {
        var homework = Homework(LocalDate.now() + 4, 22)
        repeat(10){
            homework.addTask(Task("", 5, "a)"))
        }
        homework.tasksperday()
        Assertions.assertEquals(homework.tasks[0].todoDate, LocalDate.now() + 1)
        Assertions.assertEquals(homework.tasks[1].todoDate, LocalDate.now() + 1)
        Assertions.assertEquals(homework.tasks[2].todoDate, LocalDate.now() + 1)
        Assertions.assertEquals(homework.tasks[3].todoDate, LocalDate.now() + 2)
        Assertions.assertEquals(homework.tasks[4].todoDate, LocalDate.now() + 2)
        Assertions.assertEquals(homework.tasks[5].todoDate, LocalDate.now() + 2)
        Assertions.assertEquals(homework.tasks[6].todoDate, LocalDate.now() + 3)
        Assertions.assertEquals(homework.tasks[7].todoDate, LocalDate.now() + 3)
        Assertions.assertEquals(homework.tasks[8].todoDate, LocalDate.now() + 3)
        Assertions.assertEquals(homework.tasks[9].todoDate, LocalDate.now() + 4)

        homework = Homework(LocalDate.now() + 4, 22)
        repeat(5){
            homework.addTask(Task("", 5, "a)"))
        }
        homework.tasksperday()
        Assertions.assertEquals(homework.tasks[0].todoDate, LocalDate.now() + 1)
        Assertions.assertEquals(homework.tasks[1].todoDate, LocalDate.now() + 1)
        Assertions.assertEquals(homework.tasks[2].todoDate, LocalDate.now() + 2)
        Assertions.assertEquals(homework.tasks[3].todoDate, LocalDate.now() + 2)
        Assertions.assertEquals(homework.tasks[4].todoDate, LocalDate.now() + 3)

        homework = Homework(LocalDate.now() + 4, 22)
        repeat(3){
            homework.addTask(Task("", 5, "a)"))
        }
        homework.tasksperday()
        Assertions.assertEquals(homework.tasks[0].todoDate, LocalDate.now() + 1)
        Assertions.assertEquals(homework.tasks[1].todoDate, LocalDate.now() + 2)
        Assertions.assertEquals(homework.tasks[2].todoDate, LocalDate.now() + 3)


        homework = Homework(LocalDate.now(), 22)
        repeat(3){
            homework.addTask(Task("", 5, "a)"))
        }
        homework.tasksperday()
        Assertions.assertEquals(homework.tasks[0].todoDate, LocalDate.now())
        Assertions.assertEquals(homework.tasks[1].todoDate, LocalDate.now())
        Assertions.assertEquals(homework.tasks[2].todoDate, LocalDate.now())


        homework = Homework(LocalDate.now() + 1, 22)
        repeat(3){
            homework.addTask(Task("", 5, "a)"))
        }
        homework.tasksperday()
        Assertions.assertEquals(homework.tasks[0].todoDate, LocalDate.now())
        Assertions.assertEquals(homework.tasks[1].todoDate, LocalDate.now())
        Assertions.assertEquals(homework.tasks[2].todoDate, LocalDate.now() + 1)

        homework = Homework(LocalDate.now() + 1, 22)
        Assertions.assertDoesNotThrow {
            homework.tasksperday()
        }

        homework = Homework(LocalDate.now() + 5, 8)
        repeat(5){
            homework.addTask(Task("", 5, "a)",2))
        }
        repeat(6){
            homework.addTask(Task("", 5, "a)",5))
        }
        homework.tasksperday()
        Assertions.assertEquals(homework.tasks[0].todoDate, LocalDate.now() + 1)
        Assertions.assertEquals(homework.tasks[1].todoDate, LocalDate.now() + 1)
        Assertions.assertEquals(homework.tasks[2].todoDate, LocalDate.now() + 1)
        Assertions.assertEquals(homework.tasks[3].todoDate, LocalDate.now() + 1)
        Assertions.assertEquals(homework.tasks[4].todoDate, LocalDate.now() + 1)
        Assertions.assertEquals(homework.tasks[5].todoDate, LocalDate.now() + 2)
        Assertions.assertEquals(homework.tasks[6].todoDate, LocalDate.now() + 2)
        Assertions.assertEquals(homework.tasks[7].todoDate, LocalDate.now() + 3)
        Assertions.assertEquals(homework.tasks[8].todoDate, LocalDate.now() + 3)
        Assertions.assertEquals(homework.tasks[9].todoDate, LocalDate.now() + 4)
        Assertions.assertEquals(homework.tasks[10].todoDate, LocalDate.now() + 4)
    }

    @Test
    fun homework_class(){
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            Homework(LocalDate.now().minusDays(1), 8)
        }
        Assertions.assertEquals(Homework(LocalDate.now(), 8).getAvailableDays(), 1)
        Assertions.assertEquals(Homework(LocalDate.now(), 20).getAvailableDays(), 1)
        Assertions.assertEquals(Homework(LocalDate.now() + 1, 8).getAvailableDays(), 1)
        Assertions.assertEquals(Homework(LocalDate.now() + 1, 22).getAvailableDays(), 2)
        Assertions.assertEquals(Homework(LocalDate.now() + 2, 8).getAvailableDays(), 2)
        Assertions.assertEquals(Homework(LocalDate.now() + 2, 22).getAvailableDays(), 3)
        Assertions.assertEquals(Homework(LocalDate.now() + 3, 8).getAvailableDays(), 3)
        Assertions.assertEquals(Homework(LocalDate.now() + 3, 22).getAvailableDays(), 4)
        Assertions.assertEquals(Homework(LocalDate.now() + 4, 8).getAvailableDays(), 3)
        Assertions.assertEquals(Homework(LocalDate.now() + 4, 22).getAvailableDays(), 4)
        Assertions.assertEquals(Homework(LocalDate.now() + 5, 8).getAvailableDays(), 4)
        Assertions.assertEquals(Homework(LocalDate.now() + 5, 22).getAvailableDays(), 5)
    }
}
        **/