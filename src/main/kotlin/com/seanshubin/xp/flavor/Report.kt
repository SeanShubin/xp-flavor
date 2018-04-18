package com.seanshubin.xp.flavor

import kotlin.math.roundToInt

data class Report(val ideal: Int, val actual: Int, val multiplier: Double, val taskReports: List<TaskReport>) {
    fun toValuesTable(): List<List<Any>> =
            listOf(
                    listOf("total ideal", ideal),
                    listOf("total actual", actual),
                    listOf("multiplier", round(multiplier)))

    fun toTaskTable(): List<List<Any>> {
        val header = listOf("task", "ideal", "actual", "expected", "explain")
        val rows = mutableListOf<List<Any>>()
        for (taskReport in taskReports) {
            rows.add(listOf(
                    taskReport.task.name,
                    taskReport.task.ideal,
                    taskReport.actual,
                    round(taskReport.expected),
                    round(taskReport.explain)))
        }
        return listOf(header) + rows
    }

    private fun round(double: Double): Double =
            (double * 100).roundToInt().toDouble() / 100
}