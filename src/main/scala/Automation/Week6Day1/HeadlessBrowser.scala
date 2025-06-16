package Automation.Week6Day1

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}

object HeadlessBrowser extends App {
//============HEADLESS MODE=============
  val options = new ChromeOptions() // SET THIS UP FOR HEADLESS MODE
  options.addArguments("--headless") // Pass the argument for Headless Mode

  //INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver(options) // need to pass options in the webdriver
//ACCESSING THE WEB URL FOR TESTING
  driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html")





  driver.quit()

}
