package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.assertEquals
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        //Create an active task
        val task = Task("Android Testing", "Complete the testing basics codelab",
                false)

        //Call your function
        val tasks = listOf(task)
        val result = getActiveAndCompletedStats(tasks)

        //Check the result
        assertEquals(result.activeTasksPercent, 100f)
        assertEquals(result.completedTasksPercent, 0f)
    }
}