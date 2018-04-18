package com.seanshubin.xp.flavor

data class Task(val name: String, val ideal: Int) : Comparable<Task> {
    override fun compareTo(other: Task): Int =
            name.compareTo(other.name)
}
