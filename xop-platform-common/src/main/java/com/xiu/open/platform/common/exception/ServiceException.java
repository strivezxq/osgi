package com.xiu.open.platform.common.exception;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class ServiceException extends Exception {
	
	@SuppressWarnings("rawtypes")
	private final Map info = new HashMap();
    private String errorCode;
    private String message;


    /**
     * @param message the exception message
     * @param cause the exception that cause this exception to be thrown
     */
    public ServiceException(String message, Throwable cause)
    {
    	super(message, cause);
        this.message = message;
    }
    public ServiceException(String message)
    {
    	super(message);
    	this.message = message;
    }

    public ServiceException(Throwable cause)
    {
        super(cause);
    }

    protected ServiceException()
    {
        super();
    }

    public void setErrorCode(String errorCode)
    {
    	this.errorCode = errorCode;
    }
    
    public String getErrorCode()
    {
        return errorCode;
    }


    @SuppressWarnings("unchecked")
	public void addInfo(String name, Object info)
    {
        this.info.put(name, info);
    }
    
    @SuppressWarnings("unchecked")
	public void addAll(Map<String,Object> map)
    {
    	this.info.putAll(map);
    }

    public void appendMessage(String s)
    {
    	if(message == null){
    		message = s;
    	}else {
    		message += s;
    	}
    }

    protected void prependMessage(String s)
    {
        message = message + ". " + s;
    }

    @Override
    public final String getMessage()
    {
    	if(message==null) {
    		message = super.getMessage();
    	}
        return message;
    }

    public String getDetailedMessage()
    {
    	
    	return null;
    }

    public Map getInfo()
    {
        return info;
    }
}
