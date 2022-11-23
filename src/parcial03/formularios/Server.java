/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package parcial03.formularios;

import parcial03.Block;
import parcial03.BlockChain; 
import parcial03.Cifrado;
import parcial03.NodeData; 
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/**
 *
 * @author Usuario
 */
//porqué hay que implementar runnable?
public class Server extends javax.swing.JFrame implements Runnable{
    
    //
    private Thread tListener;
   private NodeData currentNode;
//   private ArrayList<NodeData> aOtherServer;
   private ArrayList<NodeData> aClients;
//   private ArrayList<wallet> frmWallet;
    private ServerSocket SvrSocket;
    private BlockChain bc;
    private Cifrado oCifrado;
    
    public Server() {
        initComponents();
    }

    //Esto no es posible porque es el de inicio, 
    //poner datos de NodeData desde el inicio?
    //ya que no recibe del frmMundo
    public Server(NodeData pnodeData){
    initComponents();
    this.oCifrado = new Cifrado("ñVbFg-+*DsHgñ");
    this.currentNode=pnodeData;
    this.startServer();
    
//    this.jLabel.setText(this.currentNode.getNodeName()); creo que esto no
//    this.aOtherServers=new ArrayList<>();
    this.aClients=new ArrayList<>();
//    this.frmWallet=new ArrayList<>();  
    }


    private void startServer(){
        //create blockchain
        this.bc=new BlockChain(3,"0","SHA256");//el metodo de blockchain nose si esta bien puesto
        this.bc.createGenesis();

        //inicializar listener
        try{
            // creo que la IpAdress puede ponerse fijo al ser un solo servidor
           InetAddress iAddress= InetAddress.getByName(this.currentNode.getIPAdress());
//           InetSocketAddress sNetServer = new InetSocketAddress(iAddress,this.currentNode.getSocketNum());
           InetSocketAddress sNetServer = new InetSocketAddress("127.0.0.1",7000);
           SvrSocket = new ServerSocket();
           SvrSocket.bind(sNetServer);
           tListener=new Thread(this);
           tListener.start();

        }
        catch(Exception ee){}
    }
    
    public void reportNewBalance(String receiver, int amount){
        for(int i=0; i<this.aClients.size();i++){
            if(this.aClients.get(i).getNodeName().equals(receiver)){
                try{
                    Socket socket=new Socket(this.aClients.get(i).getIPAdress(),
                            this.aClients.get(i).getSocketNum());
                    ObjectOutputStream oos= new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(amount);
                    socket.close();
                }
                catch(Exception ee){}
            }
        }
    }
    public void listBalances(){
        String sCad="";
        for(int i=0; i<this.aClients.size();i++){
            sCad+= this.aClients.get(i).getNodeName() +
                    "= $ "+
                    //Trate de hacer un parseo para probar si ahora agarra solo valores enteros
                    Integer.toString((int)(this.bc.getBalance(this.aClients.get(i).getNodeName())))
                    + "\n";
        }
        this.txtMessages.setText(sCad);
    }
    
//    Esto es por si se usa el broadcast
//    public void registerClients(ArrayList<NodeData> aNClients){
//        this.aClients=aNClients;
//        this.listBalances();
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nUsuario = new javax.swing.JTextField();
        agregar_usuario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtMessages = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 0, 255));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Meow Paw", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("Nuevo usuario:");

        txt_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidadActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Meow Paw", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Usuarios activos");

        jLabel2.setFont(new java.awt.Font("Meow Paw", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 153));
        jLabel2.setText("gatitos iniciales:");

        agregar_usuario.setBackground(new java.awt.Color(102, 0, 0));
        agregar_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parcial03/imagenes/perro (1).png"))); // NOI18N
        agregar_usuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        agregar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_usuarioActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        txtMessages.setBackground(new java.awt.Color(51, 0, 51));
        txtMessages.setForeground(new java.awt.Color(102, 0, 102));
        txtMessages.setText("jLabel3");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parcial03/imagenes/gato(2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(txtMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(txt_nUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(agregar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(txtMessages))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(71, 0, 44));

        jLabel4.setFont(new java.awt.Font("Meow Paw", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(246, 163, 71));
        jLabel4.setText("Cashcat Server");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/parcial03/imagenes/Diseño sin título (1) (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(17, 17, 17))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_usuarioActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_agregar_usuarioActionPerformed

    private void txt_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel txtMessages;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_nUsuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run(){
        while(true){
            try{
                Socket socket = this.SvrSocket.accept();
                
                //Deserializacion
                InputStream is = socket.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                Block blk=(Block)ois.readObject();
                socket.close();
                
                if(blk.getId()<0){
                    String sSender =this.oCifrado.desencriptar(blk.getTransaction(0).getSender());
                    String sReceiver =this.oCifrado.desencriptar(blk.getTransaction(0).getReceiver());
                    int dAmount = blk.getTransaction(0).getAmount();
                    
                    Block tBlk = new Block();
                    tBlk.setTransaction(sSender, dAmount, sReceiver);
                    
                    if(this.bc.getBalance(sSender)>=dAmount){
                        //Crea el bloque
                        this.bc.createBlock();
                        //Obtiene el último bloque y se le enlaza una transacción
                        this.bc.getLastBlock().setTransaction(tBlk.getTransaction(0));
                        this.bc.mineBlock();
                        //this.broadcastBlock(this.bc.getLastBlock()); difusion del bloque esto es para los otros servidores, ver si se puede omitir
                        this.reportNewBalance(sReceiver, dAmount);
                    }
                    else this.txtMessages.setText("Insufficient funds from: "+sSender);
                    }else{
                    // cuando recibe bloques completos
                    this.bc.addProvedBlock(blk);
                }
                this.listBalances();
            }
            catch(Exception ee){}
        }
    }
}
