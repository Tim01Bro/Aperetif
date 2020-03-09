package com.project.Aperetif.Model;


import java.util.Objects;


public class FeedBack {

    private Long id;

    private String nameSender;

    private String sonameSender;

    private String commentSender;

    private String dateSender;

    public FeedBack(Long id,String nameSender, String sonameSender, String commentSender, String dateSender) {
        this.nameSender = nameSender;
        this.sonameSender = sonameSender;
        this.commentSender = commentSender;
        this.dateSender = dateSender;
        this.id = id;
    }

    public FeedBack() {
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

    public String getCommentSender() {
        return commentSender;
    }

    public void setCommentSender(String commentSender) {
        this.commentSender = commentSender;
    }

    public String getDateSender() {
        return dateSender;
    }

    public void setDateSender(String dateSender) {
        this.dateSender = dateSender;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedBack feedBack = (FeedBack) o;
        return Objects.equals(id, feedBack.id) &&
                Objects.equals(nameSender, feedBack.nameSender) &&
                Objects.equals(sonameSender, feedBack.sonameSender) &&
                Objects.equals(commentSender, feedBack.commentSender) &&
                Objects.equals(dateSender, feedBack.dateSender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameSender, sonameSender, commentSender, dateSender);
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "id=" + id +
                ", nameSender='" + nameSender + '\'' +
                ", sonameSender='" + sonameSender + '\'' +
                ", commentSender='" + commentSender + '\'' +
                ", dateSender='" + dateSender + '\'' +
                '}';
    }
}
