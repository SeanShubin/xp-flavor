package com.seanshubin.xp.flavor

import kotlin.math.abs

data class Work(val dayMap: Map<Day, Map<Person, Map<Task, Int>>>) {
    fun toTable(): List<List<Any>> {
        val header = listOf("day", "person", "task", "actual")
        val rows = mutableListOf<List<Any>>()
        for (day in dayMap.keys) {
            val personMap = dayMap.getValue(day)
            for (person in personMap.keys) {
                val taskMap = personMap.getValue(person)
                for (task in taskMap.keys) {
                    val actual = taskMap.getOrElse(task, { 0 })
                    val row = listOf(day, person.name, task.name, actual)
                    rows.add(row)
                }
            }
        }
        return listOf(header) + rows
    }

    fun toReport(): Report {
        val taskActuals = taskActuals()
        var totalIdeal = 0
        var totalActual = 0
        for (task in taskActuals.keys) {
            totalIdeal += task.ideal
            totalActual += taskActuals.getValue(task)
        }
        val totalMultiplier = totalActual.toDouble() / totalIdeal
        val taskReports = mutableListOf<TaskReport>()
        for (task in taskActuals.keys.sorted()) {
            val expected = task.ideal * totalMultiplier
            val actual = taskActuals.getValue(task)
            val explain = actual - expected
            val multiplier = actual.toDouble() / task.ideal
            val error = abs((actual - expected) / expected)
            taskReports.add(TaskReport(task, actual, multiplier, error, expected, explain))
        }
        return Report(totalIdeal, totalActual, totalMultiplier, taskReports)
    }

    fun taskActuals(): Map<Task, Int> {
        val accumulator = mutableMapOf<Task, Int>()
        for (day in dayMap.keys) {
            val personMap = dayMap.getValue(day)
            for (person in personMap.keys) {
                val taskMap = personMap.getValue(person)
                for (task in taskMap.keys) {
                    if (task.name != "other") {
                        val actual = taskMap.getOrElse(task, { 0 })
                        val oldValue = accumulator.getOrElse(task, { 0 })
                        val newValue = oldValue + actual
                        accumulator[task] = newValue
                    }
                }
            }
        }
        return accumulator
    }
}
