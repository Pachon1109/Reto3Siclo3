/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Siclo3.Reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Pacho
 */
@Entity
@Table(name = "Message")
public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    
     //relacion tabla habitacion
    @ManyToOne
    @JoinColumn(name = "partyroomid")
    @JsonIgnoreProperties({"messages", "reservations", "client"})//
    private Partyroom partyroom;

    //relacion tabla cliente
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"client", "messages", "reservations"})
    private Client client;

    

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    
    public Partyroom getPartyroom() {
        return partyroom;
    }

    public void setPartyroom(Partyroom partyroom) {
        this.partyroom = partyroom;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
