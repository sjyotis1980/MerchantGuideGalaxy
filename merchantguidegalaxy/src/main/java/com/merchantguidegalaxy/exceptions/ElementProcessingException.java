
package com.merchantguidegalaxy.exceptions;

/**
 * Thrown to indicate Element Processing exception.
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class ElementProcessingException extends Exception
{
	
	private static final long serialVersionUID = -7317184850233575845L;

	/**
     * Constructs an <code>ElementProcessingException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
	public ElementProcessingException(String msg)
	{
		super(msg);
	}
}
