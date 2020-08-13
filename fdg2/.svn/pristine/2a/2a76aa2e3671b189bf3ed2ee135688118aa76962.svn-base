package com.sloth.common.exception;

public class SlothException extends RuntimeException {
	private static final long serialVersionUID = 877147761930525885L;
	private int code;

	public SlothException(int code) {
		this.code = code;
	}

	public SlothException(String msg) {
		super(msg);
		this.code = -1;
	}

	public SlothException(int code, String msg) {
		super(msg);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}