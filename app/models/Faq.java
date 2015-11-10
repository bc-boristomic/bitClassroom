package models;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

/**
 * Created by NN on 17.10.2015.
 */

@Entity
@Table(name="faq_setup")
public class Faq extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="question", length = 500)
    private String question;
    @Column(name="answer", length = 500)
    private String answer;
    @Column(name = "create_date", updatable = false, columnDefinition = "datetime")
    private DateTime createdDate = new DateTime();
    @Column
    private Integer status = 0;

    /**
     * Constructor for new FAQ question for admin
     * @param question - Stgring format of question
     * @param answer - String format of answer of entere question
     */
    public Faq(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    static Finder<Long, Faq> finder = new Finder<Long, Faq>(Faq.class);


    public static List<Faq> findAllFAQ() {
        return finder.orderBy("id desc").findList();
    }

    public static Faq findFaqById(Long id) {
        return finder
                .where()
                .eq("id", id)
                .findUnique();
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Faq{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }


}
