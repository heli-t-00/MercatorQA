package Automation.Week5Day3

import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver

import scala.Console.println

object HandlingAlerts extends App {
//INITIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
//ACCESSING THE WEB URL FOR TESTING
  driver.get("https://the-internet.herokuapp.com/javascript_alerts")
// Alerts are usually made using JavaScript and are not part of HTML DOM, therefore CANNOT use INSPECT on webpage

//  // Simple Alert - click OK
//  val alert = driver.switchTo().alert()
//  println(alert.getText) // Read msg

  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click()
    driver.switchTo().alert().getText()

  println("Test passed for simple alert" + driver.switchTo().alert().getText)

  val alert = driver.switchTo().alert()
  println("Alert Text = "+ alert.getText)
  alert.accept()
  // Confirmation Alert - OK and CANCEL button

  driver.findElement((By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"))).click()
  driver.switchTo().alert().dismiss()
  println("Confirmation Alert Passed")



  // Prompt Alert - NEED to make input / then OK or CANCEL


driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click()
  val alert1 = driver.switchTo().alert()
  println(alert.getText)
  alert1.sendKeys("Welcome")
  alert1.accept() // can use alert.dismiss()



  driver.quit()

}
