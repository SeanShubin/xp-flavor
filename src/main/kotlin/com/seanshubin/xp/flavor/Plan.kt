package com.seanshubin.xp.flavor

data class Plan(val tasks: List<Task>) {
    fun toTable(): List<List<Any>> {
        val header = listOf("name", "ideal")
        val body = tasks.map { taskToRow(it) }
        return listOf(header) + body
    }

    private fun taskToRow(task: Task): List<Any> =
            listOf(task.name, task.ideal)
}
