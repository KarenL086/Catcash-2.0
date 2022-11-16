/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial03;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Transaccion implements Serializable{
    
private int id;
private long timeStamp;
private String sender;
private String receiver;
private double amount;
// receiber se menatiene como sender y amount como voto, receiver creo se elimina

public Transaccion(int pId, String pSender, String pReceiver, double pAmount)
{
    this.id=pId;
    this.timeStamp= new Date().getTime();
    this.sender=pSender;
    this.receiver=pReceiver;
    this.amount=pAmount;
}
@Override
    public String toString() {
    return Integer.toString(getId())+Long.toString(getTimeStamp())+getSender()+getReceiver()+Double.toString(getAmount());
    }
     /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the timeStamp
     */
    public long getTimeStamp() {
        return timeStamp;
    }

    /**
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * @return the receiver
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    } 
}
