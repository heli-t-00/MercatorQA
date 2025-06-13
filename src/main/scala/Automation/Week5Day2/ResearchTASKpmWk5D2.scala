package Automation.Week5Day2

object ResearchTASKpmWk5D2 {

  // # Selenium Q&A Notes
  //
  //## 1. Difference between .close() and .quit()
  //
  //| Action                  | .close()                                  | .quit()                                      |
  //|-------------------------|--------------------------------------------|-----------------------------------------------|
  //| Closes...               | Only the current active tab/window         | All browser windows opened by WebDriver       |
  //| WebDriver session       | Stays active if other windows exist        | Ends the session completely                   |
  //| When multiple tabs?     | Closes one, focus shifts to another        | Closes all tabs and ends session              |
  //| Example                 | If you open 3 tabs and call .close() on one, the others stay. .quit() will close all 3. |
  //---
  //## 2. How Selenium handles multiple browser windows
  //
  //• getWindowHandle(): Returns the unique ID of the current window.
  //• getWindowHandles(): Returns a Set[String] of all open window handles.
  //• Switching between windows:
  //
  //```scala
  //val handles = driver.getWindowHandles
  //val it = handles.iterator()
  //val parent = it.next()
  //val child = it.next()
  //driver.switchTo().window(child)
  //```
  //---
  //## 3. Alternatives to .navigate().to()
  //
  //- `.navigate().to(url)` and `driver.get(url)` are functionally similar.
  //- Under the hood, `get()` is a wrapper around `.navigate().to()`.
  //- **Performance**: Nearly identical. However, `.navigate()` also supports `.back()`, `.forward()`, and `.refresh()`.
  //
  //**Use** `get()` for simple navigation; use `navigate()` for advanced navigation.
  //
  //---
  //
  //## 4. Difference between findElement() and findElements()
  //
  //| Method         | `findElement()`                    | `findElements()`                                |
  //|----------------|------------------------------------|--------------------------------------------------|
  //| Return type    | `WebElement`                       | `List[WebElement]` (empty list if none)          |
  //| If element missing | Throws `NoSuchElementException`   | Returns an empty list                            |
  //| Use case       | Single element expected            | Zero or many elements expected                   |
  //
  //**Good practice**: Use `findElements()` when you're not sure the element exists or expect multiple matches.
  //**Locator test**: One vs None vs Many
  //
  //**Example scenarios**:
  //
  //- **One match**:
  //  ```scala
  //  driver.findElement(By.id("submit"))
  //---
  //## 5. Selenium Manager (introduced in Selenium 4.6+)
  //
  //- **Purpose**: Automatically downloads and configures the correct browser driver
  //  (like `chromedriver`, `geckodriver`) based on your system and browser version.
  //
  //- **Before Selenium Manager**:
  //  You had to manually download drivers, match them with browser versions,
  //  and set system paths.
  //
  //- **Now with Selenium Manager**:
  //    - No more `System.setProperty("webdriver.chrome.driver", "...")`
  //    - Automatically handles the right driver behind the scenes.
  //
  //**Simplifies setup**, reduces errors, and makes onboarding much easier.
}
