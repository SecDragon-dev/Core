package edu.kit.kastel.mcse.secdragon.core.api

import com.fasterxml.jackson.annotation.JsonProperty

data class SecurityAnnotation(
    @JsonProperty("securityObjective") val objective: SecurityObjective,
    @JsonProperty("securityImpact") val impact: Impact,
    @JsonProperty("securityMitigation") val mitigation: Mitigation
)
