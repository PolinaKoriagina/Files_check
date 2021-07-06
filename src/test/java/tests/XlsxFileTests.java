package tests;


import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.*;

public class XlsxFileTests {


    @Test
    void xlsxTest() {
        String xlsFilePath = "./src/test/resources/files/1.xlsx";
        String expectedData = "Лето – это время путешествий и приключений.";

        String actualData = readXlsxFromPath(xlsFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void xlsxCellTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/1.xlsx";
        String expectedData = "Лето – это время путешествий и приключений.";

        XLS xls = getXls(xlsFilePath);
        String actualData = xls.excel.getSheetAt(0).getRow(3).getCell(1).toString();
        assertThat(actualData, containsString(expectedData));

    }
}
