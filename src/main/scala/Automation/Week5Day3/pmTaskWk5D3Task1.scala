package Automation.Week5Day3

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.Select

//MVP:
//Automate a basic form interaction and navigation:
//1. Navigate to the site: https://testpages.herokuapp.com/styled/index.html
//• Once here, maximise the page.
//2. Handle Text Boxes:
//• Go to the "HTML Form Example" page.
//• Fill in the username and password fields.
//3. Handle Checkbox:
//• Locate a checkbox.
//• Select the checkbox located if not already selected.
//4. Handle Radio Buttons:
//• Select a radio option.
//5. Handle Dropdown/Select:
//• Choose an option from the dropdown.
//6. Handle Buttons:
//• Click the "Submit" button.
//7. Handle Links:
//• Click a link to return to the homepage.

object pmTaskWk5D3Task1 extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
  //1. Navigate to the site: https://testpages.herokuapp.com/styled/index.html
  driver.get("https://testpages.herokuapp.com/styled/index.html")
  //• Once here, maximise the page.
  driver.manage().window().maximize()

  //2. Handle Text Boxes:
  //• Go to the "HTML Form Example" page.
  //• Fill in the username and password fields.

driver.navigate().to("https://testpages.eviltester.com/styled/basic-html-form-test.html")
  val username = driver.findElement(By.name("username"))
  username.sendKeys("AlphaBetty")
  println("Enter username - "+ username)

  val password =driver.findElement(By.name("password"))
  password.sendKeys(("123@123"))
  println("Enter password - " + password)



  //3. Handle Checkbox:
  //• Locate a checkbox.
  //• Select the checkbox located if not already selected.
val checkBox = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[1]"))
  if(!checkBox.isSelected){
    checkBox.click()
  println("check if selected, select the checkbox")
  }
// OPTIONAL Uncheck if needed
if(checkBox.isSelected) {
  checkBox.click() //unselects the checkbox
}
  println("Checkbox interaction complete")



  //4. Handle Radio Buttons:
  //• Select a radio option.

  //Locate the radio btns
  val radioBtn1 = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[1]"))
  val radioBtn2 = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[2]"))
  val radioBtn3 = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[3]"))

  //Only click radioBtn3 if not already selected
  if (!radioBtn3.isSelected){
    radioBtn3.click()
    println("radio button 3 selected")
  } else {
    println("radio button 3 already selected")
  }

  //checks which radio button is selected
  if (radioBtn1.isSelected) {
    println("Radio 1 is selected")
  } else if (radioBtn2.isSelected) {
    println("Radio 2 is selected")
  } else if (radioBtn3.isSelected) {
    println("Radio 3 is selected")
  } else {
    println("No radio button selected")
  }

  //5. Handle Dropdown/Select:
    //• Choose an option from the dropdown.

val dropDown: WebElement = driver.findElement(By.name("dropdown"))
val selectDropdown = new Select(dropDown)

  selectDropdown.selectByVisibleText("Drop Down Item 1") // Visible by Text
  println("Select by visible text - " + selectDropdown.getFirstSelectedOption.getText)
  selectDropdown.selectByIndex(2) // Select based on index
println("Select by index - " + selectDropdown)
  selectDropdown.selectByValue("dd6")
  println("Select by value - " +selectDropdown)
    //6. Handle Buttons:
    //• Click the "Submit" button.

  val submit = driver.findElement(By.cssSelector("input[type='submit']"))
  submit.click()
  println("6.\nClicked submit button")

    //7. Handle Links:
    //• Click a link to return to the homepage.

  val homeLink = driver.findElement(By.xpath("//*[@id='back_to_form']"))
  homeLink.click()
  println("7.\nClicked 'Index' link to return to homepage")

  driver.quit()

}
