package edu.kit.kastel.mcse.secdragon.core.datasetextraction

import com.fasterxml.jackson.module.kotlin.readValue
import createObjectMapper
import edu.kit.kastel.mcse.secdragon.core.api.RequirementDataset
import edu.kit.kastel.mcse.secdragon.core.api.RequirementDatasetFile
import java.io.File
import java.io.InputStream
import java.net.URL
import java.nio.file.Path
import java.nio.file.Paths

public class DatasetExtractor {

    private fun loadFile(path: String): InputStream {
        if(path.contains(" ")){
            throw IllegalArgumentException("spaces not allowed in paths!")
        }
        val resource = javaClass.getResourceAsStream(path)
        if (resource == null) {
            throw IllegalArgumentException("file not found!")
        } else {
            return resource
        }
    }


    fun extract(path: String): RequirementDatasetFile{
        val file = loadFile(path)
        val oom = createObjectMapper()
        return oom.readValue(file)
    }

}
