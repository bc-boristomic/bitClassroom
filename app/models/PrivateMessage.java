package models;

import com.avaje.ebean.Model;
import models.user.User;
import org.joda.time.DateTime;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;

/**
 * Created by NN on 20.9.2015.
 */

@Entity
public class PrivateMessage extends Model {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column
    @Constraints.Required
    private String subject;

    @Column
    @Constraints.Required
    private String content;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;

    @Column
    private Integer status;

    @Column
    private Integer inboxStatus;

    @Column
    private Integer  sendStatus;

    @Column(name = "create_date", updatable = false, columnDefinition = "datetime")
    private DateTime creationDate = new DateTime();


    private static Finder<Long, PrivateMessage> find = new Finder<Long, PrivateMessage>(PrivateMessage.class);


    public PrivateMessage(String subject, String content, User sender, User receiver){

        this.subject = subject;
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
    }

    public PrivateMessage(){

        this.subject = "No subject";
        this.content = "No conent";
        this.sender = null;
        this.receiver = null;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public static PrivateMessage create(String subject, String content, User sender, User receiver) {
        PrivateMessage newMessage = new PrivateMessage(subject, content, sender, receiver);
        newMessage.save();
        return newMessage;
    }

    public Long getId() {
        return id;
    }

    public Integer getInboxStatus() {
        return inboxStatus;
    }

    public void setInboxStatus(Integer inboxStatus) {
        this.inboxStatus = inboxStatus;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public static Finder<Long, PrivateMessage> getFind() {
        return find;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static PrivateMessage findMessageById(Long id) {
        return find
                .where()
                .eq("id", id)
                .orderBy("id desc")
                .findUnique();
    }

    public static List<PrivateMessage> findAllMessage(){

        return find.all();
    }


    public static void deleteMsg(Long id){

        find.ref(id).delete();
    }

    public static List<PrivateMessage> getSentMessages(Long id){
        List<PrivateMessage> list = find.where().eq("sender_id", id).findList();
        return list;
    }

    public static List<PrivateMessage> getReceivedMessages(Long id){
        List<PrivateMessage> list = find.where().eq("receiver_id", id).findList();
        return list;
    }
}