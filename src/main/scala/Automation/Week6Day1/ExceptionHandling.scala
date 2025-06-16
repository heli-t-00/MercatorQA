package Automation.Week6Day1

import Automation.Week4Day4.ByID.driver
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{NoSuchElementException}



object ExceptionHandling extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
  try{
    //ACCESSING THE WEB URL FOR TESTING
    driver.get("https://www.selenium.dev/selenium/web/web-form.html")

    //------NO SUCH ELEMENT EXCEPTION--------

    val emailAddress: WebElement = driver.findElement(By.id ("email"))
    emailAddress.sendKeys("test@gmail.com")
    println("email address entered: Passed")
  }
  catch {
    case e: NoSuchElementException =>
       println("element not found" +e.getMessage)
//    e.printStackTrace()

//
    case e: Exception => // USE THIS WHEN YOU DON"T KNOW WHAT TYPE OF EXCEPTION IS EXPECTED
      println("Print any exception: " +e.getMessage )
    e.printStackTrace() // get log for debugging

  } finally {
    if(driver !=null) {
      driver.quit()
    }

    // add multiple cases for debugging
  }





}
