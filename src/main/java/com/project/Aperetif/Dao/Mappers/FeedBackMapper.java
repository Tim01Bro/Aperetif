package com.project.Aperetif.Dao.Mappers;

import com.project.Aperetif.Model.FeedBack;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedBackMapper  implements RowMapper<FeedBack> {
    @Override
    public FeedBack mapRow(ResultSet resultSet, int i) throws SQLException {
        FeedBack feedBack = new FeedBack();

        feedBack.setId(resultSet.getLong("id"));
        feedBack.setNameSender(resultSet.getString("namesender"));
        feedBack.setSonameSender(resultSet.getString("sonamesender"));
        feedBack.setCommentSender(resultSet.getString("commentsender"));
        feedBack.setDateSender(resultSet.getString("datesender"));

        return feedBack;
    }
}
