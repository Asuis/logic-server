package com.real.logicserver.utils.user.model;

/**
 * @author asuis
 */
class Session
{
    private String skey;

    private String id;

    public void setSkey(String skey){
        this.skey = skey;
    }
    public String getSkey(){
        return this.skey;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
}

/**
 * @author asuis
 */
public class LoginSession
{
    private Session session;

    private int F2C224D4_2BCE_4C64_AF9F_A6D872000D1A;

    public void setSession(Session session){
        this.session = session;
    }
    public Session getSession(){
        return this.session;
    }
    public void setF2C224D4_2BCE_4C64_AF9F_A6D872000D1A(int F2C224D4_2BCE_4C64_AF9F_A6D872000D1A){
        this.F2C224D4_2BCE_4C64_AF9F_A6D872000D1A = F2C224D4_2BCE_4C64_AF9F_A6D872000D1A;
    }
    public int getF2C224D4_2BCE_4C64_AF9F_A6D872000D1A(){
        return this.F2C224D4_2BCE_4C64_AF9F_A6D872000D1A;
    }
}
