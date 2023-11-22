package edu.kit.kastel.mcse.secdragon.core.api

data class RequirementDataset(val sentence: String, val securityObjectiveAnnotations: List<SecurityAnnotation>, val source: String, val sentenceNumber: Double) {
}
