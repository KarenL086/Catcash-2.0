/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial03;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Usuario
 */
public class Cifrado {
    //Variables
    private SecretKeySpec llave;
    private Cipher oCifrado;
    private Cipher oDescifrado;  
    
    public Cifrado(String pClave) {
        //Configuración de objetos para encriptar y desencriptar
			try{
                            MessageDigest oHash = MessageDigest.getInstance("SHA-1");
                            //Digestión de carácteres a través de un array de bytes
                            byte[] aBytes= oHash.digest(pClave.getBytes("UTF-8"));
                            //Se trunca en 32 bytes
                            byte[] aBytes32 = Arrays.copyOf(aBytes, 32);
                            //Se hace la especificación de llave secreta
                            this.llave = new SecretKeySpec(aBytes32, "AES");
                            
                            //Crea una instancia para un algoritmo descifrado
                            this.oCifrado=Cipher.getInstance("AES/ECB/PKCS5Padding");
                            
                            //activa modo de encriptación
                            this.oCifrado.init(Cipher.ENCRYPT_MODE,this.llave);
                            
                            //Lo mismo que lo anterior pero con desencriptar
                            this.oDescifrado=Cipher.getInstance("AES/ECB/PKCS5PADDING");
                            this.oDescifrado.init(Cipher.DECRYPT_MODE, this.llave);
                        }
                        catch(Exception e){}
    }
    public Block cifrarBloque(Block pBlk){
        try{
            pBlk.toString();
            return null;
        } catch(Exception e){
            return null;
        }
    }
    public String encriptar(String pCadena) throws Exception{
        //Se convierte la cadena a Bytes
        byte[] aBytes= pCadena.getBytes("UTF-8");
        // Realiza el cifrado del bloque de bytes
        byte[] aBytesEnc=this.oCifrado.doFinal(aBytes);
        //Se utiliza una base de 64 bits para que se pueda leer
        //Con encodeToString convierte el flujo de datos en algo legible
        return Base64.getEncoder().encodeToString(aBytesEnc);
    }
    
    public String desencriptar(String pCadena) throws Exception{
        
        //Llamada para desencriptar (La realiza el servidor)
        byte[] aBytes=Base64.getDecoder().decode(pCadena);
        //Realiza el producto final del desencriptado
        byte[] aBytesDec=this.oDescifrado.doFinal(aBytes);
        //Conversión a String
        String datos=new String(aBytesDec);
        
        return datos;
    }

                        
    }

