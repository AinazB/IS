package com.ainaz.expertsystemlab1.data.gis

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gis_table")
class GisEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String?,
    val prise: Int?,
    val producerCountry: String?,
    val archPrinciple: String?,
    val territoryCoverage: String?,
    val subjectArea: String?,
    val graphType: String?,
    val dbmsIntegration: Boolean?,
    val clientServer: Boolean?,
    val cloudComputation: Boolean?,
    val mobilePlatforms: Boolean?
)
