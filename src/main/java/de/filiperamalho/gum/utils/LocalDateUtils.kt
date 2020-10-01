package de.filiperamalho.gum.utils

import java.time.LocalDate


operator fun LocalDate.minus(i: Int) = LocalDate.of(year, month, dayOfMonth).minusDays(i.toLong())!!


operator fun LocalDate.plus(i: Int) = LocalDate.of(year, month, dayOfMonth).plusDays(i.toLong())!!