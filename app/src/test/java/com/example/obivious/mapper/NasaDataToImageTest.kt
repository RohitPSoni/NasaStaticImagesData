package com.example.obivious.mapper

import com.example.obivious.remote.model.NasaData
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class NasaDataToImageTest {
    private lateinit var mapper: NasaDataToImage

    @BeforeEach
    fun setUp() {
        mapper = NasaDataToImageImpl()
    }

    @Test
    fun `parse to ui mapper when list is empty`() {
        val list = mapper.invoke(mutableListOf())
        Assertions.assertEquals(0, list.size)
    }

    @Test
    fun `parse to ui mapper when list has data`() {
        val list = mapper.invoke(generateMockNetworkList())
        Assertions.assertTrue(list.isNotEmpty())
    }

    private fun generateMockNetworkList(): List<NasaData> {
        val list = mutableListOf<NasaData>()
        list.add(
            NasaData(null, null, null, null, null, null, "Title1", null)
        )
        list.add(NasaData(null, null, null, null, null, null, "Title2", "Some URL"))
        return list
    }
}