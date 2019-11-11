package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // Create an active task
        val task = Task("Android Testing", "Complete the testing basics codelab",
                false)

        // Call your function
        val tasks = listOf(task)
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))

    }

    @Test
    fun getActiveAndCompletedStats_oneCompletedNoActive_returnsHundredZero() {
        // Create a completed task
        val completedTask = Task("Android Testing", "Take unit testing codelab",
                true)

        // Call your function
        val tasks = listOf(completedTask)
        val result = getActiveAndCompletedStats(tasks)

        // Check the results
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_twoCompletedThreeActive_returnsFortySixty() {
        // Create two completed tasks
        val firstTask = Task("Task 1", "Task 1 description", true)
        val secondTask = Task("Task 2", "Task 2 description", true)

        // Create three active tasks
        val thirdTask = Task("Task 3", "Task 3 description", false)
        val fourthTask = Task("Task 4", "Task 4 description", false)
        val fifthTask = Task("Task 5", "Task 5 description", false)

        // Create task list of all five tasks
        val tasks = listOf(firstTask, secondTask, thirdTask, fourthTask, fifthTask)

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the results
        assertThat(result.activeTasksPercent, `is`(60f))
        assertThat(result.completedTasksPercent, `is`(40f))

    }
}