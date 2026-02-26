README – Regular Polygon Drawer (JavaFX)

OVERVIEW
--------
Regular Polygon Drawer is a JavaFX application that draws a regular
polygon based on user input for number of sides, radius, and color.
When the user presses Enter or clicks the Draw button, the program
computes the polygon’s vertices using trigonometry and displays it.

COMPILE & RUN INSTRUCTIONS
--------------------------
Since this program uses JavaFX, you must tell the compiler and JVM where
to find JavaFX modules in your system. For example, if your JavaFX SDK is
installed at:

  C:\Program Files\Java\javafx-sdk-25.0.2

Then compile with:

  javac --module-path "C:\Program Files\Java\javafx-sdk-25.0.2\lib" \
        --add-modules javafx.controls RegularPolygonDrawer.java

And run with:

  java --module-path "C:\Program Files\Java\javafx-sdk-25.0.2\lib" \
       --add-modules javafx.controls RegularPolygonDrawer

Replace this path with the actual path to your JavaFX installation folder.

USAGE
-----
1. Launch the program.
2. Enter the number of sides (at least 3).
3. Enter a positive radius.
4. Choose a fill color.
5. Press Enter in a text field or click Draw.

Errors will display for invalid values or if the polygon would not fit.


HOW IT WORKS
------------
Once two valid inputs are registered, number of sides and radius, the program
calculates the vertices using:

  θ = 2 × π / n
  x = centerX + r × cos(i × θ)
  y = centerY + r × sin(i × θ)

For i from 0 to n−1, where centerX and centerY define the drawing pane’s
center.


KEY CONCEPTS & CITATIONS
------------------------

1. JavaFX `Polygon` Shape
   The JavaFX Polygon class represents a shape determined by x/y
   coordinate pairs. Its `getPoints()` method returns a list of
   vertex coordinates that can be modified or expanded to define the
   polygon.  
   Source: “JavaFX | Polygon with examples,” GeeksforGeeks, https://www.geeksforgeeks.org/java/javafx-polygon-with-examples/

2. Drawing Polygons in JavaFX
   Tutorials for JavaFX show how to instantiate a Polygon, add points,
   and display it in a scene — examples include using `getPoints().addAll()`
   to supply vertex coordinates.  
   Source: “JavaFX 2D Shapes – Polygon,” Tutorialspoint, https://www.tutorialspoint.com/javafx/2dshapes_polygon.htm

3. ColorPicker Control Overview
   The `ColorPicker` control lets the user choose a color. A selected
   color can be retrieved from the control for use in styling shapes.  
   Source: “JavaFX | ColorPicker with examples,” GeeksforGeeks, https://www.geeksforgeeks.org/java/javafx-colorpicker-with-examples/ 

4. Using ColorPicker in Code
   Tutorials explain how to create a ColorPicker instance in JavaFX and
   read its value (the selected color) for use in application logic.  
   Source: “JavaFX ColorPicker,” Jenkov Tutorials, https://jenkov.com/tutorials/javafx/colorpicker.html 

5. JavaFX SDK Controls and Modules
   Many instructional guides show that JavaFX UI controls (like buttons,
   color pickers, and shapes) are part of the `javafx.controls` module,
   which must be specified with module‑path flags when compiling and running
   JavaFX applications.  
   Source: “JavaFX Drawing a Polygon,” Tutorialspoint, https://www.tutorialspoint.com/javafx/javafx_drawing_polygon.html

6. Geometry for Regular Polygons
   Basic trigonometry applies to computing regular polygon vertices by
   using angles around a circle (angle = 2π/n) and converting them into
   x/y coordinates. While not tied to JavaFX’s API itself, this geometric
   approach is standard in shape generation. A classic overview of the
   polygon shape concept and coordinate use is found in general tutorials
   and examples like those used for JavaFX polygon drawing.  
   Source: “JavaFX 2D Shapes – Polygon,” Tutorialspoint, https://www.tutorialspoint.com/javafx/2dshapes_polygon.htm 

7. Favimage Citation: https://www.flaticon.com/free-icon/polygon_7005622?related_id=7005633&origin=search

8. Favimage (Window Icon) in JavaFX
   JavaFX allows a custom window icon to be set for an application by
   loading an image (such as a .png) and adding it to the Stage’s icon
   list via `stage.getIcons().add(...)`. This icon appears in the
   title bar and (depending on platform) the taskbar. Simple examples
   show that loading an image and adding it via `getIcons()` is the
   standard way to give your JavaFX window a custom icon.  
   Source: “JavaFX 101: How to Add Icons to Stages,” Coderscratchpad, https://coderscratchpad.com/adding-an-icon-to-your-javafx-stage/

END OF README