package com.project.Aperetif.Model;

 import java.util.Objects;


public class GetInTouch {

    private Long id;

    private String nameSender;

    private String sonameSender;

    private String phoneSender;

    private String emailSender;

    private String subjectSender;

    private String dateSender;

    public GetInTouch(Long id,String nameSender, String sonameSender, String phoneSender, String emailSender, String subjectSender,String dateSender) {
        this.nameSender = nameSender;
        this.sonameSender = sonameSender;
        this.phoneSender = phoneSender;
        this.emailSender = emailSender;
        this.subjectSender = subjectSender;
        this.id = id;
        this.dateSender =dateSender;
    }

    public GetInTouch() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSender() {
        return nameSender;
    }

    public void setNameSender(String nameSender) {
        this.nameSender = nameSender;
    }

    public String getSonameSender() {
        return sonameSender;
    }

    public void setSonameSender(String sonameSender) {
        this.sonameSender = sonameSender;
    }

    public String getPhoneSender() {
        return phoneSender;
    }

    public void setPhoneSender(String phoneSender) {
        this.phoneSender = phoneSender;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender;
    }

    public String getSubjectSender() {
        return subjectSender;
    }

    public void setSubjectSender(String subjectSender) {
        this.subjectSender = subjectSender;
    }

    @Override
    public String toString() {
        return "GetInTouch{" +
                "id=" + id +
                ", nameSender='" + nameSender + '\'' +
                ", sonameSender='" + sonameSender + '\'' +
                ", phoneSender='" + phoneSender + '\'' +
                ", emailSender='" + emailSender + '\'' +
                ", subjectSender='" + subjectSender + '\'' +
                ", dateSender='" + dateSender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetInTouch that = (GetInTouch) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nameSender, that.nameSender) &&
                Objects.equals(sonameSender, that.sonameSender) &&
                Objects.equals(phoneSender, that.phoneSender) &&
                Objects.equals(emailSender, that.emailSender) &&
                Objects.equals(subjectSender, that.subjectSender) &&
                Objects.equals(dateSender, that.dateSender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameSender, sonameSender, phoneSender, emailSender, subjectSender, dateSender);
    }
}
