package Automation.Week5Day1

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver, WebElement}

object BycssSelector extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
//ACCESSING THE WEB URL FOR TESTING
  driver.get("https://proleed.academy/exercises/selenium/selenium-element-id-locators-practice-form.php")

//  val emailAddress: WebElement = driver.findElement(By.id("email")) // Find by ID

  val emailAddress: WebElement = driver.findElement(By.cssSelector("#email")) // Find by cssSelector

  emailAddress.sendKeys("test@gmail.com")
  println("Email address entered - passed")

//val password: WebElement = driver.findElement(By.id("password")) // Find using ID
  val password: WebElement = driver.findElement(By.cssSelector("input[type='password']")) //shorter cssSelector used: it TARGETS all <input> fields that have an attribute type="password", it doesn't need to follow the HTML hierarchy (like body > main > div......
  // ("input[type='password']") says Find an <input> element where type attribute is 'password'

  password.sendKeys("TestPassword")
  println("Password entered - passed")


  //DIFFERENT WEBPAGE
  driver.get("https://www.selenium.dev/selenium/web/web-form.html")



  // val login: WebElement =driver.findElement(By.id("login"))
  val login: WebElement = driver.findElement(By.cssSelector("[value='Submit']"))
  login.click()
  println("Logged in successfully - Passed")

//===============Step by Step Explanation=================
  /* Inspecting HTML, to find the exact loaction of the input field in HTML, the browser's inspect tool is used. */
  //Using nested elements (parents and children -- follow the path in inspect tool)
  val passwordTwo: WebElement = driver.findElement(By.cssSelector("body > main > div > form > div > div:nth-child(1) > label:nth-child(2) > input"))
  //  div:nth-child(1) - (1) because this is the first div tag in the nest
  //  label:nth-child(2) - (2) because this is the 2nd label tag in the nest
  /*CSS selector:

body > main > div > form > div > div:nth-child(1) > label:nth-child(2) > input
This selector goes deeply into the page structure:

Element	Meaning
body	Start at the <body> tag.
> main	Go to the direct child <main> of <body>.
> div	Go to the direct <div> under <main>.
> form	Go to the <form> inside the <div>.
> div	Go to the <div> inside the <form>.
> div:nth-child(1)	Go to the first child <div> inside the previous <div>.
> label:nth-child(2)	Inside that div, go to the second <label> element.
> input	Finally, select the <input> inside that label (your password field).

🧠 This is a very specific and strict path — it will break if the structure changes.*/

  passwordTwo.sendKeys("TestPasswordTwo")
  println("PasswordTwo entered - passed")

  driver.quit()

// LONG Selector (body>........>input) - very precise, long and hard to maintain, can break easily, when structure changes, ONLY USE when there is SIMILAR elements and you must target specific ones.
  // SHORT Selector (input[type='password']) - less precise, matches all password inputs, short readable and more flexible, will continue to work even with layout changes, BEST used, where there is only ONE or the FIRST match is fine.



}
