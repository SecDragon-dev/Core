package edu.kit.kastel.mcse.secdragon.core

import com.fasterxml.jackson.module.kotlin.readValue
import createObjectMapper
import edu.kit.kastel.mcse.secdragon.core.api.RequirementDatasetFile
import org.junit.jupiter.api.Test
import java.io.File

class DatasetLoadingTest {
    @Test
    fun test()  {
        val oom = createObjectMapper()
        val dataset: RequirementDatasetFile = oom.readValue(File("C:\\Users\\Sophie\\Desktop\\Riaz\\nursing_ehr_business_and_functional_elements_june__2012_PUBLISH.json"))

        System.out.println("" + dataset)
    }
}
