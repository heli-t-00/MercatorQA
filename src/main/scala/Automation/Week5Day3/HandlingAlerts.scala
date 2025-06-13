package Automation.Week5Day3

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

import scala.Console.println

object HandlingAlerts extends App {
  //INSTANTIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
  //ACCESSING THE WEB URL FOR TESTING
  driver.get("https://the-internet.herokuapp.com/javascript_alerts")
  // Alerts are usually made using JavaScript and are not part of HTML DOM, therefore CANNOT use INSPECT on webpage

  // ============= JS Alerts TYPES and How to Handle them ============
  //  SIMPLE ALERT - click OK ie. click first button (Just Click OK)
  //  val alert = driver.switchTo().alert()
  //  println(alert.getText) // Read msg

  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click() // finds and clicks the first alert btn
  driver.switchTo().alert().getText() // switch focus to the alert and reads the message

  println("Test passed for simple alert" + driver.switchTo().alert().getText)

  // Saves the alert to a variable, prints it and clicks 'ok' on the alert
  val alert = driver.switchTo().alert()
  println("Alert Text = " + alert)
  alert.accept()
  println("Simple Alert PASSED")


  // CONFIRMATION Alert - OK and CANCEL button - (Choose between OK or CANCEL)

  driver.findElement((By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"))).click()
  driver.switchTo().alert().dismiss() // clicks 'cancel' on the confirmation alert
  println("Confirmation Alert Passed")



  // PROMPT Alert - NEED to make input / then OK or CANCEL (Enter text + OK or CANCEL)


  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click()
  val alert1 = driver.switchTo().alert() // switches focus to alert
  println(alert1.getText) // reads the message
  alert1.sendKeys("Welcome") // type 'welcome' into the prompt input
  alert1.accept() // Clicks 'ok' NB: can use alert.dismiss()


  driver.quit()

}
