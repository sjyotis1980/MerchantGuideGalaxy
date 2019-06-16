
package com.merchantguidegalaxy.exceptions;

/**
 * Thrown to indicate that a method has been passed an illegal or
 * inappropriate Numeral argument.
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class InvalidNumeralException extends Exception 
{

	private static final long serialVersionUID = 3587579189666575519L;
	
    /**
     * Constructs an <code>InvalidNumeralException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
	public InvalidNumeralException(String msg)
	{
		super(msg);
	}

}
