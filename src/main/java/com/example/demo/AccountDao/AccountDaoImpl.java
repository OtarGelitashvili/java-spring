package com.example.demo.AccountDao;

import com.example.demo.AccountModel.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;
    public AccountDaoImpl(DataSource dataSource)
    {
        this.jdbcTemplate=new JdbcTemplate( dataSource);
    }

    @Override
    public int save(Account account) {
        String sql="INSERT INTO account( person_id,name,lastname,phone) VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql,account.getPerson_id(),account.getName(),account.getLastname(),account.getPhone());

    }

    @Override
    public int update(Account account) {
        String sql="UPDATE Account SET person_id=?,name=?,lastname=?,phone=? WHERE accaunt_id=?";

        return jdbcTemplate.update(sql,account.getPerson_id(),account.getName(),account.getLastname(),
                account.getPhone(),account.getId());
    }

    @Override
    public  Account get(Integer id) {

        String sql="SELECT * FROM Account WHERE accaunt_id=" + id;
        ResultSetExtractor<Account> extractor=new ResultSetExtractor<Account>() {
            @Override
            public Account extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    String person_id=resultSet.getString("perosn_id");
                    String name=resultSet.getString("name");
                    String lastname=resultSet.getString("lastname");

                    String phone=resultSet.getString("phone");

                    return new Account(id, person_id,name,lastname,phone);
                }
                return null;
            }
        };
        return jdbcTemplate.query(sql,extractor);
    }

    @Override
    public int delete(Integer id) {
        String sql="DELETE FROM Account WHERE accaunt_id="+id;
        return jdbcTemplate.update(sql);
    }

    @Override
    public List<Account> List() {
        String sql="SELECT * FROM Account";
        RowMapper<Account> rowMapper=new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id=resultSet.getInt("accaunt_id");
                String person_id=resultSet.getString("perosn_id");
                String name=resultSet.getString("name");
                String lastname=resultSet.getString("lastname");

                String phone=resultSet.getString("phone");

                return new Account(id, person_id,name,lastname,phone);

            }

        };
        return  jdbcTemplate.query(sql,rowMapper);

    }
}
