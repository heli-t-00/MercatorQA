package Automation.Week5Day2

import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

object Task3 extends App {
  val driver: WebDriver = new ChromeDriver()
  //  Task 3:
  //    Use this link: https://demoqa.com/automation-practice-form
  //  Create a simple automation script that locates elements on a test page and uses Web
  //  Element conditional methods to verify their states before interacting.
  //  1. Launch the browser using WebDriver.
  //  2. Navigate to the test URL.
  //  3. Locate these elements:
  //    o First Name input field
  //  o Submit button
  //  o Hobbies checkbox
  //  4. Use conditional methods to:
  //    o Check if the First Name input is displayed and enabled before typing a name.
  //  o Check if the Hobbies checkbox is selected; if not, select it.
  //  o Check if the Submit button is displayed and enabled before clicking it.
  //  5. Print meaningful messages for each condition check and action taken.
  //  6. Close the browser at the end.

  //Launch browser using WebDriver
  //2. Navigate to test URL
  driver.get("https://demoqa.com/automation-practice-form")

  //3. Locate these elements: First Name Input Field, Submit Button and Hobbies Checkbox
  val firstname = driver.findElement(By.id("firstName"))
  val submit = driver.findElement(By.id("submit"))
  val checkedBox = driver.findElement(By.xpath("//*[@id='hobbies-checkbox-1']"))

  // Step 4a. Check FirstName field
  if (firstname.isDisplayed && firstname.isEnabled) {
    println("First Name input is displayed and enabled.")
    firstname.sendKeys("Alpha")
    println(" Enter First name")
  } else {
    println("Firstname is not displayed and enabled")
  }
  //4b. Check Hobbies Checkbox
  if (!checkedBox.isSelected) {
    println("Check box not selected - check this now")
  } else {
    println("Check box already selected")
  }

  //SECOND example - Check Hobbies Checkbox
  if (!checkedBox.isSelected) {
    println("Hobbies checkbox is not selected. Selecting it now.")

    // Scroll into view first ==== USE JavaScriptExecutor =======

    val js = driver.asInstanceOf[JavascriptExecutor]
    js.executeScript("arguments[0].scrollIntoView(true);", checkedBox)
    Thread.sleep(500)

    // Click using JS to avoid interception
    js.executeScript("arguments[0].click();", checkedBox)
  } else {
    println("Hobbies checkbox is already selected.")
  }

  // Step 4c: Check Submit button
  if (submit.isDisplayed && submit.isEnabled) {
    println("Submit button is displayed and enabled. Clicking it.")
    submit.click()
  } else {
    println("Submit button is not clickable.")
  }

  // Optional wait to observe the result before closing
    Thread.sleep(3000)


    //  6. Close the browser at the end.
    driver.close()







}