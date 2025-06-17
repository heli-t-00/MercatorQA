package Automation.Week6Day1

import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.{By, WebDriver}

object HeadlessMode extends App {

  // Set up ChromeOptions for headless mode
  val options = new ChromeOptions()
  options.addArguments("--headless=new")
  //  options.addArguments("--headless")             // Headless mode

  //      options.addArguments("--window-size=1920,1080")// Optional: ensures layout behaves properly

  // Launch headless browser
  val driver: WebDriver = new ChromeDriver(options)

  driver.get("https://www.selenium.dev/selenium/web/web-form.html")

  // Example: print title
  println("Page title is: " + driver.getTitle)

  // Example: find an element
  val element = driver.findElement(By.tagName("h1"))
  println("Heading text: " + element.getText)

  driver.quit()
}