package stellarbytestudios.socialboard.architechture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import stellarbytestudios.socialboard.SocialBoardApplication;


import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.Configurations.consideringOnlyDependenciesInDiagram;
import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.adhereToPlantUmlDiagram;
import static com.tngtech.archunit.thirdparty.com.google.common.io.Resources.getResource;

@AnalyzeClasses(packagesOf = SocialBoardApplication.class, importOptions = {ImportOption.DoNotIncludeTests.class})
public class StructureTest {

    @ArchTest
    static ArchRule architechtureTest = classes()
            .should(adhereToPlantUmlDiagram(getResource("Structure.puml"),
                    consideringOnlyDependenciesInDiagram()));

}