package Automation.Week5Day1

import Automation.Week5Day1.BycssSelector.driver
import Automation.Week5Day1.Week5day1_pmTask.submitBtn
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

import scala.reflect.internal.util.NoFile.input

object Week5day1_pmTask extends App{
  val driver: WebDriver = new ChromeDriver()
 //Navigates to TEST Web URL
  driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html")


//  Afternoon Task:
//    Form Interaction Using All Selenium Locator Strategies
//  Create a Selenium program in Scala that fills out a basic web form and performs clicks using
//  all the major locator types.
//    Ensure you:
//  Use simple println() to confirm each successful action.
//  One locator type per element — don’t repeat strategies.
//    Test Web URL: https://testpages.herokuapp.com/styled/basic-html-form-test.html
 // WRITE Selenuium Scala program:

  // Enter Text into:
  // Username Field
  val username = driver.findElement(By.name("username"))
  username.sendKeys("UserName")
  println("Enter text into Username field: PASSED")
//Password Field
  val password = driver.findElement(By.cssSelector("input[type=password]"))
  password.sendKeys("UserName")
  println("Enter text into Password field: PASSED")
// Comments/extra Field
val comments = driver.findElement(By.tagName(("textarea"))) // using tagName
  comments.clear()
  comments.sendKeys("write in this field")
  println("Enter text into Comments/extra field: PASSED")


  //CLICKS ON:
  // Checkbox using 'xpath':
val checkbox =driver.findElement(By.xpath("//input[@type='checkbox' and @value='cb1']"))
   checkbox.click()
  println("checkbox: CLICKED")

//Submit button using :
val submitBtn = driver.findElement(By.cssSelector("input[name=submitbutton]"))
submitBtn.click()
println("submit: CLICKED")

  //Link on the page use linkText:
val linkPage = driver.findElement(By.linkText("Index"))
linkPage.click()
  println("Click on link on page: CLICKED")

  //Use a different locator strategy for each action:
  // One action must use `id`
  // One must use `name`
  // One must use `className`
  //One must use `tagName`
  //One must use `cssSelector`
  //One must use `xpath`
  //One must use `linkText`
  //One must use `partialLinkText`


}
