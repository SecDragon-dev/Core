package edu.kit.kastel.mcse.secdragon.core.tests

import com.fasterxml.jackson.module.kotlin.readValue
import createObjectMapper
import edu.kit.kastel.mcse.secdragon.core.api.RequirementDatasetFile
import edu.kit.kastel.mcse.secdragon.core.datasetextraction.DatasetExtractor
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Paths

class DatasetLoadingTest {

    val cchit = "CCHIT_Certified_2011_Ambulatory_EHR_Criteria_20110517_PUBLISH.json"
    val ehr = "EHR-Privacy-Security-Requirements_PUBLISH.json"
    val featureRequests = "featureRequests_-_for_annotation-PUBLISH.json"
    val hl7 = "HL7_Functional_Profile_-_PUBLISH.json"
    val nursing = "nursing_ehr_business_and_functional_elements_june__2012_PUBLISH.json"
    val vler = "VLER_UserStories_Combined_PUBLISH.json"


    @Test
    fun test()  {

        val datasetExtractor = DatasetExtractor()
        val dataset = datasetExtractor.extract("/riaz-dataset/"+nursing)
        println("" + dataset)
    }
}
