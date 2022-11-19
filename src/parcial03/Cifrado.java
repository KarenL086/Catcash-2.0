/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial03;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Merari Angélica
 */
public class Cifrado {

	private SecretKeySpec llave;
	private Cipher oCifrado;
	private Cipher oDescifrado;

	public Cifrado(String pClave) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException{
	try{
            MessageDigest oHash = MessageDigest.getInstance("SHA-1");
            // Se crea la difestión de caracteres, generando un Array de 
            //Bytes
            byte[] aBytes= oHash.digest(pClave.getBytes("UTF-8"));
            // Truncado a 32 bytes
            byte[] aBytes32 = Arrays.copyOf(aBytes, 32);
            //Especificación de la llave secreta
            this.llave = new SecretKeySpec(aBytes32, "AES");
            
            //Crea una instacia de un algoritmo de cifrado
            this.oCifrado=Cipher.getInstance("AES/ECB/PKCS5Padding");
            //Inicializa el modo de encriptación
            this.oCifrado.init(Cipher.ENCRYPT_MODE, this.llave);
            
            this.oDescifrado=Cipher.getInstance("AES/ECB/PKCS5PADDING");
            this.oDescifrado.init(Cipher.DECRYPT_MODE, this.llave);
	} 
        catch(Exception e){
            
        }
}
        public Block cifrarBloque(Block pBlk){
            try{
                pBlk.toString();
            }
            catch (Exception e){
                
              return null;  
            }
            
        }
        public String encriptar(String pCadena) throws Exception{
            byte[] aBytes = pCadena.getBytes("UTF-8");
            byte[] aBytesEnc =this.oCifrado.doFinal(aBytes);
            return Base64.getEncoder().encodeToString(aBytesEnc);
        }
        
        public String desencriptar(String pCadena) throws Exception{
            byte[] aBytes= pCadena.getBytes("UTF-8");
            byte[] aBytesDec= this.oDescifrado.doFinal(aBytes);
            String datos = new String(aBytesDec);
        }
 
}
