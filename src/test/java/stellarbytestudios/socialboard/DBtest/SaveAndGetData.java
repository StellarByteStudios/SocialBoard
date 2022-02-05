package stellarbytestudios.socialboard.DBtest;

import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@ActiveProfiles("test")
public class SaveAndGetData {

   // Jep, hier lässt sich nichts Testen ka warum
}
