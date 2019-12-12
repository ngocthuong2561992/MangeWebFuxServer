package openhouse.exception;

import openhouse.common.BaseStatusError;

public class SfaException extends RuntimeException {
    private static final long serialVersionUID = 5926563242473060260L;
    protected String messageCode;

    public SfaException(Exception e) {
        super(e);
    }

    public SfaException(String messageCode, String messageContent) {
        super(messageContent);
        this.messageCode = messageCode;
    }

    public SfaException(BaseStatusError baseStatusError) {
        super(baseStatusError.getMessage());
        this.messageCode = baseStatusError.getCode();
    }

    public SfaException(String messageContent) {
        super(messageContent);
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }
}
