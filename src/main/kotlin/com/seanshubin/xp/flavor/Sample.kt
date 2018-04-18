package com.seanshubin.xp.flavor

class Sample(private val randomInt: (Int) -> Int) {
    private val randomMap = mapOf(
            Pair(0, 1),
            Pair(1, 1),
            Pair(2, 2),
            Pair(3, 2),
            Pair(4, 4),
            Pair(5, 4),
            Pair(6, 4),
            Pair(7, 4),
            Pair(8, 8),
            Pair(9, 8),
            Pair(10, 6),
            Pair(11, 12)
    )

    fun sampleLines(): List<String> {
        val personNames = listOf("Alice", "Bob", "Carol", "Dave")
        val taskNames = listOf("page", "styling", "database", "api", "bug")
        val tasks = generateTasks(taskNames)
        val otherTask = Task("other", 0)
        val people = generatePeople(personNames)
        val plan = generatePlan(taskNames)
        val work = generateWork(people, tasks, otherTask)
        val report = work.toReport()
        return generateLines("### Accepted stories for this iteration", plan.toTable()) +
                generateLines("### Daily recording of actual hours", work.toTable()) +
                generateLines("### Totals", report.toValuesTable()) +
                generateLines("### Time report for stories", report.toTaskTable()) +
                generateLines("### How we are spending our time", generateObstacleTable())
    }

    private fun generatePeople(personNames: List<String>): List<Person> = personNames.map { Person(it) }
    private fun generateTasks(taskNames: List<String>): List<Task> = taskNames.map { generateTask(it) }
    private fun generateTask(taskName: String): Task = Task(taskName, randomEstimate())
    private fun generatePlan(taskNames: List<String>): Plan {
        val tasks = taskNames.map { Task(it, randomEstimate()) }
        return Plan(tasks)
    }

    private fun randomEstimate(): Int = randomMap.getValue(randomInt(randomMap.size))

    private fun generateWork(people: List<Person>, tasks: List<Task>, otherTask: Task): Work {
        val workMap = Day.values().map { Pair(it, createWorkForDay(people, tasks, otherTask)) }.toMap()
        return Work(workMap)
    }

    private fun createWorkForDay(people: List<Person>, tasks: List<Task>, otherTask: Task): Map<Person, Map<Task, Int>> {
        return people.map { Pair(it, createWorkForPerson(tasks, otherTask)) }.toMap()
    }

    private fun createWorkForPerson(tasks: List<Task>, otherTask: Task): Map<Task, Int> {
        var remainingTime = 8
        val pairs = mutableListOf<Pair<Task, Int>>()
        for (task in tasks) {
            val timeForTask = randomInt(remainingTime + 1)
            remainingTime -= timeForTask
            if (timeForTask > 0) {
                pairs.add(Pair(task, timeForTask))
            }
        }
        if (remainingTime > 0) {
            pairs.add(Pair(otherTask, remainingTime))
        }
        return pairs.toMap()
    }

    private fun generateLines(caption: String, rows: List<List<Any>>): List<String> {
        val tableLines = TableFormatter.createTable(rows)
        return listOf(caption) + indent(tableLines)
    }

    private fun indent(lines: List<String>): List<String> = lines.map { "    $it" }
    private fun generateObstacleTable(): List<List<Any>> {
        return listOf<List<Any>>(
                listOf("reason", "actual"),
                listOf("time spent ideally", 100),
                listOf("company internet down", 20),
                listOf("reliance on buggy third party library", 30))
    }
}
