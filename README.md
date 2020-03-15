# Emerge-Tech_Task
automation script that automates the registration process and the verification of successful login.
By using POM and page factory design pattern, and TestNG framework, written with java language.
You can find 7 packages, 6 packages in “src/main/java” folder:
1-	com.Pixelogic.Base which includes one class called TestBase.java, this class implements the base functionalities, in turn it include the initialization method which initialize the browser (driver) and two other methods, openurl and getpagetitle.
2-	com.Pixelogic.Config which includes one file called config.proterties, this file include the links that are used in the test, the file path, file name and the sheet name.
3-	com.Pixelogic.Pages which includes two classes (LoginPage, SignupPage) inherit the TestBase class, they implement the page element locators and the methods required from each page for the test class.
4-	com.Pixelogic.TestData which includes one file called Registration.xlsx, this file include the test data required for each user to register in the website.
5-	com.Pixelogic.Util this package includes two classes (ReadFromExcel, Takescreenshot) the two classes implement the utilities required for the test.
6-	ExetentReportListner
There is also one package in “src/test/java” folder: 
1-	com.pixelogic.Test this package includes one class called signUpPageTest.java this class implements the test script, with TestNG framework:
@Beforemethod annotation which initializes the driver and the pages classes.
@Aftermethod annotation which closes the browser after the test.
@Dataprovider annotation which implements the data driven test approach and pass the data from the excel file to the test.
@Test annotation which implements the test.
