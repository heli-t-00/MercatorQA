package Automation.Week4Day4

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

// This code launches Chrome, opens Google, prints the page title to the console, and then closes the browser. It’s a basic example of how Selenium WebDriver can automate browser tasks in Scala.

object ChromeBrowserInvoke extends App {

  val driver: WebDriver = new ChromeDriver() // create a new browser using google chrome, ChromeDriver is a class, that opens up Chrome browser window to allow for automation
  //Driver is declared as a WebDriver, this interfaces with Chrome Driver
  //NB: Allows you to write code that can work with OTHER drivers ie. SafariDriver, FirefoxDriver by changing this line.
  println("Invoking Chrome Browser") // tracks execution flow, prints message to console when browser is launched
  driver.get("https://www.google.com") // navigates to the URL, this is how to open a website in automation
  println("title of page: " +driver.getTitle) // fetches the title of the CURRENT webpg and prints
  // .getTitle is a method of WebDriver that returns the title of the pg currently loaded on the browser
  // USEFUL to validate on the correct page for automated test

  driver.quit() // Close entire browser session and stops the WebDriver process. This free up system resources and avoid memory leaks



}
