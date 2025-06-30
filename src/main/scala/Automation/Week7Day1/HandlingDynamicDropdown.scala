package Automation.Week7Day1

import Automation.Week5Day3.HandlingDropdownList.select
import Automation.Week5Day4.JavaScriptExecutor.{driver, js, login}
import Automation.Week6Day1.HeadlessMode.element
import Automation.Week6Day1.ScreenCapture.element
import Automation.Week7Day1.HandlingDynamicDropdown.clickableElement
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.{ExpectedCondition, ExpectedConditions, WebDriverWait}
import org.scalactic.PrettyMethods.Prettyizer
import org.scalactic.TypeCheckedTripleEquals.convertToCheckingEqualizer

import java.time.Duration

object HandlingDynamicDropdown extends App {
  //INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
  //ACCESSING THE WEB URL FOR TESTING
  driver.get("https://demoqa.com/automation-practice-form")

  // ======= DYNAMIC DROPDOWN elements======
  /*this is a type of dropdown element where the options available to select ARE NOT fixed and can change based on user interactions or other factors.
  ====EXAMPLE==== dropdown for COUNTRY and CITY. When you select Country = USA, list of City for US appears, if Country = Canada, list of City for Canada appears.

  ADD EXPLICIT Waits - to allow the options to load dynamically use 'WebDriverWait'
  NB: When inspecting for Locators - this may not have STANDARD html structure there need to inspect carefully

  STEPS
  1. Identify dynamic dropdown
  2. Locate PARENT element
  3. Locate the target element
  4. Handle the dependency
  5. Use explicit waits (WebDriverWait) to wait for the option
  6. Select the desired option

  NB: FOR Dependent Dropdown aka Cascading dropdown, REPEAT the same pattern AFTER selecting the first dropdown value. NEED to wait until SECOND dropdown is loaded before trying to interact.

  JS Executor - does not need to be REDEFINED again if used once already.  REUSE:

// Scroll to an element
js.executeScript("arguments[0].scrollIntoView(true);", someElement)

// Click an element using JS
js.executeScript("arguments[0].click();", anotherElement)

   */

  driver.manage().window().maximize()

  // LOCATE THE DROPDOWN
  val element = driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]"))

  // SCROLL INTO VIEW - use JS Executor as there are Ads and popup on webpage

  val js = driver.asInstanceOf[JavascriptExecutor]
  js.executeScript("arguments[0].scrollIntoView(true);", element)

  //Try JS click first (in cae it's blocked)
  js.executeScript("arguments[0].click();", element)

  //Now wait until it is clickable

  val waitDriver = new WebDriverWait(driver, Duration.ofSeconds(20))

  val clickableElement = waitDriver.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]")))

  //Click it
  clickableElement.click()
  //  select.selectByVisibleText("Haryana")

  // Select 'Harayana' (custom dropdown)
  val option = waitDriver.until(
    ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Haryana')]"))
  )

  option.click()

  println("Option 'Haryana' clicked successfully.")

//=========== Select City===============
  val elementCity = driver.findElement(By.xpath("//*[@id=\"city\"]/div/div[1]/div[1]"))

  // SCROLL INTO VIEW - use JS Executor as there are Ads and popup on webpage

  js.executeScript("arguments[0].scrollIntoView(true);", elementCity)

  //Try JS click first (in cae it's blocked)
  js.executeScript("arguments[0].click();", elementCity)

  //Now wait until it is clickable

  val waitDriverCity = new WebDriverWait(driver, Duration.ofSeconds(20))

  val clickableElementCity = waitDriver.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"city\"]/div/div[1]/div[1]")))

  //Click it
  clickableElementCity.click()
  //  select.selectByVisibleText("Haryana")

  // Select 'Karnal' (custom dropdown)
  val optionCity = waitDriver.until(
    ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Karnal')]"))
  )

  optionCity.click()

  println("Option 'Karnal' clicked successfully.")

  driver.findElement(By.id("submit")).click()
  println("Submit clicked")

driver.quit()

}
