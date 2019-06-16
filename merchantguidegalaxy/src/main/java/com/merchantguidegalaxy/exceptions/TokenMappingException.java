
package com.merchantguidegalaxy.exceptions;

/**
 * Thrown to indicate Token mapping exception.
 *
 * @author Jyoti
 * @see 
 * @Date 16-Jun-2019
 *
 */
public class TokenMappingException extends Exception 
{
	private static final long serialVersionUID = 4819018588218770986L;
	
    /**
     * Constructs an <code>TokenMappingException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
	public TokenMappingException(String msg)
	{
		super(msg);
	}
	
}
