/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial03;

/**
 *
 * @author Usuario
 */
public class NodeData {
    private String nodeName;
    private String IPAdress;
    private int socketNum;
    
    public NodeData(String pnodeName, String pIPAdress, int psocketNum){
        this.nodeName=pnodeName;
        this.IPAdress=pIPAdress;
        this.socketNum=psocketNum;
    }

    /**
     * @return the nodeName
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * @return the IPAdress
     */
    public String getIPAdress() {
        return IPAdress;
    }

    /**
     * @return the socketNum
     */
    public int getSocketNum() {
        return socketNum;
    }
    
}
