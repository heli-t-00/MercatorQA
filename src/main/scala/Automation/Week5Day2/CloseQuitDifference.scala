package Automation.Week5Day2

object CloseQuitDifference extends App{
  //What is the difference between .close() and .quit() in different scenarios?
  //Try closing one tab vs closing the entire session.
  //Research how they behave when multiple windows/tabs are open.

  // driver.quit() - closes all browser windows opened during the session and ends the WebDriver session completely. It kills the browser process and cleans up everything related to that webdriver. USE this at end of the script to ensure proper cleanup and avoid memory leaks.

  // driver.close() - closes the CURRENT browser window that the WebDriver is controlling. It does not end the entire WebDriver session if multiple browser windows or tabs are open. USEFUL when you want to close a specific tab or window BUT continue using the browser in your automation.


}
