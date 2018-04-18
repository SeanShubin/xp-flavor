package com.seanshubin.xp.flavor

data class TaskReport(val task: Task,
                      val actual: Int,
                      val multiplier: Double,
                      val error: Double,
                      val expected: Double,
                      val explain: Double)