package core.actions;

import core.Client;
import core.Protocol;
import core.ServerCore;
import core.model.ProtectoraEntity;
import org.hibernate.Session;
import utils.HibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Login {
    public static void doAction(DatagramSocket sock, Client sc, Protocol petition){

        try {
            Protocol response = new Protocol();

            Session sessionOne = HibernateUtils.getSession();
            Query query = sessionOne.createQuery("FROM ProtectoraEntity where correo=:nombre AND contrasenia=:pass")
            .setParameter("nombre",petition.getArgs().get("user")).setParameter("pass",petition.getArgs().get("pass"));

            List<ProtectoraEntity> protectoras = query.getResultList();

            if(protectoras.size()<=0){
                response.setHEADER(404);
                response.setBody("Username or password incorrect");
                DatagramPacket respuesta =
                        new DatagramPacket(response.toString().getBytes(StandardCharsets.UTF_8), response.toString().getBytes(StandardCharsets.UTF_8).length,
                                sc.getAddress(), sc.getPort());
                sock.send(respuesta);
            }else{
                response.setHEADER(200);
                response.setBody("HOLA!");
                DatagramPacket respuesta =
                        new DatagramPacket(response.toString().getBytes(StandardCharsets.UTF_8), response.toString().getBytes(StandardCharsets.UTF_8).length,
                                sc.getAddress(), sc.getPort());
                sock.send(respuesta);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}