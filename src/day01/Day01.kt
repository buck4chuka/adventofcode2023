package day01

import println
import readInput

fun main() {
    val wordToDigitMap = mapOf(
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9"
    )
    val digitsMap = wordToDigitMap + (1..9).associate { it.toString() to it.toString() }
    fun part1(input: List<String>): Int {
        return input.sumOf { it ->
            val firstIdx = it.indexOfFirst { it.isDigit() }
            val secondIdx = it.indexOfLast { it.isDigit() }
            "${it[firstIdx]}${it[secondIdx]}".toInt()
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { line ->
            val numbers = line.indices.flatMap { i ->
                (i until line.length).mapNotNull { j -> digitsMap[line.substring(i, j + 1)] }
            }
            "${numbers.first()}${numbers.last()}".toInt()
        }
    }
    val input = readInput("day01/day01")
    part1(input).println()
    part2(input).println()
}
