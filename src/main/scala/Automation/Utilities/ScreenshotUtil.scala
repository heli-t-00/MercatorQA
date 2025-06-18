package Automation.Utilities
import org.openqa.selenium.{OutputType, TakesScreenshot, WebDriver}
import java.io.File
import java.nio.file.Files
object ScreenshotUtil extends App{

  def takeScreenshot(driver: WebDriver, filePath: String): Unit = {
    // Cast WebDriver to TakesScreenshot
    val screenshot = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)

    // Copy the screenshot to the target file path
    Files.copy(screenshot.toPath, new File(filePath).toPath)
  }
}
