package com.ainaz.expertsystemlab1.data.gis

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GisDao {
    @Insert
    @JvmSuppressWildcards
    suspend fun addGis(gis: GisEntity)

    @Query("SELECT * FROM gis_table")
    @JvmSuppressWildcards
    fun getAll(): Flow<List<GisEntity>>

    @Query(
        """SELECT * 
                FROM gis_table
                WHERE prise <= :prise
                AND producerCountry IN (:producerCountry)
                AND archPrinciple IN (:archPrinciple)
                AND territoryCoverage IN (:territoryCoverage)
                AND subjectArea IN (:subjectArea)
                AND graphType IN (:graphType)
                AND dbmsIntegration = :dbmsIntegration
                AND clientServer = :clientServer
                AND cloudComputation = :cloudComputation
                AND mobilePlatforms = :mobilePlatforms
                """
    )
    fun getFilteredGisList(
        prise: Int,
        producerCountry: String,
        archPrinciple: String,
        territoryCoverage: String,
        subjectArea: String,
        graphType: String,
        dbmsIntegration: Boolean,
        clientServer: Boolean,
        cloudComputation: Boolean,
        mobilePlatforms: Boolean
    ): Flow<List<GisEntity>>

    @Query(
        """SELECT * 
                FROM gis_table
                WHERE mobilePlatforms = :mobilePlatforms
                """
    )
    fun getFilteredGisListTest(
        mobilePlatforms: Boolean
    ): Flow<List<GisEntity>>
}