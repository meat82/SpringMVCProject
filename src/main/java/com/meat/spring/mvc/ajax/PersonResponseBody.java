package com.meat.spring.mvc.ajax;

import com.fasterxml.jackson.annotation.JsonView;
import com.meat.spring.mvc.model.Person;

public class PersonResponseBody {

    @JsonView(Views.Public.class)
    private String msg;

    @JsonView(Views.Public.class)
    private String code;

    @JsonView(Views.Public.class)
    private Person result;

    public PersonResponseBody() {
        setCode("");
        setMsg("");
        setResult(new Person());
    }
    
    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
     *            the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the result
     */
    public Person getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(Person result) {
        this.result = result;
    }
    
}
