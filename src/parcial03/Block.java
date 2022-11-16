/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial03;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date; 
/**
 *
 * @author Usuario
 */
public class Block implements Serializable{
    private int id;
    private int nonce;
    private long timeStamp;
    private String hash;
    private String hashPrevio;
    private ArrayList<Transaccion> aTransaccion;
    
    public Block(int pId, String pHashPrev){
        this.id = pId;
        this.timeStamp = new Date().getTime();
        this.hashPrevio=pHashPrev;
        this.aTransaccion= new ArrayList<>();
        this.nonce=-1;
        this.hash=null;
    }
    
    public Block() {
        this.timeStamp = new Date().getTime();
        this.aTransaccion= new ArrayList<>();
        this.nonce=-1;
        this.hash=null;
        this.id = -1;
    }
    public boolean register(int pNonce, String pHash)
    {
        if ((this.getId()>-1)&&(this.getNonce()<0)&&(this.getHash()==null))
        {
        this.nonce=pNonce;
        this.hash=pHash;
        return true;
        }
        else return false;
    }
    
    //Set transaccion debe cambiarse por las votaciones
    public void setTransaction(String pSender, double pAmount, String pReceiver)
    {
        this.aTransaccion.add(new Transaccion(
        this.aTransaccion.size(),pSender,pReceiver,pAmount));
    }
    
    public void setTransaction(Transaccion pTran)
    {
        this.aTransaccion.add(new Transaccion(
        this.aTransaccion.size(),pTran.getSender(),pTran.getReceiver(),pTran.getAmount()));
    }
    
    public Transaccion getTransaction(int pId)
    {
        return this.aTransaccion.get(pId);
    }
    
    public int countTransactions()
    {
        return this.aTransaccion.size();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nonce
     */
    public int getNonce() {
        return nonce;
    }

    /**
     * @return the timeStamp
     */
    public long getTimeStamp() {
        return timeStamp;
    }

    /**
     * @return the hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * @return the hashPrevio
     */
    public String getHashPrevio() {
        return hashPrevio;
    }

    @Override
    public String toString(){
        String sCad=Integer.toString(id)+ Long.toString(timeStamp) + this.hashPrevio;
        
        for(int i=0; i<this.aTransaccion.size(); i++)
        {
        sCad= sCad + this.aTransaccion.get(i).toString();
        }
        return sCad;
    }  
}
