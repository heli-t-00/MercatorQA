package Automation.Week5Day3

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.{By, WebDriver}

import scala.Console.println

object HandlingAlertsEXTRA extends App {
  //INSTANTIATING THE CHROMEDRIVER FOR INTERACTING WITH THE CHROME BROWSER
  val driver: WebDriver = new ChromeDriver()
  //ACCESSING THE WEB URL FOR TESTING
  driver.get("https://the-internet.herokuapp.com/javascript_alerts")


  // ============= JS Alerts `EXTRA`============
  // 3 types of ALERTS
// JS Alert

  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click() // PERFORM ACTION .click()

  val alert = driver.switchTo().alert() // reuse this variable alert

  alert.accept() // '.accpet()' will click the 'OK' in the alert

  // JS Confirm

  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click()
  println( alert.getText)
    alert.dismiss() // '.dismiss()' will click 'CANCEL' in the alert





  // JS Prompt

  driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click()

  alert.sendKeys("HELLO HELLO") // this will write something to the alert BEFORE you accept/ dismiss

  alert.accept()


  driver.quit()

}
