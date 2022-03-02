package stellarbytestudios.socialboard.architechture;

import com.tngtech.archunit.base.PackageMatchers;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import stellarbytestudios.socialboard.SocialBoardApplication;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.Configurations.consideringOnlyDependenciesInAnyPackage;
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