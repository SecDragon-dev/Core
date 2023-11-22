import edu.kit.kastel.mcse.ardoco.core.api.models.ArchitectureModelType
import edu.kit.kastel.mcse.ardoco.core.common.util.CommonUtilities
import edu.kit.kastel.mcse.ardoco.core.execution.runner.ArDoCoRunner
import edu.kit.kastel.mcse.ardoco.core.models.ModelProviderAgent
import edu.kit.kastel.mcse.ardoco.core.text.providers.TextPreprocessingAgent
import java.io.File
import java.io.IOException
import java.util.SortedMap

class SecDragonPipeline(projectName: String) : ArDoCoRunner(projectName) {
    // private val logger: Logger = LoggerFactory.getLogger(SecDragonPipeline::class.java)

    fun setUp(
        diagramDirectory: File,
        inputText: File,
        inputModelArchitecture: File,
        inputArchitectureModelType: ArchitectureModelType,
        additionalConfigs: SortedMap<String, String>,
        outputDir: File
    ) {
        try {
            definePipeline(inputText, inputModelArchitecture, inputArchitectureModelType, additionalConfigs)
        } catch (e: IOException) {
            /*logger.error(
                "Problem in initialising pipeline when loading data (IOException)",
                e.cause
            )*/
            isSetUp = false
            return
        }
        setOutputDirectory(outputDir)
        isSetUp = true
    }

    /**
     * This method sets up the pipeline for ArDoCo.
     *
     * @param inputText              the input text file
     * @param inputArchitectureModel the input architecture file
     * @param architectureModelType  the type of the architecture (e.g., PCM, UML)
     * @param additionalConfigs      the additional configs
     * @throws IOException When one of the input files cannot be accessed/loaded
     */
    private fun definePipeline(
        inputText: File,
        inputArchitectureModel: File,
        architectureModelType: ArchitectureModelType,
        additionalConfigs: SortedMap<String, String>
    ) {
        val arDoCo = arDoCo
        val dataRepository = arDoCo.dataRepository
        val requirements = CommonUtilities.readInputText(inputText)
        arDoCo.addPipelineStep(TextPreprocessingAgent.get(additionalConfigs, dataRepository))
        arDoCo.addPipelineStep(ModelProviderAgent.get(inputArchitectureModel, architectureModelType, dataRepository))
    }
}
