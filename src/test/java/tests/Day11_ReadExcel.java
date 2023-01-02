package tests;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day11_ReadExcel extends TestBase {
    /*
        Import the apache poi dependency in your pom file
        Create resources directory under java folder(right click on java and create the folder)
        Add the Excel file on the resources folder
        Create a new package: excelautomation
        Create a new class : ReadExcel
        Create a new test method : readExcel()
        Store the path of the  file in a string
        Open the file
        Open the workbook using fileinputstream
        Open the first worksheet
        Go to first row
        Go to first cell on that first row and print
        Go to second cell on that first row and print
        Go to 2nd row first cell  and assert if the data equal to USA
        Go to 3rd row 2nd cell-chain the row and cell
        Find the number of row
        Find the number of used row
        Print country, capitol key value pairs as map object
    */

    @Test
    public void readExcelTest() throws IOException {

        //  workbook > worksheet > row > cell

        //       Store the path of the  file in a string
        String path = "./src/test/java/resources/Capitals.xlsx";//We add "./" (Dot means all ==>> We are ignoring the root of the path) at the beginning of the path
        // (We copied "Path from content root")

        //        Open the file
        FileInputStream fileInputStream = new FileInputStream(path); //Where is the file

        //Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream); // Get that excel sheet (workbook ==>> excel itself)
                                                                     // Sometimes it throws exception, if it is needed, add exception into the method signature

        //        Open the first worksheet
        Sheet sheet1 = workbook.getSheet("Sheet1");
        // workbook.getSheetAt(0); //ALTERNATIVELY
        //NOTE: We can use sheet name with getSheet() OR sheet index with getSheetAt()
        // sheet indexes start at 0. (zero)

        //        Go to first row (Those get methods coming from apache.poi library)
        Row row1 = sheet1.getRow(0); // index starts at Zero (0) going to the first row

        //        Go to first cell on that first row and print
        Cell cell1 = row1.getCell(0); //index starts at 0. reading the first cell data that is on the first row
        System.out.println(cell1);
        // NOTE : In cell1 data we can use only apache.poi methods.

        //        We can convert the cell data to string
        String cell1Data = cell1.toString();
        System.out.println(cell1Data);
        //NOTE : The benefit of converting to String is using String methods.

        //        Go to second cell on that first row and print
        Cell r1c2 = row1.getCell(1);
        System.out.println("R1C2 : " + r1c2.toString());

        // SHORT WAY: CHAINING THE METHODS
        //        Go to 2nd row first cell  and assert if the data equal to USA
        String r2c1 = sheet1.getRow(1).getCell(0).toString();
        Assert.assertEquals("USA", r2c1);

        //        Go to 3rd row 2nd cell-chain the row and cell
        String r3c2 = sheet1.getRow(2).getCell(1).toString();
        System.out.println(r3c2);

        //        Find the number of row
        int numOfRows = sheet1.getLastRowNum() + 1; //index starts at 0, so add 1 to find the total number of rows
        System.out.println("ROW COUNT : " + numOfRows);

        //        Find the number of used rows
        //        Index starts at 1. getPhysicalNumberOfRows() returns the number of rows (integer) that have DATA. It will skip empty rows/cells.
        int numOfData = sheet1.getPhysicalNumberOfRows();
        System.out.println("Number of used rows : " + numOfData);

        //        Print country, capital key value pairs as map object
        //        {{USA,D.C.},{ France,Paris},...}
        //        Create a map that will store the capital and country pairs
        Map<String, String> countryCapitals = new HashMap<>();
        for (int rowNum = 1; rowNum < numOfRows; rowNum++) {//row index starts at 1, ends at 11
            String country = sheet1.getRow(rowNum).getCell(0).toString();
            String capital = sheet1.getRow(rowNum).getCell(1).toString();
            countryCapitals.put(country, capital);
        }
        System.out.println(countryCapitals);


    }

}
