📱 JavaFX Simple Calculator
This is a basic calculator application built using JavaFX.
It features a clean user interface and supports fundamental arithmetic operations like addition, subtraction, multiplication, division, clear, and equals.

🛠️ About the Project
The calculator includes:

A display area (non-editable TextField)
Number buttons from 0 to 9
Operation buttons: +, -, *, /, C, and =
Responsive UI with hover and press effects on buttons
Layout organized using VBox and HBox
It's a beginner-friendly project showcasing JavaFX UI and event handling.

💡 What I Learned
While building this project, I learned:

Button arrays for cleaner loops:

Button[] numberButtons = {button1, button2, ..., button0};
Button[] operation = {buttonPlus, buttonMinus, buttonMultiply, buttonDivide};
Grouping buttons in arrays made it easier to use loops and avoid repeated code.

Using enhanced for-loops to apply actions and styles to multiple buttons:

for (Button button : numberButtons) {
    // Set size, styles, and action handlers
}
Implementing core functions like:

+ Addition
- Subtraction
* Multiplication
/ Division
= Equals (to calculate the result)
C Clear (to reset everything)
Styling JavaFX UI with inline CSS and adding interactive effects like hover and pressed states.

🚀 Future Improvements
Add support for decimal numbers
Add keyboard input support
Improve error handling (e.g., division by zero)
