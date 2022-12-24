package tests;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileExistTest extends TestBase {
    //Class: FileExistTest
    //Method: isExist
    //Pick a file on your desktop
    //And verify if that file exists on your computer or not

    @Test
    public void isExist(){

        String userDIR= System.getProperty("user.dir");       //=>gives the path of the current project folder
        System.out.println(userDIR);                          ///Users/techproed/IdeaProjects/SeleniumNewProject

        String userHOME=System.getProperty("user.home");      //=>gives you the user folder ===>>> returns the dynamic path
        System.out.println(userHOME); ///Users/techproed


//        Pick a file on your desktop
//        And verify if that file exists on your computer or not
        String pathOfFile = userHOME + "/Downloads/logo.jpeg";         //WRITING THE PATH DYNAMICALLY SO THIS PATH CAN WORK ON OTHER LAPTOPS
        boolean isExist = Files.exists(Paths.get(pathOfFile));      //returns TRUE if file exists. FALSE if file doesn't exists
        Assert.assertTrue(isExist);
    }

}
