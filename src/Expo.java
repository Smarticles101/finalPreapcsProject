// THE EXPO CLASS FOR COMPUTER SCIENCE CLASSES

// NOTE: HTML <br> (breaks) are used in the documentation so it will look better in Javadoc.


import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.applet.Applet;

/**
 *
 * DELUXE EXPO CLASS UPDATE: 5/21/2013 <BR><BR>
 *
 * The concept and implementation of the original set of Expo class methods was created by John L. M. Schram
 * (the Son), who is called John Schram.  The Expo class was created to teach programming skills to students
 * in introductory computer science courses. Use of the Expo class eliminates many program steps that are
 * tedious and frustrating for beginning students. Program input is simplified and graphics commands are
 * more intuitive. Many additional graphics commands are added to allow for interesting displays with minimal effort. <BR><BR>
 *
 * The Expo class is a work in progress and you can expect the Schrams to add additional methods in time to come.
 * The version date will indicate if you have the latest update. <BR><BR>
 *
 * This version of the EXPO class is the "DELUXE" version of the original class.
 * In addition to the "fundamental methods" from the "slimmed down" Expo class, it contains several additional
 * methods.  Some of these are for GUI keyboard input; some are Math functions; but most of the new methods are
 * "graphics" methods intended to help enhance graphics projects done near the end of the school year.
 * Examples of these would be drawBurst, drawSpiral, drawRoundedRectangle, and a whole slew of "drawThick" methods.
 * Also, there are about 50 new colors available. <BR><BR>
 *
 * Since the creation of the initial bulk of the Expo class, John L. A. Schram (the father),
 * who is called Leon Schram, has added some additional methods.
 * Both John Schram and Leon Schram are computer science teachers at John Paul II High School in Plano, Texas. <BR><BR>
 *
 * This code is free software; you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation.  This code is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.<br><br>
 *
 * 85 color constants are built into the DELUXE Expo class<br>
 * The 10 main colors are red, green, blue, orange, cyan, magenta, yellow, gray, pink and tan.<BR>
 * Each of these colors has 4 other shades which simply require the prefix "light", "dark", "lighter" or "darker". <br>
 * For example, the 5 shades of red are: red, lightRed, darkRed, lighterRed and darkerRed. <br><br>
 * The following colors are also included without multiple shades: <BR>
 * black, white, brown, violet, purple, turquoise, plum, indigo, aqua, aquaMarine, goldenRod, gold, silver, bronze, <br>
 * teal, maroon, fuschia, lavender, lime, navy, chartreuse, fireBrick, moccasin, olive, salmon, khaki, crimson, <br>
 * orchid, sienna, melon, tangerine, terraCotta, pumpkin, mahogany, and amber <BR><BR>
 *
 * NOTE:  Some colors are duplicates.  "navy" is the same as "darkBlue"; <BR>
 *        "silver" is the same as "lightGray"; and "aqua" is the same as "cyan". <BR><BR>
 *
 * The following real numbers constants are also built in: <BR>
 * twoPI, which equals 2 * Math.PI <BR>
 * halfPI, which equals Math.PI / 2; <BR>
 * quarterPI, which equals Math.PI / 4; <BR>
 *
 **/

public class Expo
{
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Color constants
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// built in colors copied to the Expo class
	static final Color red            = Color.red;
	static final Color green          = Color.green;
	static final Color blue           = Color.blue;
	static final Color orange         = Color.orange;
	static final Color cyan           = Color.cyan;
	static final Color magenta        = Color.magenta;
	static final Color yellow         = Color.yellow;
	static final Color gray           = Color.gray;
	static final Color lightGray      =	Color.lightGray;
	static final Color darkGray       = Color.darkGray;
	static final Color pink           = Color.pink;
	static final Color black          = Color.black;
	static final Color white          = Color.white;

	// 4 darker/lighter shades of all the above colors (except for black and white)
	static final Color lightRed       = new Color(255,128,128);
	static final Color lighterRed     = new Color(255,192,192);
	static final Color darkRed        = new Color(192,0,0);
	static final Color darkerRed      = new Color(128,0,0);

	static final Color lightOrange    = new Color(255,224,0);
	static final Color lighterOrange  = new Color(255,224,64);
	static final Color darkOrange     = new Color(255,128,0);
	static final Color darkerOrange   = new Color(255,64,0);

	static final Color lightYellow    = new Color(255,255,128);
	static final Color lighterYellow  = new Color(255,255,192);
	static final Color darkYellow     = new Color(192,192,0);
	static final Color darkerYellow   = new Color(128,128,0);

	static final Color lightGreen     = new Color(128,255,128);
	static final Color lighterGreen   = new Color(192,255,192);
	static final Color darkGreen      = new Color(0,128,0);
	static final Color darkerGreen    = new Color(0,64,0);

	static final Color lightBlue      = new Color(128,128,255);
	static final Color lighterBlue    = new Color(192,192,255);
	static final Color darkBlue       = new Color(0,0,128);
	static final Color darkerBlue     = new Color(0,0,64);

	static final Color lightMagenta   = new Color(255,64,255);
	static final Color lighterMagenta = new Color(255,128,255);
	static final Color darkMagenta    = new Color(192,0,192);
	static final Color darkerMagenta  = new Color(128,0,128);

	static final Color lightCyan      = new Color(128,255,255);
	static final Color lighterCyan    = new Color(192,255,255);
	static final Color darkCyan       = new Color(0,192,192);
	static final Color darkerCyan     = new Color(0,128,128);

	static final Color lightPink      = new Color(255,194,194);
	static final Color lighterPink    = new Color(255,216,216);
	static final Color darkPink       = new Color(240,150,150);
	static final Color darkerPink     = new Color(224,128,128);

	static final Color tan            = new Color(210,180,140);
	static final Color lightTan       = new Color(231,198,154);
	static final Color lighterTan     = new Color(252,216,168);
	static final Color darkTan        = new Color(189,145,87);
	static final Color darkerTan      = new Color(168,124,66);

	static final Color lighterGray    = new Color(224,224,224);
	static final Color darkerGray     = new Color(32,32,32);

	// special colors (which do not have multiple shades provided)
	static final Color brown          = new Color(150,100,15);
	static final Color violet         = new Color(240,128,240);
	static final Color purple         = new Color(128,0,128);
	static final Color turquoise      = new Color(64,224,208);
	static final Color plum           = new Color(221,160,221);
	static final Color indigo         = new Color(75,0,130);
	static final Color aqua           = new Color(0,255,255);
	static final Color aquaMarine     = new Color(127,255,112);
	static final Color goldenRod      = new Color(218,168,32);
	static final Color gold           = new Color(255,215,0);
	static final Color silver         = new Color(192,192,192);
	static final Color bronze         = new Color(164,102,40);
	static final Color teal           = new Color(0,128,128);
	static final Color maroon         = new Color(128,0,0);
	static final Color fuschia        = new Color(255,0,255);
	static final Color lavender       = new Color(230,230,250);
	static final Color lime           = new Color(50,205,50);
	static final Color navy           = new Color(0,0,128);
	static final Color chartreuse     = new Color(127,255,0);
	static final Color fireBrick      = new Color(178,34,34);
	static final Color moccasin       = new Color(255,228,181);
	static final Color olive          = new Color(128,128,0);
	static final Color salmon         = new Color(250,128,114);
	static final Color khaki          = new Color(240,230,140);
	static final Color crimson        = new Color(220,20,60);
	static final Color orchid         = new Color(218,112,214);
	static final Color sienna         = new Color(160,82,45);
	static final Color melon          = new Color(254,186,73);
	static final Color tangerine      = new Color(243,132,0);
	static final Color terraCotta     = new Color(226,114,91);
	static final Color pumpkin        = new Color(152,118,54);
	static final Color mahogany       = new Color(192,64,0);
	static final Color amber          = new Color(255,191,0);


	// allows for alternative spelling of "grey"
	static final Color grey           = gray;
	static final Color lightGrey      =	lightGray;
	static final Color lighterGrey    = lighterGray;
	static final Color darkGrey       = darkGray;
	static final Color darkerGrey     = darkerGray;

	static Color currentColor 		  = black;   // The current drawing color being used at any particular time.


	//////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Math Constants, Math Functions and Random Number Generating Methods
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	static final double twoPI  = 2 * Math.PI;
	static final double halfPI = Math.PI / 2;
	static final double quarterPI = Math.PI / 4;


	/**
     * Returns the "square" number, which is the number multiplied times itself. <br>
     * Example:<br>
     * System.out.println(Expo.square(5)); <br>
     * This will display 25.0
     **/
	public static double square(double number)
	{
		return number * number;
	}


	/**
     * Returns the "cube" of number, which is number raised to the 3rd power. <br>
     * Example:<br>
     * System.out.println(Expo.cube(2)); <br>
     * This will display 8.0
     **/
	public static double cube(double number)
	{
		return number * number * number;
	}


	/**
     * Returns the cubeRoot (3rd root) of number. <br>
     * Example:<br>
     * System.out.println(Expo.cubeRoot(8)); <br>
     * This will display 2.0
     **/
	public static double cubeRoot(double number)
	{
		return Math.exp(Math.log(number) / 3);
	}


	/**
     * Returns the xth root of number. <br>
     * Example:<br>
     * System.out.println(Expo.root(1000000,6)); <br>
     * This will display the 6th root of 1000000, which is 10.0 <br><br>
     * Preconditions: number > 0, root != 0
     **/
	public static double root(double number, double x)
	{
		return Math.exp(Math.log(number) / x);
	}


	/**
     * Returns the log of a number with a base specified by the user. <br>
     * This solves the equation: base^? = number <br>
     * Example:<br>
     * System.out.println(Expo.logBaseX(81,3)); <br>
     * This will display 4.0 because 3^4 = 81. <br><br>
     * Preconditions: number > 0, base > 0
     **/
	public static double logBaseX(double number, double base)
	{
		return Math.log(number) / Math.log(base);
	}


	/**
     * Returns the log base 10 of number. <br>
     * This solves the equation: 10^? = number <br>
     * Example:<br>
     * System.out.println(Expo.logBase10(1000)); <br>
     * This will display 3.0 because 10^3 = 1000. <br><br>
     * Precondition: number > 0
     **/
	public static double logBase10(double number)
	{
		return logBaseX(number,10);
	}


	/**
     * Returns the log base 2 of number. <br>
     * This solves the equation: 2^? = number <br>
     * Example:<br>
     * System.out.println(Expo.logBase2(128)); <br>
     * This will display 7.0 because 2^7 = 128. <br><br>
     * Precondition: number > 0
     **/
	public static double logBase2(double number)
	{
		return logBaseX(number,2);
	}


	/**
     * Returns a "true" random integer in the [min..max] range, inclusive. <BR>
     * Precondition: max > min <br>
     * Example:<br>
     * System.out.println(Expo.random(100,200)); <br>
     * This will display a random integer between 100 and 200.
     **/
	public static int random(int min, int max)
	{
		int range = max - min + 1;
		int number = (int) (range * Math.random() + min);
		return number;
	}



	//////////////////////////////////////////////////////////////////////////////////////////////////////////////



	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// String Utility Methods
	// These next few methods manages the positioning and display of output text.
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Utility method that will skip a certain number of blank lines on a text output screen.<br>
	 * This is used to space out text output. <br>
     * Example: <br>
     * Expo.skip(4); <br>
     * This will display 4 blank lines.
	 **/
	public static void skip(int n)
	{
		for (int k = 1; k <= n; k++)
			System.out.println();
	}


	/**
	 * Displays centered text on an 80 column text screen. <br>
     * Example: <br>
     * Expo.center("Hello World"); <br>
     * This will display "Hello World" centered horizontally on the text screen.
	 **/
	public static void center(String str)
	{
		int len = str.length();
		int tab = (80 - len) / 2;
		for (int k = 1; k <= tab; k++)
		   System.out.print(" ");
		System.out.println(str);
	}


	/**
	 * Displays right-justified text on an 80 column text screen. <br>
     * Example: <br>
     * Expo.rightJustify("Hello World"); <br>
     * This will display "Hello World" on the far right side of the text screen.
	 **/
	public static void rightJustify(String str)
	{
		int len = str.length();
		int tab = 80 - len;
		for (int k = 1; k <= tab; k++)
		   System.out.print(" ");
		System.out.println(str);
	}


	//////////////////////////////////////////////////////////////////////////////////////////////////////////////



	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Waiting Utility Methods
	// These next couple methods will stop the output temporarily.
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////


	/**
	 * Pauses the output and waits for the user to press the [enter] key. <br>
     * Example: <br>
     * Expo.pause();
	 **/
	public static void pause()
	{
		skip(2);
		System.out.print("Press the <enter> key to continue...");
		String dummy = enterString();
		skip(3);
	}


	/**
	 * Delays the output for a specified number of milliseconds (1/1000ths of a second). <br>
	 * Examples:<br>
	 * Expo.delay(1000); // pause for 1 second <br>
	 * Expo.delay(2000); // pause for 2 seconds <br>
	 * Expo.delay(500);  // pause for 1/2 of a second <br>
	 * Expo.delay(100);  // pause for 1/10 of a second <br>
	 * Expo.delay(10);   // pause for 1/100 of a second <br>
	 * Expo.delay(1);    // pause for 1/1000 of a second <br>
	 **/
	public static void delay(int n)
	{
		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < n)
			endDelay = System.currentTimeMillis();
	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Methods for keyboard text input during program execution.
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
     * Allows input of an int (integer) from the keyboard in a text window. <br>
     * Example: <br>
     * System.out.print("How old are you?  -->  "); <br>
     * int age = Expo.enterInt();
     **/
	public static int enterInt()
	{
		Scanner input = new Scanner(System.in);
		int temp = input.nextInt();
		return temp;
	}


	/**
     * Allows input of a double (real number) from the keyboard in a text window. <br>
     * Example: <br>
     * System.out.print("What is your current GPA?  {0.00 - 4.00}  -->  "); <br>
     * double gpa = Expo.enterDouble();
     **/
	public static double enterDouble()
	{
		Scanner input = new Scanner(System.in);
		double temp = input.nextDouble();
		return temp;
	}


	/**
     * Allows input of a String from the keyboard in a text window. <br>
     * Example: <br>
     * System.out.print("What is your name?  --->  "); <br>
     * String name = Expo.enterString();
     **/
	public static String enterString()
	{
		Scanner input = new Scanner(System.in);
		String temp = input.nextLine();
		return temp;
	}


	/**
     * Allows input of a char from the keyboard in a text window. <br>
     * Example: <br>
     * System.out.print("What is your middle initial?  -->  "); <br>
     * char middleInitial = Expo.enterChar();
     **/
	public static char enterChar()
	{
		Scanner input = new Scanner(System.in);
		String temp = input.nextLine();
		return temp.charAt(0);
	}


    /**
     * Allows input of a boolean (true or false) from the keyboard in a text window. <br>
     * The user can enter the word "true" or "false". <br>
     * The method is not case sensitive.  (True, trUE, TruE will all work) <br>
     * The user can also enter T or F. <br>
     * The user can also enter 1 for true and 0 for false. <br>
     * The user can also enter A for true and B for false. <br>
     * The user can also enter Y for true/yes and N for false/no. <br>
     * Essentially, anything that does not begin with a 'T', '1', 'A' or 'Y' will be interpreted as "false".
     **/
	public static boolean enterBoolean()
	{
		Scanner input = new Scanner(System.in);
		String temp = input.nextLine();
		temp = temp.toUpperCase();
		char firstChar = temp.charAt(0);
		String temp2 = String.valueOf(firstChar);
		return( temp2.equals("T") || temp2.equals("1") || temp2.equals("A") || temp2.equals("Y") );
	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//  Methods for keyboard graphics input during program execution using small graphics windows.
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
     * Allows GUI input of an int (integer) from the keyboard. <br>
     * Example: <br>
     * int age = Expo.enterIntGUI("How old are you?");
     **/
    public static int enterIntGUI(String prompt)
	{
		String tempString = JOptionPane.showInputDialog(prompt);
		int temp = Integer.parseInt(tempString);
		return temp;
	}


	/**
     * Allows input of a double (real number) from the keyboard using a GUI window. <br>
     * The String parameter "prompt" is a message that tells the user what he/she is suppose to enter. <br>
     * Example: <br>
     * double gpa = Expo.enterDoubleGUI("What is your GPA?  {0.00 - 4.00}");
     **/
    public static double enterDoubleGUI(String prompt)
	{
		String tempString = JOptionPane.showInputDialog(prompt);
		double temp = Double.parseDouble(tempString);
		return temp;
	}


	/**
     * Allows input of a String from the keyboard using a GUI window. <br>
     * The String parameter "prompt" is a message that tells the user what he/she is suppose to enter. <br>
     * Example: <br>
     * String name = Expo.enterStringGUI("What is your name?");
     **/
    public static String enterStringGUI(String prompt)
	{
		String temp = JOptionPane.showInputDialog(prompt);
		return temp;
	}


	/**
     * Allows input of a char from the keyboard using a GUI window. <br>
     * The String parameter "prompt" is a message that tells the user what he/she is suppose to enter. <br>
     * Example: <br>
     * char middleInitial = Expo.enterCharGUI("What is your middle initial?");
     **/
    public static char enterCharGUI(String prompt)
	{
		String temp = JOptionPane.showInputDialog(prompt);
		return temp.charAt(0);
	}


	/**
     * Allows input of a boolean (true or false) from the keyboard using a GUI window. <br>
     * The user can enter the word "true" or "false". <br>
     * The method is not case sensitive.  (True, trUE, TruE will all work) <br>
     * The user can also enter T or F. <br>
     * The user can also enter 1 for true and 0 for false. <br>
     * The user can also enter A for true and B for false. <br>
     * The user can also enter Y for true/yes and N for false/no. <br>
     * Essentially, anything that does not begin with a 'T', '1', 'A' or 'Y' will be interpreted as "false". <br>
     * The String parameter "prompt" is a message that tells the user what he/she is suppose to enter. <br>
     * Example: <br>
     * boolean voter = Expo.enterBooleanGUI("You are registered to vote.  (Enter True or False)");
     **/
    public static boolean enterBooleanGUI(String prompt)
	{
		String temp = JOptionPane.showInputDialog(prompt);
		temp = temp.toUpperCase();
		char firstChar = temp.charAt(0);
		String temp2 = String.valueOf(firstChar);
		return( temp2.equals("T") || temp2.equals("1") || temp2.equals("A") || temp2.equals("Y") );
	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// displayGUI methods
	// The first displayGUI method will display a String in a GUI window.
	// The other 4 overloaded methods will first convert a specific simple/primative data type to a String,
	// and then display the String in the GUI window.
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
     * Displays a String in a GUI window.<br>
     * The window will stay on the screen until the user clicks "OK". <br>
     * Example: <br>
     * Expo.displayGUI("Hello World"); <br>
     * Displays "Hello World" in a GUI window
     **/
	public static void displayGUI(String text)
	{
		JOptionPane.showMessageDialog(null,text);
	}


	/**
     * Displays an int (integer) in a GUI window.<br>
     * The window will stay on the screen until the user clicks "OK". <br>
     * Example: <br>
     * Expo.displayGUI(25); <br>
     * Displays the integer "25" in a GUI window
     **/
	public static void displayGUI(int temp)
	{
		String text = String.valueOf(temp);
		JOptionPane.showMessageDialog(null,text);
	}


	/**
     * Displays a double (real number) in a GUI window.<br>
     * The window will stay on the screen until the user clicks "OK". <br>
     * Example: <br>
     * Expo.displayGUI(3.14159); <br>
     * Displays the real number "3.14159" in a GUI window
     **/
	public static void displayGUI(double temp)
	{
		String text = String.valueOf(temp);
		JOptionPane.showMessageDialog(null,text);
	}


	/**
     * Displays a char in a GUI window.<br>
     * The window will stay on the screen until the user clicks "OK". <br>
     * Example: <br>
     * Expo.displayGUI('Q'); <br>
     * Displays the character "Q" in a GUI window
     **/
	public static void displayGUI(char temp)
	{
		String text = String.valueOf(temp);
		JOptionPane.showMessageDialog(null,text);
	}


	/**
     * Displays a boolean (true or false) value in a GUI window.<br>
     * The window will stay on the screen until the user clicks "OK". <br>
     * Example: <br>
     * Expo.displayGUI(2 + 2 == 5); <br>
     * Displays the boolean value "false" in a GUI window
     **/
	public static void displayGUI(boolean temp)
	{
		String text = String.valueOf(temp);
		JOptionPane.showMessageDialog(null,text);
	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Graphics methods to manipulate color.
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Allows the user to change the color, using a Color object parameter. <BR>
     * Example: <br>
     * Expo.setColor(g,Expo.red); <br>
     * Changes the graphics color to red.  <BR><br>
     * There are 85 colors avaibale are listed below:<BR>
     * The 10 main colors are red, green, blue, orange, cyan, magenta, yellow, gray, pink and tan.<BR>
     * Each of these colors has 4 other shades which simply require the prefix "light", "dark", "lighter" or "darker". <br>
     * For example, the 5 shades of red are: red, lightRed, darkRed, lighterRed and darkerRed. <br><br>
     * The following colors are also included without multiple shades:
     * black, white, brown, violet, purple, turquoise, plum, indigo, aqua, aquaMarine, goldenRod, gold, silver, bronze, <br>
     * teal, maroon, fuschia, lavender, lime, navy, chartreuse, fireBrick, moccasin, olive, salmon, khaki, crimson, <br>
     * orchid, sienna, melon, tangerine, terraCotta, pumpkin, mahogany, and amber
     **/
	public static void setColor(Graphics g, Color newColor)
	{
		g.setColor(newColor);
		currentColor = newColor;
	}


	/**
	 * Allows the user to change to one of 10 predefined primary colors using a single int parameter.<br>
	 * This is especially useful in programs where you want to change from one color to a contrasting color quickly. <br>
	 * 0 = black <br>
	 * 1 = red <br>
	 * 2 = green <br>
	 * 3 = blue <br>
	 * 4 = orange <br>
	 * 5 = cyan <br>
	 * 6 = magenta <br>
	 * 7 = yellow <br>
	 * 8 = gray <br>
	 * 9 = pink <br>
	 * Any negative number will give you white. <br><br>
	 * Example: <br>
	 * Expo.setColor(g,1); <br>
     * Changes the current drawing color to red.
	 **/
	public static void setColor(Graphics g, int colorNum)
	{
		colorNum %= 10;
		switch(colorNum)
		{
			case  0 : g.setColor(black); 	currentColor = black; 	 break;
			case  1 : g.setColor(red); 		currentColor = red;		 break;
			case  2 : g.setColor(green); 	currentColor = green;	 break;
			case  3 : g.setColor(blue); 	currentColor = blue;	 break;
			case  4 : g.setColor(orange); 	currentColor = orange;	 break;
			case  5 : g.setColor(cyan); 	currentColor = cyan;	 break;
			case  6 : g.setColor(magenta); 	currentColor = magenta;	 break;
			case  7 : g.setColor(yellow); 	currentColor = yellow;	 break;
			case  8 : g.setColor(gray); 	currentColor = gray;	 break;
			case  9 : g.setColor(pink); 	currentColor = pink;	 break;
			default : g.setColor(white);
		};
	}


	/**
	 * Allows the user to change the color using 3 int parameters representing the amount of red, green and blue.<br>
	 * This allows for more than 16 million different color combinations. <br>
	 * Precondition: All 3 color values need to be between 0 and 255 inclusive. <br>
	 * Example: <br>
	 * Expo.setColor(g,190,10,47); <br>
     * Changes the current drawing color to the shade of red used in the official Texas Flag
	 **/
	public static void setColor(Graphics g, int red, int green, int blue)
	{
		Color newColor = new Color(red, green, blue);
		g.setColor(newColor);
		currentColor = newColor;
	}


	/**
	 * Allows the user to change the color and transparency using 4 int parameters. <BR>
	 * The first 3 represent the amount of red, green and blue.<br>
	 * This allows for more than 16 million different color combinations. <br>
	 * The fourth int value is the "alpha" value which determines transparency.
	 * Small alpha values are more transparent.  Large alpha values are more opaque. <BR>
	 * Precondition: All 4 int values need to be between 0 and 255 inclusive. <br>
	 * Example: <br>
	 * Expo.setColor(g,190,10,47,128); <br>
     * Changes the current drawing color to the shade of red used in the official Texas Flag
     * and makes it semi-transparent
	 **/
	public static void setColor(Graphics g, int red, int green, int blue, int alpha)
	{
		Color newColor = new Color(red, green, blue, alpha);
		g.setColor(newColor);
		currentColor = newColor;
	}


	/**
	 * Returns a random Color object which can be any of the 16,000,000+ possible colors.
	 **/
	public static Color getRandomColor()
	{
		int red   = random(0,255);
		int green = random(0,255);
		int blue  = random(0,255);
		Color randomColor = new Color(red, green, blue);
		return randomColor;
	}


	/**
	 * Sets the current color to a random color value which can be any of the 16,000,000+ possible colors. <br>
	 * Example: <br>
	 * Expo.setRandomColor(g);
	 **/
	public static void setRandomColor(Graphics g)
	{
	    int red   = random(0,255);
	    int green = random(0,255);
	    int blue  = random(0,255);
	    Color newColor = new Color(red, green, blue);
		g.setColor(newColor);
		currentColor = newColor;
	}


	/**
	 * Sets the entire background to a single color using a Color object parameter. <br>
	 * Precondition: The applet window cannot be greater than 4800 X 3600 in size. <br>
	 * Postcondition: The current drawing color will not be affected by the background color. <br>
	 * Example: <br>
	 * Expo.setBackground(g,Expo.red); <br>
	 * This will make the entire background red.
	 **/
	public static void setBackground(Graphics g, Color bgColor)
	{
	    g.setColor(bgColor);
	    fillRectangle(g,0,0,4800,3600);
	    setColor(g,currentColor);
	}


	/**
	 * Sets the entire background to one of 10 predefined primary colors using a single int parameter. <br>
	 * 0 = black <br>
	 * 1 = red <br>
	 * 2 = green <br>
	 * 3 = blue <br>
	 * 4 = orange <br>
	 * 5 = cyan <br>
	 * 6 = magenta <br>
	 * 7 = yellow <br>
	 * 8 = gray <br>
	 * 9 = pink <br>
	 * Any negative number will give you white. <br><br>
	 * Example: <br>
	 * Expo.setBackground(g,1); <br>
     * Changes the background color to red.
	 **/
	public static void setBackground(Graphics g, int colorNum)
	{
		colorNum %= 10;
		switch(colorNum)
		{
			case  0 : setBackground(g,black);    break;
			case  1 : setBackground(g,red);      break;
			case  2 : setBackground(g,green);    break;
			case  3 : setBackground(g,blue);     break;
			case  4 : setBackground(g,orange);   break;
			case  5 : setBackground(g,cyan);     break;
			case  6 : setBackground(g,magenta);  break;
			case  7 : setBackground(g,yellow);   break;
			case  8 : setBackground(g,gray);     break;
			case  9 : setBackground(g,pink);     break;
			default : setBackground(g,white);
		};
	}

	/**
	 * Sets the entire background to a single color using 3 int parameters representing the amount of red, green and blue.<br>
	 * This allows for more than 16 million different color combinations. <br>
	 * Preconditions: All 3 color values need to be between 0 and 255 inclusive. <br>
	 *                The applet window cannot be greater than 4800 X 3600 in size. <br>
	 * Postcondition: The current drawing color will not be affected by the background color. <br>
	 * Example: <br>
	 * Expo.setBackground(g,190,10,47); <br>
     * Changes the background color to the shade of red used in the official Texas Flag
	 **/

	public static void setBackground(Graphics g, int red, int green, int blue)
	{
		Color newColor = new Color(red, green, blue);
		setBackground(g,newColor);
	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////




	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Graphics methods which draw a large variety of "open" figures.
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Draws a single pixel at the specified x,y location. <BR>
	 * Example: <BR>
	 * Expo.drawPixel(g,100,200); <BR>
	 * Draws a very small single dot (pixel) on the computer screen 100 pixels over and 200 pixels down
	 **/
	public static void drawPixel(Graphics g, int x, int y)
	{
		g.drawLine(x,y,x,y);
	}


	/**
	 * Draws a 3 pixel X 3 pixel "point" whose center is at the specified x,y location. <BR>
	 * Example: <BR>
	 * Expo.drawPoint(g,100,200);
	 * Draws a larger, more visible (than drawPixel) dot on the computer screen 100 pixels over and 200 pixels down.
	 **/
	public static void drawPoint(Graphics g, int x, int y)
	{
		g.fillRect(x-1,y-1,3,3);
	}


	/**
	 * Draws the line segment connecting coordinates x1,y1 and x2,y2. <BR>
	 * Example: <BR>
	 * Expo.drawLine(g,100,200,300,400); <BR>
	 * Draws a line segment connecting the starting coordinate point (100,200) with the ending point (300,400).
	 **/
	public static void drawLine(Graphics g, int x1, int y1, int x2, int y2)
	{
		g.drawLine(x1,y1,x2,y2);
	}


	/**
	 * Draws an open circle.<br>
	 * The user specifies the x,y coordinate of the center of the circle as well as the radius value. <br>
	 * Example: <br>
	 * Expo.drawCircle(g,300,200,100); <br>
	 * Draws an open circle with a radius of 100 pixels whose center is located at the coordinate (300,200).
	 **/
	public static void drawCircle(Graphics g, int centerX, int centerY, int radius)
	{
		int diameter = 2 * radius;
		g.drawOval(centerX-radius, centerY-radius, diameter, diameter);
	}


	/**
	 * Draws an open oval.<br>
	 * The user specifies the x,y coordinate of the center of the oval as well as the horizontal and vertical radii values. <br>
	 * Example: <br>
	 * Expo.drawOval(g,300,200,100,50); <br>
	 * Draws an open oval with a horizontal radius of 100 pixels and a vertical radius of 50 pixels. <br>
	 * The center of this oval is located at the coordinate (300,200).
	 **/
	public static void drawOval(Graphics g, int centerX, int centerY, int hRadius, int vRadius)
	{
		int hDiameter = 2 * hRadius;
		int vDiameter = 2 * vRadius;
		g.drawOval(centerX-hRadius, centerY-vRadius, hDiameter, vDiameter);
	}


	/**
	 * Draws and arc which looks like a curve.<br>
	 * An ARC is a "piece" of an OVAL.<br>
	 * The first 5 parameters (g and 4 ints) are the same as drawOval.<br>
	 * There are 2 additional parameters for the starting degree value and finishing degree of the arc. <br>
	 * 0 degrees is at the 12:00 position and the degrees progress in a CLOCKWISE fashion. <br>
	 * (90 degrees is at 3:00, 180 degrees is at 6:00, 270 degrees is at 9:00, 360 degrees is back at 12:00).
	 **/
	public static void drawArc(Graphics g, int centerX, int centerY, int hRadius, int vRadius, int start, int finish)
	{
		int hDiameter = 2 * hRadius;
		int vDiameter = 2 * vRadius;

		if (finish < start)
			finish += 360;
		int newStart  = 90 - start;   // shifts starting position from 3:00 to 12:00
		int newFinish = start-finish; // as opposed to finish-start.  Subtracting backwards changes from counter-clockwise to clockwise.

		g.drawArc(centerX-hRadius, centerY-vRadius, hDiameter, vDiameter, newStart, newFinish);
	}


	/**
	 * Draws an open irregular triangle using the three sets of provided coordinates. <br>
	 * Example: <br>
	 * Expo.drawTriangle(g,100,300,200,100,300,300);
	 **/
	 public static void drawTriangle(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3) ////// Added 06-25-08
	 {
	 	drawPolygon(g,x1,y1,x2,y2,x3,y3);
	 }


	 /**
	  *	Draws an open irregular quadrilateral using the four sets of provided coordinates. <br>
	  * Example: <br>
	  * Expo.drawQuad(g,100,100,200,300,400,400,300,200);
	  **/
	 public static void drawQuad(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4) ////// Added 06-25-08
	 {
	 	drawPolygon(g,x1,y1,x2,y2,x3,y3,x4,y4);
	 }


	/**
	 * Draws an open irregular polygon using 3 or more sets of provided coordinates. <br>
	 * Examples: <br>
	 * Expo.drawPolygon(g,100,300,200,100,300,300);                         // for a triangle
	 * Expo.drawPolygon(g,525,300,600,250,650,250,725,300,725,350,650,400); // for a hexagon
	 **/
	public static void drawPolygon(Graphics g, int... coordinate)
	{
		if (coordinate.length < 6 || coordinate.length % 2 == 1)
		{
			throw new ArrayIndexOutOfBoundsException(
				"When using <drawPolygon>, the number of int parameters ("
				+ coordinate.length + ") must be even and no less than 6.");
		}
		else
		{
		 	Polygon myPoly = new Polygon();
		 	for (int j = 0; j < coordinate.length-1; j+=2)
		 		myPoly.addPoint(coordinate[j],coordinate[j+1]);
		 	g.drawPolygon(myPoly);
		}
	}


	/**
	 * Draws an open rectangle.<br>
	 * The upper-left-hand corner is specified by x1,y1 and the lower-right-hand corner is specified by x2, y2. <br>
	 * Example: <br>
	 * Expo.drawRectangle(g,100,200,300,400); <br>
	 * Draws an open rectangle whose upper-left-hand coordinate is (100,200) and whose lower-right-hand coordinate is (300,400).
	 **/
	public static void drawRectangle(Graphics g, int x1, int y1, int x2, int y2)
	{
		int temp;
		if (x1 > x2)
			{ temp = x1; x1 = x2; x2 = temp; }
		if (y1 > y2)
			{ temp = y1; y1 = y2; y2 = temp; }
		int width  = x2 - x1;
		int height = y2 - y1;
		g.drawRect(x1,y1,width,height);
	}


	/**
	 * Draws an open rectangle with rounded corners.<br>
	 * The first 5 parameters (g and 4 ints) are the same as drawRect.<br>
	 * The final parameter "pixels" specifies the number of pixels used in the rounded corner. <br>
	 * Example: <br>
	 * Expo.drawRoundedRectangle(g,100,200,300,400,25);
	 **/
	public static void drawRoundedRectangle(Graphics g, int x1, int y1, int x2, int y2, int pixels)
	{
		int temp;
		if (x1 > x2) { temp = x1; x1 = x2; x2 = temp; }
		if (y1 > y2) { temp = y1; y1 = y2; y2 = temp; }
		int width  = x2 - x1;
		int height = y2 - y1;
		int diameter = pixels * 2;
		g.drawRoundRect(x1,y1,width,height,diameter,diameter);
	}


	/**
	 * Draws a spiral.<br>
	 * The center of the spiral is specified with the centerX,centerY parameters.<br>
	 * The maxRadius parameter determines the size of the spiral <br>
	 * (It is actually the radius of the circle that the spiral would fit inside). <br>
	 * Example: <br>
	 * Expo.drawSpiral(g,300,200,100); <br>
	 * Draws a spiral with a maxRadius of 100 pixels whose center is located at the coordinate (300,200).
	 **/
	public static void drawSpiral(Graphics g, int centerX, int centerY, int maxRadius)
	{
		double spiralRadius = 0;
		double radian = 0;
		while (spiralRadius <= maxRadius)
		{
			int x = (int) Math.round(Math.cos(radian - halfPI) * spiralRadius) + centerX;
			int y = (int) Math.round(Math.sin(radian - halfPI) * spiralRadius) + centerY;
			drawPixel(g,x,y);
			radian += 0.001;
			spiralRadius += 0.002;
		}
	}


	/**
	 * Draws a spiral whose spacing is precisely controlled by the "spacing" parameter. <br>
	 * The center of the spiral is specified with the centerX,centerY parameters.<br>
	 * The maxRadius parameter determines the size of the spiral <br>
	 * (It is actually the radius of the circle that the spiral would fit inside.) <br>
	 * Example: <br>
	 * Expo.drawPreciseSpiral(g,300,200,100,25); <br>
	 * Draws a spiral with a maxRadius of 100 pixels whose center is located at the coordinate (300,200). <br>
	 * There are precisely 25 pixels separating each "loop" of the spiral.
	 **/
	public static void drawPreciseSpiral(Graphics g, int centerX, int centerY, int maxRadius, double spacing)
	{
		double spiralInc = spacing / (twoPI * 1000);

		double spiralRadius = 0;
		double radian = 0;
		while (spiralRadius <= maxRadius)
		{
			int x = (int) Math.round(Math.cos(radian - halfPI) * spiralRadius) + centerX;
			int y = (int) Math.round(Math.sin(radian - halfPI) * spiralRadius) + centerY;
			drawPixel(g,x,y);
			radian += 0.001;
			spiralRadius += spiralInc;
		}
	}


	/**
	 * Draws a certain number of lines (numLines) in a burst like pattern.<br>
	 * The lines are evenly spaced and drawn from the center of a circle to its edge.<br>
	 * The size of the circle is specified by the radius parameter. <br>
	 * Example: <br>
	 * Expo.drawBurst(g,300,200,100,50); <br>
	 * Draws a "burst" with a radius of 100 pixels whose center is located at the coordinate (300,200). <br>
	 * The "burst" will be comprised of 50 evenly spaced lines.
	 **/
	public static void drawBurst(Graphics g, int centerX, int centerY, int radius, int numLines)
	{
		double offSet;
		if (numLines % 2 == 1)
			offSet = halfPI;
		else
			offSet = halfPI + Math.PI/numLines;

		for (double radian = 0; radian < twoPI; radian += twoPI/numLines)
		{
			int x = (int) Math.round(Math.cos(radian - offSet) * radius) + centerX;
			int y = (int) Math.round(Math.sin(radian - offSet) * radius) + centerY;
			g.drawLine(centerX, centerY, x, y);
		}
	}


	/**
	 * Draws a certain number of random lines in a burst like pattern.<br>
	 * The lines have random colors, random lengths and are drawn in random directions.<br>
	 * The parameters are the same as drawBurst. <br>
	 * Postcondition: The current drawing color will not be affected by the randomly colored lines. <br>
	 * Example: <br>
	 * Expo.drawRandomBurst(g,300,200,100,50); <br>
	 * Draws a "random burst" with a max radius of 100 pixels whose center is located at the coordinate (300,200). <br>
	 * The "burst" will be comprised of 50 lines with random spacing, random length and random color.
	 **/
	public static void drawRandomBurst(Graphics g, int centerX, int centerY, int radius, int numLines)
	{
		for (int j = 1; j <= numLines; j++)
		{
			double radian = twoPI * Math.random();
			double randomRadius = radius * Math.random();
			int x = (int) Math.round(Math.cos(radian) * randomRadius) + centerX;
			int y = (int) Math.round(Math.sin(radian) * randomRadius) + centerY;
			g.setColor(getRandomColor());
			g.drawLine(centerX, centerY, x, y);
		}
		setColor(g,currentColor);
	}


	/**
	 * Draws an open regular polygon with a specified number of sides.<br>
	 * The center of this polygon is specified by centerX,centerY and its size is specified by radius <br>
	 * (As in the radius of the circle the regular polygon would fit inside). <br>
	 * Precondition: sides >= 3 <br>
	 * Example: <br>
	 * Expo.drawRegularPolygon(g,300,200,100,8); <br>
	 * Draws an open regular polygon with 8 sides and a radius of 100 pixels whose center is located at the coordinate (300,200).
	 **/
	public static void drawRegularPolygon(Graphics g, int centerX, int centerY, int radius, int sides)
	{
		int xCoord[] = new int[sides];
		int yCoord[] = new int[sides];

	 	double rotate;
	    if (sides % 2 == 1)
	    	rotate = halfPI;
	    else
	    	rotate = halfPI + Math.PI/sides;

		for (int k = 0; k < sides; k++)
		{
			xCoord[k] = (int) Math.round(Math.cos(twoPI * k/sides - rotate) * radius) + centerX;
			yCoord[k] = (int) Math.round(Math.sin(twoPI * k/sides - rotate) * radius) + centerY;
		}
		if (sides == 3)
			yCoord[1] = yCoord[2];
		g.drawPolygon(xCoord,yCoord,sides);
	}


	/**
	 * Draws an open star with a specified number of points.<br>
	 * The center of this star is specified by centerX,centerY and its size is specified by radius <br>
	 * (As in the radius of the circle the star would fit inside). <br>
	 * Precondition: points >= 2 <br>
	 * Example: <br>
	 * Expo.drawStar(g,300,200,100,8); <br>
	 * Draws an open star with 8 points and a radius of 100 pixels whose center is located at the coordinate (300,200).
	 **/
	public static void drawStar(Graphics g, int centerX, int centerY, int radius, int points)
	{
		int halfRadius = getHalfRadius(radius, points);
		int p = points;
		points *= 2;

		int xCoord[] = new int[points];
		int yCoord[] = new int[points];

		int currentRadius;

		for (int k = 0; k < points; k++)
		{
			if (k % 2 == 0)
				currentRadius = radius;
			else
				currentRadius = halfRadius;

			xCoord[k] = (int) Math.round(Math.cos(twoPI * k/points - halfPI) * currentRadius) + centerX;
			yCoord[k] = (int) Math.round(Math.sin(twoPI * k/points - halfPI) * currentRadius) + centerY;
		}

		int x = (p-5)/2+1;
		if (p >= 5 && p <= 51)
			switch(p % 4)
			{
				case  1 : yCoord[x] = yCoord[x+1] = yCoord[points-x-1] = yCoord[points-x]; break;
				case  2 : yCoord[x] = yCoord[x+1] = yCoord[points-x-1] = yCoord[points-x];
					      yCoord[x+3] = yCoord[x+4] = yCoord[points-x-4] = yCoord[points-x-3]; break;
				case  3 : yCoord[x+2] = yCoord[x+3] = yCoord[points-x-3] = yCoord[points-x-2];
			}
		g.drawPolygon(xCoord,yCoord,points);
	}


	/**
	 * Draws a String s on the graphics screen at a certain x,y coordinate. <br>
	 * The coordinate x,y is the location of the bottom-left corner of the first character in the String s. <br>
	 * Example: <br>
	 * Expo.drawString(g,"Hello There!",100,200);
	 **/
	public static void drawString(Graphics g, String s, int x, int y)
	{
		g.drawString(s,x,y);
	}


	/**
	 * Allows you to change the current "font" used by the drawString method.
	 * Example:
	 * Expo.setFont(g,"Arial",Font.BOLD,36);
	 * Changes the font to Arial Bold with a Point Size of 36
	 * NOTE: If drawString is used without this command, you will get the default font of Arial Plain with a Point Size of 12
	 * Using a Font name that is misspelled or does not exist will result in getting the default Font of Arial.
	 * There are 4 Font styles available: Font.PLAIN, Font.BOLD, Font.ITALIC and Font.BOLD+Font.ITALIC
	 **/
	public static void setFont(Graphics g, String name, int style, int size)
	{
		Font myFont = new Font(name,style,size);
		g.setFont(myFont);
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Graphics methods which draw a large variety of "open" figures with "thick" borders.
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////


	/**
	 * Draws a "thick" line segment connecting coordinates x1,y2 and x2,y2.<br>
	 * The thickness is specified in the last parameter. <br>
	 * Example: <br>
	 * Expo.drawThickLine(g,100,200,300,400,5); <br>
	 * Draws a "thick" line segment connecting the starting coordinate point (100,200) with the ending point (300,400). <br>
	 * The line will be 5 pixels thick.
	 **/
	public static void drawThickLine(Graphics g, int x1, int y1, int x2, int y2, int thickness)
	{
		if (thickness < 2)
			thickness = 2;

		int start = -thickness / 2;
		int finish;
		if (thickness % 2 == 0)
			finish = thickness / 2;
		else
			finish = thickness / 2 - 1;

		for (int x = start; x <= finish; x++)
		   for (int y = start; y <= finish; y++)
			  g.drawLine(x1+x,y1+y,x2+x,y2+y);
	}


	/**
	 * Draws a "thick" circle.<br>
	 * The user specifies the x,y coordinate of the center of the circle as well as the radius value.<br>
	 * The thickness is specified in the last parameter. <br>
	 * Example: <br>
	 * Expo.drawThickCircle(g,300,200,100,5); <br>
	 * Draws a "thick" open circle with a radius of 100 pixels whose center is located at the coordinate (300,200). <br>
	 * The edge of this circle will be 5 pixels thick.
	 **/
	public static void drawThickCircle(Graphics g, int centerX, int centerY, int radius, int thickness)
	{
		int diameter = 2 * radius - 1;

		if (thickness < 2)
			thickness = 2;
		thickness--;

		for (int j = 0; j < thickness; j++)
		   g.drawOval(centerX-radius+j, centerY-radius+j, diameter-2*j, diameter-2*j);

		centerX++;

		for (int j = 0; j < thickness; j++)
		   g.drawOval(centerX-radius+j, centerY-radius+j, diameter-2*j, diameter-2*j);

		centerY++;

		for (int j = 0; j < thickness; j++)
		   g.drawOval(centerX-radius+j, centerY-radius+j, diameter-2*j, diameter-2*j);

		centerX--;

		for (int j = 0; j < thickness; j++)
		   g.drawOval(centerX-radius+j, centerY-radius+j, diameter-2*j, diameter-2*j);
	}


	/**
	 * Draws a "thick" oval.<br>
	 * The user specifies the x,y coordinate of the center of the oval as well as the horizontal and vertical radii values.<br>
	 * The thickness is specified in the last parameter. <br>
	 * Example: <br>
	 * Expo.drawThickOval(g,300,200,100,50,5); <br>
	 * Draws a "thick" open oval with a horizontal radius of 100 pixels and a vertical radius of 50 pixels. <br>
	 * The center of this oval is located at the coordinate (300,200). <br>
	 * The edge of this oval will be 5 pixels thick.
	 **/
	public static void drawThickOval(Graphics g, int centerX, int centerY, int hRadius, int vRadius, int thickness)
	{
		int hDiameter = 2 * hRadius - 1;
		int vDiameter = 2 * vRadius - 1;

		if (thickness < 2)
			thickness = 2;
		thickness--;

		for (int j = 0; j < thickness; j++)
		   g.drawOval(centerX-hRadius+j, centerY-vRadius+j, hDiameter-2*j, vDiameter-2*j);

		centerX++;

		for (int j = 0; j < thickness; j++)
		   g.drawOval(centerX-hRadius+j, centerY-vRadius+j, hDiameter-2*j, vDiameter-2*j);

		centerY++;

		for (int j = 0; j < thickness; j++)
		   g.drawOval(centerX-hRadius+j, centerY-vRadius+j, hDiameter-2*j, vDiameter-2*j);

		centerX--;

		for (int j = 0; j < thickness; j++)
		   g.drawOval(centerX-hRadius+j, centerY-vRadius+j, hDiameter-2*j, vDiameter-2*j);
	}


	/**
	 * Draws a "thick" arc which will look like a thick curved line.<br>
	 * The parameters are the same as drawArc, except there is an extra parameter at the end for the thickness.
	 **/
	public static void drawThickArc(Graphics g, int centerX, int centerY, int hRadius, int vRadius, int start, int finish, int thickness)
	{
		int hDiameter = 2 * hRadius - 1;
		int vDiameter = 2 * vRadius - 1;

		if (thickness < 2)
			thickness = 2;
		thickness--;

		for (int j = 0; j < thickness; j++)
		   drawArc(g,centerX, centerY, hRadius-j, vRadius-j, start, finish);

		centerX++;

		for (int j = 0; j < thickness; j++)
		   drawArc(g,centerX, centerY, hRadius-j, vRadius-j, start, finish);

		centerY++;

		for (int j = 0; j < thickness; j++)
		   drawArc(g,centerX, centerY, hRadius-j, vRadius-j, start, finish);

		centerX--;

		for (int j = 0; j < thickness; j++)
		   drawArc(g,centerX, centerY, hRadius-j, vRadius-j, start, finish);
	}


	/**
	 * Draws a "thick" open irregular triangle using the three sets of provided coordinates.<br>
	 * The parameters are the same as drawTriangle, except there is an extra parameter at the end for the thickness.
	 **/
	public static void drawThickTriangle(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int thickness) ////// Added 10/21/2008
	{
	 	for (int x = 0; x < thickness; x++)
	 		for (int y = 0; y < thickness; y++)
	 			drawTriangle(g,x1+x,y1+y,x2+x,y2+y,x3+x,y3+y);
	}


	/**
	 * Draws a "thick" open irregular quadrilateral using the four sets of provided coordinates.<br>
	 * The parameters are the same as drawQuad, except there is an extra parameter at the end for the thickness.
	 **/
	public static void drawThickQuad(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,int thickness) ////// Added 10/21/2008
	{
	 	for (int x = 0; x < thickness; x++)
	 		for (int y = 0; y < thickness; y++)
	 			drawQuad(g,x1+x,y1+y,x2+x,y2+y,x3+x,y3+y,x4+x,y4+y);
	}

	/**
	 * Draws a "thick" open irregular polygon using 3 or more sets of provided coordinates. <br>
	 * The parameters are the same as drawQuad, except there is an extra parameter at the end for the thickness. <br>
	 *
	 * Examples: <br>
	 * Expo.drawPolygon(g,100,300,200,100,300,300,10);                         // for a triangle
	 * Expo.drawPolygon(g,525,300,600,250,650,250,725,300,725,350,650,400,25); // for a hexagon
	 **/
	public static void drawThickPolygon(Graphics g, int... coordinate)  ////// Added 5/21/2013
	{
		if (coordinate.length < 7 || coordinate.length % 2 == 7)
		{
			throw new ArrayIndexOutOfBoundsException(
				"When using <drawThickPolygon>, the number of int parameters ("
				+ coordinate.length + ") must be odd and no less than 7.");
		}
		else
		{
			int thickness = coordinate[coordinate.length-1];
			for (int x = 0; x < thickness; x++)
	 			for (int y = 0; y < thickness; y++)
	 			{
	 				Polygon myPoly = new Polygon();
		 			for (int j = 0; j < coordinate.length-1; j+=2)
		 				myPoly.addPoint(coordinate[j]+x,coordinate[j+1]+y);
		 			g.drawPolygon(myPoly);
	 			}
		}
	}


	/**
	 * Draws a "thick" open rectangle.<br>
	 * The parameters are the same as drawRectangle, except there is an extra parameter at the end for the thickness.
	 **/
	public static void drawThickRectangle(Graphics g, int x1, int y1, int x2, int y2, int thickness)
	{
		if (thickness < 2)
			thickness = 2;
		int temp;
		if (x1 > x2)
			{ temp = x1; x1 = x2; x2 = temp; }
		if (y1 > y2)
			{ temp = y1; y1 = y2; y2 = temp; }
		int width  = x2 - x1;
		int height = y2 - y1;
		for (int j = 0; j < thickness; j++)
		   g.drawRect(x1+j, y1+j, width-2*j, height-2*j);

	}


	/**
	 * Draws a "thick" open rectangle with rounded corners.<br>
	 * The parameters are the same as drawRoundedRectangle, except there is an extra parameter at the end for the thickness.
	 **/
	public static void drawThickRoundedRectangle(Graphics g, int x1, int y1, int x2, int y2, int pixels, int thickness)
	{
		int temp;
		if (x1 > x2) { temp = x1; x1 = x2; x2 = temp; }
		if (y1 > y2) { temp = y1; y1 = y2; y2 = temp; }
		int width  = x2 - x1 - 1;
		int height = y2 - y1 - 1;
		int diameter = pixels * 2;

		if (thickness < 2)
			thickness = 2;
		thickness--;

		for (int j = 0; j < thickness; j++)
		   g.drawRoundRect(x1+j, y1+j, width-2*j, height-2*j,diameter,diameter);

		x1++;

		for (int j = 0; j < thickness; j++)
		   g.drawRoundRect(x1+j, y1+j, width-2*j, height-2*j,diameter,diameter);

		y1++;

		for (int j = 0; j < thickness; j++)
		   g.drawRoundRect(x1+j, y1+j, width-2*j, height-2*j,diameter,diameter);

		x1--;

		for (int j = 0; j < thickness; j++)
		   g.drawRoundRect(x1+j, y1+j, width-2*j, height-2*j,diameter,diameter);
	}


	/**
	 * Draws a "thick" spiral.<br>
	 * The parameters are the same as drawSpiral, except there is an extra parameter at the end for the thickness.
	 **/
	public static void drawThickSpiral(Graphics g, int centerX, int centerY, int maxRadius, int thickness)
	{
		if (thickness < 2)
			thickness = 2;
		double spiralRadius = 0;
		double radian = 0;
		int dotRadius = thickness / 2;
		while (spiralRadius <= maxRadius)
		{
			int x = (int) Math.round(Math.cos(radian - halfPI) * spiralRadius) + centerX;
			int y = (int) Math.round(Math.sin(radian - halfPI) * spiralRadius) + centerY;
			fillCircle(g,x,y,dotRadius);
			radian += 0.01;
			if (thickness > 25)
				spiralRadius += 0.02 * Math.sqrt(thickness);
			else
				spiralRadius += 0.02 * cubeRoot(thickness);
		}
	}


	/**
	 * Draws a "thick" and "precise" spiral. <br>
	 * The parameters are the same as drawPreciseSpiral, except there is an extra parameter at the end for the thickness.
	 **/
	public static void drawThickPreciseSpiral(Graphics g, int centerX, int centerY, int maxRadius, double spacing, int thickness)
	{
		double spiralInc = spacing / (twoPI * 100);

		if (thickness < 2)
			thickness = 2;
		double spiralRadius = 0;
		double radian = 0;
		int dotRadius = thickness / 2;
		while (spiralRadius <= maxRadius)
		{
			int x = (int) Math.round(Math.cos(radian - halfPI) * spiralRadius) + centerX;
			int y = (int) Math.round(Math.sin(radian - halfPI) * spiralRadius) + centerY;
			fillCircle(g,x,y,dotRadius);
			radian += 0.01;
			spiralRadius += spiralInc;
		}
	}


	/**
	 * Draws a certain number of "thick" lines in a burst like pattern.<br>
	 * The parameters are the same as drawBurst, except there is an extra parameter at the end for the thickness.
	 **/
	public static void drawThickBurst(Graphics g, int centerX, int centerY, int radius, int numLines, int thickness)
	{
		if (thickness < 2)
			thickness = 2;

		double offSet;
		if (numLines % 2 == 1)
			offSet = halfPI;
		else
			offSet = halfPI + Math.PI/numLines;

		for (double radian = 0; radian < twoPI; radian += twoPI/numLines)
		{
			int x = (int) Math.round(Math.cos(radian - offSet) * radius) + centerX;
			int y = (int) Math.round(Math.sin(radian - offSet) * radius) + centerY;
			drawThickLine(g, centerX, centerY, x, y, thickness);
		}
	}


	/**
	 * Draws a certain number of random "thick" lines in a burst like pattern.<br>
	 * The "thick" lines have random colors, random lengths and are drawn in random directions.<br>
	 * The parameters are the same as drawRandomBurst, except there is an extra parameter at the end for the thickness. <br>
	 * Postcondition: The current drawing color will not be affected by the randomly colored thick lines. <br>
	 **/
	public static void drawThickRandomBurst(Graphics g, int centerX, int centerY, int radius, int numLines, int thickness)
	{
		if (thickness < 2)
			thickness = 2;

		for (int j = 1; j <= numLines; j++)
		{
			double radian = twoPI * Math.random();
			double randomRadius = radius * Math.random();
			int x = (int) Math.round(Math.cos(radian) * randomRadius) + centerX;
			int y = (int) Math.round(Math.sin(radian) * randomRadius) + centerY;
			g.setColor(getRandomColor());
			drawThickLine(g, centerX, centerY, x, y, thickness);
		}
		setColor(g,currentColor);
	}


	/**
	 * Draws a "thick" regular polygon with a specified number of sides.<br>
	 * The parameters are the same as drawRegularPolygon, except there is an extra parameter at the end for the thickness. <br>
	 * Precondition: sides >= 3
	 **/
	public static void drawThickRegularPolygon(Graphics g, int centerX, int centerY, int radius, int sides, int thickness)
	{
		int xCoord[] = new int[sides];
		int yCoord[] = new int[sides];

	 	double rotate;
	    if (sides % 2 == 1)
	    	rotate = halfPI;
	    else
	    	rotate = halfPI + Math.PI/sides;

	 	if (thickness > radius)
			thickness = radius;
		if (thickness < 2)
			thickness = 2;
		thickness--;

	    for (int currentRadius = radius; currentRadius > radius-thickness; currentRadius -= 0.1)
			drawRegularPolygon(g, centerX, centerY, currentRadius, sides);

	    centerX++;

	    for (int currentRadius = radius; currentRadius > radius-thickness; currentRadius -= 0.1)
			drawRegularPolygon(g, centerX, centerY, currentRadius, sides);

	    centerY++;

	    for (int currentRadius = radius; currentRadius > radius-thickness; currentRadius -= 0.1)
			drawRegularPolygon(g, centerX, centerY, currentRadius, sides);

	    centerX--;

	    for (int currentRadius = radius; currentRadius > radius-thickness; currentRadius -= 0.1)
			drawRegularPolygon(g, centerX, centerY, currentRadius, sides);
	}


	/**
	 * Draws a "thick" star with a specified number of points.<br>
	 * The parameters are the same as drawBurst, except there is an extra parameter at the end for the thickness. <br>
	 * Precondition: points >= 2
	 **/
	public static void drawThickStar(Graphics g, int centerX, int centerY, int radius, int points, int thickness)
	{
		if (thickness < 2)
			thickness = 2;
		thickness--;
		int originalRadius = radius;

	    for (int j = 1; j <= thickness; j++)
	    {
			drawStar(g,centerX,centerY,radius,points);
			radius--;
	    }

	    centerX++;
	    radius = originalRadius;

	    for (int j = 1; j <= thickness; j++)
	    {
			drawStar(g,centerX,centerY,radius,points);
			radius--;
	    }

	    centerY++;
	    radius = originalRadius;

	    for (int j = 1; j <= thickness; j++)
	    {
			drawStar(g,centerX,centerY,radius,points);
			radius--;
	    }

	    centerX--;
	    radius = originalRadius;

	    for (int j = 1; j <= thickness; j++)
	    {
			drawStar(g,centerX,centerY,radius,points);
			radius--;
	    }
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////



	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Graphics methods which draws a large variety of "filled-in" figures.
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////


	/**
	 * Draws a solid "filled in" circle.<br>
	 * The user specifies the x,y coordinate of the center of the circle as well as the radius value. <br>
	 * Example: <br>
	 * Expo.fillCircle(g,300,200,100); <br>
	 * Draws a solid circle with a radius of 100 pixels whose center is located at the coordinate (300,200).
	 **/
	public static void fillCircle(Graphics g, int centerX, int centerY, int radius)
	{
		int diameter = 2 * radius;
		g.fillOval(centerX-radius, centerY-radius, diameter, diameter);
	}


	/**
	 * Draws a solid "filled in" oval.<br>
	 * The user specifies the x,y coordinate of the center of the oval as well as the horizontal and vertical radii values.  <br>
	 * Example: <br>
	 * Expo.fillOval(g,300,200,100,50); <br>
	 * Draws a solid oval with a horizontal radius of 100 pixels and a vertical radius of 50 pixels. <br>
	 * The center of this oval is located at the coordinate (300,200).
	 **/
	public static void fillOval(Graphics g, int centerX, int centerY, int hRadius, int vRadius)
	{
		int hDiameter = 2 * hRadius;
		int vDiameter = 2 * vRadius;
		g.fillOval(centerX-hRadius, centerY-vRadius, hDiameter, vDiameter);
	}


	/**
	 * Draws a "solid" arc which will look either like a pie wedge or Pac-man.<br>
	 * A FILLED ARC is a "piece" of a SOLID OVAL.<br>
	 * The first 5 parameters (g and 4 ints) are the same as drawOval.<br>
	 * There are 2 additional parameters for the starting degree value and finishing degree of the arc. <br>
	 * 0 degrees is at the 12:00 position and the degrees progress in a CLOCKWISE fashion. <br>
	 * (90 degrees is at 3:00, 180 degrees is at 6:00, 270 degrees is at 9:00, 360 degrees is back at 12:00).
	 **/
	public static void fillArc(Graphics g, int centerX, int centerY, int hRadius, int vRadius, int start, int finish)
	{
		int hDiameter = 2 * hRadius;
		int vDiameter = 2 * vRadius;

		if (finish < start)
			finish += 360;
		int newStart  = 90 - start;   // shifts starting position from 3:00 to 12:00
		int newFinish = start-finish; // as oppose to finish-start.  Subtracting backwards changes from counter-clockwise to clockwise.

		g.fillArc(centerX-hRadius, centerY-vRadius, hDiameter, vDiameter, newStart, newFinish);
	}


	/**
	 * Draws an solid "filled-in" irregular triangle using the three sets of provided coordinates. <br>
	 * Example: <br>
	 * Expo.fillTriangle(g,100,300,200,100,300,300);
	 **/
	public static void fillTriangle(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3) ////// Added 06-25-08
	{
		fillPolygon(g,x1,y1,x2,y2,x3,y3);
	}


	/**
	 *	Draws an solid "filled-in" irregular quadrilateral using the four sets of provided coordinates.  <br>
	  * Example: <br>
	  * Expo.fillQuad(g,100,100,200,300,400,400,300,200);
	 **/
	public static void fillQuad(Graphics g,int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4) ////// Added 06-25-08
	{
		fillPolygon(g,x1,y1,x2,y2,x3,y3,x4,y4);
	}


	/**
	 * Draws an solid "filled-in" irregular polygon using 3 or more sets of provided coordinates. <br>
	 * Examples: <br>
	 * Expo.fillPolygon(g,100,300,200,100,300,300);                         // for a triangle
	 * Expo.fillPolygon(g,525,300,600,250,650,250,725,300,725,350,650,400); // for a hexagon
	 **/
	public static void fillPolygon(Graphics g, int... coordinate)
	{
		if (coordinate.length < 6 || coordinate.length % 2 == 1)
		{
			throw new ArrayIndexOutOfBoundsException(
				"When using <fillPolygon>, the number of int parameters ("
				+ coordinate.length + ") must be even and no less than 6.");
		}
		else
		{
		 	Polygon myPoly = new Polygon();
		 	for (int j = 0; j < coordinate.length-1; j+=2)
		 		myPoly.addPoint(coordinate[j],coordinate[j+1]);
		 	g.fillPolygon(myPoly);
		}
	}


	/**
	 * Draws a solid "filled in" rectangle.<br>
	 * The upper-left-hand corner is specified by x1,y1 and the lower-right-hand corner is specified by x2, y2. <br>
	 * Example: <br>
	 * Expo.fillRectangle(g,100,200,300,400); <br>
	 * Draws an open rectangle whose upper-left-hand coordinate is (100,200) and whose lower-right-hand coordinate is (300,400).
	 **/
	public static void fillRectangle(Graphics g, int x1, int y1, int x2, int y2)
	{
		int temp;
		if (x1 > x2)
			{ temp = x1; x1 = x2; x2 = temp; }
		if (y1 > y2)
			{ temp = y1; y1 = y2; y2 = temp; }
		int width  = x2 - x1 + 1;
		int height = y2 - y1 + 1;
		g.fillRect(x1,y1,width,height);
	}


	/**
	 * Draws a solid "filled in" rectangle with rounded corners. <br>
	 * The parameters are the same as drawRoundedRectangle.
	 **/
	public static void fillRoundedRectangle(Graphics g, int x1, int y1, int x2, int y2, int pixels)
	{
		int temp;
		if (x1 > x2) { temp = x1; x1 = x2; x2 = temp; }
		if (y1 > y2) { temp = y1; y1 = y2; y2 = temp; }
		int width  = x2 - x1 + 1;
		int height = y2 - y1 + 1;
		int diameter = pixels * 2;
		g.fillRoundRect(x1,y1,width,height,diameter,diameter);
	}


	/**
	 * Draws a solid "filled in" regular polygon with a specified number of sides.<br>
	 * The center of this polygon is specified by centerX,centerY and its size is specified by radius <br>
	 * (As in the radius of the circle the regular polygon would fit inside). <br>
	 * Precondition: sides >= 3 <br>
	 * Example: <br>
	 * Expo.fillRegularPolygon(g,300,200,100,8); <br>
	 * Draws a solid regular polygon with 8 sides and a radius of 100 pixels whose center is located at the coordinate (300,200).
	 **/
	public static void fillRegularPolygon(Graphics g, int centerX, int centerY, int radius, int sides)
	{
		int xCoord[] = new int[sides];
		int yCoord[] = new int[sides];

	 	double rotate;
	    if (sides % 2 == 1)
	    	rotate = halfPI;
	    else
	    	rotate = halfPI + Math.PI/sides;

		for (int k = 0; k < sides; k++)
		{
			xCoord[k] = (int) Math.round(Math.cos(twoPI * k/sides - rotate) * radius) + centerX;
			yCoord[k] = (int) Math.round(Math.sin(twoPI * k/sides - rotate) * radius) + centerY;
		}
		if (sides == 3)
			yCoord[1] = yCoord[2];
		g.fillPolygon(xCoord,yCoord,sides);
	}


	private static int getHalfRadius(int radius, int points)
	{
		int halfRadius;

		switch(points)
		{
			case  3 : halfRadius = 140 * radius / 500; break;
			case  4 : halfRadius = 170 * radius / 400; break;
			case  5 : halfRadius = 192 * radius / 500; break;
			case  6 : halfRadius = 233 * radius / 400; break;
			case  7 : halfRadius = 179 * radius / 500; break;
			case  8 : halfRadius = 215 * radius / 400; break;
			case  9 : halfRadius = 173 * radius / 500; break;
			case 10 : halfRadius = 212 * radius / 400; break;
			default : if (points < 52)
				  	  {
				     	  if (points % 2 == 1)
					      	  halfRadius = (180-points) * radius / 500;
				     	  else
		                	  halfRadius = (222-points) * radius / 400;
				  	  }
				  	  else
				 	 	  halfRadius = radius / 2;
		}
		return halfRadius;
	}


	/**
	 * Draws a solid "filled in" star with a specified number of points.<br>
	 * The center of this star is specified by centerX,centerY and its size is specified by radius <br>
	 * (As in the radius of the circle the star would fit inside). <br>
	 * Precondition: points >= 2 <br>
	 * Example: <br>
	 * Expo.fillStar(g,300,200,100,8); <br>
	 * Draws a solid star with 8 points and a radius of 100 pixels whose center is located at the coordinate (300,200).
	 **/
	public static void fillStar(Graphics g, int centerX, int centerY, int radius, int points)
	{
		int halfRadius = getHalfRadius(radius, points);
		int p = points;
		points *= 2;

		int xCoord[] = new int[points];
		int yCoord[] = new int[points];

		int currentRadius;

		for (int k = 0; k < points; k++)
		{
			if (k % 2 == 0)
				currentRadius = radius;
			else
				currentRadius = halfRadius;

			xCoord[k] = (int) Math.round(Math.cos(twoPI * k/points - halfPI) * currentRadius) + centerX;
			yCoord[k] = (int) Math.round(Math.sin(twoPI * k/points - halfPI) * currentRadius) + centerY;
		}

		int x = (p-5)/2+1;
		if (p >= 5 && p <= 51)
			switch(p % 4)
			{
				case  1 : yCoord[x] = yCoord[x+1] = yCoord[points-x-1] = yCoord[points-x]; break;
				case  2 : yCoord[x] = yCoord[x+1] = yCoord[points-x-1] = yCoord[points-x];
					      yCoord[x+3] = yCoord[x+4] = yCoord[points-x-4] = yCoord[points-x-3]; break;
				case  3 : yCoord[x+2] = yCoord[x+3] = yCoord[points-x-3] = yCoord[points-x-2];
			}
		g.fillPolygon(xCoord,yCoord,points);
	}
}