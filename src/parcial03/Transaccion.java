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
// Ya que el bloque es serializable también 
// sus "ramas" deben serlo
public class Transaccion implements Serializable{
//Definición de variables 
    

private int id;
private long timeStamp;
//Persona que envía:
private String sender;
//Persona que recibe:
private String receiver;
//Amount es la cantidad de dinero que envía
private int amount;
// receiber se menatiene como sender y amount como voto, receiver creo se elimina

public Transaccion(int pId, String pSender, String pReceiver, int pAmount)
{
    this.id=pId;
    this.timeStamp= new Date().getTime();
    this.sender=pSender;
    this.receiver=pReceiver;
    this.amount=pAmount;
}
@Override
    public String toString() {
        //Realiza una conversión de datos a Strings en una sola cadena
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
    public int getAmount() {
        return amount;
    } 
}
