package com.op.core.exception;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/15.
 ****************************************/
public class OperationPlatformException extends RuntimeException {
	public OperationPlatformException() {
	}

	public OperationPlatformException(Throwable cause) {
		super(cause);
	}

	public OperationPlatformException(String message) {
		super(message);
	}

	public OperationPlatformException(String message, Throwable cause) {
		super(message, cause);
	}

	public OperationPlatformException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
