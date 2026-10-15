package Automation.Week8Day1


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver}

import java.time.Duration

object FilterSort extends App {
  //INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
  //ACCESSING THE WEB URL FOR TESTING
  driver.get("https://www.saucedemo.com/inventory.html")

/// LOGIN
val username = driver.findElement(By.id("user-name"))
  val password = driver.findElement(By.id("password"))
  val login = driver.findElement(By.id("login-button"))

  username.sendKeys("standard_user")
  password.sendKeys("secret_sauce")
  login.click()

  // APPLY WAIT
  val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10))
  driver.manage().window().maximize()

  val filterSort = driver.findElement((By.className("product_sort_container")))
  val js = driver.asInstanceOf[JavascriptExecutor]
  js.executeScript("arguments[0].scrollIntoView(true);", filterSort)

  filterSort.click() //  CLICKED on field for the list to appear

  // Find value and click the state (ADD explicitWait.until to wait for the options to be appear)
  val filterOption = explicitWait.until(
    ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]")))

  filterOption.click()
println("clicked filter")


  //use assertion to check that this is selected

  val chosenAZ = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]")).getText
  assert(chosenAZ == "Name (A to Z)",  s"Option Value <$chosenAZ>")
  println("A-Z")
//
//
//  val chosenZA = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]")).getText
//assert(chosenZA == "Name (Z to A)", s"Option Value <$chosenZA")

//  val chosenLoHi = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).getText
//  assert(chosenLoHi == "Price (low to high)", s"Option Value <$chosenLoHi")
//  println(chosenLoHi)
//
//  val chosenHiLo = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]")).getText
//  assert(chosenHiLo == "Price (high to low)", s"Option Value <$chosenHiLo")
  //NB: USE xpath to find the exact locator for the element especially in dynamic dropdown



}
